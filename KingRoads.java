import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class KingRoads {

	public static void main(String [] args) {
		int h = 3;

		int [] a ={7, 1, 1, 2, 2, 3, 1};

		int [] b = {7, 1, 7, 4, 5, 2, 6};

		System.out.println(solution(h, a, b));
		
	}
	
	public static boolean solution(int h, int[] a, int[] b) {
		//lets do some initialization to the nodes.
		Map<Integer, Node> dummy = new HashMap<Integer, Node>();
		//assuming the length of a and b are the same. 
		for(int i = 0; i < a.length; i++) {
			dummy.put(i+1, new Node(i));
			
		}
		
		for(int i = 0; i < a.length; i++) {
			dummy.get(a[i]).adjList.add(dummy.get(b[i]));
			dummy.get(b[i]).adjList.add(dummy.get(a[i]));
		}
		//now do the BFS.... ahh... I hope I still remember. 
		//I don't need a cloud here... for sure
		Queue<Node> Frontier = new LinkedList<Node>();
		Set<Node> explored = new HashSet<Node>();
		
		//just start with the first element. 
		Node start = dummy.get(1);
		Frontier.add(start);
		while(!Frontier.isEmpty()) {
			Node current = Frontier.poll();
			explored.add(current);
			for(Node adj: current.adjList) {
				if(explored.contains(adj)) continue;
				if(Frontier.contains(adj)) continue;
				Frontier.add(adj);
			}
		}
		
		
		return explored.size() == a.length;
	}
	
}


class Node {
	public ArrayList<Node> adjList;
	public int value;
	
	public Node(int s) {
		this.value =  s;
		adjList = new ArrayList<Node>();
	}
}

