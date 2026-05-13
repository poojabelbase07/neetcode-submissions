class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // min heap - keeps k most frequent elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int num : freq.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}