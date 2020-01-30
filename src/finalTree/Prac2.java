package finalTree;
import java.io.*;
import java.util.*;


class Node13{
	int data;
	Node13 left;
	Node13 right;
	
	public Node13(int d) {
		data=d;
		left=null;
		right=null;
	}

}

class pair2{
	Node13 root;
	int level;
	
	pair2(Node13 r,int l){
		root=r;
		level=l;
	}
}
public class Prac2 {
	static Node13 root;
	static int edgeTo[]=new int[11];
	
	public static void inorder(Node13 root) {
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	static int maxLevel=0;
	
	public static void leftView(Node13 root,int level) {
		
		if(root==null)
			return;
		
		if(maxLevel<level) {
			System.out.print(root.data+" ");
			maxLevel=level;
		}
		leftView(root.left,level+1);
		leftView(root.right,level+1);

		
		
	}
	
	public static void rightView(Node13 root,int level) {
		
		if(root==null)
			return;
		
		if(maxLevel<level) {
			System.out.print(root.data+" ");
			maxLevel=level;
		}
		rightView(root.right,level+1);
		rightView(root.left,level+1);
	
	}
	
	public static void bfs(Node13 root) {
		Queue<Node13> qq=new LinkedList<>();
		
		qq.add(root);
		
		while(!qq.isEmpty()) {
			Node13 t1=qq.poll();
//			System.out.print(t1.data+" ");
			
			if(t1.left!=null) {
				edgeTo[t1.left.data]=t1.data;
				qq.add(t1.left);
			}
			if(t1.right!=null) {
				edgeTo[t1.right.data]=t1.data;
				qq.add(t1.right);
			}
		}
		
	
		
	}
	
public static Node13 LCA(Node13 root,int p,int q) {
		
		if(root==null)
			return null;
		
		if(root.data==p || root.data==q)
			return root;
		
		Node13 l=LCA(root.left,p,q);
		Node13 r=LCA(root.right,p,q);
		
		if(l!=null && r!=null)
			return root;
		
		else {
			return (l!=null?l:r);
		}

	
	}
	
	public static void disBwn(Node13 root,int p,int q)
	{
		Node13 t3=LCA(root,p,q);
		int w1=t3.data;
		bfs(root);
		int c1=0;
		for(int i=p;i!=w1;i=edgeTo[i]) {
			System.out.print(i+" ");
			
			c1++;
		}
		System.out.print(w1+" ");
		ArrayList<Integer> list2=new ArrayList<>();
		for(int i=q;i!=w1;i=edgeTo[i]) {
			
			list2.add(i);
			
//			System.out.print(i+" ");
			c1++;
		}
		
		Collections.reverse(list2);
		for(int z:list2)
			System.out.print(z+" ");
		
		System.out.println("distance between is = "+c1);
		
		
		
	}
	
	public static void bfs2(Node13 root,HashMap<Integer,ArrayList<Integer>> map2) {
		Queue<pair2> qq2=new LinkedList<>();
		
		qq2.add(new pair2(root,0));
		
		while(!qq2.isEmpty()) {
			pair2 t1=qq2.poll();
			
			Node13 rr=t1.root;
			int ll=t1.level;
			
			ArrayList<Integer> lis=map2.get(ll);
			
			if(lis==null) {
				lis=new ArrayList<Integer>();
				lis.add(rr.data);
				map2.put(ll,lis);
			}
			
			else if(lis!=null) {
				lis.add(rr.data);
				map2.put(ll,lis);
			}
		
			
			if(t1.root.left!=null) {
				qq2.add(new pair2(t1.root.left,ll-1));
			}
			if(t1.root.right!=null) {
				qq2.add(new pair2(t1.root.right,ll+1));
			}
		}
		
	
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node13(1);
		root.left=new Node13(2);
		root.left.left=new Node13(4);
		root.left.right=new Node13(5);
		root.left.right.right=new Node13(9);
		root.left.right.right.left=new Node13(10);
		root.right=new Node13(3);
		root.right.right=new Node13(7);
		root.right.left=new Node13(6);
		root.right.right.right=new Node13(8);
		
		inorder(root);
		System.out.println();
		
		
//		leftView(root,1);
		rightView(root,1);
		System.out.println();
		
		disBwn(root,8,3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
