
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder result;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 시작할 정점

		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		visited = new boolean[N+1];
		result = new StringBuilder();
		// DFS 수행
		dfs(V);
		// DFS 결과 출력 
		System.out.println(result);
		
		// 결과 String과 visited 배열 초기화
		result.setLength(0);
		visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visited[V] = true;
		result.append(V+" ");
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i=1; i<=N; i++) {
				if (graph[curr][i] == 1 && !visited[i]) {
					result.append(i+" ");
					visited[i] = true;
					q.add(i);
				}
			}
		}
		System.out.println(result.toString());
	}

	static void dfs(int start) {
		if (visited[start]) return;
		visited[start] = true;
		boolean check = false;
		result.append(start + " ");
		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1) {
				dfs(i);
			}
		}
	}

}
