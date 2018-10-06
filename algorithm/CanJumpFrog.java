
import java.util.HashMap;
import java.util.HashSet;


public class CanJumpFrog {
	boolean canJump(int[] stones)  {
		
		HashMap<Integer, HashSet<Integer>> dp = new HashMap<Integer, HashSet<Integer>>();
		dp.put(0, new HashSet<Integer>());
		dp.get(0).add(1);
		
		for (int i = 0; i < stones.length; i++) {
			int stone = stones[i];
			if (!dp.containsKey(stone)) {
				continue;
			}
			
			for (int jump : dp.get(stone)) {
				int next = stone + jump;
				if (next == stones[stones.length -1]) {
					return true;
				}
				if (next == stone)
					continue;
				
				HashSet<Integer> set = null;
				if (dp.containsKey(next)) {
					set = dp.get(next);
				} else {
					set = new HashSet<Integer>();
					dp.put(next, set);
					set.add(jump);
				}
				set.add(jump-1);
				set.add(jump+1);
			}
		}
		HashSet<Integer> ss = dp.get(stones[stones.length-1]);
		System.out.println("SS: " + ss);
		
		return  false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {0,1,3,5,6,8,12,17};
		CanJumpFrog test = new CanJumpFrog();
		System.out.println("Can Jump:" + test.canJump(stones));

	}

}
