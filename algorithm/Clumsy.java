package algorithm;

public class Clumsy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clumsy test = new Clumsy();
		int res = test.clumsy(6);//4, 10
		//6:8
		System.out.println("result: " + res);

	}
	
	public int clumsy(int N) {
		   if (N == 1)
			   return 1;
		   
	     int ret = 0;
	     
	     int j = N;

	     int prev = j;
	     j--;
	     while (j > 4 ) {
	    	 ret += prev * j/(j-1) + (j-2);
	    	 prev = (j-3)*(-1);
	    	 j = j-4;
	     }
	     
	     if (j == 4) {
	    	 ret += prev * 4/3 + 2-1;
	     }
	     else if (j == 3) {
	    	 ret += prev * 3/2+1;
	     }
	     else if (j == 2) {
	    	 ret += prev *2/1;
	     }
	     else if (j == 1) {
	    	 ret += prev;
	     }
        
        return ret;
    }
	
}
