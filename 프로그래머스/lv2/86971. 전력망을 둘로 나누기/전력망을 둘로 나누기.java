import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        		int answer = n-2;
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		for (int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<wires.length; i++) {
			graph[wires[i][0]].add(wires[i][1]);
			graph[wires[i][1]].add(wires[i][0]);
		}
		
//		for (int i=0; i<n+1; i++) {
//			System.out.print(i+": ");
//			for (int x: graph[i])
//				System.out.print(x+" ");
//			System.out.println();
//		}
		
		for (int i=0; i<wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			graph[a].remove(graph[a].indexOf(b));
			graph[b].remove(graph[b].indexOf(a));
			
			answer = Math.min(Math.abs(bfs(a, graph, n)-bfs(b, graph, n)), answer);
			
			graph[a].add(b);
			graph[b].add(a);
		}
        return answer;
    }
    static int bfs(int start, ArrayList<Integer>[] graph, int n) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		int cnt=1;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int point: graph[node]) {
				if (!visited[point]) {
					q.offer(point);
					visited[point] = true;
					cnt++;
				}
			}
		}
//		System.out.println("start: "+start+" cnt: "+cnt);
		return cnt;
		
	}
}