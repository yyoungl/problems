import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int answer = R*C;
			
			char[][] flag = new char[R][C];
			
			for (int i=0; i<R; i++) {
				String str = sc.next();
				flag[i] = str.toCharArray();
			}
			
			for (int bCnt = 1; bCnt<= R-2; bCnt++ ) {
				for (int i=1; i<R-bCnt; i++) {
					int cnt = 0;
					for (int r=0; r<i; r++) {
						for (int c=0; c<C; c++) {
							if (flag[r][c]!='W') 
								cnt++;
							
						}
					}
					for (int r=i; r<i+bCnt; r++) {
						for (int c=0; c<C; c++) {
							if (flag[r][c]!='B') 
								cnt++;
						}
					}
					
					for (int r=i+bCnt; r<R; r++) {
						for (int c=0; c<C; c++) {
							if (flag[r][c] != 'R') cnt++;
						}
					}
					
					
					answer = Math.min(answer, cnt);
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}

	}

}
