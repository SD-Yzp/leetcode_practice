package com.study.structure.linkedlist;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int count = 0;
        while(count<2){
            node1 = node1.next;
            if(node1==null){
                node1 = headB;
                count++;
            }
            node2 = node2.next;
            if(node2==null){
                node2 = headA;
            }
            if(count==1){
                if(node1==node2){
                    return node1;
                }
            }
        }
        return null;
    }
    public static ListNode getIntersectionNode_better(ListNode headA, ListNode headB){
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1!=node2){  // 两个链表都走一遍后如果没有交点，会在null处相交
            node1 = (node1==null) ? headB : node1.next;
            node2 = (node2==null) ? headA : node2.next;
        }
        return node1;
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        ListNode nextNode;
        while(node!=null) {
            nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
        return pre;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 头结点
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1!=null){
            node.next = l1;
        }
        if(l2!=null){
            node.next = l2;
        }
        return head.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node!=null){
            int temp = node.val;
            while(node.next!=null && node.next.val == temp){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 到了末尾，说明删除第一个
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode head_node = new ListNode(0);
        ListNode node1 = head;
        ListNode node2 = null;
        ListNode temp = null;
        if(head.next!=null){
            node2 = head.next;
            temp = node2.next;
            head_node.next = node2;
        }else{
            head_node.next = node1;
        }
        while(node2!=null){
            node1.next = temp;
            node2.next = node1;
            if(temp!=null && temp.next!=null){
                node1.next = temp.next; // 反转后指向的不是下一个节点，而是下下个节点
                node1 = temp;
                node2 = temp.next;
                temp = node2.next;
            }else {
                break;
            }
        }
        return head_node.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode temp = l1;
        while (temp!=null){
            stack1.push(temp);
            temp = temp.next;
        }
        temp = l2;
        while (temp!=null){
            stack2.push(temp);
            temp = temp.next;
        }
        ListNode head = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int x = stack1.isEmpty() ? 0 : stack1.pop().val;
            int y = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = x + y + carry;
            ListNode node = new ListNode(sum%10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next==null){
                break;
            }
            fast = fast.next.next;
        }
        // 反转
        ListNode pre = null;
        ListNode node = slow;
        ListNode next_node;
        while(node!=null){
            next_node = node.next;
            node.next = pre;
            pre = node;
            node = next_node;
        }
        // 比较
        ListNode node2 = head;
        node = pre;
        while(node2!=null && node!=null){
            if(node2.val != node.val){
                return false;
            }
            node2 = node2.next;
            node = node.next;
        }
        return true;
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode node = root;
        while(node!=null){
            node = node.next;
            count++;
        }
        int n =  count / k;
        int rem = count % k;
        ListNode[] nodes = new ListNode[k];
        ListNode temp = root;
        for (int i = 0; i < k; i++) {
            node = temp;
            nodes[i] = node;
            if(rem > 0){
                for (int j = 1; j < n+1; j++) {
                    node  = node.next;
                }
                rem--;
            }else{
                for (int j = 1; j < n; j++) {
                    node  = node.next;
                }
            }
            if(node==null){
                temp = null;
            }else {
                temp = node.next;
                node.next = null;
            }
        }
        return nodes;
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node1 = head;
        ListNode temp = head.next;
        ListNode pre = node1;
        ListNode node2;
        int count = 0;
        while(node1.next!=null){
            node2 = node1.next;
            pre = node1;
            node1.next = node2.next;
            node1 = node2;
            count++;
        }
        if(count%2!=0){
            pre.next = temp;
        }else{
            node1.next = temp;
        }
        return head;
    }
    public static ListNode oddEvenList_better(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (odd.next!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void showList(ListNode head){
        if(head!=null){
            System.out.print(head.val+" ");
            showList(head.next);
        }else{
            System.out.print("null");
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node22 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node22;
        node22.next = node11;
        node11.next = node9;
        // node3.next = node8;


        // node4.next = node5;
        // node5.next = node6;
        // node6.next = node7;
        // node7.next = node8;
        // node8.next = node9;
        // ListNode node = getIntersectionNode_better(node1, node4);
        // System.out.println(node.val);
        // node1.next = node11;
        // node11.next = node2;
        // node2.next = node22;
        // node22.next = node3;


        showList(node1);
        System.out.println();
        ListNode node = oddEvenList(node1);
        showList(node);
        // ListNode[] nodes = splitListToParts(node1, 3);
        // for (ListNode node : nodes) {
        //     showList(node);
        //     System.out.println();
        // }
        // System.out.println(isPalindrome(node1));
        // ListNode node = swapPairs(node1);
        // showList(node);
        // ListNode node = removeNthFromEnd(node1, 4);
        // showList(node);
        // showList(node4);
        // System.out.println();
        // ListNode node = deleteDuplicates(node1);
        // showList(node);
        // ListNode node = reverseList(node4);
        // showList(node);
        // ListNode node = mergeTwoLists(node1, node2);
        // showList(node);
    }
}