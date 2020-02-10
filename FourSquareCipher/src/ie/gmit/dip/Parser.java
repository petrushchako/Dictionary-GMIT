
package ie.gmit.dip;

import java.io.*;
import java.net.URL;

public class Parser {

    private String decryptedText="";
    private String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    private String[][] alphabetTable = new String[5][5];    
    private String[][] keyTable = new String[5][5];
	// Take input key, convert to upper case, replace j with I(if J is in the password(key))    

    
	private static String removeDuplicateChars(String keyInput){
	    char[] a = keyInput.toUpperCase().replace("J", "I").toCharArray();
		String result = "";                                               //String without duplicades
		for (int i = 0; i < a.length; i++) {
			if (!result.contains("" + a[i])){           
				result += a[i];
			}
		}
	    return result;
	}
	
	
	private String[] split(String text){
	    String plaintext = text.toUpperCase();
	    if (plaintext.length() % 2 != 0) {        // check that last pair exists
	        plaintext = plaintext + "X";          // if not, than ad "X"
	    }
	    String[] pairs = new String[plaintext.length() / 2];
	    int count = 0;
	    for (int i = 0; i < pairs.length / 2; i++) {
	        pairs[i] = plaintext.substring(count, count + 2);
	        count = count + 2;
	    }
	    return pairs;
	}
	
	
	public void  keyTableArray(String keyInput){
	    populateKeyTable(removeDuplicateChars(keyInput + alphabet), keyTable);
	    populateKeyTable(alphabet, alphabetTable);
	}
	

	 private String [][] populateKeyTable(String text, String[][] table){
	    int counter = 0;
	    for(int i = 0; i < table.length; i++){
	         for(int j = 0; j < table[i].length; j++){
	                table[i][j] = text.substring(counter, counter+1);
	                counter++;
	          } 
	    }  
	   return table;
	 }

	
	private boolean isEqual(String text1, String text2){  // compares input letter to letter in the array
	     return (text1.compareTo(text2) == 0);
	}
	


	public String decrypt(String textToDecrypt){
			
	         int x1 = 0; 
	         int y1 = 0;
	         int x2 = 0; 
	         int y2 = 0;
	         
	         String[] pairs = split(textToDecrypt);       // split file into string of pairs
	         StringBuilder decryptText = new StringBuilder();
	         String firstLetter;
	         String secondLetter;
	         
	         for(int i = 0; i < pairs.length; i++){
	            String pair = pairs[i];
	 
	            firstLetter = pair.substring(0, 1);
	            secondLetter = pair.substring(1,2);
	            for(int k=0; k < keyTable.length; k++){
	                for(int j=0; j < keyTable[k].length; j++){
	                   if (isEqual(keyTable[k][j], firstLetter)) {                   
	                        x1 = k;
	                        y1 = j;
	                    }else if (isEqual(keyTable[i][j], secondLetter)) {
	                        x2 = k;
	                        y2 = j;
	                    }
	                }
	            }

	           decryptedText = decryptText.append(alphabetTable[x2][y1]).append(alphabetTable[x1][y2]).toString();
	         }   

	            System.out.println(decryptedText);  
	          return decryptedText;
	}
}
