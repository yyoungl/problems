
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[] seq = new int[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		for (int i=0; i<=N; i++) {
			if (graph[i].size() > 1) Collections.sort(graph[i], Collections.reverseOrder());
		}
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		visited[R] = true;
		int cnt = 1;
		seq[R] = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next: graph[curr]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
					cnt++;
					seq[next] = cnt;
				}
			}
		}
		
		for (int i=1; i<=N; i++) System.out.println(seq[i]);

	}
}
