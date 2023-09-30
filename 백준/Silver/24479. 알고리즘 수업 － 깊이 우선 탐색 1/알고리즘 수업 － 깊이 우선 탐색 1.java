
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int answer = 0;
	static int[] nodes;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// 정점의 수
		N = sc.nextInt();
		// 간선의 수
		int M = sc.nextInt();
		// 시작 정점
		int R = sc.nextInt();
		
		nodes = new int[N+1];
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for (int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		dfs(R);
		for (int i=1; i<=N; i++) {
			sb.append(nodes[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		nodes[start] = ++answer;
		if (visited[start] || graph[start].isEmpty()) return;
		visited[start] = true;
		for (int node: graph[start]) {
			if (!visited[node]) dfs(node);
		}
	}

}
