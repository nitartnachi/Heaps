/*
 * Find the kth largest element in an unsorted array.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * ------------------------------------------------------
 * BIG O Details: time O(arr.length * logk) -- space O(k)
 */

package com.nitin.algo;

import java.util.PriorityQueue;

public class KthLargestUnsortedArray {
	
	public static void main(String[] args) {
		
		int[] arr = {3,2,1,5,6,4};
		int k = 3;
		int kthlarge = kthLargest(arr, k);
		
		System.out.println("The " + k + "th largest number in the array is " + kthlarge);
	}

	private static int kthLargest(int[] arr, int k) {
		if(arr == null || arr.length == 0 || k > arr.length) 
			throw new RuntimeException("Invalid input");
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < k; ++i)
			pq.add(arr[i]);
		
		for (int i = k; i < arr.length; ++i) {
			if(arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		return pq.poll();
	}

}
