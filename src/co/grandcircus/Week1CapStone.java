package co.grandcircus;

import java.util.Arrays;
import java.util.Scanner;

public class Week1CapStone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing;
		final String [] VOWELS = {"a", "e", "i", "o", "u"};
		
		System.out.println("Welcome to the Pig Latin translator!");
		
		do {
			System.out.println("Enter a line to be translated: ");
			String input = scan.nextLine();
			
			//put final translation here
			String [] allWords = splitLine(input);
			
			System.out.println(assembleLine(allWords));
			
			
			
			System.out.println("Translate another line? (y/n): ");
			if (scan.nextLine().equalsIgnoreCase("y")) {
				keepGoing = true;
			}
			else {
				keepGoing = false;
			}
		} while (keepGoing);

	}
	
	static String [] splitLine(String line) {
		return line.split(" ");
	}
	
	static int numOfWords(String [] line) {
		return line.length;
	}
	
	static boolean hasVowel(String word) {
		String [] vowels = {"a", "e", "i", "o", "u"};
		boolean hasVowel = false;
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				String letterInWord = Character.toString(word.charAt(i));
				if (letterInWord.equalsIgnoreCase(vowels[j])){
					hasVowel = true;
				}
			}
		}
		return hasVowel;
	}
	
	static boolean startsWithVowel(String word) {
		String [] vowels = {"a", "e", "i", "o", "u"};
		String firstLetter = Character.toString(word.charAt(0));
		for (int i = 0; i < vowels.length; i++) {
			if(firstLetter.equalsIgnoreCase(vowels[i])) {
				return true;
			}
		}
		return false;
	}
	
	static String ayOrWay(boolean startsWithVowel) {
		if (startsWithVowel) {
			return "way";
		}
		return "ay";
	}
	
	static int findFirstVowelIndex(String word) {
		String [] vowels = {"a", "e", "i", "o", "u"};
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				String letterInWord = Character.toString(word.charAt(i));
				if (letterInWord.equalsIgnoreCase(vowels[j])){
					return i;
				}
			}
		}
		return -1;
	}
	
	static String assembleWord (String word){
		
		String slicedWord = (word.substring(findFirstVowelIndex(word), word.length()));
		String leadingConsonants = word.substring(0, findFirstVowelIndex(word));
		boolean startsWithVowel = startsWithVowel(word);
		String suffix = ayOrWay(startsWithVowel);
		if (!hasVowel(word)) {
			return word;
		}
		
		String newWord = "";
		if (!startsWithVowel) {
			newWord = (slicedWord + leadingConsonants + suffix);
		}
		else {
			newWord = (slicedWord + leadingConsonants + suffix);
		}		
		return newWord;
	}
	
	static String assembleLine(String [] allWords) {
		StringBuilder assembledLine = new StringBuilder();
		
		for (String word : allWords) {
			if (hasVowel(word)) {
				assembledLine.append(assembleWord(word.toLowerCase()) + " ");
			}
			else {
				assembledLine.append(word.toLowerCase() + " ");
			}
		}		
		return assembledLine.toString();
	}

}
