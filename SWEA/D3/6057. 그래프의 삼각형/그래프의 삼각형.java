
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case=1; test_case<=t; test_case++) {
			// 정점 개수
			int N = sc.nextInt();
			// 간선 개수
			int M = sc.nextInt();
			int answer = 0;
			int[][] graph = new int[N+1][N+1];
			
			for (int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (graph[i][j] == 0) continue;
					for (int k=1; k<=N; k++) {
						if (graph[k][i] == 1 && (graph[k][j] == 1)) {
							answer++;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+(answer/6));
		} 
	}

}
