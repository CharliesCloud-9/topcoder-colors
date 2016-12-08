package colorTestPackage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.*;  
/**
 * 
 * @author carlosgallegos
 *
 * The following file contains 9 colors different colors: http://sugar.upsellit.com/sugar/big_ol_file.rar -- 4,995,329 of them.
 * The colors in the file are: black, blue, green, grey, orange, purple, red, white, and yellow.  

 * Some are misspelled by one character (ie: greqn, gr7en) or one extra character or number (ie: greeqn, gree2n). 
 * - None have more than one wrong character or more than one extra character (so you will never have gree2qn), and none have missing characters (so you will never have gren).
 * - However, some of the words in the file are complete gibberish of random length and will match nothing... not purposely at least.

 * I need a java program that parses through this file and gives me the count of each color as found in the file, including the corrections. 
 * That is to say: green, gr7en, green, greeqn, green = 5 greens. Strings like "uxzmnit", which is in the file, will match nothing.
 * Develop: in java, include java code & result with the final counts of each of the 9 colors from the file,...
 * ...along with the count of unmatched/gibberish characters. 

 * The final output for this file should be the colors and the number of times they're featured in the file:

 * black: XX,XXXX
 * blue: YY,YYYY
 * red: ZZ,ZZZZ

 * There is a correct answer, though we'll take within 99.99%. A few of the random strings will probably accidentally match a color. 
 * We'd just like it to be as close/accurate as possible. Please include your java code with the answer.
 * 
 */

public class Colors {
	 Integer count = 0;
	
	public static void main(String arg[]) throws IOException {
		int black = 0, blue = 0, green = 0, grey = 0, orange = 0, purple = 0, red = 0, white = 0, yellow = 0, other = 0;
		int fxdBlack = 0, fxdBlue = 0, fxdGreen = 0, fxdGrey = 0, fxdOrange = 0, fxdPurple = 0, fxdRed = 0, fxdWhite = 0, fxdYellow = 0;
		Scanner colorsKey = new Scanner(new File("big_ol_file.txt"));		//Scanner sBlue = new Scanner(new File("big_ol_file.txt"));
		Map<String, Integer> nextstringHash = new HashMap<String, Integer>();
		//1. Find and Count the colors with correct spelling, else put the ones without correct spelling a side.
		try {
		while (colorsKey.hasNext()) {				//while true if colorsKey file has another token(or word) in it
			String nextString = colorsKey.next();		//get the next token/word and assign it to nextString, this will represent the next word in the file.
		    if (nextString.equalsIgnoreCase("black"))  { 
		    	black++;
		    }
		    else if (nextString.equalsIgnoreCase("blue")) {
		    	blue++;
			}
		    else if (nextString.equalsIgnoreCase("green")) {
		    	green++;  	
		    }
		    else if (nextString.equalsIgnoreCase("grey") || nextString.equalsIgnoreCase("gray")) {
				grey++;		
		    }
		    else if (nextString.equalsIgnoreCase("orange")) {
		    	orange++;  	
			}
		    else if (nextString.equalsIgnoreCase("purple")) {
		    	purple++;	
		    }
		    else if (nextString.equalsIgnoreCase("red")) {
				red++;	
		    }
		    else if (nextString.equalsIgnoreCase("white")) {
				white++;
		    }
		    else if (nextString.equalsIgnoreCase("yellow")) {
				yellow++;
		    }
		    else if (nextString.startsWith("b") && nextString.endsWith("k") || nextString.contains("black") || nextString.contains("lac")) {
				fxdBlack++;
		    }
		    else if (nextString.startsWith("b") && nextString.endsWith("e") || nextString.contains("blue") || nextString.contains("lue")) {
				fxdBlue++;
		    }
		    else if (nextString.startsWith("g") && nextString.endsWith("n") || nextString.contains("green") || nextString.contains("ree")) {
				fxdGreen++;
		    }
		    else if (nextString.startsWith("g") && nextString.endsWith("y") || nextString.contains("grey") || nextString.contains("gray") || nextString.contains("rey") || nextString.contains("ray")) {
				fxdGrey++;
		    }
		    else if (nextString.startsWith("o") && nextString.endsWith("e") || nextString.contains("orange") || nextString.contains("rang")) {
				fxdOrange++;
		    }
		    else if (nextString.startsWith("p") && nextString.endsWith("e") || nextString.contains("purple") || nextString.contains("urpl")) {
				fxdPurple++;
		    }
		    else if (nextString.startsWith("r") || nextString.endsWith("d") || nextString.contains("red") || nextString.contains("ed")) {
				fxdRed++;
		    }
		    else if (nextString.startsWith("w") && nextString.endsWith("e") || nextString.contains("white") || nextString.contains("hit")) {
				fxdWhite++;
		    }
		    else if (nextString.startsWith("y") && nextString.endsWith("w") || nextString.contains("yellow") || nextString.contains("ello")) {
				fxdYellow++;
		    }
		    
		    else {	
		    //2. Separated gibberish
				other++;		//else if none of the compared strings match, than place it inside other count...these represent the misspelled/ and or gibberish words.
				Integer previousValue = nextstringHash.get(nextString);
				nextstringHash.put(nextString, previousValue == null ? 1 : previousValue + 1);
		   }
		    
		}		
		}catch (NoSuchElementException e) {	//just in case we use Exception Handling
			System.out.println("handled");
		}finally {
			colorsKey.close();
		}
		
		System.out.println();
		//System.out.printf("Frequency:   %.5f", (double) wordCountBlack / totalCount);
		System.out.println("---Originally correctly spelled colors---");
		System.out.println("black:  " + black);
		System.out.println("blue:  " + blue);
		System.out.println("green:  " + green);
		System.out.println("grey:  " + grey);
		System.out.println("orange:  " + orange);
		System.out.println("purple:  " + purple);
		System.out.println("red:  " + red);
		System.out.println("white:  " + white);
		System.out.println("yellow:  " + yellow);		
		System.out.println();
		int total = black + blue + green + grey + orange + purple + red + white + yellow + fxdBlack + fxdBlue + fxdGreen + fxdGrey + fxdOrange + fxdPurple + fxdRed + fxdWhite + fxdYellow + other;
		
		System.out.println("---Mispelled colors---");
		System.out.println("Fixed black: " + fxdBlack);
		System.out.println("Fixed blue: " + fxdBlue);
		System.out.println("Fixed green: " + fxdGreen);
		System.out.println("Fixed grey: " + fxdGrey);
		System.out.println("Fixed black: " + fxdOrange);
		System.out.println("Fixed blue: " + fxdPurple);
		System.out.println("Fixed green: " + fxdRed);
		System.out.println("Fixed grey: " + fxdWhite);
		System.out.println("Fixed green: " + fxdYellow);
		System.out.println();
		System.out.println("---Giberish colors---");
		System.out.println("Giberish  " + other);
		System.out.println();
		System.out.println("Total: " + total);
	}
	
}

