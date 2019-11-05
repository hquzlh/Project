package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: niukewang
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-14 14:51
 **/

public class Test5 {
    public ListNode ReverseList(ListNode head) {
        ListNode next=null,pre=null;
        if(head==null){
            return null;
        }
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
