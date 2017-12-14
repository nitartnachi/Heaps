/*
 * For a giving string of alphabets, find first k non-repeating characters in single pass of string.
 * Example given str = ABCDBAGHCHFAC and k = 3, the output should be D G F
 */
package com.nitin.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstKNonRepeatingInStringOnePass {
	
	static class Pair{
		int first, second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main(String[] args) {
		String input = "ABXCDBAGHCHFAC";
		int k = 3;
		System.out.println("The first k non-repeating characters in the given string are: " + firstKNonRepeating(input, k).toString());
	}

	private static List<Character> firstKNonRepeating(String input, int k) {
		if(input == null || input.isEmpty())
			return Collections.emptyList();
		
		List<Character> result = new ArrayList<>(3);
		Map<Character, Pair> map = new HashMap<>();
		
		char[] arr = input.toCharArray();
		
		//store characters with their count and last index in map
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				Pair pair = map.get(arr[i]);
				pair.first++;
				pair.second = i;
				map.put(arr[i], pair);
			}
			else{
				map.put(arr[i], new Pair(1, i ));
			}
		}
		
		//create a priority q for k items
		//scan the map (max of 26) and insert index of K elements from map into priority queue where count = 1
		int heapSize = k;
		PriorityQueue<Integer> pq = new PriorityQueue<>(heapSize, Collections.reverseOrder());
		for(Map.Entry<Character, Pair> entry : map.entrySet()) {
			int count = entry.getValue().first;
			int index = entry.getValue().second;
			
			if(count == 1) {
				if(--heapSize >= 0) {
					pq.add(index);
				}
				else {
					if(index < pq.peek()) {
						pq.poll();
						pq.add(index);
					}
				}
			}
		}
		while(!pq.isEmpty())
			result.add(arr[pq.poll()]);
		return result;
	}

}
