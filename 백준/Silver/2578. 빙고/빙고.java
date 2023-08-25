import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] bingo = new int[5][5];
		int bCnt = 0;
		boolean isBingo = false;
		int N;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
	
		for (N=1; N<=25; N++) {
			int num =  sc.nextInt();
			for (int r=0; r<5; r++) {
				for (int c=0; c<5; c++) {
					if (bingo[r][c] == num) {
						bingo[r][c] = 0;
						
						bCnt = checkBingo(bingo);
						if (bCnt >= 3) {
							isBingo = true;
							break;
						}
					}
				}
				if (isBingo) break;
			}
			if (isBingo) break;
		}
		
		System.out.println(N);
	}
	
	static int checkBingo(int[][] bingo) {
		int bCnt = 0;
		for (int r=0; r<5; r++) {
			int rc = 0;
			int cc = 0;
			for (int c=0; c<5; c++) {
				if (bingo[r][c] == 0) rc++;
				if (bingo[c][r] == 0) cc++;
			}
			
			if (rc==5) bCnt++;
			if (cc==5) bCnt++;
		}
		int xc1 = 0;
		int xc2 = 0;
		for (int i=0;i <5; i++) {
			if (bingo[i][i] == 0) xc1++;
			if (bingo[i][4-i] == 0) xc2++;
		}
		
		if (xc1==5) bCnt++;
		if (xc2==5) bCnt++;
		return bCnt;
	}
	

}
