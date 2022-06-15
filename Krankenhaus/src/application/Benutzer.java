package application;

public class Benutzer {

	private static String userId;
	private static String password;

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		Benutzer.userId = userId;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Benutzer.password = password;
	}

}
