import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N+1][N+1];
			int cnt = 0;
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int r=0; r<N+1; r++) {
				int check = 0;
				for (int c=0; c<N+1; c++) {
					if (map[r][c] == 0) {
						if (check==K) 
							cnt++;
						check =0;
					}
					else{
						check ++;
					}
				}
				
			}
			
			for (int r=0; r<N+1; r++) {
				int check = 0;
				for (int c=0; c<N+1; c++) {
					if (map[c][r] == 0) {
						if (check==K) cnt++;
							check =0;
					} 
					else{
						check ++;
					}
				}
			}
			System.out.println("#" +test_case+" "+cnt);
		}
	}

}