public class Solution {
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        double low = 0.0, high = Double.MIN_VALUE;
        
        double dist, diff = 1e-6;
        int station, gap, N = arr.length;
        for(int i=1; i<N; i++) high = Math.max(high, arr[i]-arr[i-1]);
        while(high-low > diff)
        {
            dist = (low+high)/2.0;
            station = 0;
            for(int i=1; i<N; i++)
            {
                gap = (int)((arr[i]-arr[i-1])/dist);
                if((arr[i]-arr[i-1])==(dist*gap))
                    gap--;
                station += gap;
            }

            if(station>K)
                low = dist;
            else
                high = dist;
        }
        return high;
    }
}
