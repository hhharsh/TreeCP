package finalTree;
import java.util.*;

class Node55{
	int data;
	Node55 left;
	Node55 right;
	
	Node55(int d){
		left=null;
		right=null;
		data=d;
	}
}
public class PrintLeftmostandRightmost {
	public static Node55 root=null;
	public static ArrayList<Integer> list=new ArrayList<>();
	
	public static void PrintAncestors(Node55 root,int d,ArrayList<Integer> list2) {
		
		if(root==null)
			return;
		
		list2.add(root.data);
		
		if(root.data==d) {
			for(int z:list2) {
				list.add(z);
			}
			
			return;
		}
		
		
		
		
		PrintAncestors(root.left,d,list2);
		PrintAncestors(root.right,d,list2);
		
		if(list2.size()>0)
		list2.remove(list2.size()-1);
		
		
		
		
		
	}
	
	public static void print(Node55 root) {
		if(root==null)
			return;
		

		
		Queue<Node55> q=new LinkedList<>();
		q.add(root);
		
		Stack<Node55> st=new Stack<>();
		
		while(!q.isEmpty()) {
			
			int s=q.size();
			
			System.out.print(q.peek().data+" ");
			
			if(s>1) {
				
				System.out.print(st.peek().data+" ");
				
				
			}
			
			
			while(s>0) {
				
				Node55 t1=q.poll();
				if(!st.isEmpty())
				st.pop();
				if(t1.left!=null) {
					q.add(t1.left);
					st.add(t1.left);
				}
				
				if(t1.right!=null) {
					q.add(t1.right);
					st.add(t1.right);
				}
				
				s--;
			}
			
			
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node55(1);
		root.left=new Node55(2);
		root.left.left=new Node55(4);
		root.left.right=new Node55(5);
		root.left.right.right=new Node55(9);
		root.left.right.right.left=new Node55(10);
		root.right=new Node55(3);
		root.right.right=new Node55(7);
		root.right.left=new Node55(6);
		root.right.right.right=new Node55(8);
		
		print(root);
		System.out.println();
		
		ArrayList<Integer> list2=new ArrayList<>();
		
		PrintAncestors(root,9,list2);
		
		for(int z:list)
			System.out.print(z+"--");

	}

}
