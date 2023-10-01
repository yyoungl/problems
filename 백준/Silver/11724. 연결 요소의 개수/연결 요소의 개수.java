
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int N;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				bfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void bfs (int start) {
		int curr = start;
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int next = q.poll();
			if (graph[next].isEmpty()) continue;
			for (int x: graph[next]) {
				if (!visited[x]) {
					q.add(x);
					visited[x] = true;					
				}
			}
			
		}
	}

}
