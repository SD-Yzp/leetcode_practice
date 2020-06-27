package com.study.thought.divide_and_conquer;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {
        /*TreeNode node;
        for (int i = 1; i <= n; i++) {
            node = new TreeNode(i);
            node.left = generateTrees(1,i-1);
            node.right = generateTrees(i+1,n);
            res.add(node);
        }*/
        if(n<1){
            return new LinkedList<TreeNode>();
        }

        return generateTrees(1,n);
    }
    private static List<TreeNode> generateTrees(int start,int end){
        /*TreeNode node = null;
        for (int i = start; i <= end; i++) {
            node = new TreeNode(i);
            node.left = generateTrees(start,i-1);
            node.right = generateTrees(i+1,end);
        }
        return node;*/
        List<TreeNode> res = new LinkedList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start,i-1);
            List<TreeNode> rightTree = generateTrees(i+1,end);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void midShow(TreeNode node){
        if(node!=null){
            midShow(node.left);
            System.out.print(node.val+" ");
            midShow(node.right);
        }
    }

    public static void frontShow(TreeNode node){
        if(node!=null){
            System.out.print(node.val+" ");
            frontShow(node.left);
            frontShow(node.right);
        }
    }

    public static void main(String[] args) {
        /*TreeNode node = generateTrees(1, 3);
        midShow(node);*/
        List<TreeNode> nodes = generateTrees(3);
        for (TreeNode n : nodes) {
            frontShow(n);
            System.out.println();
        }
    }
}