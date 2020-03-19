import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 13:24 2020/2/26
 * @Modified By:
 */
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// Related Topics 链表 数学
public class AddTwoNumers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode newHead=head;
        int carry=0;
        while (l1 != null && l2 != null) {
            int tmp=l1.val+l2.val+carry;
            carry=tmp/10;
            head.next =new ListNode(tmp%10);
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int tmp=l1.val+carry;
            carry=tmp/10;
            head.next =new ListNode(tmp%10);
            head=head.next;
            l1=l1.next;
        }
        while (l2!=null){
            int tmp=l2.val+carry;
            carry=tmp/10;
            head.next =new ListNode(tmp%10);
            head=head.next;
            l2=l2.next;
        }
        if(carry==1) {
            head.next = new ListNode(1);
            head.next.next=null;
        }else {
            head.next=null;
        }
        return newHead.next;
    }

    @Test
    public void testAddTwoNumbers(){
        List<Integer> list1 = new ArrayList<Integer>();
        Collections.addAll(list1, 4, 9, 1, 3);
        ListNode l1=Utils.listToListNode(list1);
        List<Integer> list2=new ArrayList<Integer>();
        Collections.addAll(list2,1,3);
        ListNode l2 =Utils.listToListNode(list2);
        ListNode header=addTwoNumbers(l1,l2);
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }
}
