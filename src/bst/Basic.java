package bst;
import java.util.*;


class Node9{
	int data;
	Node9 right;
	Node9 left;
	Node9(int d){
		data=d;
		right=null;
		
		left=null;
	}
}

public class Basic {
	public static Node9 root;
	
	public static Node9 Insert(Node9 root,int data) {
		if(root==null) {
			root=new Node9(data);
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
	
	public static void Print(Node9 root) {
		if(root==null)
			return ;
		
		Print(root.left);
		System.out.println(root.data);
		Print(root.right);
	}
	
	public static Node9 Delete(Node9 root,int data) {
		
		if(root==null)
			return root;
		
		if(data<root.data) {
			root.left=Delete(root.left,data);
		}
		
		else if(data>root.data) {
			root.right=Delete(root.right,data);
		}
		
		else {
			if(root.left==null)
				return root.right;
			
			else if(root.right==null)
				return root.left;
			
			root.data=min_value(root.right);
			root.right=Delete(root.right,root.data);
		}
		
		return root;
		
	}
	
	public static int min_value(Node9 root) {
		
		while(root.left!=null) {
			
			
			root=root.left;
		}
		
		return root.data;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Basic obj=new Basic();

		// tree 2
   root=Insert(root,5);
		Insert(root,2);
		Insert(root,3);
		Insert(root,4);
		Insert(root,6);
		Insert(root,1);
		Insert(root,7);
		Insert(root,8);
		Insert(root,9);
		Insert(root,10);
		
		Print(root);
		
//		Delete(root,5);
//		Delete(root,6);
		Delete(root,4);
		
		System.out.println("*****************");
		
		Print(root);
	}

}
