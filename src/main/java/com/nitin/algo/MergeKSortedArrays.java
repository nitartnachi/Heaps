/*
 * This problem can be solved by using a heap. The time is O(nlog(n)).
 * Given m arrays, the minimum elements of all arrays can form a heap. 
 * It takes O(log(m)) to insert an element to the heap and it takes O(1) to delete the minimum element.
 * Assume all arrays have same length
 */
package com.nitin.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	static class QueueNode implements Comparable<QueueNode>{
		int array;
		int index;
		int val;
		
		public QueueNode(int array, int index, int val) {
			this.array = array; this.index = index; this.val = val;
		}

		@Override
		public int compareTo(QueueNode node) {
			if(val > node.val) return 1;
			if(val < node.val) return -1;
			return 0;
		}
		
	}

	public static void main(String[] args) {
		int[][] arr = {	{10,20,30,40},
						{15,25,35,45},
						{27,29,37,48},
						{32,33,39,50},
						{16,18,22,28}
					   };
		
		List<Integer> sortedList = sortArrays(arr);
		System.out.println(sortedList.toString());
		
	}

	private static List<Integer> sortArrays(int[][] arr) {
		if(arr == null || arr.length == 0)
			return Collections.emptyList();

		List<Integer> sortedList = new ArrayList<>();
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		
		for(int i = 0; i < arr.length; i++) {
			pq.add(new QueueNode(i, 0, arr[i][0]));
		}
		
		while(!pq.isEmpty()) {
			QueueNode min = pq.poll();
			sortedList.add(min.val);
			int newIndex = min.index + 1;
			if(newIndex < arr[min.array].length)
				pq.add(new QueueNode(min.array, newIndex, arr[min.array][newIndex]));
				
		}
		return sortedList;
		
	}
		
}
