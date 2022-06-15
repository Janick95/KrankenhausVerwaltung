package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	
	//Die Methode erwartet den zu schreibenden Text als String, sowie den Dateipfad des Textdokumentes, in das geschrieben werden soll
	public static void writeStringIntoTxt(String text, String file) throws IOException {
		
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		if(bufferedReader.readLine() != null) {
			bufferedWriter.newLine();
		}
		bufferedWriter.write(text);
		bufferedWriter.close();
		bufferedReader.close();
	}
	
	//die Methode nimmt alle Einträge einer Zeile im Textdokument als Array entgegen, fügt sie zu einem String zusammen und schreibt diesen in das Textdokument
	public static void writeStringIntoTxt(String[] text, String file) throws IOException {
		
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i = 0; i < text.length; i++) {
		stringBuilder.append(text[i]);
		}
		
		if(bufferedReader.readLine() != null) {
			bufferedWriter.newLine();
		}
		bufferedWriter.write(stringBuilder.toString());
		bufferedWriter.close();
		bufferedReader.close();
	}
	
	
	//Sucht nach dem gewünschten Eintrag und löscht die gesamte Zeile, in der der Eintrag vorkommt; Funktioniert nur mit einem Eintrag und dem löschen einer Zeile
	public static void deleteFromTxt(String word, String file) throws IOException {
		
		//Speichert die Infos aus dem Textdokument im Array
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		int numberOfLines = 0;
		
		while(bufferedReader.readLine() != null) {
			numberOfLines ++;
		}
		bufferedReader.close();
		
		String[] data = new String[numberOfLines];
		
		FileReader reader2 = new FileReader(file);
		BufferedReader bufferedReader2 = new BufferedReader(reader2);
		
		for(int i = 0; i < data.length; i++) {
			if((data[i] = bufferedReader2.readLine()) != null) {}
		}
		
		//Löscht die zu entfernende Zeile aus dem Array
		boolean hit = false;
		
		for(int i = 0; i < data.length; i++) {
			String [] line = data[i].split(",");
			
			for(int j = 0; j < line.length; j++) {
				if(line[j].equals(word)) {
					hit = true;
					data[i] = null;
					break;
				}
			}
			if(hit) {
				break;
			}
		}
		
		bufferedReader2.close();
		
		//Löscht den Inhalt des Textdokumentes
		FileWriter writer = new FileWriter(file, false);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		bufferedWriter.write("");
		bufferedWriter.close();
		
		//Schreibt restliche Daten wieder in das Textdokument
		FileWriter writer2 = new FileWriter(file, true);
		BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);
		FileReader reader3 = new FileReader(file);
		BufferedReader bufferedReader3 = new BufferedReader(reader3);
		
		for(int i = 0; i < data.length; i++) {
			
			if(data[i] != null) {
				if(i != 0) {
					bufferedWriter2.newLine();
				}
				bufferedWriter2.write(data[i]);
			}
		}
		bufferedWriter2.close();
		bufferedReader3.close();
		
	}
}
