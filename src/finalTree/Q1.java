package finalTree;
import java.io.*;
import java.util.*;


class Node2{
	int data;
	Node2 left;
	Node2 right;
	
	public Node2(int d) {
		data=d;
		left=null;
		right=null;
	}

}
public class Q1 {
	
	public static void Inorder(Node2 root) {
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.print(root.data+" ");
		Inorder(root.right);
	}
	
	public static ArrayList<Integer>[] Level(Node2 root,int h) {
		
		ArrayList<Integer> list=new ArrayList<>();
		
		ArrayList<Integer> tt[]=new ArrayList[h];
		for(int i=0;i<h;i++) {
			tt[i]=new ArrayList<Integer>();
		}
		
		int p=0;
		for(int i=1;i<=h;i++) {
			printLevel(root,i,list);
			ArrayList<Integer> temp=new ArrayList<>();
			for(int z:list) {
				temp.add(z);
			}
			tt[p++]=temp;
			list.clear();
		}
		
		
		
		return tt;
		
		
		
		
	}
	
	public static void printLevel(Node2 root,int L,ArrayList<Integer> list) {
		
		if(root==null)
			return;
		
		if(L==1) {
			
			list.add(root.data);
			return;
			
		}
		
		
		printLevel(root.left,L-1,list);
		printLevel(root.right,L-1,list);
		
		
	}
	
//	public static void level(Node2 root,ArrayList<Integer> list[],int c,int h) {
//		
//		if(root==null)
//			return;
//		
//		
//		if(c<=h)
//		list[c].add(root.data);
//		
//		
//		level(root.left,list,++c,h);
//		
//		level(root.right,list,++c,h);
//		
//		
//	}
	
	public static int height(Node2 root) {
		if(root==null)
			return 0;
		
		int lh=height(root.left);
		int rh=height(root.right);
		
		return 1+Math.max(lh,rh);
	}


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		
		String ar[]=br.readLine().split(" ");
		int N=Integer.parseInt(ar[0]);
		int Q=Integer.parseInt(ar[1]);
		
		Node2 narr[]=new Node2[N];
		
		int arr[]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0;i<N;i++){
			if(narr[i]==null) {
				narr[i]=new Node2(arr[i]);
			}
			
			if((2*i)+1>=N)
				break;
			
			if(narr[(2*i)+1]==null) {
				narr[(2*i)+1]=new Node2(arr[(2*i)+1]);
				narr[i].left=narr[(2*i)+1];
			}
			
			if((2*i)+2>=N)
				break;
			
			if(narr[(2*i)+2]==null) {
				narr[(2*i)+2]=new Node2(arr[(2*i)+2]);
				narr[i].right=narr[(2*i)+2];
			}
		}
		
		Node2 root=narr[0];
		Inorder(root);
		System.out.println();
		
		int h=height(root);
		
		ArrayList<Integer> list[]=new ArrayList[h];
		for(int i=0;i<h;i++)
			list[i]=new ArrayList<Integer>();
		
		list[0].add(root.data);
		
		boolean marked[]=new boolean[N];
		
//		level(root,list,0,h);
		
		list=Level(root,h);
		
		for(ArrayList<Integer> z:list) {
			for(int q:z)
			{
				System.out.print(q+" ");
			}
			System.out.println();
		}


	}

}
