package com.suprithgurudu;

import javax.swing.tree.TreeCellRenderer;

class TreeNode{
    int data;
    TreeNode left, right;
    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] sorted = {1,2,3,4,5,6,7,8};

        TreeNode root = BSTConstruction(sorted, 0, sorted.length-1);

        inOrder(root);
    }

    private static void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    private static TreeNode BSTConstruction(int[] sorted, int l, int h) {
        if(l<=h){
            int m = (l+h)/2;
            TreeNode root = new TreeNode(sorted[m], null, null);
            root.left = BSTConstruction(sorted, l, m-1);
            root.right = BSTConstruction(sorted, m+1, h);
            return root;
        }
        return null;
    }
}

