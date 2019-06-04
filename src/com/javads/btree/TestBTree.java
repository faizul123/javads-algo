package com.javads.btree;

public class TestBTree {
	
	public static void main(String[] args) {
		BTree btree = new BTree();
		btree.add(5);
		btree.add(4);
		btree.add(7);
		btree.add(8);
		boolean test = btree.search(40);
		System.out.println(test);
	}
	
}
