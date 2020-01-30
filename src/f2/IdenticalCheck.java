package f2;
import java.util.*;

class Node9{
	int data;
	Node9 left;
	Node9 right;
	
	Node9(int d){
		data=d;
	}
}
public class IdenticalCheck {
	
	static Node9 root;
	static Node9 root2;
	
	static boolean checkRec(Node9 root1,Node9 root2){
		
		if(root1==null && root2==null)
			return true;
		
		if(root1==null || root2==null)
			return false;
		
		
		return (root1.data==root2.data && checkRec(root1.left,root2.left) && checkRec(root1.right,root2.right));
		
	}
	
	static boolean checkItr(Node9 root1,Node9 root2){
		
		Queue<Node9> q1=new LinkedList<>();
		Queue<Node9> q2=new LinkedList<>();
		
		q1.add(root1);
		q2.add(root2);
		
		while(!q1.isEmpty() || !q2.isEmpty()) {
			
			Node9 t1=q1.poll();
			Node9 t2=q2.poll();
			
			if(t1.data!=t2.data)
				return false;
			
			if(t1.left==null && t2.left!=null)
				return false;
			
			if(t1.left!=null && t2.left==null)
				return false;
			
			if(t1.right==null && t2.right!=null)
				return false;
			
			if(t1.right!=null && t2.right==null)
				return false;
			
			if(t1.left!=null && t2.left!=null) {
				q1.add(t1.left);
				q2.add(t2.left);
			}
			
			if(t1.right!=null && t2.right!=null) {
				q1.add(t1.right);
				q2.add(t2.right);
			}
			
		}
		
		return true;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		root=new Node9(2);
		root.left=new Node9(1);
		root.left.left=new Node9(4);
		root.left.right=new Node9(5);
		root.right=new Node9(3);
		
		root2=new Node9(2);
		root2.left=new Node9(1);
		root2.left.left=new Node9(4);
		root2.left.right=new Node9(5);
		root2.right=new Node9(3);
		
		System.out.println(checkRec(root,root2));
		System.out.println(checkItr(root,root2));
	}

}
