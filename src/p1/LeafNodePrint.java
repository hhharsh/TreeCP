package p1;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int d) {
		data=d;
		left=null;
		right=null;
	}
}

public class LeafNodePrint {
	
	public static Node root;
	
	public static void printInorder(Node root) {
		
		if(root==null)
			return;
		
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
		
	}
	
	public static void printLeaf(Node root) {
		
		if(root==null)
			return;
		
		if(root.left==null && root.right==null) {
			System.out.println(root.data+"*");
			return;
		}
		
		
		
		
	
		printLeaf(root.left);
		
		printLeaf(root.right);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);

		root=new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.right.right=new Node(9);
		root.left.right.right.left=new Node(10);
		root.right=new Node(3);
		root.right.right=new Node(7);
		root.right.left=new Node(6);
		root.right.right.right=new Node(8);
		
		printInorder(root);
		System.out.println("$$$$$$$$$$$$$$$$$");
		printLeaf(root);
	}

}
