public class Solution {
    public int solve(int[] A, int B) {
        int xorValue = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);
        int subarrayCount = 0;
        for(int num:A)
        {
            xorValue ^= num;
            subarrayCount += freq.getOrDefault(xorValue^B, 0);
            freq.put(xorValue, freq.getOrDefault(xorValue,0)+1);
        }
        return subarrayCount;
    }
}
