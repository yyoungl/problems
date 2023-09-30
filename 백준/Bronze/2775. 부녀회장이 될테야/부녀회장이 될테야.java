
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] apt = new int[15][15];
		// 행: 층 수 0층 ~ N층
		// 열: 호 수 1호 ~ N호
		int[] zero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		apt[0] = zero;
		for (int tc=1; tc<=T; tc++) {
			// k층 n호
			int k = sc.nextInt();
			int n = sc.nextInt();
			for (int i=0; i<=k; i++) {
				for (int j=1; j<=n; j++) {
					if (apt[i][j] > 0) continue;
					apt[i][j] = apt[i-1][j] + apt[i][j-1];
				}
			}
			System.out.println(apt[k][n]);
		}
	}

}
