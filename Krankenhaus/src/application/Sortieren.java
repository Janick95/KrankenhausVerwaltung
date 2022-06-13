package application;

public class Sortieren {

	// Methoden

	//SortierAlgorythmen
	//mergeSort //funktioniert
	public static String[] sortIDAscending(String[] array) {
		
		int index = 0;
		mergeSort(array, 0, array.length - 1,index);
		return array;
	}
	
	public static String[] sortIDDescending(String[] array) {
		
		int index = 0;
		mergeSort(array, 0, array.length - 1, index);
		String[] reversed = reverse(array);
		return reversed;
	}
	
	public static String[] sortNameAscending(String[] array) {
		
		int index = 3;
		mergeSort(array, 0, array.length - 1,index);
		
		
		return array;
	}
	
	public static String[] sortNameDescending(String[] array) {
		
		return array;
	}
	
	public static String[] sortProfessionAscending(String[] array) {
		
		return array;
	}
	
	public static String[] sortProfessionDescending(String[] array) {
		
		return array;
	}
	
	public static String[] sortReasonForStayAscending(String[] array) {
		
		return array;
	}
	
	public static String[] sortReasonForStayDescending(String[] array) {
		
		return array;
	}
	
	
	//Eventuell zusätzlich/ nicht im Pflichtenheft
	public static String[] sortOperationDateAscending(String[] array) {
		
		return array;
	}
	
	
	//MergeSort
	public static void mergeSort(String[] array, int l, int r, int index) {
		int q;
		if(l < r) {
			q = (l + r)/2;
			System.out.println("mergesort");
			mergeSort(array, l, q, index);
			System.out.println("mergesort 2");
			mergeSort(array, q + 1, r, index);
			mergeInt(array, l, q, r, index);
		}
	}
	
	/*public static void merge(String[] array, int l, int q, int r, int index) {
		System.out.println("Merge");
		System.out.println("//////////////");
		System.out.println(l);
		System.out.println(q);
		System.out.println(r);
		System.out.println("//////////////");
		
		int leftProgress,rightProgress,overallProgress;
		
		int leftLength = q - l + 1;
		int rightLength = r - q;
		
		String[] leftArray = new String[leftLength]; 
		String[] rightArray = new String[rightLength];
		
		for(int i = 0; i < leftLength; i++) {
			leftArray[i] = array[l + 1];
		}
		
		for(int j = 0; j < rightLength; j++) {
			rightArray[j] = array[q + 1 + j];
		}
		
		leftProgress = 0;
		rightProgress = 0;
		overallProgress = l;
		
		//für string erweitern
		while(leftProgress < leftLength && rightProgress < rightLength) {
			if(leftArray[leftProgress] <= rightArray[rightProgress]) {
				array[overallProgress] = leftArray[leftProgress];
				leftProgress++;
			}else {
				array[overallProgress] = rightArray[rightProgress];
				rightProgress++;
			}
			overallProgress++;
		}
		
		
		
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
	}*/
	
	//merge für zahlen
	public static void mergeInt(String[] array, int l, int q, int r, int index) {
		
		System.out.println("Merge");
		System.out.println("//////////////");
		System.out.println(l);
		System.out.println(q);
		System.out.println(r);
		System.out.println("//////////////");
		
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
	public static String[] sortiereAlphabetisch(String[] array) {

		String memory;
		
		for(int j = 0; j <= array.length - 2; j++) {
			for(int i = 0; i <= array.length; i++) {
				if(array[i].compareTo(array[i + 1]) > 0) {
					memory = array[i];
					array[i] = array[i + 1];
					array[i + 1] = memory;
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
	}

}
