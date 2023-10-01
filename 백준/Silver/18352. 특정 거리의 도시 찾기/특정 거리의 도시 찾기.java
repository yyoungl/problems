
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 도시 개수 
		int N = sc.nextInt();
		// 간선 개수 
		int M = sc.nextInt();
		// 거리 정보
		int K = sc.nextInt();
		// 출발지
		int X = sc.nextInt();
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		q.add(X);
		visited[X] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for (int next: graph[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					distance[next] = distance[curr]+1;
					if(distance[next] == K) answer.add(next);
				}
			}
		}
		if (answer.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(answer);
			for (int x: answer) System.out.println(x);
		}
		
	}
	

}
