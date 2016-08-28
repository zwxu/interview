package com.ustc.zwxu.arithmetic;

import java.util.Scanner;


public class AVLTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree demo=new AVLTree();
		System.out.println("------添加------");
		/*for(int i=0;i<10;i++){
			int ran = (int)(Math.random() * 100);
			System.out.print(ran+" ");
			demo.insert(ran);
		}*/
		demo.insert(20);
		demo.insert(12);
		demo.insert(15);
		demo.insert(17);
		demo.insert(19);
		demo.insert(25);
		demo.insert(30);
		demo.insert(18);
		System.out.println("------删除------");
		//应该绕15左旋
		Scanner s=new Scanner(System.in);
		int value=s.nextInt();
		demo.delete(value);
		demo.middleDisplay();
	} 
}
class AVLTree
{
   private AVLNode root;

   public AVLTree()
   {
       root = null;
   }
   
   public boolean isEmpty()
   {
       return root == null;
   }
   //找到要删除的节点
   public AVLNode findDelete(int data)
   {
	   AVLNode temp = root;
		while (temp != null) {
			if (temp.data == data) {
				return temp;
			} else  if (data < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return null;
   }
   public void insert(int data)
   {
       // 新建一个节点
       AVLNode insertNode = new AVLNode(data);
       // 如果根节点为空，直接赋值给根节点
       if (root == null)
       {
           root = insertNode;
           return;
       }
       AVLNode insertPos = root;
       // 先将节点插入树中，需要回朔改变插入路径的各个节点的平衡因子。
       while (insertPos != null)//插入左边
       {
           if (data < insertPos.data)//插入左边
           {
               if (insertPos.left == null)
               {
                   insertPos.left = insertNode;
                   insertPos.bf += 1;
                   insertNode.parent = insertPos;
                   break;
               }
               else
               {
                   insertPos = insertPos.left;//不为空，继续往左走
               }
           }
           else//插入右边
           {
               if (insertPos.right == null)
               {
                   insertPos.right = insertNode;
                   insertPos.bf -= 1;
                   insertNode.parent = insertPos;
                   break;
               }
               else
               {
                   insertPos = insertPos.right;//不为空，继续往右走
               }
           }
       }
       // 下面是回朔算法，从insertPos节点开始检查
       AVLNode current = insertPos;//此时找到插入节点的父节点
       while (true)//检查不平衡因素，子节点没有，往上找父节点
       {
           // 如果节点的平衡因子为0，不需要再回朔了，直接返回
           if (current.bf == 0)
           {
               return;
           }
           // 如果节点的平衡因子为1或者-1，首先修正父节点的平衡因子，但是要先判断当前节点是否是root
           else if (current.bf == 1 || current.bf == -1)
           {
               // 如果已经回朔到根节点，则直接返回
               if (current == root)
               {
                   return;
               }
               // 如果插入的节点在当前节点的父节点的左边，则将父节点的bf值+1
               else if (data < current.parent.data)
               {
                   current.parent.bf += 1;
               }
               // 否则当前节点的父节点的bf值减一
               else
               {
                   current.parent.bf -= 1;
               }
               // 继续回朔当前的父节点
               current = current.parent;
           }
           // 如果节点的平衡因子的绝对值大于1，则说明找到了最小不平衡子树的根，下面左旋转修正操作
           else if (current.bf == 2 || current.bf == -2)
           {
               if (data < current.data && data < current.left.data)
               {
            	// case 1:LL类型旋转
                   rightRotate(current);
               }
               // case 2:RR类型旋转
               else if (data >= current.data && data >= current.right.data)
               {
                   
                   leftRotate(current);
               }
               //case 3:LR型旋转
               //先要将current.left绕着current.left.right左旋，再将current绕着current.left右旋
               else if (data < current.data && data >= current.left.data)
               {
                   leftRotate(current.left);
                   rightRotate(current);
               }
              //case 4:RL型旋转
               //先要将current.right绕着current.right.left左旋，再将current绕着current.right右旋
               else
               {
                   rightRotate(current.right);
                   leftRotate(current);
               }
               // 如果B的bf值为0或者B为根节点，则跳出循环
               if (current.parent == root || current.parent.bf == 0)
               {
                   break;
               }
               // 否则继续检查B的父节点
               else
               {
                   current = current.parent.parent;
               }
           }
       }
   }
   
   public AVLNode successor(AVLNode node) {//右孩子或右孩子的左孩子
		AVLNode rightChild = node.right;
		if  (rightChild != null) {
			AVLNode previous = null;
			while (rightChild != null) {
				previous = rightChild;
				rightChild = rightChild.left;
			}
			return previous;
		} else {
			AVLNode parent = node.parent;
			while (parent != null && node != parent.left) {
				node = parent;//root
				parent = parent.parent;//null
			}
			return parent;//null
		}
	}
   /**
   	设q为被删节点的父节点, 如果删除的是q的左子树, 
   	则bf(q)减一, 否则 bf(q)加一. 根据bf(q), 存在三种情况
    * 
    */
   public AVLNode delete(int data)
   {
       AVLNode current = findDelete(data);//z
       AVLNode tempNode = null;//y
       int temp = current.data;
       while (current != null)
       {
         if (current.left == null || current.right == null) 
           {
        	   tempNode = current;			
   		   } 
           else 
   		   {
        	   tempNode = successor(current);
   		   }
           if (tempNode != null)
           {
        	   current.data = tempNode.data;
        	   tempNode.data = temp;
        	   current = tempNode;
            }
           // 从root往下走
           if (current == root)
           {
               root = null;
               return current;
           }
           else if (current == current.parent.left)// 如果当前节点是其父节点的左子树
           {
              if (current.left != null)
              {// 如果当前节点的左子树不为空
                  current.parent.left = current.left;
                  current.left.parent = current.parent;
              }
              else if (current.right != null)
              {
            	  current.parent.left = current.right;
            	  current.right.parent = current.parent;
              }
              else
              {
            	  current.parent.left = null;
              }
              current.parent.bf -= 1;//添加是+1
              }
           else{// 如果当前节点是其父节点的右子树
              if (current.left != null)
              {// 如果当前节点的左子树不为空，则将当前节点的左子树链接到当前节点的父节点
                  current.parent.right = current.left;
                  current.left.parent = current.parent;
              }
              else if (current.right != null)
              {
                  current.parent.right = current.right;
                  current.right.parent = current.parent;
              }
              else
              {
            	  current.parent.right = null;
              }
              current.parent.bf += 1;//添加时-1
        }
       
        tempNode = current.parent;// 删除节点的父节点
        // 下面是删除操作的回朔算法tempNode为替换删除节点的节点
        while (true)
        {
        	// case1:如果被删除节点的父节点的bf为1或者-1
        	//说明删除之前的bf为0（左右子树相同），需改变父节点和其他祖父节点的平衡因子
        	if (tempNode.bf == 1 || tempNode.bf == -1)
            {
        		return current;
            }
            else if (tempNode.bf == 0)
            {// case1:如果被删除节点的父节点的bf为0
             //说明删除之前bf为1或者-1，删除之后高度减少了，需改变父节点和其他祖父节点的平衡因子
            	if (tempNode == root)// 首先需要判断是否已经回朔到了根节点
                {
            		return current;
                }
                else if (tempNode == tempNode.parent.left)
                {// 如果当前节点是父节点的左子树，说明父节点的左子树高度下降了
                	tempNode.parent.bf -= 1;
                }
                else
                {
                	tempNode.parent.bf += 1;
                }
            }
            else
            {  //case1:如果被删除节点的父节点的bf为2或者-2，
            	//说明之前节点bf为1或-1，左右子树高度不同，此时需平衡化处理
            	if (tempNode.bf >= 0 && tempNode.left.bf >= 0)
                {// LL型旋转
            		rightRotate(tempNode);
                }
                else if (tempNode.bf >= 0 && tempNode.left.bf < 0)
                {// LR型旋转
                	leftRotate(tempNode.left);
                	rightRotate(tempNode);
                }
                else if (tempNode.bf < 0 && tempNode.right.bf >= 0)
                {// RL型旋转
                	rightRotate(tempNode.right);
                	leftRotate(tempNode);
                }
                else
                {// RR型旋转
                	leftRotate(tempNode);
                }
           }
           tempNode = tempNode.parent;
     }//end(true)
  }//end(null)
  return current;    
  }
   
   /**
    * 返回一个树的最大值节点
    * 
    * @param root
    * @return
    */
   private AVLNode maxNode(AVLNode root)
   {
       AVLNode current = root;
       while (current != null)
       {
           if (current.right == null)
           {
               break;
           }
           else
           {
               current = current.right;
           }
       }
   
       return current;
   }
   
   /**
    * 返回一个树的最小值节点
    * 
    * @param root
    * @return
    */
   private AVLNode minNode(AVLNode root)
   {
       AVLNode current = root;
       while (current != null)
       {
           if (current.left == null)
           {
               break;
           }
           else
           {
               current = current.left;
           }
       }
       return current;
   }
   
   /**
    * 将节点左旋的方法
    * 
    * @param node
    * @see [类、类#方法、类#成员]
    */
   private void leftRotate(AVLNode node)
   {
	   System.out.println("绕"+node.data+"左旋");
       // 旋转代码
       if (node.parent == null)
       {
           root = node.right;
       }
       else if (node == node.parent.left)
       {
           node.parent.left = node.right;
       }
       else
       {
           node.parent.right = node.right;
       }
       node.right.parent = node.parent;
       if (node.right.left != null)
       {
           node.right.left.parent = node;
       }
       node.parent = node.right;
       node.right = node.parent.left;
       node.parent.left = node;
       // 调整平衡因子
       if (node.parent.bf < 0)//如果父节点的平衡因子小于0
       {
           node.bf = node.bf - node.parent.bf + 1;
       }
       else
       //如果父节点的平衡因子大于或等于0
       {
           node.bf += 1;
       }
       if (node.bf < 0)
       {
           node.parent.bf += 1;
       }
       else
       {
           node.parent.bf = node.parent.bf + node.bf + 1;
       }
   }
   
   /**
    * 将节点右旋的方法
    * 
    * @param node
    * @see [类、类#方法、类#成员]
    */
   private void rightRotate(AVLNode node)
   {
	   System.out.println("绕"+node.data+"右旋");
       if (node.parent == null)
       {
           root = node.left;
       }
       else if (node == node.parent.left)
       {
           node.parent.left = node.left;
       }
       else
       {
           node.parent.right = node.left;
       }
       // 将B的父节点设为A的父节点
       node.left.parent = node.parent;
       // 如果B的右子树不为null，则将B的右子树的父节点设为A
       if (node.left.right != null)
       {
           node.left.right.parent = node;
       }
       // 将A的父节点设为B
       node.parent = node.left;
       // 将B的右子树接到A的左边
       node.left = node.parent.right;
       node.parent.right = node;
       // 求得当前节点旋转后的bf值，这个是经过公式推导出来的会有三种情况-1,0,1
       //        node.bf = node.bf - node.parent.bf - 1;
       //        if (node.bf == -1)
       //        {
       //            node.parent.bf -= 2;
       //        }
       //        else
       //        {
       //            node.parent.bf -= 1;
       //        }
       if (node.parent.bf >= 0)
       {
           node.bf = node.bf - node.parent.bf - 1;
       }
       else
       {
           node.bf -= 1;
       }
       if (node.bf >= 0)
       {
           node.parent.bf -= 1;
       }
       else
       {
           node.parent.bf = node.parent.bf + node.bf - 1;
       }
   }
   
   /**
    * 中序遍历二叉树
    */
   public void middleDisplay()
   {
       middleDisplay(root);
   }
   
   /**
    * 使用递归方式中序遍历二叉树
    */
   private void middleDisplay(AVLNode root)
   {
       if (root != null)
       {
           middleDisplay(root.left);
           root.displayNode();
           middleDisplay(root.right);
       }
   }
   class AVLNode {
		public AVLNode left;
		public AVLNode right;
		public AVLNode parent;
		public int bf=0;
		public int data;
		public AVLNode(int data){
			this.data=data;
		}
		public  void displayNode(){
			System.out.print(data+" ");
		}
   }
}