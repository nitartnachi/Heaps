/*
 * Check if a given array represents min heap or not
 * Ex: {2,3,4,5,10,15} : true and {2,10,4,5,3,15}: false
 */
package com.nitin.algo;

public class IsArrayMinHeap {
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,10,15};
		//int[] arr = {2,10,4,5,3,15};
		
		System.out.println("The given array is minimum heap: " + isArrayMinHeap(arr));
	}

	private static boolean isArrayMinHeap(int[] arr) {
		if(arr == null || arr .length < 2)
			return true;
		
		for(int i = 0; i < (arr.length - 2)/2; i++) {
			if( (arr[i] > arr[2*i + 1]) || 
					((2 * i + 2 != arr.length) && (arr[i] > arr[2*i + 2])))
					return false;
		}
		return true;
	}

}
