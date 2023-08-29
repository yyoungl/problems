import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int H = sc.nextInt();
		
		int[][] ladder = new int[H+2][N+1];
		for (int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ladder[a][b] = 1;
			ladder[a][b+1] = -1;
		}
		
		int answer = -1;
		
		
		for (int i=0; i<=3; i++) {
			if (dfs(i, 0, ladder, N, H)) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
	static boolean dfs(int depth, int cnt, int[][] ladder, int N, int H) {
		if (cnt == depth) {
			return ladderCheck(ladder, N, H);
		} else {
			for (int r=1; r<=H; r++) {
				for (int c=1; c<N; c++) {
					if (ladder[r][c] == 0 && ladder[r][c+1]==0) {
						ladder[r][c] = 1;
						ladder[r][c+1]=-1;
						boolean temp = dfs(depth, cnt+1, ladder, N, H);
						if (temp) return true;
						ladder[r][c]=0;
						ladder[r][c+1]=0;
					}
				}
			}
			
		}
		
		return false;
	}
	
	static boolean ladderCheck(int[][] ladder, int N, int H) {
		boolean result = true;
		for (int i=1; i<=N; i++) {
			int r=1;
			int c=i;
			while (r<H+1) {
				if (ladder[r][c] == 1) c++;
				else if (ladder[r][c] == -1) c--;
				r++;
			}
			if (c!=i) {
				result = false;
				break;
			}
		}
		return result;
	}

}
