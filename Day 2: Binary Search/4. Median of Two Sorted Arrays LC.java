class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // The task of finding median of two arrays can be considered as splitting the two arrays such that the left half of both the arrays combined forms the actual left half of the merged array. If we proceed this way, we are finding a splitting index X1, X2 for nums1, nums2 respectively. 

        // [ . | . |. | ...  X1 ... | . | . | . ]
        // [ . | . |. | .....   X2 ... | . | . | . ]

        // left segment of nums1 = [0,X1-1]
        // right segment of nums1 = [X1, N1-1]
        // left segment of nums1 = [0,X2-1]
        // right segment of nums1 = [X2, N2-1]

        // if we find such X1, X2 that nums1[X1-1]<=nums2[X2] && nums2[X2-1]<=nums1[X1]
        //     this split is our answer

        int len1 = nums1.length, len2 = nums2.length;
        
        if(len1<len2)
            return solve(nums1, nums2);
        
        return solve(nums2, nums1);
    }
  
    public double solve(int[] nums1, int[] nums2)
    {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1+len2;
        int medianLen = (totalLen+1)/2;
        
        int low1 = 0, high1 = len1;
        int X1, X2;
        
        while(low1<=high1)
        {
            X1 = (low1+high1)/2;
            X2 = medianLen - X1;
            

            int leftEnd1 = (X1>0)? nums1[X1-1] : Integer.MIN_VALUE;
            int leftEnd2 = (X2>0)? nums2[X2-1] : Integer.MIN_VALUE;

            int rightEnd1 = (X1<len1 ? nums1[X1] : Integer.MAX_VALUE);
            int rightEnd2 = (X2<len2 ? nums2[X2] : Integer.MAX_VALUE);

            if(leftEnd1<=rightEnd2 && leftEnd2<=rightEnd1)
            {
                if(totalLen%2 == 1) // median is only one element
                    return Math.max(leftEnd1, leftEnd2);
                else
                    return ((double)(Math.max(leftEnd1, leftEnd2) + Math.min(rightEnd1,rightEnd2)))/2.0;
            }
            else if(leftEnd1>rightEnd2)
                high1 = X1-1;
            else
                low1 = X1+1;
        }
        return -1.0;
    }
    
}
