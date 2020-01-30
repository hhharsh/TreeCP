package finalTree;
import java.util.*;
class Node33{
	int data;
	Node33 left;
	Node33 right;
	
	public Node33(int d) {
		data=d;
		left=null;
		right=null;
	}
}

public class IterativePreOrder {
	
	public static Node33 root;
	
	public static void pre(Node33 root) {
		
		if(root==null)
			return;
		Node33 curr=root;
		
		Stack<Node33> st=new Stack<>();
		while(curr!=null || !st.isEmpty()) {
			
			
			while(curr!=null) {
				
				System.out.print(curr.data+" ");
				st.push(curr);
				curr=curr.left;
			}
			
				curr=st.pop();
			
		
			curr=curr.right;
		}
	}
	
	public static void in(Node33 root) {
		
		if(root==null)
			return;
		Node33 curr=root;
		
		Stack<Node33> st=new Stack<>();
		while(curr!=null || !st.isEmpty()) {
			
			
			while(curr!=null) {
				
				
				st.push(curr);
				curr=curr.left;
			}
			
				curr=st.pop();
				System.out.print(curr.data+" ");
		
			    curr=curr.right;
		}
	}
	
	public static void post(Node33 root) {
		
		if(root==null)
			return;
		
		Stack<Node33> st1=new Stack<>();
		Stack<Node33> st2=new Stack<>();
		
		
		st1.push(root);
		while( !st1.isEmpty()) {
			
			Node33 temp=st1.pop();
			st2.push(temp);
			
			if(temp.left!=null) {
				st1.push(temp.left);
			}
			
			if(temp.right!=null) {
				st1.push(temp.right);
			}
			
		}
		
		while (!st2.isEmpty()) 
        {
            Node33 temp = st2.pop();
            System.out.print(temp.data + " ");
        }
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node33(1);
		root.left=new Node33(2);
		root.right=new Node33(3);
		root.left.right=new Node33(4);
		root.right.left=new Node33(5);
		root.right.right=new Node33(6);
		
		pre(root);
		System.out.println();
		in(root);
		System.out.println();
		post(root);
		
	}

}
