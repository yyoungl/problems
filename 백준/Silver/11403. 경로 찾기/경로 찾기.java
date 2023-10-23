import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[][] answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		graph = new ArrayList[N];
		answer = new boolean[N][N];
		for (int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int temp = sc.nextInt();
				if (temp == 1) {
					graph[i].add(j);
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			bfs(i);
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (answer[i][j]) sb.append(1+" ");
				else sb.append(0+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int start) { 
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for (int node: graph[curr]) {
				answer[start][node] = true;
				answer[curr][node] = true;
				if (!visited[node]) {
					visited[node] = true;
					q.add(node);
				}
			}
			
		}
		
	}

}
