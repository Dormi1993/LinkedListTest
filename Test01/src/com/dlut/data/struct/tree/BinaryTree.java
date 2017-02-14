package com.dlut.data.struct.tree;

import java.util.Scanner;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class BinaryTree {
    private static Scanner sc = new Scanner(System.in);
    /**
     * 用Java创建二叉树貌似成了一大难题，网上、书上好多写的代码特别复杂，不知道搞那么麻烦干啥
     * @return
     */
    public static TreeNode create() {
        int value = sc.nextInt();
        if(value>0) {
            TreeNode node = new TreeNode(value);
            node.left = create();//？？
            node.right = create();
            return node;
        }
        return null;
    }
    
    //二叉树的三种常用遍历，是可以查阅网上资料的，有的还给画了图
    /**
     * 二叉树的前序遍历需要好好熟悉一下，给你一个二叉树结构，能说出来前序遍历的结果
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if(root!=null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    /**
     * 二叉树的中序遍历需要好好熟悉一下，给你一个二叉树结构，能说出来前序遍历的结果
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if(root!=null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }
    /**
     * 二叉树的后序遍历需要好好熟悉一下，给你一个二叉树结构，能说出来前序遍历的结果
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if(root!=null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.value);
        }
    }
    
    /**
     * 统计节点个数
     * @param root
     * @return
     */
    public static int getNodeCount(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        return getNodeCount(root.left)+getNodeCount(root.right)+1;
    }
    
    /**
     * 计算高度
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root) {
        if(root==null) 
            return 0;
        if(root.left==null && root.right==null) {
            return 1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
    /**
     * 主要就是创建，其他的跟着网上走就行，常考的就是跟递归相关的算法
     * @param args
     */
    public static void main(String[] args) {
        TreeNode tree = BinaryTree.create();
        System.out.println("前序遍历，先序遍历");
        BinaryTree.preOrder(tree);
        System.out.println("中序遍历");
        BinaryTree.inOrder(tree);
        System.out.println("后序遍历");
        BinaryTree.postOrder(tree);
        System.out.println("节点个数："+BinaryTree.getNodeCount(tree));
        System.out.println("高度："+BinaryTree.getHeight(tree));
    }
}
