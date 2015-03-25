package by.st.h2_test.dao.connection_pool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class H2_PropertyManager {

	private final String PATH = "db.properties";
	private final String PREFIX = this.getClass().getResource("/").getPath();

	private Properties properties = new Properties();
	private BufferedReader bufferedReader = null;

	
	private static class Holder {
		private static final H2_PropertyManager INSTANCE = new H2_PropertyManager();
	}

	public static H2_PropertyManager getInstance() {
		return Holder.INSTANCE;
	}
	
	private H2_PropertyManager() {
		try {
			bufferedReader = new BufferedReader(new FileReader(PREFIX+PATH));
			properties.load(bufferedReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return properties.getProperty(key);
	}



}
