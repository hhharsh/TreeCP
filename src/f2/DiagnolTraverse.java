package f2;
import java.util.*;

class Node94{
	int data;
	Node94 left;
	Node94 right;
	
	Node94(int d){
		data=d;
	}
}
public class DiagnolTraverse {
	static Node94 root;
	
	static void traverse(Node94 root) {
		
		Queue<Node94> q=new LinkedList<>();
		
		q.add(root);
		q.add(null);
		int sum=0;
		while(!q.isEmpty()) {
			
			Node94 t1=q.poll();
			if(t1==null) {
				System.out.println();
				System.out.println("sum is = "+sum);
				sum=0;
				q.add(null);
				if(q.peek()==null) {
					break;
				}
			}
			
			while(t1!=null) {
				System.out.print(t1.data+" ");
				sum+=t1.data;
				if(t1.left!=null)
					q.add(t1.left);
				
				t1=t1.right;
			}
			
			
		}
		
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node94(2);
		root.left=new Node94(1);
		root.left.left=new Node94(4);
		root.left.right=new Node94(5);
		root.right=new Node94(3);
		root.right.left=new Node94(7);
		
		traverse(root);

	}

}
