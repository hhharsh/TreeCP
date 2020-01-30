package p2;



class Node2{
	int data;
	Node2 left;
	Node2 right;
	
	Node2(int d){
		left=null;
		right=null;
		data=d;
	}
}
public class W2 {
	
	public static void change(Node2 root) {
		if(root==null)
			return;
		
		
		change(root.left);
		root.data=9;
		change(root.right);
	}
	
	public static void print(Node2 root) {
		if(root==null)
			return;
		
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	public static Node2 root=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		change(root);
		
		print(root);
	}

}
