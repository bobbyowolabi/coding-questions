package com.owodigi.linked.list.recursion;

import com.owodigi.util.ListNode;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class MergeTwoSortedLists {

    private ListNode min(final ListNode list1, final ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                return list1;
            } else {
                return list2;
            }
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else {
            return null;
        }
    }

    private void merge(final ListNode tail, final ListNode list1, ListNode list2) {
        final ListNode next = min(list1, list2);
        if (next == null) {
            return;
        } else {
            if (next == list1) {
                tail.next = list1;
                merge(tail.next, list1.next, list2);
            } else {
                tail.next = list2;
                merge(tail.next, list1, list2.next);
            }
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode head = new ListNode(-1);
        merge(head, list1, list2);
        return head.next;
    }

    @Test
    public void testCase1() {
        //[1,2,4]
        //[1,3,4]
    }

    @Test
    public void testCase2() {
        //[]
        //[0]
    }

    @Test
    public void testCase3() {
        //[]
        //[]
    }
}
