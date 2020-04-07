package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 15:11 2020/2/19
 * @Modified By:
 */

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1:
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2:
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// Related Topics 排序 链表
public class SortList {
    public ListNode sortList(ListNode head) {
        return solution2(head);

    }

    //将链表中的的结点取出存在一个List中，排序后，将List中的元素再放入链表中，时间复杂度为O(n),空间复杂度为O(n),不符合题意
    public ListNode solution1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        return Utils.listToListNode(list);
    }

    //链表的归并排序
    private ListNode solution2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l = slow.next;
        slow.next = null;
        ListNode left = solution2(head);
        ListNode right = solution2(l);
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        while (left != null && right != null) {
            if (head.val < right.val) {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                head = head.next;
            } else {
                tmp.next = new ListNode(right.val);
                tmp = tmp.next;
                right = right.next;
            }
        }
        if (left != null)
            tmp.next = head;
        if (right != null)
            tmp.next = right;
        return newHead.next;
    }

    @Test
    public void testSortList() {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 4, 2, 1, 3);
        ListNode header = solution1(Utils.listToListNode(list));
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }
}
