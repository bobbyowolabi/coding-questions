package com.owodigi.linked.list.recursion;

import java.util.*;

import com.owodigi.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class MergeTwoSortedLists {

    private void merge(final ListNode list1, final ListNode list2, final ListNode merged) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = new ListNode(list1.val);
                merge(list1.next, list2, merged.next);
            } else {
                merged.next = new ListNode(list2.val);
                merge(list1, list2.next, merged.next);
            }
        } else if (list1 != null) {
            merged.next = new ListNode(list1.val);
            merge(list1.next, list2, merged.next);
        } else if (list2 != null) {
            merged.next = new ListNode(list2.val);
            merge(list1, list2.next, merged.next);
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode merged = new ListNode(-1);
        merge(list1, list2, merged);
        return merged.next;
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
