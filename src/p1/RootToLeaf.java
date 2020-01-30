package p1;
// correct
import java.util.*;

class Node7{
 	int data;
 	Node7 left;
 	Node7 right;
 	
 	public Node7(int d) {
 		data=d;
 		left=null;
 		right=null;
 	}
 }
public class RootToLeaf {

	static Node7 root;
	static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	static int k=0;
	public static void PrintPath(Node7 root,ArrayList<Integer> q) {
		
		if(root==null) {
			return;
		}
		
		q.add(root.data);
		
		if(root.left==null && root.right==null) {
			ArrayList<Integer> list2=new ArrayList<>();
			for(int z:q) {
				list2.add(z);
			}
			
			list.add(list2);
		}
		
		PrintPath(root.left,q);
		PrintPath(root.right,q);
		q.remove(q.size()-1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);
		root=new Node7(1);
		root.left=new Node7(2);
		root.left.left=new Node7(4);
		root.left.right=new Node7(5);
		root.left.right.right=new Node7(9);
		root.left.right.right.left=new Node7(10);
		root.right=new Node7(3);
		root.right.right=new Node7(7);
		root.right.left=new Node7(6);
		root.right.right.right=new Node7(8);
		
		ArrayList<Integer> q=new ArrayList<>();
		
		PrintPath(root,q);
		System.out.println(list);
	}

}
