package com.study.thought.search.backtracking;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 提前放入根节点
        stack.push(root);
        dfs(root,stack,res);
        return res;
    }

    private static void dfs(TreeNode root, Deque<TreeNode> stack, List<String> res) {
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            Iterator<TreeNode> iterator = stack.descendingIterator();
            while(iterator.hasNext()){
                sb.append(iterator.next().val).append("->");
            }
            sb.delete(sb.length()-2,sb.length());
            res.add(sb.toString());
            return;
        }
        // 遍历左子树
        if(root.left!=null){
            stack.push(root.left);
            dfs(root.left,stack,res);
            stack.pop();
        }
        // 遍历右子树
        if(root.right!=null){
            stack.push(root.right);
            dfs(root.right,stack,res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(71);
        TreeNode node2 = new TreeNode(72);
        TreeNode node3 = new TreeNode(73);
        TreeNode node4 = new TreeNode(74);
        TreeNode node5 = new TreeNode(-75);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        List<String> res = binaryTreePaths(node1);
        for (String re : res) {
            System.out.println(re);
        }
    }
}