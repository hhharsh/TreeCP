package p1;
import java.util.*;
class Node4{
 	int data;
 	Node4 left;
 	Node4 right;
 	
 	public Node4(int d) {
 		data=d;
 		left=null;
 		right=null;
 	}
}
public class PrintHeight {

	static Node4 root;
	
	public static int HeightTree(Node4 root) {
		
		if(root==null)
			return 0;
		
		int lh=HeightTree(root.left);
		int rh=HeightTree(root.right);
		
		return 1+Math.max(lh,rh);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);

// tree(1)
		root=new Node4(1);
		root.left=new Node4(2);
		root.left.left=new Node4(4);
		root.left.right=new Node4(5);
		root.left.right.right=new Node4(9);
		root.left.right.right.left=new Node4(10);
		root.right=new Node4(3);
		root.right.right=new Node4(7);
		root.right.left=new Node4(6);
		root.right.right.right=new Node4(8);

		
		System.out.println(HeightTree(root));
	}

}
