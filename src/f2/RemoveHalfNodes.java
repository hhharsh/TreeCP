package f2;

class Node93{
	int data;
	Node93 left;
	Node93 right;
	
	Node93(int d){
		data=d;
	}
}
public class RemoveHalfNodes {
	static Node93 root;
	
	static Node93 rem(Node93 root) {
		
		if(root==null)
			return null;
		
		root.left=rem(root.left);
		root.right=rem(root.right);
		
		if(root.left==null && root.right==null) {
			return root;
		}
		
		if(root.left==null) {
			return root.right;
//			return tt;
		}
		
		if(root.right==null) {
			return root.left;
//			return tt; 
		}
		
		return root;
		
	}
	
	static void Inorder(Node93 root) {
		if(root==null)
			return;
		
		
		
		Inorder(root.left);
		System.out.print(root.data+" ");
		Inorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node93(2);
		root.left=new Node93(1);
		root.left.left=new Node93(4);
		root.left.right=new Node93(5);
		root.right=new Node93(3);
		root.right.left=new Node93(7);
		
		Inorder(root);
		rem(root);
		System.out.println();
		Inorder(root);

	}

}
