package p1;
import java.util.*;

class Node10{
	int data;
	Node10 left;
	Node10 right;
	
	Node10(int d){
		data=d;
		left=null;
		right=null;
	}
}
public class Demo {
	
	public static Node10 root;
	
	public static void Inorder(Node10 root) {
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.println(root.data);
		Inorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		root=new Node10(5);
		root.left=new Node10(6);
		root.left.left=new Node10(3);
		root.right=new Node10(2);
		
		Inorder(root);
		
		
		
	}

}
