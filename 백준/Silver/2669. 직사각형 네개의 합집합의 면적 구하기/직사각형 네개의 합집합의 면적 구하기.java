import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[101][101];
		for (int i=1; i<=4; i++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();
			
			for (int y=y1; y<y2; y++) {
				for (int x=x1; x<x2; x++) {
					board[y][x] = 1;
				}
			}
		}
			int cnt = 0;
			for (int r=0; r<101; r++) {
				for (int c=0; c<101; c++) {					
					if (board[r][c] == 1) {
						cnt ++;
					}
				}
			}
			System.out.println(cnt);
		
	}

}
