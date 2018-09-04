package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private LinkedList<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		
		String[] words = sourceText.split(" +");
		
		starter = words[0];
		
		
		/*
		 * First method
		 */
		for(int i=0; i<words.length; i++){
			
			int index = doesExist(words[i]);
			
			if(index >= 0  && (i+1) < words.length){
				wordList.get(index).addNextWord(words[i+1]);
			}else{
				wordList.add(new ListNode(words[i]));
				if((i+1) < words.length){
					wordList.getLast().addNextWord(words[i+1]);
				}
			}	
		}
		
		
		wordList.getLast().addNextWord(starter);
		
		/*
		 * Second method
		String prevWord = starter;
		
		int i = 1;
		for(; i<words.length; i++){

			int index = doesExist(prevWord);
			
			if(index >= 0){
				wordList.get(index).addNextWord(words[i]);
			}else{
				wordList.add(new ListNode(prevWord));
				wordList.getLast().addNextWord(words[i]);
			}
			
			prevWord = words[i];
		}
		
		if(i == words.length && doesExist(prevWord) < 0){
			wordList.add(new ListNode(prevWord));
			wordList.getLast().addNextWord(starter);
		}
		else if(i == words.length && doesExist(prevWord) >= 0){
			wordList.getLast().addNextWord(starter);
		}
		
		*/
		System.out.println("Size:" + wordList.size());
		
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		
		StringBuilder builder = new StringBuilder();
		
		int num = rnGenerator.nextInt(wordList.size());
		String currentWord = wordList.get(num).getWord();
		
		builder.append(currentWord + " ");
		
		int i = 0;
		while(i<numWords){
			ListNode node = wordList.get(doesExist(currentWord));
			String word = node.getRandomNextWord(rnGenerator);
			builder.append(word + " ");
			currentWord = word;
			i++;
		}
		
		
		return builder.toString();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList.clear();
		starter = ""; 
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	private int doesExist(String word){
		
		for(int i=0; i<wordList.size(); i++){
			if(wordList.get(i).getWord().equals(word)){
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		//String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		String textString = "hi there hi Leo";
		//System.out.println(textString);

		
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		//gen.retrain(textString2);
		gen.train(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	
	}
	

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		
		// Return a random word from the list
		// The random number will be generated between 0 and size-1 of the list
	    return nextWords.get(generator.nextInt(nextWords.size()));
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
	@Override
	public boolean equals(Object o){
		
		boolean theSame = false;
		
		if(o != null && o instanceof ListNode){
			 theSame = ((ListNode) o).getWord().equals(this.getWord());
		}
		
		return theSame;
		
	}
	
}


