package com.study.structure.tree;

import java.util.*;

/**
 * 数节点
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static int maxDepth(TreeNode root){
        if(root!=null){
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }else{
            return 0;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }else {
            return false;
        }
    }

    public static int maxDiameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxDiameter = Math.max(maxDepth(root.right)+maxDepth(root.left),maxDiameter);
        maxDiameter = Math.max(diameterOfBinaryTree(root.left),maxDiameter);
        maxDiameter = Math.max(diameterOfBinaryTree(root.right),maxDiameter);
        return maxDiameter;
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return sum == root.val;
        }else{
            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }
    }

    private static int count;
    public static int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        isPathSum(root,sum);
        pathSum(root.right,sum);
        pathSum(root.left,sum);
        return count;
    }
    private static void isPathSum(TreeNode root, int sum){
        if(root==null){
            return;
        }
        if(root.val==sum){
            count++;
            System.out.println(sum);
        }
        isPathSum(root.left,sum-root.val);
        isPathSum(root.right,sum-root.val);
    }


    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        return isSubtreeWithRoot(s,t)||isSubtree(s.right,t)||isSubtree(s.left,t);
    }
    public static boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return isSubtreeWithRoot(s.left,t.left)&&isSubtreeWithRoot(s.right,t.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left)&&isSymmetric(root.right);
    }

    public static boolean isSymmetric(TreeNode leftNode,TreeNode rightNode) {
        if(leftNode==null&&rightNode==null){
            return true;
        }
        if(leftNode==null||rightNode==null){
            return false;
        }
        if(leftNode.val!=rightNode.val){
            return false;
        }
        return isSymmetric(leftNode.left,rightNode.right)&&isSymmetric(leftNode.right,rightNode.left);
    }

    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return minDepth(root.left,root.right)+1;
    }
    public static int minDepth(TreeNode leftNode,TreeNode rightNode) {
        if(leftNode==null&&rightNode==null){
            return 0;
        }
        if(leftNode!=null&&rightNode!=null){
            return Math.min(minDepth(leftNode.left,leftNode.right),minDepth(rightNode.left,rightNode.right))+1;
        }else if(leftNode==null){
            return minDepth(rightNode.left,rightNode.right)+1;
        }else{
            return minDepth(leftNode.left,leftNode.right)+1;
        }
    }

    private static int sumOfLeft;
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null){
                sumOfLeft += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sumOfLeft;
    }

    private static int longestPath = 0;
    public static int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longestPath;
    }
    private static int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = 0;
        if(root.left!=null && root.left.val==root.val){
            leftPath = left + 1;
        }
        int rightPath = 0;
        if(root.right!=null && root.right.val==root.val){
            rightPath = right + 1;
        }
        longestPath = Math.max(longestPath,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }

    public static int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int val1 = root.val;
        if(root.left!=null){
            val1 += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            val1 += rob(root.right.left)+rob(root.right.right);
        }
        int val2 = rob(root.left)+rob(root.right);
        return Math.max(val1,val2);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        if(root.left==null&&root.right==null){
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if(leftVal==root.val){
            leftVal = findSecondMinimumValue(root.left);
        }
        if(rightVal==root.val){
            rightVal = findSecondMinimumValue(root.right);
        }
        if(leftVal!=-1&&rightVal!=-1){
            return Math.min(leftVal,rightVal);
        }
        if(leftVal==-1){
            return rightVal;
        }
        return leftVal;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            double count = 0;
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node!=null){
                    sum += node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                    count++;
                }
            }
            // 最后一层再往下时就不要计算了
            if(!queue.isEmpty()){
                res.add(sum/count);
            }
        }
        return res;
    }

    public static int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                res = node.val;
            }
        }
        return res;
    }

    /**
     * 非递归实现前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();  // ArrayDeque不能放入null
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);  // 先放入右节点，因为栈是先进后出
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 非递归实现后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();  // 在加一个链表实际上为了实现反转
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }

    /**
     * 非递归实现后序遍历
     * 使用Collections工具类也可以
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal_collections(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 非递归实现中序遍历
     * 使用Collections工具类也可以
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){  // 一次性放入一条链上的左子节点
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;  // 对于每颗子树都需要左中右遍历，上面的循环找到了最左的节点，这个节点相当于在本子树中的中节点
        }
        return res;
    }

    /**
     * 修剪二叉搜索树
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }
        if(root.val>R){
            return trimBST(root.left,L,R);
        }
        if(root.val<L){
            return trimBST(root.right,L,R);
        }
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }

    /**
     * 查找第k个最小的
     * 中序遍历查找
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list.get(k-1);
    }

    /**
     * 查找第k个最小的
     * 递归查找
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest_recursion(TreeNode root, int k) {
        int leftCount = count(root.left);
        if(leftCount == k-1){
            return root.val;
        }
        if(leftCount > k-1){
            return kthSmallest_recursion(root.left,k);
        }
        return kthSmallest_recursion(root.right,k-leftCount-1);
    }
    private static int count(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }

    /**
     * 二叉搜索树变成累加树
     * 栈解决
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int temp = 0;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            node.val += temp;
            temp = node.val;
            cur = node.left;
        }
        return root;
    }

    /**
     * 二叉搜索树变成累加树
     * 递归解决
     * @param root
     * @return
     */
    private static int sum = 0;
    public static TreeNode convertBST_recursion(TreeNode root) {
        traver(root);
        return root;
    }
    private static void traver(TreeNode root) {
        if(root==null){
            return;
        }
        traver(root.right);
        sum += root.val;
        root.val = sum;
        traver(root.left);
    }

    /**
     * 二叉搜索树寻找最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }

    /**
     * 二叉树寻找最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_commonly(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor_commonly(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor_commonly(root.right,p,q);
        return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
    }

    /**
     * 有序数组转成二叉搜索树
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return sortedArrayToBST(nums,low,high);
    }
    private static TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if(low>high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,low,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,high);
        return root;
    }

    /**
     * 在二叉查找树中找两个节点，相加为target
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        int l = 0;
        int r = list.size()-1;
        while (l<r){
            int sum = list.get(l) + list.get(r);
            if(sum < k){
                l++;
            }else if(sum==k){
                return true;
            }else {
                r--;
            }
        }
        return false;
    }

    /**
     * 二叉搜索树的任意两节点最小绝对差
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre!=null){
                min = Math.min(Math.abs(node.val-pre.val),min);
            }
            pre = node;
            cur = node.right;
        }
        return min;
    }

    /**
     * 寻找二叉树中出现次数最多的值
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        inorder(root,map);
        int maxCount = 1;
        List<Integer> nums = new ArrayList<>();
        for (Integer value : map.values()) {
            maxCount = Math.max(value,maxCount);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)==maxCount){
                nums.add(key);
            }
        }
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        return res;
    }

    private static void inorder(TreeNode root,Map<Integer,Integer> map) {
        if(root==null){
            return;
        }
        inorder(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inorder(root.right,map);
    }


    public static void frontShow(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        frontShow(root.left);
        frontShow(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        // node2.left = node4;
        // node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        // node4.left = node8;
        // node4.right = node9;
        // node5.left = node10;

        // System.out.println(isBalanced(node1));
        // System.out.println(diameterOfBinaryTree(node1));
        frontShow(node1);
        // invertTree(node1);
        System.out.println("=====");
        // frontShow(node3);
        System.out.println("=====");
        // TreeNode node = mergeTrees(node1, node3);
        // frontShow(node);
        // System.out.println(hasPathSum(node1,18));
        // System.out.println(hasPathSum(node1,15));
        // System.out.println(hasPathSum(node1,16));
        // System.out.println(hasPathSum(node1,17));
        // System.out.println(pathSum(node1,10));
        // System.out.println(minDepth(node1));
        // System.out.println(sumOfLeftLeaves(node1));
        // System.out.println(longestUnivaluePath(node1));
        /*List<Double> res = averageOfLevels(node1);
        for (Double re : res) {
            System.out.println(re);
        }*/
        // System.out.println(findBottomLeftValue(node1));
        // List<Integer> res = postorderTraversal_collections(node1);
        // for (Integer re : res) {
        //     System.out.println(re);
        // }
        // System.out.println(kthSmallest_recursion(node1,3));
        // TreeNode node = convertBST(node1);
        // frontShow(node);
        // TreeNode node = lowestCommonAncestor(node1, node3, node7);
        // System.out.println(node.val);
        // int[] nums = {-10,-3,0,5,9};
        // TreeNode node = sortedArrayToBST(nums);
        // frontShow(node);
        // System.out.println(findTarget(node1,19));
        // System.out.println(getMinimumDifference(node1));
        int[] mode = findMode(node1);
        System.out.println(Arrays.toString(mode));
    }
}