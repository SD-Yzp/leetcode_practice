package com.study.thought.double_pointer;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }


    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        do{
            node1 = node1.next;
            if(node2.next==null){
                return false;
            }
            node2 = node2.next.next;
        }while(node1!=null&&node2!=null&&node1!=node2);

        return node1 == node2;
    }
}