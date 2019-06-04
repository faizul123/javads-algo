package com.javads.btree;

public class BTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(Node left,int data,Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	private Node root;
	
	public void add(int data) {
		addNode(data,root);
	}
	
	private void addNode(int data,Node root) {
		if(root == null) {
			Node node = new Node(null,data,null);
			this.root = node;
			return;
		}
		if(root.data > data) {
			addNode(data,root.left);
		}else {
			addNode(data, root.right);
		}
	}
	
	public boolean search(int data) {
		return searchNode(data,root) == -1 ? false : true;
	}
	
	private int searchNode(int data,Node node) {
		if(root == null || node == null ) return -1;
		if(root.data == data) {
			return root.data;
		}
		else if(root.data >= data) {
			node = root.left;
			return searchNode(data, node);
		}
		else if(root.data < data) {
			node = root.right;
			return searchNode(data, node);
		}
		return -1;
	}
}
