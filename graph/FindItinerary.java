package graph;

import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;

public class FindItinerary {

	public List<String> findItinerary(String[][] tickets) {
		
		List<String> res = new LinkedList<String>();
		HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		
		for (String[] ticket : tickets) {
			map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		}
		
		
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		
		while (!stack.isEmpty()) {
			while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
				stack.push(map.get(stack.peek()).poll());
			}
			res.add(0, stack.pop());
		}
				
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] tickets = {
				{"JFK","SFO"}, {"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
		};
		
		FindItinerary test = new FindItinerary();
		List<String> res = test.findItinerary(tickets);
		
		for (String str : res) {
			System.out.println(str);
		}

	}

}
