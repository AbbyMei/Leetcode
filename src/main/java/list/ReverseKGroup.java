package list;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
// 示例：
//
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
// 说明：
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
// Related Topics 链表
public class ReverseKGroup {
    private ListNode reverseKGroup(ListNode head,int k){
        int step=1;
        ListNode kStart=null;
        ListNode kPreStart=null;
        ListNode kEnd;
        ListNode kAfterEnd;
        ListNode tmp=head;
        while (tmp!=null){
            if(step==1){
                kStart=tmp;
                step++;
            }else if(step==k){
                kEnd=tmp;
                kAfterEnd=kEnd.next;
                ListNode pre=kPreStart;
                ListNode cur=kStart;
                while (cur!=kEnd){
                    ListNode ttmp=cur.next;
                    cur.next=pre;
                    pre=cur;
                    cur=ttmp;
                }
                kPreStart.next=kEnd;
                kStart.next=kAfterEnd;
                kPreStart=kStart;
                step=1;
            }else {
                step++;
            }
            tmp=tmp.next;
        }
    }
}
