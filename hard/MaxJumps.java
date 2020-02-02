package hard;

public class MaxJumps {

	public static void main(String[] args) {
		MaxJumps test = new MaxJumps();
		int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
		int d = 2;
		
		System.out.println("result: " + test.maxJumps(arr, d));
	}
	
	   int[] jump; 
	    public int maxJumps(int[] arr, int d) {
	        jump = new int[arr.length];
	        
	        int max1 = 1;
	        for (int i = 0; i < arr.length; i++) {
	            max1 = Math.max(max1, jumpMax(arr, d, i));
	        }
	        
	        return max1;
	    }
	    
	    int jumpMax(int[] arr, int d, int start) {
	        if ( jump[start] > 0 )
	            return jump[start];
	        
	        int ret = 1;
	        int high = arr[start];
	        int s2 = Math.max(start - d, 0);
	        for (int i = start-1; i >= s2; i--) {
	            if (arr[i] < high) {
	                ret = Math.max(ret, 1 + jumpMax(arr, d, i));
	            } else {
	                break;
	            }
	        }
	                
	        high = arr[start];
	        int end = Math.min(start+d, arr.length-1);
	        for (int i = start+1; i <= end; i++) {
	            if (arr[i] < high) {
	                ret = Math.max(ret, 1 + jumpMax(arr, d, i));
	            } else {
	                break;
	            }
	        }
	        
	        jump[start] = ret;
	        return ret;
	    } 

}
