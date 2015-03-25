package by.st.h2_test.helper;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import by.st.h2_test.beans.Login;

public final class HelperJSON {

	final static String ID = "idLogin";
	final static String NAME = "name";
	final static String EMAIL = "email";
	final static String PASS = "password";

	public static JSONArray generationJsons(List<Login> list) {

		JSONArray listJSON = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(HelperJSON.ID, list.get(i).getIdLogin());
			jsonObject.put(HelperJSON.NAME, list.get(i).getName());
			jsonObject.put(HelperJSON.EMAIL, list.get(i).getEmail());
			jsonObject.put(HelperJSON.PASS, list.get(i).getPassword());
			listJSON.add(jsonObject);
		}

		return listJSON;
	}

	public static JSONObject generationJson(Login login) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(HelperJSON.ID, login.getIdLogin());
		jsonObject.put(HelperJSON.NAME, login.getName());
		jsonObject.put(HelperJSON.EMAIL, login.getEmail());
		jsonObject.put(HelperJSON.PASS, login.getPassword());

		return jsonObject;
	}
	public static Login generationLoginFromJson(String json) throws ParseException {
		Login login = new Login();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
		Object idO = jsonObject.get(ID);
		Integer id = Integer.valueOf(String.valueOf(idO));
		login.setIdLogin(id.intValue());
		login.setName((String) jsonObject.get(NAME));
		login.setEmail((String) jsonObject.get(EMAIL));
		Object passO = jsonObject.get(PASS);
		Integer pass = Integer.valueOf(String.valueOf(passO));
		login.setPassword(pass.intValue());
		
		return login;
	}

}
