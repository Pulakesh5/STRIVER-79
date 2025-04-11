class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        // ExpectedSum = n*(n+1)/2
        // actualSum = X 
        // X-a+b = ExpectedSum
        // => a-b = X-ExpectedSum

        // To find out exact value of a and b, we need one more equation preferably a+b

        // We can use a^2-b^2 = (a-b)(a+b)

        long originalSum = 0, originalSquareSum = 0;
        long expectedSum = 0, expectedSquareSum = 0;
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            originalSum += nums[i - 1];
            originalSquareSum += 1L * nums[i - 1] * nums[i - 1];

            expectedSum += i;
            expectedSquareSum += 1L * i * i;
        }

        long a_minus_b = originalSum - expectedSum;
        long a_plus_b = (originalSquareSum - expectedSquareSum) / a_minus_b;

        int repeating = (int) ((a_minus_b + a_plus_b) / 2);
        int missing = (int) ((a_plus_b - a_minus_b) / 2);

        return new int[] {repeating, missing};
    }
}
