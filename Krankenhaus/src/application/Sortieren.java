package application;

public class Sortieren {

	// Methoden

	//SortierAlgorythmen
	
	//Patienten, Pfleger, Ärzte, Räume, Termine
	public static String[] sortIDAscending(String[] array) {
		
		int index = 0;
		boolean number = true;
		mergeSort(array, 0, array.length - 1,index, number);
		return array;
	}
	
	//Patienten, Pfleger, Ärzte, Räume, Termine
	public static String[] sortIDDescending(String[] array) {
		
		int index = 0;
		boolean number = true;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	//Patienten, Pfleger, Ärzte
	public static String[] sortNameAscending(String[] array) {
		
		int index = 2;
		boolean number = false;
		mergeSort(array, 0, array.length - 1,index, number);
		return array;
	}
	
	//Patienten, Pfleger, Ärzte
	public static String[] sortNameDescending(String[] array) {
		
		int index = 2;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	//Ärzte
	public static String[] sortSpecialFieldAscending(String[] array) {
		
		int index = 3;
		boolean number = false;
		quickSort(array, 1, array.length - 1, index, number);
		return array;
	}
	
	//Ärzte
	public static String[] sortSpecialFieldDescending(String[] array) {
		
		int index = 3;
		boolean number = false;
		quickSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	//Patienten
	public static String[] sortAgeAscending(String[] array) {
		
		int index = 3;
		boolean number = true;
		quickSort(array, 0, array.length - 1, index, number);
		return array;
	}
	
	//Patienten
	public static String[] sortAgeDescending(String[] array) {
		
		int index = 3;
		boolean number = true;
		quickSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	//Patienten
	public static String[] sortReasonForStayAscending(String[] array) {
		
		int index = 4;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		return array;
	}
	
	//Patienten
	public static String[] sortReasonForStayDescending(String[] array) {
		
		int index = 4;
		boolean number = false;
		mergeSort(array, 0, array.length - 1, index, number);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	////////////////
	//Eventuell zusätzlich/ nicht im Pflichtenheft
	public static String[] sortOperationDateAscending(String[] array) {
		
		return array;
	}
	////////////////
	
	//MergeSort
	public static void mergeSort(String[] array, int l, int r, int index, boolean number) {
		int q;
		if(l < r) {
			q = (l + r)/2;
			mergeSort(array, l, q, index, number);
			mergeSort(array, q + 1, r, index, number);
			if(number) {
				mergeInt(array, l, q, r, index);
			}else {
				mergeString(array, l, q, r, index);
			}
		}
	}
	
	//merge für Strings
	public static void mergeString(String[] array, int l, int q, int r, int index) {
		
		int leftProgress,rightProgress,overallProgress;
		
		int leftLength = q - l + 1;
		int rightLength = r - q;
		
		String[] leftArray = new String[leftLength]; 
		String[] rightArray = new String[rightLength];
		
		for(int i = 0; i < leftLength; i++) {
			leftArray[i] = array[l + i];
		}
		
		for(int j = 0; j < rightLength; j++) {
			rightArray[j] = array[q + 1 + j];
		}
		
		leftProgress = 0;
		rightProgress = 0;
		overallProgress = l;
		
		//vergleicht die Worte
		while(leftProgress < leftLength && rightProgress < rightLength) {
			
			//Nachnamen werden auf chars herunter gebrochen
			String[] leftLine = leftArray[leftProgress].split(",");
			String[] rightLine = rightArray[rightProgress].split(",");
			String leftWord = leftLine[index].toLowerCase();
			String rightWord = rightLine[index].toLowerCase();
			char[] leftLetters = leftWord.toCharArray();
			char[] rightLetters = rightWord.toCharArray();
			int i = 0;
			
			//Nachnamen werden verglichen
			while(true) {
				if(i < leftLetters.length && i < rightLetters.length) {
					if(leftLetters[i] < rightLetters[i]) {
						array[overallProgress] = leftArray[leftProgress];
						leftProgress++;
						break;
					}else if(leftLetters[i] > rightLetters[i]){
						array[overallProgress] = rightArray[rightProgress];
						rightProgress++;
						break;
								
					}else if(leftLetters[i] == rightLetters[i]){
						i++;
						continue;
							
					}else {
						break;
					}
				
				//wenn die Nachnamen identisch sind
				}else {
					
					//Vornamen werden auf chars herunter gebrochen
					String leftWordFN = leftLine[index - 1].toLowerCase();
					String rightWordFN = rightLine[index - 1].toLowerCase();
					char[] leftLettersFN = leftWordFN.toCharArray();
					char[] rightLettersFN = rightWordFN.toCharArray();
					int j = 0;
					
					//vergleicht die Vornamen
					while(true) {
						if(j < leftLettersFN.length && j < rightLettersFN.length) {
							if(leftLettersFN[j] < rightLettersFN[j]) {
								array[overallProgress] = leftArray[leftProgress];
								leftProgress++;
								break;
							}else if(leftLettersFN[j] > rightLettersFN[j]){
								array[overallProgress] = rightArray[rightProgress];
								rightProgress++;
								break;
										
							}else if(leftLettersFN[j] == rightLettersFN[j]){
								j++;
								continue;
									
							}else {
								break;
							}
							
						//wenn auch die Vornamen identisch sind
						}else {
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
		
		//füllt das Gesamtarray mit den restlichen Werten des linke Teilarrays
		while(leftProgress < leftLength) {
			array[overallProgress] = leftArray[leftProgress];
			leftProgress++;
			overallProgress++;
		}
		
		//füllt das Gesamtarray mit den restlichen Werten des linke Teilarrays
		while(rightProgress < rightLength) {
			array[overallProgress] = rightArray[rightProgress];
			rightProgress++;
			overallProgress++;
		}
	}
	
	//merge für Zahlen
	public static void mergeInt(String[] array, int l, int q, int r, int index) {
		
		int leftProgress,rightProgress,overallProgress;
		
		int leftLength = q - l + 1;
		int rightLength = r - q;
		
		String[] leftArray = new String[leftLength]; 
		String[] rightArray = new String[rightLength];
		
		for(int i = 0; i < leftLength; i++) {
			leftArray[i] = array[l + i];
		}
		
		for(int j = 0; j < rightLength; j++) {
			rightArray[j] = array[q + 1 + j];
		}
		
		leftProgress = 0;
		rightProgress = 0;
		overallProgress = l;
		
		//Solange beide Arrays Elemente enthalten, werden die ersten beiden Werte der Arrays in der while-Schleife verglichen
		while(leftProgress < leftLength && rightProgress < rightLength) {
			
			String[] leftLine = leftArray[leftProgress].split(",");
			String[] rightLine = rightArray[rightProgress].split(",");
			
			if(Integer.parseInt(leftLine[index]) <= Integer.parseInt(rightLine[index])) {
				array[overallProgress] = leftArray[leftProgress];
				leftProgress++;
			}else {
				array[overallProgress] = rightArray[rightProgress];
				rightProgress++;
			}
			overallProgress++;
		}
		
		//wenn nur noch ein Teilarray Werte enthält, wird das gemergte Array mit diesen aufgefüllt
		while(leftProgress < leftLength) {
			array[overallProgress] = leftArray[leftProgress];
			leftProgress++;
			overallProgress++;
		}
		
		while(rightProgress < rightLength) {
			array[overallProgress] = rightArray[rightProgress];
			rightProgress++;
			overallProgress++;
		}
	}
	
	
	public static void quickSort(String[] array, int l, int r, int index, boolean number) {
		System.out.println("in quick sort");
		int i, j;
		String pivot, note;
		if(l < r) {
			i = l - 1;
			j = r;
			pivot = array[r];
			
			System.out.println("///////////////////////////");
			System.out.println(pivot);
			System.out.println(r);
			System.out.println("///////////////////////////");
			for(int x = 0; x < array.length; x++) {
				System.out.println(array[x]);
			}
			System.out.println("///////////////////////////");
			
			while(i <= j) {
				System.out.println("in der while");
				System.out.println(i);
				System.out.println(j);
				while(check(array, pivot, i, "<=", index, number)) {
					i++;
				}
				System.out.println("zweite while");
				while(j >= l && check(array, pivot, j, ">=", index, number)) {
					j--;
				}
				if(i >= j) {
					partition(array, l, i, r, index, number);
				}else {
					System.out.println("§§§§§§§§§§§§§§§§§§§§");
					System.out.println("tausch");
					System.out.println(array[i]);
					System.out.println(array[j]);
					note = array[i];
					array[i] = array[j];
					array[j] = note;
					System.out.println(array[i]);
					System.out.println(array[j]);
					System.out.println("§§§§§§§§§§§§§§§§§§§§");
				}
			}
		}
	}
	
	public static void partition (String[] array, int l, int i, int r, int index, boolean number) {
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("in partition");
		System.out.println("i ist " + i);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		
		String note;
		if(i < array.length) {
			System.out.println("i ist verdammt nochmal " + i);
			note = array[i];
			array[i] = array[r];
			array[r] = note;
			System.out.println(note);
		}else {
			i--;
			note = array[i];
			array[i] = array[r];
			array[r] = note;
		}
		System.out.println(l);
		System.out.println(i);
		System.out.println(r);
		
		quickSort(array, l, i - 1, index, number);
		System.out.println("unteres quicksort array");
		quickSort(array, i + 1, r, index, number);
	}
	
	public static boolean check(String[] array, String pivot, int counter, String sign, int index, boolean number) {
		boolean check = false;
		if(counter >= array.length) {
			return false;
		}
		
			String[] leftSide = array[counter].split(",");
			String[] rightSide = pivot.split(",");
		
		if(number) {
			if(sign.equals("<=")) {
				if(Integer.parseInt(leftSide[index]) <= Integer.parseInt(rightSide[index])){
					check = true;
				}
			}else if(sign.equals(">=")) {
				if(Integer.parseInt(leftSide[index]) >= Integer.parseInt(rightSide[index])) {
					check = true;
				}
			}else {
				check = false;
			}
		}
		
		if(!number) {
			String leftWord = leftSide[index].toLowerCase();
			String rightWord = rightSide[index].toLowerCase();
			char[] leftLetters = leftWord.toCharArray();
			char[] rightLetters = rightWord.toCharArray();
			int i = 0;
			
			System.out.println("################################");
			System.out.println(sign);
			System.out.println(leftWord);
			System.out.println(rightWord);
			System.out.println("################################");
			
			if(sign.equals("<=")) {
				while(i < leftLetters.length || i < rightLetters.length) {
					if(leftLetters[i] <= rightLetters[i]){
						check = true;
						break;
					}else if(leftLetters[i] > rightLetters[i]){
						check = false;
						break;
					}else {
						i++;
					}
				}
			}else if(sign.equals(">=")) {
				while(i < leftLetters.length || i < rightLetters.length) {
					if(leftLetters[i] >= rightLetters[i]){
						check = true;
						break;
					}else if(leftLetters[i] < rightLetters[i]){
						check = false;
						break;
					}else {
						i++;
					}
				}
			}else {
				check = false;
			}
		}
		System.out.println(check);
		return check;
	}
	
	//kehrt das Array um
	public static String[] reverse(String[] array) {
		String[] reversed = new String[array.length];
		int count = array.length;;
		
		for(int i = 0; i < array.length; i++) {
			reversed[count - 1] = array[i];
			count--;
		}
		return reversed;
	}
	
	//BubbleSort Alphabetisch
	/*public static String[] sortiereAlphabetisch(String[] array) {
		String memory;
		
		for(int k = 0; k <= array.length - 2; k++) {
			for(int j = 0; j < array.length - 1; j++) {
				char[] letters = array[j].toCharArray();
				char[] letters2 = array[j + 1].toCharArray();				
				int i = 0;
			
				while(true) {
					if(letters[i] > letters2[i]) {
						memory = array[j];
						array[j] = array[j + 1];
						array[j + 1] = memory;
						break;
					}else if(letters[i] == letters2[i]){
						i++;
						continue;
					}else {
						break;
					}
				}
			}
		}
		return array;
	}

	
	//BubbleSort Nummerisch
	public static int[] sortiereNummerisch(int[] array) {

		int memory;
		
		for(int j = 0; j <= array.length - 2; j++) {
			for(int i = 0; i < array.length -1; i++) {
				if(array[i] > array[i+1]) {
					memory = array[i];
					array[i] = array[i + 1];
					array[i + 1] = memory;
				}
			}
		}
		
		return array;
	}*/

}
