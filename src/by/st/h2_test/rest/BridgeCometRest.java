package by.st.h2_test.rest;

import java.util.ArrayList;

public class BridgeCometRest {

	private ArrayList<String> actions = null;

	private BridgeCometRest() {
		actions = new ArrayList<String>();
	}

	public static BridgeCometRest getInstance() {
		return Holder.instance;
	}

	private static class Holder {
		private static final BridgeCometRest instance = new BridgeCometRest();
	}

	public ArrayList<String> getActions() {
		return actions;
	}

	public void setActions(ArrayList<String> actions) {
		this.actions = actions;
	}

	public void clear() {
		actions.clear();
	}
}
