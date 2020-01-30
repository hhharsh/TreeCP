package finalTree;
import java.util.*;


class Node12{
	int data;
	Node12 left;
	Node12 right;
	
	Node12(int d){
		data=d;
	}
}

class pair{
	Node12 root;
	int level;
	
	pair(Node12 r,int l){
		root=r;
		level=l;
	}
}

public class Prac1 {
	
	static Node12 root;
	static int edgeTo[]=new int[11];
	
	public static void inorder(Node12 root) {
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static int height(Node12 root) {
		
		if(root==null)
			return 0;
		
		int lh=height(root.left);
		int rh=height(root.right);
		
		return 1+Math.max(lh,rh);
		
	}
	
	public static void printLeaf(Node12 root) {
		
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
			System.out.print(root.data+" ");
		
		printLeaf(root.left);
		printLeaf(root.right);

		
	}
	
	public static void bfs(Node12 root) {
		Queue<Node12> qq=new LinkedList<>();
		
		qq.add(root);
		
		while(!qq.isEmpty()) {
			Node12 t1=qq.poll();
			System.out.print(t1.data+" ");
			
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
	
	public static void bfs2(Node12 root,HashMap<Integer,ArrayList<Integer>> map2) {
		Queue<pair> qq2=new LinkedList<>();
		
		qq2.add(new pair(root,0));
		
		while(!qq2.isEmpty()) {
			pair t1=qq2.poll();
			
			Node12 rr=t1.root;
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
				qq2.add(new pair(t1.root.left,ll-1));
			}
			if(t1.root.right!=null) {
				qq2.add(new pair(t1.root.right,ll+1));
			}
		}
		
	
		
	}
	
	
	
	public static Stack<Integer> minPath(Node12 root,int s,int d) {
		
		Stack<Integer> st=new Stack<>();
		
		for(int i=d;i!=s;i=edgeTo[i]) {
			st.add(i);
		}
		st.add(s);
		
		return st;
		
	}
	
	public static Node12 LCA(Node12 root,int p,int q) {
		
		if(root==null)
			return null;
		
		if(root.data==p || root.data==q)
			return root;
		
		Node12 l=LCA(root.left,p,q);
		Node12 r=LCA(root.right,p,q);
		
		if(l!=null && r!=null)
			return root;
		
		else {
			return (l!=null?l:r);
		}

	
	}
	
	public static void levelPrint(Node12 root,int level) {
		
		if(root==null)
			return;
		
		if(level==1)
			System.out.print(root.data+" ");
		
		
		levelPrint(root.left,level-1);
		levelPrint(root.right,level-1);
		
		
	}
	
	public static void vertical(Node12 root,int h,TreeMap<Integer,ArrayList<Integer>> map) {
		
		if(root==null)
			return;
		
		ArrayList<Integer> list=map.get(h);
		
		if(list==null) {
			list=new ArrayList<Integer>();
			list.add(root.data);
			map.put(h,list);
		}
		else if(list!=null) {
			list.add(root.data);
			map.put(h,list);
		}
		
		vertical(root.left,h-1,map);
		vertical(root.right,h+1,map);

		
		
	}
	
	public static int minDepth(Node12 root) {
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return 1;
		
		if(root.left==null) {
			return minDepth(root.right)+1;
		}
		
		if(root.right==null) {
			return minDepth(root.left)+1;
		}
		
		return Math.min(minDepth(root.left),minDepth(root.right))+1;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node12(1);
		root.left=new Node12(2);
		root.left.left=new Node12(4);
		root.left.right=new Node12(5);
		root.left.right.right=new Node12(9);
		root.left.right.right.left=new Node12(10);
		root.right=new Node12(3);
		root.right.right=new Node12(7);
		root.right.left=new Node12(6);
		root.right.right.right=new Node12(8);
		
		inorder(root);
		System.out.println();
		System.out.println("height = "+height(root));
		System.out.print("leaf nodes are = ");
		printLeaf(root);
		System.out.println();
		System.out.print("bfs traversal is = ");
		bfs(root);
		System.out.println();
		
		System.out.print("min path is = ");
		for(int z:minPath(root,1,8)){
			System.out.print(z+" ");
		}
		System.out.println();
		
		Node12 tt=LCA(root,9,2);
		System.out.println(tt.data+"*");
		System.out.println();
		
		levelPrint(root,3);
		
		TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
		vertical(root,0,map);
		System.out.println();
		

		
		for(Map.Entry z:map.entrySet()) {
			System.out.print(z.getKey()+"-->");
			for(int q:(ArrayList<Integer>)z.getValue()) {
				System.out.print(q+" ");
			}
			System.out.println();
		}
		
		
		System.out.println();
		
		System.out.println("min Depth = "+minDepth(root));
		
		System.out.println();
		
		HashMap<Integer,ArrayList<Integer>> map2=new HashMap<>();
		bfs2(root,map2);
		
		for(Map.Entry ww:map2.entrySet()) {
			System.out.print(ww.getKey()+" --> ");
			for(int y2:(ArrayList<Integer>)ww.getValue()) {
				System.out.print(y2+" ");
			}
			System.out.println();
		}

	}

}
