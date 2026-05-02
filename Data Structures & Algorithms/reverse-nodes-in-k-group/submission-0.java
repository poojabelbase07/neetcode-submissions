class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // step 1 - check if k nodes exist
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        // less than k nodes remaining → leave as is
        if (count < k) return head;

        // step 2 - reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3 - head is now tail of reversed group
        // connect it to result of next group
        head.next = reverseKGroup(curr, k);

        // prev is new head of this group
        return prev;
    }
}