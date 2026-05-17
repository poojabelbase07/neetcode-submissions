class Solution {
    public double myPow(double x, int n) {
        long power = n; // use long to handle Integer.MIN_VALUE

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return fastPow(x, power);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        if (n % 2 == 0) {
            // even power - square the result of half power
            double half = fastPow(x, n / 2);
            return half * half;
        } else {
            // odd power - multiply x once extra
            return x * fastPow(x, n - 1);
        }
    }
}