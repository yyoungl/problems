
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] answer;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new ArrayList[N+1];
		answer = new int[N+1];
		for (int i=0; i<=N; i++) graph[i]= new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (!graph[x].contains(y))	graph[x].add(y);
			if (!graph[y].contains(x)) graph[y].add(x);
		}
		int min = 0;
		answer[0] = Integer.MAX_VALUE;
		for (int i=1; i<=N; i++) {
			int temp = bfs(i);
			if (answer[min] > temp) {
				min = i;
			}
			answer[i] = temp;
		}
		System.out.println(min);
		
	}
	
	
	static int bfs(int start) {
		int[] cnt = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int node: graph[curr]) {
				if (!visited[node]) {
					cnt[node] = cnt[curr]+1;
					visited[node] = true;
					q.add(node);
				}
			}
			
		}
		int answer = 0;
		for (int i=1; i<=N; i++) {
			answer += cnt[i];
		}
		return answer;
	}

}
