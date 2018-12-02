package algorithm;


public class PartitionGroup {
    public int partitionDisjoint(int[] A) {
  
        int[] arr = new int[2];
        getMin(A, 0, A.length-1, arr);
        int lMin = arr[1];    	        
        int lmax = getMax(A, 0, lMin);
        System.out.println("min: " + lMin + ", lmax: " + lmax);
        
        if (lMin == lmax)
        	return 1;
        
        boolean c2 = true;        
        int rstart = lMin+1;
        int rend = A.length-1;
        
        while (c2  ) {
            getMin(A, rstart, rend, arr);
            int min2 = arr[0];
            int rMin = arr[1];
            System.out.println("min2: " + min2 + ", rMin: " + rMin + ", lmax: " + lmax);
            
            if (min2 >= lmax){
                c2 = false;
                break;
            } else {
            	lMin = arr[1];
                int mMax  = getMax(A, rstart, rMin);
                lmax = Math.max(lmax, mMax);
                
                rstart = rMin+1; 
            } 
            System.out.println("rstart: " + rstart + ", min2b: " + min2 + ", lmax: " + lmax);
            
        }
        
        return lMin +1;
        
    }
    
    void getMin(int[] A, int start, int end, int[] arr) {

    	
        arr[0] = A[start];
        arr[1] = start;
        if (start >= end)
        	return;
        
        for (int i = start+1; i <= end; i++) {
            if (A[i] <= arr[0]) {
                arr[0] = A[i];
                arr[1] = i;
            }       
        }

    }
    
    int getMax(int[] A, int start, int end) {
        int max = A[start];
        for (int i = start+1; i <= end; i++) {
            max = Math.max(max, A[i]);
        }   
        
        return max;
    }



	public static void main(String[] args) {
		
		PartitionGroup test = new PartitionGroup();
		//int[] A = {90,47,69,10,43,92,31,73,61,97}; //{1, 1}; //{5,0,3,8,6}; //{5, 0, 3, 7, 4, 8, 6, 9};
		int[] A = {1, 1}; //{5,0,3,8,6}; //{5, 0, 3, 7, 4, 8, 6, 9};
		//int[] A = {5,0,3,8,6}; //{5, 0, 3, 7, 4, 8, 6, 9};
		
		System.out.println("result: " + test.partitionDisjoint(A));
	}

}
