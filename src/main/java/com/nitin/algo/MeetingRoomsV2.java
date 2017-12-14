/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * find the minimum number of conference rooms required.
 */
package com.nitin.algo;

import java.util.Arrays;

public class MeetingRoomsV2 {
	
	static class Interval implements Comparable<Interval>{
		int start;
		int end;
	
		public Interval(int start, int end) {
			this.start = start; this.end = end;
		}

		@Override
		public int compareTo(Interval i) {
			if(this.start > i.start) return 1;
			if(this.start < i.start) return -1;
			return 0;
		}
		
		@Override
		public String toString() {
			return "[" + this.start + ", " + this.end + "]";
		}
	}
	
	public static void main(String[] args) {
		//Interval[] arr = { new Interval(0,5), new Interval(5,10), new Interval(15,20)};
		Interval[] arr = { new Interval(0,10), new Interval(5,10), new Interval(11,20)};
		for (Interval i : arr)
			System.out.println(i.toString());
		System.out.println("Minimum number of conference rooms required is : " + minNumberOfRooms(arr));
		
	}

	private static int minNumberOfRooms(Interval[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		 Arrays.sort(arr);
		 
		 int count = 1;
		 for(int i = 0; i < arr.length - 1; i++) {
			 Interval cur = arr[i];
			 Interval next = arr[i+1];
			 if(cur.end > next.start)
				 count++;
		 }
		return count;
	}

}
