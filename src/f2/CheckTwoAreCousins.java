package f2;
import java.util.*;
class Node92{
	int data;
	Node92 left;
	Node92 right;
	
	Node92(int d){
		data=d;
	}
}

class pair{
	Node92 roo;
	int par;
	
	pair(Node92 rr,int pp){
		roo=rr;
		par=pp;
	}
}
public class CheckTwoAreCousins {
	
	static Node92 root;
	
	static boolean check(Node92 root,int p,int q) {
		
		pair p1=new pair(root,-1);
		
		Queue<pair> qq=new LinkedList<>();
		
		qq.add(p1);
		int f=0;
		int tt=0;
		
		while(!qq.isEmpty()) {
			pair t1=qq.poll();
			Node92 n1=t1.roo;
			int n2=t1.par;
			
			
			if((n1.data==p || n1.data==q) && f==0) {
				tt=n2;
				f++;
			}
			
			else if((n1.data==p || n1.data==q) && f==1) {
				if(tt!=n2) {
					return true;
				}
			}
			
			
			
			if(n1.left!=null) {
				qq.add(new pair(n1.left,n1.data));
			}
			
			if(n1.right!=null) {
				qq.add(new pair(n1.right,n1.data));
			}
			
			
			
		}
		return false;
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node92(2);
		root.left=new Node92(1);
		root.left.left=new Node92(4);
		root.left.right=new Node92(5);
		root.right=new Node92(3);
		root.right.left=new Node92(7);
		
		System.out.println(check(root,4,7));

	}

}
