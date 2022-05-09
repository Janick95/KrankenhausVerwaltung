package application;

public class Sortieren {

	// Methoden

	//BubbleSort Alphabetisch
	public static String[] sortiereAlphabetisch(String[] array) {

		String memory;
		
		for(int j = 0; j <= array.length; j++) {
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
		
		for(int j = 0; j <= array.length; j++) {
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
