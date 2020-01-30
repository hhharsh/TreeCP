package p2;


class Node{
	int data;
	Node right;
	Node left;
	Node(int d){
		data=d;
		right=null;
		
		left=null;
	}
}
public class W1 {
	
	public static int max=Integer.MIN_VALUE; 
	public static int ans=0;
	
	
	public static void maxLevel( Node root, int level) 
	{ 
		
		if(root==null)
			return;

		if(level==0) {
			if(root.data>max)
				max=root.data;
		}
		
		
		maxLevel(root.left,level-1);
		maxLevel(root.right,level-1);
	}
	public static Node fun1(Node root) {
		
		
		if(root==null)
			return null;
		
		
		
		Node t1=fun1(root.left);
		Node t2=fun1(root.right);
		
		if(t1!=null && t2!=null) {
			int p=root.data+t1.data+t2.data;
			if(p>max)
				max=p;
		}
		
		
		
		return root;
		
		
		
		
		
	}
	
public static void fun2(Node root,int d) {
	
	if(root==null)
		return;
	
	if(root.data==d) {
			return;
	}
	
	System.out.print(root.data+" ");
	
	
	fun2(root.left,d);
	fun2(root.right,d);
	
		
	}

public static void fun3(Node root,int d,int count) {
	
	if(root==null)
		return;
	
	if(root.data==d) {
		ans=count;
		return;
	}
	
	
	fun3(root.left,d,++count);
	fun3(root.right,d,++count);
	
	count--;
	
	
	
}

public static void printL(Node root,int t,int p) {
	
	
	if(root==null)
		return;
	
	if(t==1 && root.data!=p) {
		System.out.print(root.data+" ");
		
	}
	
	
	
	
	printL(root.left,t-1,p);
	printL(root.right,t-1,p);
	
	
	
	
}


public static int fun4(Node root) {
	
	if(root==null)
		return 0;
	
	if(root.left==null && root.right==null)
		return root.data;
	
	
	
	int ll=fun4(root.left);
	
	int rr=fun4(root.right);
	
	root.data=root.data+rr;
	
	return root.data;
	
	
	
}
	
public static void printIn(Node root) {
	if(root==null)
		return;
	
	printIn(root.left);
	System.out.print(root.data+" ");
	printIn(root.right);
}

	static Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.right.right=new Node(9);
		root.left.right.right.left=new Node(10);
		root.right=new Node(3);
		root.right.right=new Node(7);
		root.right.left=new Node(6);
		root.right.right.right=new Node(8);
		
//		maxLevel(root,2);
//		System.out.println(max);
		
		
		
//		
//		fun1(root);
//		System.out.println(max);
		
		
//		fun2(root,3);
		
//		fun3(root,5,0);
//		int t=ans;
//		
//		printL(root,t,5);
		
		fun4(root);
		printIn(root);
		
		
		
		
		
		
		

	}

}
