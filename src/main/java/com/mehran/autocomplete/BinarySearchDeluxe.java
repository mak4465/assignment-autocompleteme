package com.mehran.autocomplete;

import java.util.Collections;
import java.util.Comparator;

public class BinarySearchDeluxe {

	// Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

    	if (a == null || key == null || comparator == null) throw new NullPointerException("impossible!");
    	int first = 0;
    	int last = a.length - 1;
    	if (comparator.compare(a[0], key) == 0) return 0;
    	
    	
    	while (first <= last) {
    		int mid = first + (last - first) / 2;
    		if (comparator.compare(key, a[mid]) < 0){
    			last = mid - 1;
    		}
    		else if (comparator.compare(key, a[mid]) > 0){
    			first = mid + 1;
    		}
    		else if (comparator.compare(a[mid - 1], a[mid]) == 0){
    			last = mid - 1;
    		}
    		else return mid;
    	}
		return -1;
    }
    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if (a == null || key == null || comparator == null) throw new IllegalArgumentException("imposible!");
    	int first = 0;
    	int last = a.length - 1;
    	if (comparator.compare(a[last], key) == 0) return last;
    	while (first <= last) {
    		int mid = first + (last - first) / 2;
    		if (comparator.compare(key, a[mid]) < 0){
    			last = mid - 1;
    		}
    		else if (comparator.compare(key, a[mid]) > 0){
    			first = mid + 1;
    		}
    		else if (comparator.compare(a[mid + 1], a[mid]) == 0){
    			first = mid + 1;
    		}
    		else return mid;
    	}
		return -1;
    }    
    
 
    
    public static void main(String[] args) {
    	
    	Integer[] numbers = {30, 30, 30, 29, 29, 29, 28, 28, 28, 27, 27, 27, 26, 26, 26};
    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 30, Collections.reverseOrder()) + "\t");
    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 30, Collections.reverseOrder()));
    	
    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 29, Collections.reverseOrder()) + "\t");
    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 29, Collections.reverseOrder()));
    	
    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 26, Collections.reverseOrder()) + "\t");
    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 26, Collections.reverseOrder()));
    	
    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 20, Collections.reverseOrder()) + "\t");
    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 20, Collections.reverseOrder()));
    }

}

