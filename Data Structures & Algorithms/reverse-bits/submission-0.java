class Solution {

    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // get last bit
            int bit = n & 1;

            // shift result left and add bit
            result = (result << 1) | bit;

            // shift n right
            n >>>= 1;
        }

        return result;
    }
}