package finalTree;
import java.util.*;
import java.io.*;


class Node10{
	int data;
	Node10 right;
	Node10 left;
	Node10(int d){
		data=d;
		right=null;
		
		left=null;
	}
}
public class verticalTraverse {
	
	public static void vertical(Node10 root,TreeMap<Integer,ArrayList<Integer>> map,int h) {
		
		if(root==null) {
			return;
		}
		
		ArrayList<Integer> pp=map.get(h);
		
		if(pp==null) {
			pp=new ArrayList<Integer>();
			pp.add(root.data);
			
		}
		else {
			
			pp.add(root.data);
			
		}
		
		
		map.put(h,pp);
		
		
		vertical(root.left,map,h-1);
		vertical(root.right,map,h+1);		
		
		
	}
	
	
	
	
	
	public static void inOrder(Node10 root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	
	static Node10 root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root=new Node10(1);
		root.left=new Node10(2);
		root.left.left=new Node10(4);
		root.left.right=new Node10(5);
		root.left.right.right=new Node10(9);
		root.left.right.right.left=new Node10(10);
		root.right=new Node10(3);
		root.right.right=new Node10(7);
		root.right.left=new Node10(6);
		root.right.right.right=new Node10(8);
		
		inOrder(root);
		System.out.println();
		System.out.println("***********");
		
		TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
		vertical(root,map,0);
		
		
		for(Map.Entry z:map.entrySet()) {
//			System.out.println(z.getKey()+"---"+z.getValue());
			for(int qq:(ArrayList<Integer>)z.getValue()) {
				System.out.print(qq+" ");
			}
			System.out.println();
		}
		
		
	}

}
