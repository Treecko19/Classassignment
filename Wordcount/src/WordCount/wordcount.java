package WordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class wordcount {

	public static void main (String[] args)throws FileNotFoundException {
	java.util.HashMap<String, Integer> map = new HashMap<String, Integer>();
	//stores the words
	
	Scanner txtFile = new Scanner(new File ("C:\\Users\\Treecko\\Documents\\Poem.txt")); // file reader 
	while(txtFile.hasNext()) {
		String word = txtFile.next();
		if (map.containsKey(word)) {
			int count = map.get(word) +1 ;
			// adds a counter for the word
			map.put(word, count) ;
		}
		else {
			map.put(word, 1) ;
		}
			
	}
	txtFile.close();
	for (Map.Entry<String, Integer> entry : map.entrySet()) {
		System.out.println(entry);
	}
}
}
