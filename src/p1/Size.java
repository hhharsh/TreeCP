package p1;

import java.util.Scanner;

class Node5{
 	int data;
 	Node5 left;
 	Node5 right;
 	
 	public Node5(int d) {
 		data=d;
 		left=null;
 		right=null;
 	}
}
public class Size {

	static Node5 root;
	static int count=0;
	public static void SizeTree(Node5 root) {
		if(root==null)
			return ;
		
		SizeTree(root.left);
		count++;
		SizeTree(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);

		// tree(1)
				root=new Node5(1);
				root.left=new Node5(2);
				root.left.left=new Node5(4);
				root.left.right=new Node5(5);
				root.left.right.right=new Node5(9);
				root.left.right.right.left=new Node5(10);
				root.right=new Node5(3);
				root.right.right=new Node5(7);
				root.right.left=new Node5(6);
				root.right.right.right=new Node5(8);
				
				SizeTree(root);
				System.out.println(count);
	}

}
