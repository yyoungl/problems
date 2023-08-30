import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			int idx = sc.nextInt();
			int con = sc.nextInt();
			graph[idx].add(con);
			graph[con].add(idx);
		}
		System.out.println(dfs(1, graph));
		
	}
	static int dfs(int start, ArrayList<Integer>[] graph) {
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int point: graph[node]) {
				if (!visited[point]) {
					q.offer(point);
					visited[point] =true;
					cnt++;
				}
			}
		}
		return cnt;
	}

}
