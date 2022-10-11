package Lecture38_Binary_Tree;

import java.util.Scanner;
public class BinaryTree {
	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;//ye pahla hamra root node hoga
	Scanner sc = new Scanner(System.in);

	public BinaryTree() {
		this.root = CreateTree();//har node ka address leke rakhega.
	}
	public Node CreateTree() {
		int item=sc.nextInt();
		Node nn=new Node();//1k create node and go a value 0 and address left right null
	    nn.data=item;//koi value aayega aur address abhi bhi null hi hai
	    boolean left_child=sc.nextBoolean();//is line se ham left tree ki value denge.
	    if(left_child==true) {
	    	nn.left=CreateTree();//create left tree 
	    }
	    boolean right_child=sc.nextBoolean();//iss line se right tree ka value denge.
	    if(right_child==true) {
	    	nn.right=CreateTree();//create right tree
	    }
	    return nn;
	}
	public void Display() {//isliye quiki ham tree ko directly  call karke print nhi kara sakte
		Display(this.root);
	}
	  private void Display(Node nn) {
		  if(nn==null) {
			  return;
		  }
		  String str="";
		  str=str+nn.data;
		  str="<--"+str+"-->";
		  if(nn.left!=null) {
			  str=nn.left.data+str;
		  }
		  else {
			  str="."+str;
		  }
		  if(nn.right!=null) {
			  str=str+nn.right.data;
		  }
		  else {
			  str=str+".";
		  }
		  System.out.println(str);
		  Display(nn.left);//all left subtree visit karenge.
		  Display(nn.right);//all right subtree visit karenge.
	  }
	  //Maximum number in tree:-
	  public int max() {
		  return max(this.root);
	  }
	  private int max(Node node) {
		  if(node==null) {
			  return Integer.MIN_VALUE;
		  }
		int leftmax=max(node.left);
		int rightmax=max(node.right);
		return Math.max(leftmax,Math.max(rightmax,node.data));
	}
	  //find item in a tree:- 
	  public boolean find(int item) {
		  return find(this.root,item);
	  }
	  private boolean find(Node nn,int item) {
		  if(nn==null) {
			  return false;
		  }
		  if(nn.data==item) {
			  return true;
		  }
		  return find(nn.left,item)|| find(nn.right,item);
	  }
	  //Height if the tree:-
	  public int hight() {
		  return hight(this.root);
	  }
	  private int hight(Node node) {
		  if(node==null) {
			  return -1;
		  }
		  int lefthight=hight(node.left);
		  int righthight=hight(node.right);
		  return Math.max(lefthight, righthight)+1;
	  }
}
