package finalTree;
import java.util.*;
import java.io.*;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}
public class BinaryTreeInput {
	
	public static void Inorder(Node root) {
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.print(root.data+" ");
		Inorder(root.right);
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		Node arr[]=new Node[N+1];
		
		for(int i=0;i<N-1;i++) {
			String ar[]=br.readLine().split(" ");
			
			int p=Integer.parseInt(ar[0]);
			int c=Integer.parseInt(ar[1]);
			
			if(arr[p]==null) {
				arr[p]=new Node(p);
			}
			if(arr[c]==null) {
				arr[c]=new Node(c);
			}
			
			if(ar[2].equals("R")) {
				arr[p].right=arr[c];
			}
			
			else if(ar[2].equals("L")) {
				arr[p].left=arr[c];
			}
			
			
		}
		
		Inorder(arr[1]);
		//input
//		10
//		1 2 R
//		1 3 L
//		2 4 R
//		2 5 L
//		3 6 R
//		3 7 L
//		5 8 R
//		5 9 L
//		7 10 R

	}

}
