
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cnt = new int[N+1];
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
			cnt[i] = -1;
		}
		
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		cnt[a] = 0;
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next: graph[curr]) {
				if (!visited[next]) {
					q.add(next);
					cnt[next] = cnt[curr] + 1;
					visited[next] = true;
				}
			}
		}
		
		System.out.println(cnt[b]);
		
	}

}
