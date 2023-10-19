
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int depth = 0;
	static int[] answer;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
        StringBuilder sb = new StringBuilder();
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 0; i <= N; i++) {
			if (graph[i].size() > 1)
				Collections.sort(graph[i], Collections.reverseOrder());
			else
				continue;
		}

		dfs(R);
		for (int i = 1; i <= N; i++)
			sb.append(answer[i]+"\n");
        System.out.println(sb.toString());
	}

	public static void dfs(int start) {
		answer[start] = ++depth;
		if (visited[start] || graph[start].isEmpty())
			return;
		visited[start] = true;
		for (int node : graph[start]) {
			if (!visited[node]) {
				dfs(node);
			}
		}

	}

}
