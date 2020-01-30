package p1;
import java.util.*;

class Node6{
	
	int data;
	Node6 left;
	Node6 right;
	
   Node6(int d){
		data=d;
	}
}
public class LevelPrint {

	static Node6 root;
	static ArrayList<ArrayList<Integer>> list1=new ArrayList<>();
	static ArrayList<Integer> list=new ArrayList<>();
	public static void PrintLevel(Node6 root) {
		
		int h=Height(root);
		System.out.println(h+"*");
		for(int i=1;i<=h;i++) {
			Print(root,i);
			ArrayList<Integer> temp=new ArrayList<>();
			for(int z:list) {
				temp.add(z);
			}
			list1.add(temp);
			list.clear();
			System.out.println();
		}
		
	}
	
	public static void Print(Node6 root,int level) {
			
		if(root==null)
			return;
		
		if(level==1) {
			System.out.print(root.data+" ");
			list.add(root.data);
			return;
		}
		
		Print(root.left,level-1);
		Print(root.right,level-1);
		
		
	}
	
	public static int Height(Node6 root) {
		if(root==null)
			return 0;
		
		int lh=Height(root.left);
		int rh=Height(root.right);
		return 1+Math.max(lh,rh);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);
		root=new Node6(1);
		root.left=new Node6(2);
		root.left.left=new Node6(4);
		root.left.right=new Node6(5);
		root.left.right.right=new Node6(9);
		root.left.right.right.left=new Node6(10);
		root.right=new Node6(3);
		root.right.right=new Node6(7);
		root.right.left=new Node6(6);
		root.right.right.right=new Node6(8);
		
		PrintLevel(root);
		System.out.println(list1);
		
		System.out.println(Height(root)+"((");
		
		// printing left view of the tree
		for(int i=0;i<list1.size();i++) {
			ArrayList<Integer> tt=list1.get(i);
			
			System.out.println(tt.get(0));
		}
	}

}
