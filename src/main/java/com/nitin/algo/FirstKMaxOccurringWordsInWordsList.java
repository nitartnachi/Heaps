/*
 * Given a list of strings with duplicate words, find first k max occurring words
 */
package com.nitin.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FirstKMaxOccurringWordsInWordsList {

	private static TrieNode root;

	private static final int CHAR_SIZE = 26;

	public FirstKMaxOccurringWordsInWordsList() {
		root = new TrieNode();
	}

	static class TrieNode{
		int count;
		String key;
		TrieNode[] children;

		public TrieNode() {
			count = 0;
			children = new TrieNode[CHAR_SIZE];
		}
	}

	static class HeapNode implements Comparable<HeapNode>{
		int count;
		String key;
		public HeapNode(int count, String key) {
			this.count = count; this.key = key;
		}
		
		@Override
		public int compareTo(HeapNode node) {
			if(this.count > node.count) return 1;
			if(this.count < node.count) return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		new FirstKMaxOccurringWordsInWordsList();
		String[] words = { "code", "codes", "coder", "code", "codes", "code", "codes", "code", "coder", "coders"};
		int k = 3;
		System.out.println("The top k most frequent words in the given list are: " + firstKMaxOccurWords(words, k).toString());
	}

	private static List<String> firstKMaxOccurWords(String[] words, int k) {
		if(words == null || words.length == 0)
			return Collections.emptyList();

		List<String> result = new ArrayList<>();

		//insert all words into trie with the word and count in the leaf node;
		for(String word : words) {
			insert(word);
		}

		//create a priority queue of heapnodes
		PriorityQueue<HeapNode> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		preOrder(root, pq);
		
		while(k-- > 0 && !pq.isEmpty())
			result.add(pq.poll().key);
		return result;
	}

	private static void preOrder(TrieNode root, PriorityQueue<HeapNode> pq) {
		TrieNode node = root;
		if(node == null)
			return;
		
		for(int i = 0; i < CHAR_SIZE; i++) { 
			if(node.children[i] != null) {
				if(node.children[i].key != null)
						pq.add(new HeapNode(node.children[i].count, node.children[i].key));
					
				preOrder(node.children[i], pq);
			}
		}
		
	}

	private static void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}
			else {
				node = node.children[index];
			}
		}
		node.key = word;
		node.count++;
	}

}
