import java.util.Deque;
import java.util.LinkedList;

public class SlideWindow {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		
		int[] res = new int[nums.length-k+1];
		
		int big = nums[0];
		int index = 0;
		Deque<Integer> queue = new LinkedList<Integer>();
	
		for (int i = 0; i < nums.length; i++) {
			
			if (queue.size() == k)
				queue.removeFirst();
			
			while (!queue.isEmpty() && queue.getLast() < nums[i]) {				
					queue.removeLast();
			}
			
			queue.addLast(nums[i]);
			res[index] = queue.getFirst();	
			if (i+1 -k >= 0)
				index++;
		}
		
		return res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 3, -1, -3, 5, 6, 7};
		SlideWindow test = new SlideWindow();
		
		int k = 3;
		int[] res = test.maxSlidingWindow(nums, k);
		for (int i = 0; i < res.length; i++) {
			System.out.print(" " + res[i]);
		}
	}

}
