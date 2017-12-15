package com.nitin.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		double[] medians = getMedians(arr);
		System.out.println("The runnign medians are: " + Arrays.toString(medians));
	}

	private static double[] getMedians(int[] arr) {
		if(arr == null || arr.length == 0)
			return null;
		double[] medians = new double[arr.length];
		PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder()); // max heap
		PriorityQueue<Integer> highers = new PriorityQueue<>(); // min heap
		
		for(int i = 0; i < arr.length; i++) {
			addNumber(arr[i], lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		
		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = (lowers.size() > highers.size()) ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = (lowers.size() > highers.size()) ? highers : lowers;
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return (biggerHeap.peek() + smallerHeap.peek())/2.0;
		}else {
			return biggerHeap.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = (lowers.size() > highers.size()) ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = (lowers.size() > highers.size()) ? highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int i, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.isEmpty() || i < lowers.peek())
			lowers.add(i);
		else
			highers.add(i);
	}
}
