import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();

			boolean[][] ladderCheck = new boolean[102][102];
			int cnt = 0;
			int arrive = 0;

			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					int temp = sc.nextInt();
					if (temp == 1) ladderCheck[i][j] = true;
					else if (temp == 2) arrive = j;
				}
			}
			
			System.out.println("#"+test_case+" "+(dfs(ladderCheck, 100, arrive)-1));

		}

	}

	private static int dfs(boolean[][] ladderCheck, int r, int c) {
		if (r == 1) {
			return c;
		}
		int[] tempC = {1,-1,0};
		int[] tempR = {0,0,-1};
		for(int i = 0 ; i < 3 ; i++) {
			int nr = r + tempR[i];
			int nc = c + tempC[i];
			if(ladderCheck[nr][nc] == true) {
				ladderCheck[nr][nc] = false;
				return dfs(ladderCheck, nr, nc);
			}
		}
		return c;
		
	}
}