package com.mehran.autocomplete;

import java.util.Arrays;

import edu.princeton.cs.algorithms.Insertion;

public class Autocomplete {

	private final Term[] terms;
	
	 // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	if (terms == null){
    		throw new NullPointerException("Terms can't be null");
    	}
    	this.terms = new Term[terms.length];
    	for (int i = 0; i < terms.length; i++) 
    		this.terms[i] = terms[i];
    	Insertion.sort(this.terms);
//    	Arrays.sort(this.terms);
    }

 // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	if (prefix == null) throw new NullPointerException("Prefix can't be null");
    	
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	if (firstIndex == -1) return new Term[0];
    	int lastIndex  = BinarySearchDeluxe.lastIndexOf (terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	Term[] matchTerms = new Term[1 + lastIndex - firstIndex];
    	
    	for (int i = 0; i < matchTerms.length; i++)
    		matchTerms[i] = terms[firstIndex++];

    	Arrays.sort(matchTerms, Term.byReverseWeightOrder());
    	
		return matchTerms;
    }    
    

 // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
    	int i, j;
    	if (prefix == null) throw new NullPointerException("Prefix can't be null");
    	
    	i = BinarySearchDeluxe.lastIndexOf (terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    	j = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		return 1 + i - j;
    }  
    
     
    public static void main (String[] args) {
    	Term[] terms = {new Term("hair", 5), new Term("Hair", 1), new Term("HAIR", 2),
    					new Term("leg", 10), new Term("Leg", 3), new Term("LEg", 7), new Term("LEG", 4),
    					new Term("hand", 0), new Term("Hand", 20), new Term("HAND", 30),
    					new Term("head", 8), new Term("Head", 2), new Term("HEAD", 0)};
    	
    	    	
    	Autocomplete autocomplete = new Autocomplete(terms);
    	
    	for(int i = 0; i < terms.length; i++){
    		System.out.print(terms[i]);
    		System.out.println();
    	}

    	System.out.println("-----------------------------------");
    	System.out.println(autocomplete.numberOfMatches("H"));
    	System.out.println("-----------------------------------");
    	
    	Term[] stuff = autocomplete.allMatches("L");
    	
    	for (Term term : stuff) System.out.println(term);
    }
}
