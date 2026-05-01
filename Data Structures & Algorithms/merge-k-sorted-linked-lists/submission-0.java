class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // min heap — smallest node value comes out first
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // add head of each list to heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            // pick smallest node
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            // if this node has next, add to heap
            if (node.next != null) {
                heap.add(node.next);
            }
        }

        return dummy.next;
    }
}