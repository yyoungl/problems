import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		
		boolean[] visited = new boolean[N+1];
		int[] answer = new int[N+1];
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for (int i=1; i<=N; i++) {
			if(graph[i].size() > 1) graph[i].sort(Comparator.naturalOrder());
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		answer[start] = cnt;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			cnt++;
			answer[curr] = cnt;
			
			for(int node: graph[curr]) {
				if (!visited[node]) {
					q.add(node);
					visited[node] = true;
				}
			}
			
		}
		
		for (int i=1; i<=N; i++) sb.append(answer[i]+"\n");
		System.out.println(sb.toString());
		
	}

}
