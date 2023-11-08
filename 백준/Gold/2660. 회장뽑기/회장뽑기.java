
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new ArrayList[N+1];
		
		for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if ( x== -1 || y == -1) break;
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int[] score = new int[N+1];
		int min = N+1;
		
		for (int i=1; i<=N; i++) {
			score[i] = bfs(i);
			min = Math.min(min, score[i]);
		}
		
		ArrayList<Integer> candidate = new ArrayList<>();
		
		for (int i=1; i<=N; i++) if (score[i] == min) candidate.add(i);
		System.out.println(min + " "+ candidate.size());
		for (int can: candidate) System.out.print(can+" ");
			
		
		
	}
	
	static int bfs(int start) {
		boolean[] chk = new boolean[N+1];
		int[] cnt = new int[N+1];
		int max = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		chk[start] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next: graph[curr]) {
				if (!chk[next]) {
					chk[next] = true;
					cnt[next] = cnt[curr] + 1;
					q.add(next);
				}
			}
			
		}
		
		for (int i=1; i<=N; i++) {
			if (i != start && cnt[i] == 0) return N+1;
			max = Math.max(max, cnt[i]);
		}
		return max;
		
	}

}
