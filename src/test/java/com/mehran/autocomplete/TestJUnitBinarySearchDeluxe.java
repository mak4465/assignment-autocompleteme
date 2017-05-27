package com.mehran.autocomplete;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class TestJUnitBinarySearchDeluxe {
	
	Term term1 = new Term("Debbie", 3);
	Term term2 = new Term("Abcd", 8);
	Term term3 = new Term("Cathy", 1.55555);
	Term term4 = new Term("Abbcd", 0.1);

	Term[] terms = new Term[] { term1, term2, term3, term4 };

	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexArrayNullThrowNullPointerException() throws NullPointerException {
		BinarySearchDeluxe.firstIndexOf (null, 10, Collections.reverseOrder());
		throw new NullPointerException();
    }
	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexKeyNullThrowNullPointerException() throws NullPointerException {
		BinarySearchDeluxe.firstIndexOf (terms, null, Collections.reverseOrder());
		throw new NullPointerException();
    }
	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexComparatorNullThrowNullPointerException() throws NullPointerException {
		BinarySearchDeluxe.firstIndexOf (terms, 44, null);
		throw new NullPointerException();
    }
	
	@Test	
	 public void testFirstLastIndexOf() {
	    	Integer[] numbers = {30, 30, 30, 29, 29, 29, 28, 28, 28, 27, 27, 27, 26, 26, 26};
	    	
	    	assertEquals(BinarySearchDeluxe.firstIndexOf (numbers, 30, Collections.reverseOrder()), 0);
	    	assertEquals(BinarySearchDeluxe.lastIndexOf (numbers, 30, Collections.reverseOrder()), 2);
	    	assertEquals(BinarySearchDeluxe.firstIndexOf (numbers, 29, Collections.reverseOrder()), 3);
	    	assertEquals(BinarySearchDeluxe.lastIndexOf (numbers, 29, Collections.reverseOrder()),5);
	    	assertEquals(BinarySearchDeluxe.firstIndexOf (numbers, 26, Collections.reverseOrder()), 12);
	    	assertEquals(BinarySearchDeluxe.lastIndexOf (numbers, 26, Collections.reverseOrder()), 14);
	    	assertEquals(BinarySearchDeluxe.firstIndexOf (numbers, 20, Collections.reverseOrder()), -1);
	    	assertEquals(BinarySearchDeluxe.lastIndexOf (numbers, 20, Collections.reverseOrder()), -1);
	}
		
}
	
