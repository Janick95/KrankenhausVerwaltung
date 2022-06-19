package application;

public class Sortieren {

	// Methoden

	// Sortiermethoden

	// Patienten, Pfleger, Ärzte, Räume, Termine
	public static String[] sortIDAscending(String[] array) {

		int index = 0;
		boolean number = true;
		quickSort(array, 0, array.length - 1, index, number);
		return array;
	}

	// Patienten, Pfleger, Ärzte, Räume, Termine
	public static String[] sortIDDescending(String[] array) {

		int index = 0;
		boolean number = true;
		quickSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}

	// Patienten, Pfleger, Ärzte
	public static String[] sortNameAscending(String[] array) {

		int index = 2;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		return array;
	}

	// Patienten, Pfleger, Ärzte
	public static String[] sortNameDescending(String[] array) {

		int index = 2;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}

	// Ärzte
	public static String[] sortSpecialFieldAscending(String[] array) {

		int index = 3;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);

		return array;
	}

	// Ärzte
	public static String[] sortSpecialFieldDescending(String[] array) {

		int index = 3;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}

	// Patienten
	public static String[] sortAgeAscending(String[] array) {

		int index = 3;
		boolean number = true;
		mergeSort(array, 0, array.length - 1, index, number);
		System.out.println("in AgeAs geschrieben");
		for (int x = 0; x < array.length; x++) {
			System.out.println(array[x]);
		}
		return array;
	}

	// Patienten
	public static String[] sortAgeDescending(String[] array) {

		int index = 3;
		boolean number = true;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}

	// Patienten
	public static String[] sortReasonForStayAscending(String[] array) {

		int index = 4;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		return array;
	}

	// Patienten
	public static String[] sortReasonForStayDescending(String[] array) {

		int index = 4;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}

	////////////////
	// Eventuell zusätzlich/ nicht im Pflichtenheft
	// Termine
	public static String[] sortOperationDateAscending(String[] array) {

		int index = 7;
		boolean number = true;
		mergeSort(array, 0, array.length - 1, index, number);
		return array;
	}
	////////////////

	// SortierAlgorythmen
	public static void mergeSort(String[] array, int l, int r, int index, boolean number) {
		int m;
		if (l < r) {
			m = (l + r) / 2;
			mergeSort(array, l, m, index, number);
			mergeSort(array, m + 1, r, index, number);
			if (number) {
				mergeInt(array, l, m, r, index);
			} else {
				mergeString(array, l, m, r, index);
			}
		}
	}

	// merge für Strings
	public static void mergeString(String[] array, int l, int m, int r, int index) {

		int leftProgress, rightProgress, overallProgress;

		int leftLength = m - l + 1;
		int rightLength = r - m;

		String[] leftArray = new String[leftLength];
		String[] rightArray = new String[rightLength];

		for (int i = 0; i < leftLength; i++) {
			leftArray[i] = array[l + i];
		}

		for (int j = 0; j < rightLength; j++) {
			rightArray[j] = array[m + 1 + j];
		}

		leftProgress = 0;
		rightProgress = 0;
		overallProgress = l;

		// vergleicht die Worte
		while (leftProgress < leftLength && rightProgress < rightLength) {

			// Nachnamen werden auf chars herunter gebrochen
			String[] leftLine = leftArray[leftProgress].split(",");
			String[] rightLine = rightArray[rightProgress].split(",");
			String leftWord = leftLine[index].toLowerCase();
			String rightWord = rightLine[index].toLowerCase();
			char[] leftLetters = leftWord.toCharArray();
			char[] rightLetters = rightWord.toCharArray();
			int i = 0;

			// Nachnamen werden verglichen
			while (true) {
				if (i < leftLetters.length && i < rightLetters.length) {
					if (leftLetters[i] < rightLetters[i]) {
						array[overallProgress] = leftArray[leftProgress];
						leftProgress++;
						break;
					} else if (leftLetters[i] > rightLetters[i]) {
						array[overallProgress] = rightArray[rightProgress];
						rightProgress++;
						break;

					} else if (leftLetters[i] == rightLetters[i]) {
						i++;
						continue;

					} else {
						break;
					}

					// wenn die Nachnamen identisch sind
				} else {

					// Vornamen werden auf chars herunter gebrochen
					String leftWordFN = leftLine[index - 1].toLowerCase();
					String rightWordFN = rightLine[index - 1].toLowerCase();
					char[] leftLettersFN = leftWordFN.toCharArray();
					char[] rightLettersFN = rightWordFN.toCharArray();
					int j = 0;

					// vergleicht die Vornamen
					while (true) {
						if (j < leftLettersFN.length && j < rightLettersFN.length) {
							if (leftLettersFN[j] < rightLettersFN[j]) {
								array[overallProgress] = leftArray[leftProgress];
								leftProgress++;
								break;
							} else if (leftLettersFN[j] > rightLettersFN[j]) {
								array[overallProgress] = rightArray[rightProgress];
								rightProgress++;
								break;

							} else if (leftLettersFN[j] == rightLettersFN[j]) {
								j++;
								continue;

							} else {
								break;
							}

							// wenn auch die Vornamen identisch sind
						} else {
							array[overallProgress] = leftArray[leftProgress];
							leftProgress++;
							overallProgress++;
							array[overallProgress] = rightArray[rightProgress];
							rightProgress++;
							break;
						}
					}
					break;
				}
			}
			overallProgress++;
		}

		// füllt das Gesamtarray mit den restlichen Werten des linke Teilarrays
		while (leftProgress < leftLength) {
			array[overallProgress] = leftArray[leftProgress];
			leftProgress++;
			overallProgress++;
		}

		// füllt das Gesamtarray mit den restlichen Werten des linke Teilarrays
		while (rightProgress < rightLength) {
			array[overallProgress] = rightArray[rightProgress];
			rightProgress++;
			overallProgress++;
		}
	}

	// merge für Zahlen
	public static void mergeInt(String[] array, int l, int m, int r, int index) {

		int leftProgress, rightProgress, overallProgress;

		int leftLength = m - l + 1;
		int rightLength = r - m;

		String[] leftArray = new String[leftLength];
		String[] rightArray = new String[rightLength];

		for (int i = 0; i < leftLength; i++) {
			leftArray[i] = array[l + i];
		}

		for (int j = 0; j < rightLength; j++) {
			rightArray[j] = array[m + 1 + j];
		}

		leftProgress = 0;
		rightProgress = 0;
		overallProgress = l;

		// solange beide Arrays Elemente enthalten, werden die ersten beiden Werte der
		// Arrays in der while-Schleife verglichen
		while (leftProgress < leftLength && rightProgress < rightLength) {

			String[] leftLine = leftArray[leftProgress].split(",");
			String[] rightLine = rightArray[rightProgress].split(",");

			if (Integer.parseInt(leftLine[index]) <= Integer.parseInt(rightLine[index])) {
				array[overallProgress] = leftArray[leftProgress];
				leftProgress++;
			} else {
				array[overallProgress] = rightArray[rightProgress];
				rightProgress++;
			}
			overallProgress++;
		}

		// wenn nur noch ein Teilarray Werte enthält, wird das gemergte Array mit diesen
		// aufgefüllt
		while (leftProgress < leftLength) {
			array[overallProgress] = leftArray[leftProgress];
			leftProgress++;
			overallProgress++;
		}

		while (rightProgress < rightLength) {
			array[overallProgress] = rightArray[rightProgress];
			rightProgress++;
			overallProgress++;
		}
	}

	public static void quickSort(String[] array, int l, int r, int index, boolean number) {
		int i, j;
		String pivot, note;
		if (l < r) {
			i = l;
			j = r - 1;
			pivot = array[r];
			System.out.println(i);
			System.out.println(j);

			while (i <= j) {
				System.out.println(i);
				System.out.println(j);
				while (check(array, pivot, i, "<", index, number)) {
					i++;
				}
				while (j >= l && check(array, pivot, j, ">", index, number)) {
					j--;
				}
				if (i >= j) {
					partition(array, l, i, r, index, number);
				} else {
					System.out.println("tausch");
					note = array[i];
					array[i] = array[j];
					array[j] = note;
				}
			}
		}
	}

	public static void partition(String[] array, int l, int i, int r, int index, boolean number) {
		String note;
		if (i < array.length) {
			note = array[i];
			array[i] = array[r];
			array[r] = note;
		}

		quickSort(array, l, i - 1, index, number);
		quickSort(array, i + 1, r, index, number);
	}

	public static boolean check(String[] array, String pivot, int counter, String sign, int index, boolean number) {
		boolean check = false;
		if (counter >= array.length) {
			return false;
		}

		String[] leftSide = array[counter].split(",");
		String[] rightSide = pivot.split(",");

		if (number) {
			if (sign.equals("<")) {
				if (Integer.parseInt(leftSide[index]) < Integer.parseInt(rightSide[index])) {
					check = true;
				}
			} else if (sign.equals(">")) {
				if (Integer.parseInt(leftSide[index]) > Integer.parseInt(rightSide[index])) {
					check = true;
				}
			} else {
				check = false;
			}
		}

		if (!number) {
			String leftWord = leftSide[index].toLowerCase();
			String rightWord = rightSide[index].toLowerCase();
			char[] leftLetters = leftWord.toCharArray();
			char[] rightLetters = rightWord.toCharArray();
			int i = 0;

			if (sign.equals("<")) {
				while (i < leftLetters.length || i < rightLetters.length) {
					if (leftLetters[i] < rightLetters[i]) {
						check = true;
						break;
					} else if (leftLetters[i] > rightLetters[i]) {
						check = false;
						break;
					} else {
						i++;
					}
				}
			} else if (sign.equals(">")) {
				while (i < leftLetters.length || i < rightLetters.length) {
					if (leftLetters[i] > rightLetters[i]) {
						check = true;
						break;
					} else if (leftLetters[i] < rightLetters[i]) {
						check = false;
						break;
					} else {
						i++;
					}
				}
			} else {
				check = false;
			}
		}
		return check;
	}

	// kehrt das Array um
	public static String[] reverse(String[] array) {
		String[] reversed = new String[array.length];
		int count = array.length;

		for (int i = 0; i < array.length; i++) {
			reversed[count - 1] = array[i];
			count--;
		}
		return reversed;
	}
}
