import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class WordSpace {
	
	public static Map<Character, ArrayList<Integer>> dict = new HashMap<>();

	
	public static void main(String [] args) {
		String s = "ridikulus ridiculous";
		String [] w = {"kuri","ks","cs","z","i","rsl"};
		//Returns: { 0,  5,  -1,  3 }
		int [] res = find(s, w);
		System.out.println(Arrays.toString(res));
		
	}
	
	
	public static int[] find(String s, String [] w) {
		int [] res = new int[w.length];
		//init map
		for(int i = 0; i < s.length(); i++) {
			if(dict.get(s.charAt(i)) == null) {
				dict.put(s.charAt(i), new ArrayList<Integer>());
			}
				dict.get(s.charAt(i)).add(i);
		}
		
		for(int i = 0; i < w.length;i++) {
			res[i] = findIdx(w[i]);
		}
		return res;
	}

	
	public static int findIdx(String s) {
		int result = -1;
		ArrayList<Integer> init = dict.get(s.charAt(0));
		Stack<Node> Frontier = new Stack<Node>();
		//initialize stack
		if(init != null) {
		if (s.length() == 1) return init.get(0);
		for(int i = 0; i < init.size();i++) {
			Node temp = new Node(0,init.get(init.size()-1-i)); temp.start = temp;
			Frontier.push(temp);
		}
		
		//begin DFS
		while(!Frontier.isEmpty()) {
			Node cur = Frontier.pop();
			if( (cur.idx +1) < s.length()) {
				ArrayList<Integer> adj = dict.get(s.charAt(cur.idx+1));
				for(int i = 0; i < adj.size(); i++) {
					//if prev == null... no distance
					if(cur.prev == null) {
						if(adj.get(i) > cur.val) {
							Node child = new Node(cur.idx+1, adj.get(i)); child.prev = cur; child.start = cur.start;
							if(child.idx == s.length()-1) return child.start.val;
							Frontier.push(child);
						} 
					}//prev == null
					else {
						if( adj.get(i) - cur.val == cur.val - cur.prev.val) {
							Node child = new Node(cur.idx+1, adj.get(i)); child.prev = cur; child.start = cur.start;
							if(child.idx == s.length()-1) return child.start.val;
							Frontier.push(child);
						}
						
					}//prev != null
				}
			
			}//eoif
		}
		}
		
		return result;
	}
	
	
	
	
	
	
}


class Node{
	public Node prev;
	public Node start;
	public int val;
	public int idx;
	
	public Node(int id, int v) {
		idx = id; val = v;
	}
	
	
	
	
}
