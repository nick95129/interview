public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        
        
        int n = nums.length;      
        if ( n == 1)
            return nums[0];

        int[] dpMax = new int[n+1];
        int[] dpMin = new int[n+1];
        
        dpMax[0] = 0;
        dpMin[0] = 0;
        int max = nums[0];

        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                dpMax[i+1] = Math.max(dpMax[i]*nums[i], nums[i]);
                dpMin[i+1] = Math.min(dpMin[i]*nums[i], nums[i]);                
            } else {
                dpMax[i+1] = Math.max(dpMin[i]*nums[i], nums[i]);
                dpMin[i+1] = Math.min(dpMax[i]*nums[i], nums[i]);                                
            }
            max = Math.max(max, dpMax[i+1]);

        }
        return max;
        
    }
}