package WordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordcount {

	public static void main (String[] args)throws FileNotFoundException {
	java.util.HashMap<String, Integer> map = new HashMap<String, Integer>();
	//stores the words
	String regEx = "[a-zA-Z]+";
	Pattern pattern = Pattern.compile(regEx);
	Scanner txtFile = new Scanner(new File ("C:\\Users\\Treecko\\Documents\\message.txt")); // file reader
	boolean start = false ;
	while(txtFile.hasNext()) {
		String word = txtFile.next();
		
		
	if (word.equals("class=\"poem\">")) {
		start = true ; 
		continue;
	} if (word.equals("</p>")) {
		start = false ;
	}
	if (start ) {
		
		Matcher matcher = pattern.matcher(word);
		while (matcher.find()) {
			//System.out.println(word);
			if (matcher.group().equals("i")) { // remove <i>
				continue ;
			}
			word=matcher.group().toLowerCase();
           if (word.equals("br" )  || word.equals("span")|| word.equals("style") || word.equals("margin") || word.equals("left")) { // gets rid of HTML 
        	   continue ; 
           }
			if (map.containsKey(word)) {
				int count = map.get(word) +1 ;
				// adds a counter for the word
				map.put(word, count) ;
			}
			else {
				map.put(word, 1) ;
			}
		//System.out.println(word);
	}
		
	}	
			
	}
	txtFile.close();
	/*for (Map.Entry<String, Integer> entry : map.entrySet()) {
		System.out.println(entry);
	}*/
	Object[] sortedMap = map.entrySet().toArray();
	Arrays.sort(sortedMap, new Comparator() {
	    public int compare(Object a, Object b) {
	        return ((Map.Entry<String, Integer>) b).getValue()
	                   .compareTo(((Map.Entry<String, Integer>) a).getValue());
	    }
	});
	int i = 0 ;
	for (Object track : sortedMap) {
	    if (i < 20 ) { // sorts for the top 20 
	    	System.out.println(((Map.Entry<String, Integer>) track).getKey() + " : "
	            + ((Map.Entry<String, Integer>) track).getValue());
	    	i++ ;
	    }
		
	}
}
}

//class="poem">  </p>