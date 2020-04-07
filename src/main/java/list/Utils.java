package list;

import list.ListNode;

import java.util.List;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 20:35 2020/2/19
 * @Modified By:
 */
public class Utils {
    public Utils() {
    }


    public static ListNode listToListNode(List<Integer> list) {
        if (list.isEmpty())
            return null;
        ListNode newHeader = new ListNode(list.get(0));
        newHeader.next = listToListNode(list.subList(1, list.size()));
        return newHeader;
    }


}
