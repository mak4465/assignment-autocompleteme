package com.mehran.autocomplete;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestJUnitAutoComplete {

	Term query1 = new Term("hair", 5);
	Term query2 = new Term("Leg", 3);
	Term query3 = new Term("HAND", 30);
	Term query4 = new Term("Head", 2);

	Term[] queries = new Term[] { query1, query2, query3, query4 };

	
	@Test(expected = NullPointerException.class)
	public void testAutocompleteArrayNullThrowNullPointerException() {
		new Autocomplete(null);
		throw new NullPointerException();
	}
	
	@Test(expected = NullPointerException.class)
	public void testAutocompletePrefixNullThrowNullPointerException() {
		Autocomplete autocomplete = new Autocomplete(queries);
		autocomplete.allMatches(null);
		throw new NullPointerException();
	}
	
	@Test
	public void testAllMatches(){
		Autocomplete autoComplete = new Autocomplete(queries);
		Term[] matches = autoComplete.allMatches("H");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, matches.length);
    	
    	assertEquals(queries[2], matches[0]);
    	assertEquals(queries[3], matches[1]);
    }
	
	
	@Test
	public void testNumberOfMatches(){
		Autocomplete autoComplete = new Autocomplete(queries);
		int NumberOfMatches = autoComplete.numberOfMatches("H");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, NumberOfMatches);
    }

}
