package p1;

import java.util.Scanner;

class Node3{
 	int data;
 	Node3 left;
 	Node3 right;
 	
 	public Node3(int d) {
 		data=d;
 		left=null;
 		right=null;
 	}
 }
public class A {

	public static Node3 root;
	
	public static Node3 Change(Node3 root) {
		
		root=null;
		return root;
	}
	
	public static void PrintInorder(Node3 root) {
		
		if(root==null)
			return;
		
		
		PrintInorder(root.left);
		System.out.println(root.data);
		PrintInorder(root.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);

		root=new Node3(1);
		root.left=new Node3(2);
		root.left.left=new Node3(4);
		root.left.right=new Node3(5);
		root.left.right.right=new Node3(9);
		root.left.right.right.left=new Node3(10);
		root.right=new Node3(3);
		root.right.right=new Node3(7);
		root.right.left=new Node3(6);
		root.right.right.right=new Node3(8);
		
		PrintInorder(root);
		Node3 nn=Change(root);
		System.out.println("***********");
		PrintInorder(nn);
	}

}
