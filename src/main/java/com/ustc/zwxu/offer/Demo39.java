package com.ustc.zwxu.offer;

/*
 * 剑指offer 二叉树的深度  
 */
public class Demo39 {
	
	public static int TreeDepth(TreeNode pRoot)
    {

		if(pRoot == null)
			return 0;
		int left=TreeDepth(pRoot.left);
		int	right=TreeDepth(pRoot.right);
		return left>right?left+1:right+1;
    }
	
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
			return true;
		int left=TreeDepth(root.left);
		int	right=TreeDepth(root.right);
        int i=left-right;
        if(i>1 || i<-1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		root.left=node1;
		root.right=node2;
		System.out.print(TreeDepth(root));
	}

}
