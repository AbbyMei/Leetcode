package list;
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head,int m,int n){
        if(head==null)
            return head;

        // 步骤 1：找到  from-1, from, to,  to+1 这四个结点
        ListNode tmp=head.next;
        ListNode preFrom=null;
        ListNode from=null;
        ListNode to=null;
        ListNode toNext=null;
        int curIndex=1;
        while (tmp!=null){
            if(curIndex==m-1){
                preFrom=tmp;
            }else if(curIndex==m){
                from=tmp;
            }else if(curIndex==n){
                to=tmp;
            }else if(curIndex==n+1){
                toNext=tmp;
            }
            curIndex++;
            tmp=tmp.next;
        }

        // 步骤2：以下使用循环迭代法翻转从 from 到 to 的结点
        ListNode pre = preFrom;
        ListNode cur=from;
        while (cur!=toNext){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        // 步骤3：将 from-1 节点指向 to 结点（如果从 head 的后继结点开始翻转，则需要重新设置 head 的后继结点），将 from 结点指向 to + 1 结点
        if(preFrom!=null){
            preFrom.next=to;
        }else{
            head.next=to;
        }
        from.next=toNext;

        return head;



    }
}
