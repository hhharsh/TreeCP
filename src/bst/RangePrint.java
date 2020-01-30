package bst;
import java.util.Scanner;

import java.util.*;


class Node8{
	int data;
	Node8 right;
	Node8 left;
	Node8(int d){
		data=d;
		right=null;
		left=null;
	}
}
public class RangePrint {
	
	public static void PrintInrange(Node8 root,int s,int e) {
		if(root==null)
			return;
		
		PrintInrange(root.left,s,e);
		if(root.data>=s && root.data<=e)
		System.out.println(root.data);
		PrintInrange(root.right,s,e);
	}

	public static Node8 root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ss=new Scanner(System.in);
		root=new Node8(1);
		root.left=new Node8(2);
		root.left.left=new Node8(4);
		root.left.right=new Node8(5);
		root.left.right.right=new Node8(9);
		root.left.right.right.left=new Node8(10);
		root.right=new Node8(3);
		root.right.right=new Node8(7);
		root.right.left=new Node8(6);
		root.right.right.right=new Node8(8);
		
		PrintInrange(root,5,7);
	}

}
