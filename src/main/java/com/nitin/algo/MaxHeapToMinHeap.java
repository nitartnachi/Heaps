/*
 * Given an array that represents a max heap, convert it into an representing min heap, in place;
 */

package com.nitin.algo;

import java.util.Arrays;

public class MaxHeapToMinHeap {
	
	static class MinHeap{
		
		public MinHeap(int[] arr, int size) {
			int i = (size - 2)/2;
			while(i >= 0) {
				Heapify(arr, i, size);
				i--;
			}
		}

		private void Heapify(int[] arr, int i, int size) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			
			int smallest = i;
			
			if(left < size && arr[left] < arr[i])
				smallest = left;
			
			if(right < size && arr[right] < arr[smallest])
				smallest = right;
			
			if(smallest != i) {
				swap(arr, i, smallest);
				Heapify(arr, smallest, size);
			}
			
		}

		public static void swap(int[] arr, int start, int end) {
			int temp;
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
	}
	
	public static void main(String[] args) {

		int[] arr = {9,4,7,1,-2,6,5};
		MinHeap pq = new MinHeap(arr, arr.length);
		System.out.println("The array after conversion is: " + Arrays.toString(arr));
	}

}
