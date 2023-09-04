import java.util.Arrays;
import java.util.Scanner;


public class Solution {
	static int N;
	static int[][] map;
	static int answer = -1;
	static int[][] result;
	static int[] dr = { 1, 1, -1, -1};
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			answer = -1;
			
			for (int r=0; r<N-2; r++) {
				for (int c=1; c<N-1; c++) {
					// 왼쪽 보기
					for (int dLeft = 1; c-dLeft>=0 && r+dLeft < N-1 ; dLeft++) {
						// 오른쪽 보기
						for (int dRight = 1; c+dRight < N && r+dRight < N-1; dRight++) {
							visited = new boolean[101];
							result = new int[4][2];
							result[0] = new int[] {r, c};
							result[3] = new int[] {r+dLeft, c-dLeft};
							result[1] = new int[] {r+dRight, c+dRight};
							if (result[1][0]+dLeft>=N) continue;
							result[2] = new int[] {result[1][0]+dLeft, result[1][1]-dLeft};
							int sum = 0;
							boolean isOkay = false;
							int idx = 0;
							int i = result[0][0];
							int j = result[0][1];
							while (idx<=4) {							
								if (i == result[(idx+1)%4][0] && j == result[(idx+1)%4][1]) idx++;	
								if (i == r && j ==c && idx == 4) {
									isOkay = true;
									break;
								} else if (visited[map[i][j]]) break;
								else {
									visited[map[i][j]] = true;
									sum++;
									i += dr[idx];
									j += dc[idx];
								}
							}
							
							if (isOkay) answer = Math.max(answer, sum);
							
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
			
			

		}
	}

}
