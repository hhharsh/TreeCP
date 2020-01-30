package f2;
import java.util.*;

class Node91{
	int data;
	Node91 left;
	Node91 right;
	
	Node91(int d){
		data=d;
	}
}
public class NextNodeSameLevel {
	
	static Node91 root;
	
	public static void NextNode(Node91 root,int x) {
		
		Queue<Node91> q1=new LinkedList<>();
		Queue<Integer> q2=new LinkedList<>();
		
		q1.add(root);
		q2.add(1);
		
		while(!q1.isEmpty()) {
			
			Node91 t1=q1.poll();
			int ll=q2.poll();
			if(t1.data==x) {
				Node91 t2=q1.poll();
				int ll2=q2.poll();
				
				if(ll==ll2) {
					System.out.println( t2.data);
					break;
				}
			}
			
			
			if(t1.left!=null) {
				q1.add(t1.left);
				q2.add(ll+1);
			}
			
			if(t1.right!=null) {
				q1.add(t1.right);
				q2.add(ll+1);
			}
			
			
			
		}

		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node91(2);
		root.left=new Node91(1);
		root.left.left=new Node91(4);
		root.left.right=new Node91(5);
		root.right=new Node91(3);
		root.right.left=new Node91(7);
		
		NextNode(root,5);

	}

}
