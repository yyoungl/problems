import java.util.Scanner;

public class Solution {

	static boolean[] visited;
	static int[][] graph;
	static int N;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			answer = 0;
			N = sc.nextInt();
			int M = sc.nextInt();
			
			graph = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for (int i=0; i<M; i++ ) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				graph[x][y] = 1;
				graph[y][x] = 1;
				
			}
			
			for (int i=1; i<=N; i++) {
				visited[i] = true;
				chk(1, i, graph);
				visited[i] = false;
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}
	
	public static void chk(int cnt, int idx, int[][] graph) {
		answer = Math.max(cnt, answer);
		
		
		for (int i=1; i<=N; i++) {
			if (visited[i] || graph[idx][i] == 0) continue;
				visited[i] = true;
				chk(cnt+1, i, graph);
				visited[i] = false;
		}
		
	}

}
