package application;

public class Benutzer {

	private static String userID;
	private static String password;

	public static String getUserID() {
		return userID;
	}

	public static void setUserID(String userID) {
		Benutzer.userID = userID;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Benutzer.password = password;
	}

}
