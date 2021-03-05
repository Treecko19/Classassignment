package WordCount;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class wordcount {
	private static JFrame frame;
public wordcount () {
	
}
	public static void main (String[] args)throws FileNotFoundException {
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI window = new GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	
	
}
	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	
         public static String returnwordcount () throws FileNotFoundException {
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
        		StringBuilder countlist = new StringBuilder(); 
        		for (Object track : sortedMap) {
        		    if (i < 20 ) { // sorts for the top 20 
        		    	countlist.append(((Map.Entry<String, Integer>) track).getKey() + " : "
        		            + ((Map.Entry<String, Integer>) track).getValue() +"\n" );
        		    	i++ ;
        		    }
        			
        		}
        		return countlist.toString() ; 
         }
	/**
	 * Initialize the contents of the frame.
	 */
/*	public static void initialize() {
		

		frame = new JFrame();
	
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Click me :D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello");
				/* try {
					JOptionPane.showMessageDialog(null, returnwordcount());
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}/
			}
		});
		btnNewButton.setBounds(166, 167, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("This is a Gui example");
		lblNewLabel.setBounds(60, 65, 318, 34);
		frame.getContentPane().add(lblNewLabel);
	*}*/
}

//class="poem">  </p>