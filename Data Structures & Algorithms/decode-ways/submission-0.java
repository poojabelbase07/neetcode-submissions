class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        if (s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]

        for (int i = 2; i <= n; i++) {

            int current = 0;

            // Single digit decode
            if (s.charAt(i - 1) != '0') {
                current += prev1;
            }

            // Two digit decode
            int twoDigit =
                    (s.charAt(i - 2) - '0') * 10
                    + (s.charAt(i - 1) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}