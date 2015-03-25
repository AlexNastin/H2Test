package by.st.h2_test.comet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.comet.CometEvent;
import org.apache.catalina.comet.CometProcessor;

import by.st.h2_test.rest.BridgeCometRest;

/**
 * Servlet implementation class CometController
 */
public class CometController extends HttpServlet implements CometProcessor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2117163851350304955L;
	private MessageSender messageSender = null;
	private static final Integer TIMEOUT = 10 * 1000;
	BridgeCometRest bridgeCometRest = BridgeCometRest.getInstance();

	@Override
	public void init() throws ServletException {
		super.init();
		messageSender = new MessageSender();
		Thread messageSenderThread = new Thread(messageSender, "CometThread "
				+ CometController.serialVersionUID);
		messageSenderThread.setDaemon(true);
		messageSenderThread.start();
	}

	@Override
	public void event(CometEvent event) throws IOException, ServletException {
		HttpServletRequest request = event.getHttpServletRequest();
		HttpServletResponse response = event.getHttpServletResponse();

		if (event.getEventType() == CometEvent.EventType.BEGIN) {
			request.setAttribute("org.apache.tomcat.comet.timeout", TIMEOUT);
			System.out.println("1e");
			messageSender.setConnection(response);
			System.out.println("2e");
		} else if (event.getEventType() == CometEvent.EventType.ERROR) {
			messageSender.delConnection(response);
			event.close();
		} else if (event.getEventType() == CometEvent.EventType.END) {
			messageSender.delConnection(response);
			event.close();
		} else if (event.getEventType() == CometEvent.EventType.READ) {
			throw new UnsupportedOperationException(
					"This servlet does not accept data");
		}

	}

	private class MessageSender implements Runnable {

		protected boolean running = true;
		private ArrayBlockingQueue<ServletResponse> connections = new ArrayBlockingQueue<ServletResponse>(
				50);
		PrintWriter printWriter = null;

		private void setConnection(HttpServletResponse connection) {
			this.connections.add(connection);
		}

		private void delConnection(HttpServletResponse connection) {
			this.connections.add(connection);
		}

		@Override
		public void run() {
			while (running) {

				if (bridgeCometRest.getActions().isEmpty()) {
					try {

						Thread.sleep(10);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					try {

						System.out.println(connections.size() + "size");
						HttpServletResponse httpServletResponse = (HttpServletResponse) connections
								.poll();
						printWriter = httpServletResponse.getWriter();
						System.out.println(messageSender.connections.size());
						if (printWriter != null) {
							printWriter.write("change");
							if (connections.size() == 49) {
								connections.clear();
							}
							try {
								if (printWriter != null) {
									printWriter.close();
								}
							} catch (NullPointerException e) {
								e.printStackTrace();
							}
							bridgeCometRest.clear();
							printWriter = null;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}