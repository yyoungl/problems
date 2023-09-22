import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<Integer>[] graph = new ArrayList[V+1];
			
			for (int i=0; i<=V; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			int[] degree = new int[V+1];
			
			for (int i=0; i<E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[x].add(y);
				degree[y]++;
			}
			Queue<Integer> q = new LinkedList<>();
			
			for (int i=1; i<=V; i++) {
				if (degree[i] == 0) q.add(i);
			}
			
			String answer = "";
			
			while(!q.isEmpty()) {
				int node = q.poll();
				answer += node +" ";
				for (int k: graph[node]) {
					degree[k] --;
					if (degree[k] == 0) q.add(k);
				}
				
				
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}

}
