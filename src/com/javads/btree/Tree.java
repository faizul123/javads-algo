package com.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	
	enum ORDER{INORDER,PREORDER,POSTORDER,LEVELORDER,ZIGZAG};
	
	static class Node{
		public Node left;
		public int data;
		public Node right;
		
		Node(int data){
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	
	private Node head;
	
	public void add(int data) {
		head = add(head,data);
	}
	
	public void traverse(ORDER order) {
		if(order == ORDER.INORDER) {
			inorder(head);
		}else if(order == ORDER.POSTORDER) {
			postorder(head);
		}else if(order == ORDER.PREORDER){
			preorder(head);
		}else if(order == ORDER.LEVELORDER) {
			bfs(head);
		}else if(order == ORDER.ZIGZAG) {
			printZigZag(head);
		}
	}
	
	
	private Node add(Node node,int data) {
		if(node == null) return new Node(data);
		
		if(data < node.data) {
			node.left = add(node.left,data);
		}else if(data > node.data) {
			node.right = add(node.right,data);
		}
		return node;
	}
	
	private void inorder(Node node) {
		if(node == null) return;
		
		inorder(node.left);
		
		System.out.println(" "+node.data);
		
		inorder(node.right);
		
		return;
	}
	
	private void postorder(Node node) {
		if(node == null) return;
		
		postorder(node.left);
		
		postorder(node.right);
		
		System.out.println(" " + node.data);
	}
	
	private void preorder(Node node) {
		if(node == null) return;
		
		System.out.println(" "+node.data);
		
		preorder(node.left);
		
		preorder(node.right);
	}
	
	public void bfs(Node root) {
		if(root == null) return;
		
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			
			System.out.println(" " + node.data);
			
			if(node.left != null) {
				nodes.add(node.left);
			}
			
			if(node.right != null) {
				nodes.add(node.right);
			}
		}
		
		return;
	}
	
	private void printZigZag(Node root) {
		if(root == null) return;
		
		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		
		boolean isLeftToRight = true;
		
		currentLevel.push(root);
		
		while(!currentLevel.isEmpty()) {
			Node temp = currentLevel.pop();
			
			if(temp != null){
				
				System.out.print(" " + temp.data);
				
				if(isLeftToRight) {
					if(temp.left != null) {
						nextLevel.push(temp.left);
					}
					if(temp.right != null ) {
						nextLevel.push(temp.right);
					}
				}else {
					if(temp.right != null) {
						nextLevel.push(temp.right);
					}
					
					if(temp.left != null) {
						nextLevel.push(temp.left);
					}
				}
				
			}
			
			if(currentLevel.isEmpty()) {
				isLeftToRight = !isLeftToRight;
				Stack<Node> stk = currentLevel;
				currentLevel = nextLevel;
				nextLevel = stk;
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		tree.add(8);
		tree.add(3);
		tree.add(1);
		tree.add(10);
		tree.add(6);
		tree.add(14);
		tree.add(4);
		tree.add(7);
		tree.add(13);
		
		tree.traverse(ORDER.ZIGZAG);
	}
}
