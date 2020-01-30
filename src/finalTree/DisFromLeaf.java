package finalTree;

import java.util.*;


class Node5{
	int data;
	Node5 left;
	Node5 right;
	
	Node5(int d){
		left=null;
		right=null;
		data=d;
	}
}

public class DisFromLeaf {
	
	public static Node5 root=null;
	
	
	public static void dis(Node5 root,ArrayList<Integer> list,int k) {
		
		
		if(root==null)
			return;
		
		list.add(root.data);
		
		if(root.left==null && root.right==null) {
			int t=list.size();
			
			int t2=t-k;
			int ans=t2-1;
			
			System.out.print(list.get(ans)+" ");
		}
		
		
		
		dis(root.left,list,k);
		dis(root.right,list,k);
		if(list.size()>0)
		
		list.remove(list.size()-1);
		
		
		

		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node5(1);
		root.left=new Node5(2);
		root.left.left=new Node5(4);
		root.left.right=new Node5(5);
		root.left.right.right=new Node5(9);
		root.left.right.right.left=new Node5(10);
		root.right=new Node5(3);
		root.right.right=new Node5(7);
		root.right.left=new Node5(6);
		root.right.right.right=new Node5(8);
		
		ArrayList<Integer> list=new ArrayList<>();
		dis(root,list,2);
		
		
		
		
		
		
	}

}
