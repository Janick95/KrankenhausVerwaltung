package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
	
	//Die Methode erwartet den Dateipfad eines Textdokumentes und gibt den Inhalt der entsprechenden Textdatei als Array zurück
	public static String[] readToArray(String file) throws IOException {
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		int numberOfLines = 0;
		
		while(bufferedReader.readLine() != null) {
			numberOfLines ++;
		}
		bufferedReader.close();
		
		String[] text = new String[numberOfLines];
		
		//Erstellt einen neuen Reader, damit der Schreibkopf wieder am Anfang des Dokumentes steht. Ansonsten würde nur null ausgelesen werden
		FileReader reader2 = new FileReader(file);
		BufferedReader bufferedReader2 = new BufferedReader(reader2);
		
		for(int i = 0; i < text.length; i++) {
			if((text[i] = bufferedReader2.readLine()) != null) {
			}
		}
		bufferedReader2.close();
		return text;
	}
	
	//Die Methode erwartet den zu schreibenden Text als String, sowie den Dteipfad des Textdokumentes, in das geschrieben werden soll
	public static void writeStringIntoTxt(String text, String file) throws IOException {
		
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		bufferedWriter.write(text);
		
		bufferedWriter.close();
	}
}
