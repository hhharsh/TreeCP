 package p1;

import java.util.Scanner;

class Node2{
 	int data;
 	Node2 left;
 	Node2 right;
 	
 	public Node2(int d) {
 		data=d;
 		left=null;
 		right=null;
 	}
 }
public class BoundaryPrint {

	public static Node2 root;
	
	public static void PrintLeft(Node2 root) {
		
		while(root.left!=null) {
			System.out.println(root.data);
			root=root.left;
		}
		
	}
	
public static void PrintRightReverse(Node2 root) {
		
	if(root.right==null)
		return;
		
	        PrintRightReverse(root.right);
			System.out.println(root.data);
			
		
		
	}

public static void printLeaf(Node2 root) {
	
	if(root==null)
		return;
	
	if(root.left==null && root.right==null) {
		System.out.println(root.data+"*");
	}
		
        printLeaf(root.left);
		printLeaf(root.right);
	
}

public static Node2 DeleteTree(Node2 root) {
	
	if(root==null)
		return root;
		
	DeleteTree(root.left);
	DeleteTree(root.right);
	root=null;
	
	return root;
}


public static void PrintBoundary(Node2 root) {
	PrintLeft(root);
	printLeaf(root);
	PrintRightReverse(root);
}
	
public static void PrintInorder(Node2 root) {
	
	if(root==null)
		return;
	
	
	PrintInorder(root.left);
	System.out.println(root.data);
	PrintInorder(root.right);
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ss=new Scanner(System.in);

		root=new Node2(1);
		root.left=new Node2(2);
		root.left.left=new Node2(4);
		root.left.right=new Node2(5);
		root.left.right.right=new Node2(9);
		root.left.right.right.left=new Node2(10);
		root.right=new Node2(3);
		root.right.right=new Node2(7);
		root.right.left=new Node2(6);
		root.right.right.right=new Node2(8);
		
		PrintBoundary(root);
		Node2 nn=DeleteTree(root);
		System.out.println("@@@@@@@@@@@@");
		PrintInorder(nn);
	}

}
