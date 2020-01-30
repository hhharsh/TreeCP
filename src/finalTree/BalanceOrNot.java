package finalTree;

class Node15{
	int data;
	Node15 left;
	Node15 right;
	
	Node15(int d){
		left=null;
		right=null;
		data=d;
	}
}

class Height{
	int height=0;
}
	
public class BalanceOrNot {
	
	public static Node15 root=null;
	
 boolean check(Node15 root,Height h) {
		
		if(root==null) {
			h.height=0;
			return true;
		}
		
		
			Height lh=new Height();
			Height rh=new Height();
			

			boolean ll=check(root.left,lh);
			boolean rr=check(root.right,rh);
			
			int lefth=lh.height;
			int righth=rh.height;
			
			
			
			h.height=Math.max(lefth,righth)+1;
			
			if(Math.abs(lefth-righth)>1) {
				
				return false;
				
			}
			
			else{
				
				return ll && rr;
				
			}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new Node15(1);
		root.left=new Node15(2);
		root.left.left=new Node15(4);
		root.left.left.left=new Node15(9);
		root.left.right=new Node15(5);
	
		root.right=new Node15(3);
		
		Height obj=new Height();
		
		BalanceOrNot oo=new BalanceOrNot();
		
		System.out.println(oo.check(root,obj));
			

	}

}
