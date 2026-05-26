class Solution {

    public int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // remove last bit + check last set bit
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}