package map;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class RandomizedSet {
	
	HashMap<Integer, Integer> map;
	List<Integer> list;
	
	public RandomizedSet() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();		
	}
	
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
				
		list.add(val);
		map.put(val, list.size());
		return true;		
	}
	
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		
		int i1 = map.get(val);
		int val2 = list.get(list.size()-1);
		list.set(i1, val2);
		map.put(val2, i1);
		list.remove(list.size()-1);
		map.remove(val);
		return true;
	}
	
	public int getRandom() {
		if (list.size() == 0)
			return -1;
		
		Random random  = new Random();
		
		int index = random.nextInt(list.size());
		return list.get(index);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet test = new RandomizedSet();
		test.insert(1);
		test.insert(2);
		test.insert(3);
		test.insert(4);
		System.out.println("Random 1: " + test.getRandom());
		test.remove(2);
		test.insert(2);
		System.out.println("Random 2: " + test.getRandom());
		test.remove(1);
		test.insert(2);
		System.out.println("Random 3: " + test.getRandom());

	}

}
