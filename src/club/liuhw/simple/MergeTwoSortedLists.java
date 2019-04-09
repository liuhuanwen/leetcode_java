package club.liuhw.simple;

import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.nextNode = l2;
        l2.nextNode = new ListNode(4);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l3.nextNode = l4;
        l4.nextNode = new ListNode(4);
        ListNode temp = mergeTwoLists(l1, l3);
        System.out.println(temp);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode temp;
        if (l1.value >= l2.value) {
            temp = new ListNode(l2.value);
            temp.nextNode = mergeTwoLists(l1, l2.nextNode);
        } else {
            temp = new ListNode(l1.value);
            temp.nextNode = mergeTwoLists(l1.nextNode, l2);
        }
        return temp;
    }

}

class ListNode {

    int value;
    ListNode nextNode;

    ListNode(int value) {
        this.value = value;
    }
}
