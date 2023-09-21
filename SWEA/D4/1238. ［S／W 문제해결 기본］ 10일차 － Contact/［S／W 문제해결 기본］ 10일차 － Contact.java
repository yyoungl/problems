import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			int answer = 0;
			int[] visited = new int[101];
			ArrayList<Integer>[] wires = new ArrayList[101];
			for (int i=0; i<N/2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if (wires[x] == null) wires[x] = new ArrayList<Integer>();
				if (wires[y] == null) wires[y] = new ArrayList<Integer>();
				if (!wires[x].contains(y)) wires[x].add(y);
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			q.add(start);
			int maxDepth = 1;
			visited[start] = 1;
			
			while (!q.isEmpty()) {
				int node = q.poll();
				if (wires[node].isEmpty()) continue;
				for (int link: wires[node]) {
					if (visited[link] > 0) continue;
					q.add(link);
					visited[link] = visited[node] + 1;
				}
			}
			
			for (int i=0; i<101; i++) {
				if (visited[i] == 0) continue;
				maxDepth = Math.max(visited[i], maxDepth);
			}
			
			for (int i=100; i>0; i-- ) {
				if (visited[i] >= maxDepth) {
					answer = i;
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}


	}

}
