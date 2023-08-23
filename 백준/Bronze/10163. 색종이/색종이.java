import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] board = new int[1001][1001];
		for (int i=1; i<=N; i++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();
			
			for (int y=y1; y<y1+y2; y++) {
				for (int x=x1; x<x1+x2; x++) {
					board[y][x] = i;
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			int cnt = 0;
			for (int r=0; r<1001; r++) {
				for (int c=0; c<1001; c++) {					
					if (board[r][c] == i) {
						cnt ++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}
