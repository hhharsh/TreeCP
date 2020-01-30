package bst;
import java.util.*;

class Node12{
	int data;
	Node12 left;
	Node12 right;
	
	Node12(int d){
		left=null;
		right=null;
		data=d;
	}
}

public class Basic2 {
	
	public static Node12 root=null;
	
	public static Node12 Insert(Node12 root,int data) {
		if(root==null) {
			root=new Node12(data);
			return root;
		}
		
		if(data<root.data) {
			root.left=Insert(root.left,data);
		}
		
		else if(data>root.data) {
			root.right=Insert(root.right,data);
		}
		
		return root;
	}
	
	public static void print(Node12 root) {
		if(root==null)
			return;
		
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=Insert(root,8);
		Insert(root,3);
		Insert(root,9);
		Insert(root,5);
		Insert(root,7);
		Insert(root,10);
		
		
//		root=Insert(root,50);
//		Insert(root,30);
//		Insert(root,20);
//		Insert(root,40);
//		Insert(root,70);
//		Insert(root,60);
//		Insert(root,80);
		
		print(root);

		
	}

}
