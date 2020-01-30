package bst;
import java.util.*;

class Node1{
	int data;
	Node1 left;
	Node1 right;
	
	Node1(){
		left=null;
		right=null;
	}
	
	Node1(int data){
		left=null;
		right=null;
	    this.data=data;
	}
}

public class LastPrac {
	
	 public static Node1 root;
	 
	 public Node1 Insert(Node1 root,int data) {
		 
		 if(root==null) {
			 root=new Node1(data);
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
	 
	 public void Inorder(Node1 root) {
		 if(root==null) {
			 return;
		 }
		 
		 Inorder(root.left);
		 System.out.println(root.data);
		 Inorder(root.right);
		 
		 
			 
	 }
	 
	 public Node1 Delete(Node1 root,int data) {
		 
		 if(root==null) {
			 return root;
		 }
		 
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
			 
			 int tt=minRight(root.right);
			 root.right=Delete(root.right,tt);
			 
			 
		 }
		 return root;
	 }
	 
	 public int minRight(Node1 root) {
		Node1 pp=root;
		 while(pp.left!=null) {
			 pp=pp.left;
		 }
		 return pp.data;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastPrac obj=new LastPrac();

		obj.root=obj.Insert(root,5);
		obj.Insert(root,4);
		obj.Insert(root,8);
		obj.Insert(root,7);
		obj.Insert(root,9);
		obj.Insert(root,4);
		
		obj.Delete(root,7);
		
		obj.Inorder(root);
		
	}

}
