package finalTree;



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
public class Foldable {
	
	public static boolean Check(Node3 root) {
		
		if(root==null)
			return true;
		
		return Check2(root.left,root.right);
		
	}
	
	public static boolean Check2(Node3 L,Node3 R) {
		
		if(L==null && R!=null)
			return false;
		
		if(R==null && L!=null)
			return false;
		
		if(L==null && R==null)
			return true;
		
		return Check2(L.left,R.right) && Check2(L.right,R.left);
		
		
	}
	public static Node3 root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node3(1);
		root.left=new Node3(2);
		root.right=new Node3(3);
		root.left.right=new Node3(4);
		root.right.left=new Node3(5);
		root.right.right=new Node3(6);
		
		System.out.println(Check(root));
		

	}

}
