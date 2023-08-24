import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int column = sc.nextInt();
		int row = sc.nextInt();
		int[][] seat = new int[row][column];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int num = sc.nextInt();
		int N = 1;
		int r = row-1;
		int c = 0;
		int d = 0;
		
		if (num>row*column) {
			System.out.println(0);
			return;
		}
		
		while (N<=num) {
			seat[r][c] = N;
			if (!(r+dr[d]>=0) || !(r+dr[d]<row) || !(c+dc[d]>=0) || !(c+dc[d]<column) || seat[r+dr[d]][c+dc[d]] > 0) {
				d++;
				
			}
			d = d%4;
			if (N==num) break;
			r = r + dr[d];
			c = c + dc[d];
			N++;
		}
		
		System.out.println((c+1)+ " "+(row-r));
		
	}

}
