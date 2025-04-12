class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MAX_VALUE;
        int speed, hour;
        while(low<high)
        {
            speed = low+(high-low)/2;
            hour = 0;
            for(int pile:piles)
                hour += (pile+speed-1)/speed;
            if(hour>h)
                low = speed+1;
            else
                high = speed;
        }
        return high;
    }
}
