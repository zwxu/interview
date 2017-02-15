package com.ustc.zwxu.offer;


/*
 * 剑指offer 重建二叉树  
 */
public abstract class Demo06 {
	protected abstract void f();
	public static void preOrder(TreeNode node)
	{
		if(node==null)
		{
			System.out.print("tree is null");
		}
	
		else
		{
			System.out.print(node.val+":");
		}
		if(node.left!=null)
		{
			preOrder(node.left);
		}
		if(node.right!=null)
		{
			preOrder(node.right);
		}
	}

	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
	        return root;
	    }
	    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
	    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
	         
	        if(startPre>endPre||startIn>endIn)
	            return null;
	        TreeNode root=new TreeNode(pre[startPre]);
	         
	        for(int i=startIn;i<=endIn;i++)
	            if(in[i]==pre[startPre]){
	                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
	                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
	            }
	                 
	        return root;
	    }

	public static void main(String[] args) {
		StringBuffer s1=new StringBuffer(10);s1.append("1234");
		System.out.println(s1);
		
		int pre[] ={1,2,4,7,3,5,6,8};
		int in[] ={4,7,2,1,5,3,8,6};
		TreeNode root=reConstructBinaryTree(pre,in);
		preOrder(root);
	}

}




