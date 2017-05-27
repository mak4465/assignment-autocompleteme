package com.mehran.autocomplete;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestJUnitAutoComplete {

	Term term1 = new Term("Debbie", 3);
	Term term2 = new Term("Abcd", 8);
	Term term3 = new Term("Cathy", 1.55555);
	Term term4 = new Term("Abbcd", 0.1);

	Term[] terms = new Term[] { term1, term2, term3, term4 };

	
	@Test(expected = NullPointerException.class)
	public void testAutocompleteArrayNullThrowNullPointerException() {
		new Autocomplete(null);
		throw new NullPointerException();
	}
	
	@Test(expected = NullPointerException.class)
	public void testAutocompletePrefixNullThrowNullPointerException() {
		Autocomplete autocomplete = new Autocomplete(terms);
		autocomplete.allMatches(null);
		throw new NullPointerException();
	}
	
	@Test
	public void testAllMatches(){
		Autocomplete autoComplete = new Autocomplete(terms);
		Term[] matches = autoComplete.allMatches("A");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, matches.length);
    	
    	assertEquals(terms[1], matches[0]);
    	assertEquals(terms[3], matches[1]);
    }
	
	
	@Test
	public void testNumberOfMatches(){
		Autocomplete autoComplete = new Autocomplete(terms);
		int noOfMatches = autoComplete.numberOfMatches("A");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, noOfMatches);
    }
	
	
	
	
	
	
	
	
	

	
	
	

}
