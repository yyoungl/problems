import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.valueOf(line.charAt(j)-'0');
				}
			}
			

			for (int r = 0; r < N/2+1; r++) {
				sum += farm[r][N / 2];
				for (int i=1; i<=r; i++) {
					sum+=farm[r][N/2+i] + farm[r][N/2-i]; 
				}
			}
			
			for (int r = N/2+1; r < N; r++) {
				sum += farm[r][N / 2];
				for (int i=1; i<N-r; i++) {
					sum+=farm[r][N/2+i] + farm[r][N/2-i]; 
				}
			}
			
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
