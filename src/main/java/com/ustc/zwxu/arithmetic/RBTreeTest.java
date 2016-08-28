package com.ustc.zwxu.arithmetic;

import java.util.Scanner;

public class RBTreeTest {
	public static void main(String[] args) {
		RBTree rbTree = new RBTree();
		Scanner data=new Scanner(System.in);
		System.out.println("--------插入---------");
    	int insertKey=data.nextInt();
    	while(insertKey != 0){
    		rbTree.rbInsert(new RBNode(insertKey));
    		rbTree.printTree();
    		System.out.println("-------------------------");
    		insertKey=data.nextInt();
    	}
    	System.out.println("--------用0结束插入操作---------");
		/*rbTree.rbInsert(new RBNode(41));
		rbTree.rbInsert(new RBNode(38));
		rbTree.rbInsert(new RBNode(31));
		rbTree.rbInsert(new RBNode(12));
		rbTree.rbInsert(new RBNode(19));
		rbTree.rbInsert(new RBNode(8));
		*/
		
    	System.out.println("--------删除---------");
		int deleteKey=data.nextInt();
		rbTree.rbDelete(deleteKey);
		rbTree.printTree();
		System.out.println("-------------------------");
	}
}
class RBTree {
	private final RBNode NIL = new RBNode(null,null,null,Color.BLACK,-1);
	private RBNode root;
	public RBTree() {
		root = NIL;
	}
	public RBTree(RBNode  root) {
		this.root = root;
	}
	public void show(RBNode node)
	{
		if (node == null) { 
			return;
		} else { 
			System.out.println(" 节点："+node.getValue() + "的颜色为：" + node.getColor());
			if (node.getLeft() != null) { 
				System.out.println("{"); 
				show(node.getLeft());
				System.out.println("}"); 
			}
			if (node.getRight() != null) { 
				System.out.println("{"); 
				show(node.getRight());
				System.out.println("}"); 
			}
		}
	}
	//插入节点
	public void rbInsert(RBNode node) {
		RBNode previous = NIL;//y
		RBNode temp = root;//x
		while (temp != NIL) {
			previous = temp;
			if (temp.getValue() < node.getValue()) {
				temp = temp.getRight();
			} else {
				temp = temp.getLeft();
			}
		}
		node.setParent(previous);//node=z
		if (previous == NIL) {
			root = node;
			//root.setParent(NIL);
		} else  if (previous.getValue() > node.getValue()) {
			previous.setLeft(node);
		} else {
			previous.setRight(node);
		}
		node.setLeft(NIL);
		node.setRight(NIL);
		node.setColor(Color.RED);//将插入的节点置为红色，
		rb_Insert_Fixup(node);
	}
	//插入节点后的调整
	private void rb_Insert_Fixup(RBNode node) {
		while (node.getParent().getColor() == Color.RED) {
			if (node.getParent() == node.getParent().getParent().getLeft()) {
				RBNode rightNuncle = node.getParent().getParent().getRight();
				if (rightNuncle.getColor() == Color.RED) {         //Case 1
					//插入节点z的叔叔是红色，z是右孩子
					rightNuncle.setColor(Color.BLACK);
					node.getParent().setColor(Color.BLACK);
					node.getParent().getParent().setColor(Color.RED);
					node = node.getParent().getParent();
				} else if (node == node.getParent().getRight()) {  //case 2
					//插入节点z的叔叔是黑色，z是右孩子
					node = node.getParent();
					leftRotate(node);
				} else {                                          //case 3
					//插入节点z的叔叔是黑色，z是左孩子
					node.getParent().setColor(Color.BLACK);
					node.getParent().getParent().setColor(Color.RED);
					rightRotate(node.getParent().getParent());	
				}
			//由对称性可得				
			} else {//插入节点的叔叔是红色，z是左孩子
				RBNode leftNuncle = node.getParent().getParent().getLeft();
				if (leftNuncle.getColor() == Color.RED) {     //case 4
					leftNuncle.setColor(Color.BLACK);
					node.getParent().setColor(Color.BLACK);
					node.getParent().getParent().setColor(Color.RED);
					node = node.getParent().getParent();
				} else if (node == node.getParent().getLeft()) { //case 5
					node = node.getParent();
					rightRotate(node);
				} else {                                          // case 6
					node.getParent().setColor(Color.BLACK);
					node.getParent().getParent().setColor(Color.RED);
					leftRotate(node.getParent().getParent());
				}
			}	
		}
		root.setColor(Color.BLACK);	
	}
	//删除节点
	public RBNode rbDelete(int data) {	
		RBNode node = search(data);//z
		RBNode temp = NIL;//y
		RBNode child = NIL;//x
		if (node == null) {
			return null;
		} else {
			if (node.getLeft() == NIL || node.getRight() == NIL) {
				temp = node;			
			} else {
				temp = successor(node);
			}
			if (temp.getLeft() != NIL) {
				child = temp.getLeft();
			} else {
				child = temp.getRight();
			}
			child.setParent(temp.getParent());
			if (temp.getParent() == NIL) {
				root = child;
			} else if (temp == temp.getParent().getLeft()) {
				temp.getParent().setLeft(child);
			} else {
				temp.getParent().setRight(child);
			}
			if (temp != node) {
				node.setValue(temp.getValue());
			}
			if (temp.getColor() == Color.BLACK) {
				rb_Delete_Fixup(child);
			}
			return temp;
		}	
	}
	//删除节点后的调整
	private void rb_Delete_Fixup(RBNode node) {//x
		while (node != root && node.getColor() == Color.BLACK) {
			if (node == node.getParent().getLeft()) {
				RBNode rightBrother = node.getParent().getRight();
				if (rightBrother.getColor() == Color.RED) {//case 1 node节点为左孩子，node节点的兄弟为RED
					rightBrother.setColor(Color.BLACK);
					node.getParent().setColor(Color.RED);
					leftRotate(node.getParent());
					rightBrother = node.getParent().getRight();
				}			
				if (rightBrother.getLeft().getColor() == Color.BLACK && rightBrother.getRight().getColor() == Color.BLACK) {
					//node兄弟是黑色，而且两个孩子都是黑色
					rightBrother.setColor(Color.RED);
					node = node.getParent();
				} else if (rightBrother.getRight().getColor() == Color.BLACK) {
					//node兄弟是黑色，而且左孩子红色，右孩子黑色
					rightBrother.getLeft().setColor(Color.BLACK);
					rightBrother.setColor(Color.RED);
					rightRotate(rightBrother);
					rightBrother = node.getParent().getRight();
				} else {
					//node兄弟是黑色，而且右孩子红色
					rightBrother.setColor(node.getParent().getColor());
					node.getParent().setColor(Color.BLACK);
					rightBrother.getRight().setColor(Color.BLACK);
					leftRotate(node.getParent());
					node = root;
				}
			//由于对称性可得		
			} else {//case 1 node节点为右孩子，node节点的兄弟为RED
				RBNode leftBrother = node.getParent().getLeft();
				if (leftBrother.getColor() == Color.RED) {
					leftBrother.setColor(Color.BLACK);
					node.getParent().setColor(Color.RED);
					rightRotate(node.getParent());
					leftBrother = node.getParent().getLeft();
				} 
				if (leftBrother.getLeft().getColor() == Color.BLACK && leftBrother.getRight().getColor() == Color.BLACK) {
					leftBrother.setColor(Color.RED);
					node = node.getParent();									
				} else if (leftBrother.getLeft().getColor() == Color.BLACK) {
					leftBrother.setColor(Color.RED);
					leftBrother.getRight().setColor(Color.BLACK);
					leftRotate(leftBrother);
					leftBrother = node.getParent().getLeft();
				} else {
					leftBrother.setColor(node.getParent().getColor());
					node.getParent().setColor(Color.BLACK);
					leftBrother.getLeft().setColor(Color.BLACK);
					rightRotate(node.getParent());
					node = root;											
				}					
			}			
		}	
		node.setColor(Color.BLACK);
	}
	/*1.一个节点有右孩子，则在中序遍历中，该节点的后继是它的右子树的最左节点。
      2. 这个节点是它父亲的左孩子，则该节点的后继节点是它的父亲
      3. 这个节点是它父亲的右孩子，则需要一直向上搜索，直到它们n-1代祖先是它第n代祖先的左孩子，
             则它的后继就是第n个祖先。如果一直搜索到根节点，也没有找到n-1代祖先是它第n代祖先的左孩子，
             则该节点是整个树的中序遍历中的最后一个节点，即它没有后继。*/
	//查找节点node的后继节点
	public RBNode successor(RBNode node) {//右孩子或右孩子的左孩子
		RBNode rightChild = node.getRight();
		if  (rightChild != NIL) {
			RBNode previous = null;
			while (rightChild != NIL) {
				previous = rightChild;
				rightChild = rightChild.getLeft();
			}
			return previous;
		} else {
			RBNode parent = node.getParent();
			while (parent != NIL && node != parent.getLeft()) {
				node = parent;//root
				parent = parent.getParent();//null
			}
			return parent;//null
		}
	}
	//查找节点
	public RBNode search(int data) {
		RBNode temp = root;
		while (temp != NIL) {
			if (temp.getValue() == data) {
				return temp;
			} else  if (data < temp.getValue()) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		return null;
	}
	//左转函数
	private void leftRotate(RBNode node) {//x
		//System.out.println("绕"+node.getValue()+"左旋");
		RBNode rightNode = node.getRight();//y
		node.setRight(rightNode.getLeft());
		if (rightNode.getLeft() != NIL) {
			rightNode.getLeft().setParent(node);
		}
		rightNode.setParent(node.getParent());
		if (node.getParent() == NIL) {
			rightNode = root;
		} else if (node == node.getParent().getLeft()) {
			node.getParent().setLeft(rightNode);
		} else {
			node.getParent().setRight(rightNode);
		}
		rightNode.setLeft(node);
		node.setParent(rightNode);	
	}
	
	//右转函数
	private void rightRotate(RBNode node) {
		//System.out.println("绕"+node.getValue()+"右旋");
		RBNode leftNode = node.getLeft();
		node.setLeft(leftNode.getRight());
		if (leftNode.getRight() != null) {
			leftNode.getRight().setParent(node);
		}
		leftNode.setParent(node.getParent());
		if (node.getParent() == NIL) {
			root = leftNode;
		} else if (node == node.getParent().getLeft()) {
			node.getParent().setLeft(leftNode);
		} else {
			node.getParent().setRight(leftNode);
		}
		leftNode.setRight(node);
		node.setParent(leftNode);				
	}
	//中序遍历红黑树
	public void printTree() {
		inOrderTraverse(root);
	}
	private void inOrderTraverse(RBNode node) {
		if (node != NIL) {
			inOrderTraverse(node.getLeft());
			System.out.println(" 节点："+node.getValue() + "的颜色为：" + node.getColor());
			inOrderTraverse(node.getRight());
		}	
	}
	public RBNode getNIL() {
		return NIL;
	}
}
class RBNode {
	private RBNode left;
	private RBNode right;
	private RBNode parent;
	private Color color;
	private int value;
	public RBNode(RBNode left, RBNode right, RBNode parent, Color color, int value) {
		super();
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.color = color;
		this.value = value;
	}
	public RBNode() {
	}
	public RBNode(int value) {
		this(null,null,null,null,value);
	}
	public RBNode getLeft() {
		return left;
	}
	public void setLeft(RBNode left) {
		this.left = left;
	}
	public RBNode getRight() {
		return right;
	}
	public void setRight(RBNode right) {
		this.right = right;
	}
	public RBNode getParent() {
		return parent;
	}
	public void setParent(RBNode parent) {
		this.parent = parent;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}	
}
enum Color {
	RED,BLACK
}
