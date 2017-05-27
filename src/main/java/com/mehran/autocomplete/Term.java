package com.mehran.autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

	private final String query;
	private final double weight;
	
	// Initializes a term with the given query string and weight.
	public Term(String query, double weight) {
		if (query == null) throw new NullPointerException("no null");
		if (weight < 0) throw new IllegalArgumentException("no less than 0");
		this.query = query;
		this.weight = weight;
	}
	
	 // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
		return new ComparatorByReverseOrderWeight();
	}
	
	// Compares the two terms in descending order by weight.
		private static class ComparatorByReverseOrderWeight implements Comparator<Term> {
			public int compare(Term a, Term b) {
				if (a.weight == b.weight) {
					return 0;
				}
				if (a.weight > b.weight){
					return -1;
				}
				return 1;			
			}
		}
	
	// Compares the two terms in lexicographic order but using only the first r characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) throw new IllegalArgumentException("no negative value");
		return new ComparatorByPrefixOrderQuery(r);
	}
	
	private static class ComparatorByPrefixOrderQuery implements Comparator<Term> {
		private int r;
		
		private ComparatorByPrefixOrderQuery(int r) {
			this.r = r;
		}
		
		public int compare(Term t1, Term t2) {
			String firstprefix;
			String secondprefix;
			
			if (t1.query.length() < r){
				firstprefix = t1.query;
			}
			else{
				firstprefix = t1.query.substring(0, r);
			}
			if (t2.query.length() < r){
				secondprefix = t2.query;
			}
			else{
				secondprefix = t2.query.substring(0, r);
			}
			return firstprefix.compareTo(secondprefix);
		}
	}
	

	// Compares the two terms in lexicographic order by query.
   	public int compareTo(Term that) {
		return this.query.compareTo(that.query);
	}
	

 // Returns a string representation of this term in the following format:
 // the weight, followed by a tab, followed by the query.
	public String toString() {
		return weight + "\t" + query;
	}
	
	
	public static void main(String[] args) {
		Term[] terms = {new Term("Melanie", 4), new Term("Christof", 6), new Term("Michael", 2.7), new Term("Albert", 0.9)};
		for(int i = 0; i < terms.length; i++){
			System.out.println(terms[i]);                         
		}
		System.out.println("-----------------------------");
			
		Arrays.sort(terms, Term.byReverseWeightOrder());
		for(int i = 0; i < terms.length; i++){
			System.out.println(terms[i]);                         
		}
		System.out.println("-----------------------------");
		
		Arrays.sort(terms, Term.byPrefixOrder(2));
		for(int i = 0; i < terms.length; i++){
			System.out.println(terms[i]);                         
		}
		System.out.println("-----------------------------");
		
		Arrays.sort(terms);
		for(int i = 0; i < terms.length; i++){
			System.out.println(terms[i]);                         
		}

	}
	
}
