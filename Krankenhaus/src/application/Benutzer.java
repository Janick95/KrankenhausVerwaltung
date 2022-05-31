package application;

public class Benutzer {

	private static String Email;
	private static String password;

	public static String getEmail() {
		return Email;
	}

	public static void setEmail(String email) {
		Email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Benutzer.password = password;
	}

}
