package com;

import java.io.*;
import java.util.*;


public class Solution {

	/*
	 * Two Characters
	 */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        char[] schar = s.toCharArray();
   
        //we determine all of the unique characters
        HashSet<Character> unique = new HashSet<Character>();
        for(int i = 0; i < schar.length; i++){
            unique.add(schar[i]);
        }
      
        //create a HashSet of Every Combination
        String alphabet = "";
        for(char letter: unique){
          alphabet = alphabet + letter;
        }
        HashSet<String> combos = pairs(alphabet.toCharArray());
        
        //create a list of all the types the modified Strings
        ArrayList<String> modStrings = new ArrayList<String>();
        for(String str: combos){
           modStrings.add(createString(str,s));
        }
      
        int max = 0;
        int value = 0;
        for(String str: modStrings){
            value = checkRepeat(str.toCharArray());
            if(value > max){
                max = value;
            }
        }
        
        System.out.println(max);
    }
  
  /**
   * 
   * @param combo
   * @param input
   * This method takes in a two letters in the String Combo
   * Then it iterates through the input and only the two characters that are in 
   * in Input get added to our String Array
   */
  private static String createString(String combo, String input){
      char[] ab = combo.toCharArray();
      char a = ab[0];
      char b = ab[1];
      char[] inputArr = input.toCharArray();
      String str = "";
    
      for(int i = 0; i < inputArr.length; i++){
          if(inputArr[i] == a || inputArr[i] == b){
              str = str + inputArr[i];
          }
      }
      return str;

  }
  
  private static HashSet<String> pairs(char[] alpha){
		HashSet<String> combos = new HashSet<String>();
		for(int i = 0; i < alpha.length; i++){
			for(int x = i + 1; x < alpha.length; x++){
				String element = alpha[i] + "" + alpha[x];
				combos.add(element);
			}
		}
		return combos;
	}
  
    private static int checkRepeat(char[] input){
    
        for(int i = 1; i < input.length; i++){
            char a = input[i - 1];
            char b = input[i];
            if(a == b){
                return -1;
            }
        }
      
        return input.length;
    }
}
