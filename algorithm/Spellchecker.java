package algorithm;

/*
 * https://leetcode.com/contest/weekly-contest-117/problems/vowel-spellchecker/
 *   966. Vowel Spellchecker
	User Accepted: 565
	User Tried: 966
	Total Accepted: 575
	Total Submissions: 2308
	Difficulty: Medium
	Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
	
	For a given query word, the spell checker handles two categories of spelling mistakes:

Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"

Input: wordlist = ["KiTe", "kite","hare","Hare"], 
queries =         ["kite", "Kite","KiTe","Hare","HARE","Hear","hear", "keti","keet","keto"]
Output:           ["kite", "KiTe","KiTe","Hare","hare", "",    "",    "KiTe","",    "KiTe"]
                  ["kite", "KiTe","KiTe","Hare","hare", "",    "",    "kite","",    "kite"] X

 */

import java.util.HashMap;
import java.util.ArrayList;

public class Spellchecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordlist = {"KiTe","kite","hare","Hare", "YellOw"};
		String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto", "YellOw"};

		Spellchecker test = new Spellchecker();
		String[] res = test.spellchecker(wordlist, queries);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashMap<String, String> map3 = new HashMap<String, String>();
        
        String[] res = new String[queries.length];
        
        for (int i = 0; i < wordlist.length; i++) {
        	String word = wordlist[i];
        	buildMap1(map1, word);
        	buildMap2(map2, word);
        	buildMap3(map3, word);
        }
        
        for (int i =0; i < queries.length; i++) {
        	String query = queries[i];
        	if (map1.containsKey(query)) {
        		res[i] = query;
        	} else if ( map2.containsKey(query.toLowerCase()) ) {
        		res[i] = map2.get(query.toLowerCase());
        	} else {
        		String help = convertString(query);
        		if ( map3.containsKey(help)) {
        			res[i] = map3.get(help);
        		} else {
        			res[i] = "";
        		}
        	}
        	
        }

        return res;
        
    }
    
    void buildMap1(HashMap<String, String> map, String word) {
    	if (map.containsKey(word))
    		return ;
    	else {
    		map.put(word, word);
    	}    	
    }
    
    void buildMap2(HashMap<String, String> map, String word) {

    	if (map.containsKey(word.toLowerCase()))
    		return ;
    	else {
    		map.put(word.toLowerCase(), word);
    	}    	
    }
    
    void buildMap3(HashMap<String, String> map, String word) {

    	String buffer = convertString(word);
    	
    	if (map.containsKey(buffer)) {
    		return;
    	} else {
    		map.put(buffer, word);
    	}
    }
    
    String convertString(String input) {
        StringBuffer buffer = new StringBuffer();
    	String word = input.toLowerCase();
    	for (int i =0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		if (c == 'a' || c == 'e' || c == 'i'|| c == 'u'|| c == 'o' ||
    			c == 'A' || c == 'E' || c == 'I'|| c == 'U'|| c == 'O')
    			buffer.append('a');
    		else 
    			buffer.append(c);
    		
    	}
    	return buffer.toString();
    
    }

}
