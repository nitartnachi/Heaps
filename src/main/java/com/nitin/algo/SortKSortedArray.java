/*
 * Given an array which is sorted such that not more than k elements are not in correct order. Sort the array completely.
 * Ex : Given arr = {1,4,5,2,3,7,8,6,10,9} and k = 2 the output should be {1,2,3,4,5,6,7,8,9,10
 */
package com.nitin.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void main(String[] args) {

		int[] arr = {1,4,5,2,3,7,8,6,10,9};
		int k = 2;
		sortKSortedArray(arr, k);
		System.out.println("The array after soerting is: " + Arrays.toString(arr));
	}

	private static void sortKSortedArray(int[] arr, int k) {
		if(arr == null || arr.length <= 1)
			return;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i <= k; i++)
			pq.add(arr[i]);
		
		int index = 0;
		for(int i = k+1; i < arr.length; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty())
			arr[index++] = pq.poll();

	}

}
