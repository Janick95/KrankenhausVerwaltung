package application;

public class Suchen {

	// Methoden

	// SuchAlgorythmen
	//Patienten, Arzt, Pfleger, Räume, Termine
	public static String searchID(String searchTerm, String[] array) {

		int index = 0;
		int position = binarySearch(array, 0, array.length - 1, searchTerm, index);
		String searched = array[position];

		return searched;
	}

	//Patienten, Arzt, Pfleger
	public static String[] searchFirstName(String searchTerm, String[] array) {

		int index = 1;
		String[] searchedElements = linearSearch(array, searchTerm, index);

		return searchedElements;
	}
	
	//Patienten, Arzt, Pfleger
	public static String[] searchLastName(String searchTerm, String[] array) {

		int index = 2;
		String[] searchedElements = linearSearch(array, searchTerm, index);

		return searchedElements;
	}

	//Räume
	public static String searchRoomNumber(String searchTerm, String[] array) {

		int index = 0;
		int position = binarySearch(array, 0, array.length - 1, searchTerm, index);
		String searched = array[position];

		return searched;
	}

	//Arzt
	public static String[] searchSpecialField(String searchTerm, String[] array) {

		int index = 4;
		String[] searchedElements = linearSearch(array, searchTerm, index);

		return searchedElements;
	}

	//Patienten
	public static String[] searchReasonForStay(String searchTerm, String[] array) {

		int index = 4;
		String[] searchedElements = linearSearch(array, searchTerm, index);

		return searchedElements;
	}

	// Eventuell zusätzlich/ nicht im Pflichtenheft
	//Räume
	public static String[] searchFreeRooms(String[] array) {

		int index = 1;
		int index2 = 2;
		String[] searchedElements = linearSearch(array, index, index2);

		return searchedElements;
	}

	public static String[] searchOperationDate(String searchTerm, String[] array) {

		return array;
	}

	// SuchAlgorythmen
	// Sucht nach einzelnen Begriffen und Zahlen und bricht ab sobald diese gefunden
	// wurden
	public static int binarySearch(String[] array, int l, int r, String k, int index) {

		int m = -1;

		while (l <= r) {

			m = (l + r) / 2;

			String[] entry = array[m].split(",");

			int value = k.compareTo(entry[index]);

			if (value > 0) {
				l = m + 1;
			} else if (value < 0) {
				r = m - 1;
			} else if (value == 0) {
				break;
			}
		}

		return m;

	}

	// Sucht mehrere Elemente aus einem array. Da das Array dafür sowieso komplett
	// durchlaufen werden muss, ist auch ein linearsearch von der Laufzeit her gut
	// geeignet. Auch eine vorherige Sortierung ist nicht nötig
	public static String[] linearSearch(String[] array, String k, int index) {
		String[] found = new String[array.length];
		int count = 0;
		int hit = 0;
		int j = 0;

		for (int i = 0; i < array.length; i++) {

			String[] entry = array[i].split(",");
			int value = k.compareTo(entry[index]);

			if (value == 0) {
				found[count] = array[i];
				count++;
			}
		}
		for (int i = 0; i < found.length; i++) {
			if (found[i] != null) {
				hit++;
			}
		}
		String[] searched = new String[hit];

		for (int i = 0; i < found.length; i++) {
			if (found[i] != null) {
				searched[j] = found[i];
				j++;
			}
		}
		return searched;
	}

	
	public static String[] linearSearch(String[] array, int index, int index2) {
		String[] found = new String[array.length];
		int count = 0;
		int hit = 0;
		int j = 0;

		for (int i = 0; i < array.length; i++) {

			String[] entry = array[i].split(",");
			int beds = Integer.parseInt(entry[index]);
			int patients = Integer.parseInt(entry[index2]);
			
			int value = beds - patients;
			
			if (value == 0) {
				found[count] = array[i];
				count++;
			}
		}
		for (int i = 0; i < found.length; i++) {
			if (found[i] != null) {
				hit++;
			}
		}
		String[] searched = new String[hit];

		for (int i = 0; i < found.length; i++) {
			if (found[i] != null) {
				searched[j] = found[i];
				j++;
			}
		}
		return searched;
	}
	
	
	/*
	 * public static int exponentialSearch(String[] array, int n, int k, int index)
	 * { int i; if(k < array[1] || k > array[n]) { return 0; }else { i = 1; }
	 * while(k > array[i] && i < n) { i = i + i; } if(i > n) { i = n; } return
	 * binarySearch(array, i/2, i, k, index, number); }
	 */

}
