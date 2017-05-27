package com.mehran.autocomplete;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TestJUnitTerm {
	
	Term term1 = new Term("Melanie", 4);
	Term term2 = new Term("Christof", 6);
	Term term3 = new Term("Michael", 2.7);
	Term term4 = new Term("Albert", 0.9);

	Term[] terms = new Term[] { term1, term2, term3, term4 };

	@Test(expected = NullPointerException.class)
	public void testJUnitQueryNullPointerException() {
		new Term(null, 9);
		throw new NullPointerException();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testJUnitWeightIllegalArgumentException() {
		new Term("test", -9);
		throw new IllegalArgumentException();
	}

	@Test
	public void testJUnitCompareTo() {

		Arrays.sort(terms);

		assertEquals(term1, terms[2]);
		assertEquals(term3, terms[3]);
		assertEquals(term4, terms[0]);
		assertEquals(term2, terms[1]);
	}

	@Test
	public void testJUnitByReverseOrder() {

		Arrays.sort(terms, Term.byReverseWeightOrder());

		assertEquals(term1, terms[1]);
		assertEquals(term3, terms[2]);
		assertEquals(term4, terms[3]);
		assertEquals(term2, terms[0]);
	}
	
	@Test
	public void testJUnitByPrefixOrder() {
		              
		Arrays.sort(terms, Term.byPrefixOrder(2));
		
		assertEquals(term1, terms[2]);
		assertEquals(term3, terms[3]);
		assertEquals(term4, terms[0]);
		assertEquals(term2, terms[1]);
	}
	
//	@Test
//	public void testJUnitToString(){
//		Term term1 = new Term("query", 4.0);
//
//    
//	assertEquals("4.0 query", term1.toString());
//}

}
