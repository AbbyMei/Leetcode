package list;

import java.util.Stack;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 22:14 2020/7/12
 * @Modified By:
 */
public class LC234_isPalindrome {
    public boolean isPalindrome1(ListNode head){
        //取出链表中的值存入栈中
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        while (!stack.isEmpty()){
            if(tmp.val != stack.pop()){
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

}
