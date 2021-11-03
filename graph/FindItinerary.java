package graph;

import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;

/*

https://leetcode.com/problems/reconstruct-itinerary/

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/
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
