class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] countT = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        int required = 0;

        for (int count : countT) {
            if (count > 0) {
                required++;
            }
        }

        int formed = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            if (countT[c] > 0 &&
                window[c] == countT[c]) {
                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window[leftChar]--;

                if (countT[leftChar] > 0 &&
                    window[leftChar] < countT[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}