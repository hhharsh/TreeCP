package finalTree;
import java.util.*;

class Node66{
	
	int data;
	Node66 left;
	Node66 right;
	
   Node66(int d){
		data=d;
	}
}

public class BfsLike {
	static Node66 root;
	
	public static void Bfs(Node66 root) {
		
		Queue<Node66> qq=new LinkedList<>();
		qq.add(root);
		
		while(!qq.isEmpty())
		{
			
			Node66 t=qq.poll();
			System.out.print(t.data+" ");
			
			if(t.left!=null) {
			
			qq.add(t.left);
			}
			
			if(t.right!=null) {
			qq.add(t.right);
			}
			
		}
		
		
		
		
	}
	
	
	public static void inOrder(Node66 root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node66(1);
		root.left=new Node66(2);
		root.left.left=new Node66(4);
		root.left.right=new Node66(5);
		root.left.right.right=new Node66(9);
		root.left.right.right.left=new Node66(10);
		root.right=new Node66(3);
		root.right.right=new Node66(7);
		root.right.left=new Node66(6);
		root.right.right.right=new Node66(8);
		
		inOrder(root);
		System.out.println();
		Bfs(root);

	}

}
