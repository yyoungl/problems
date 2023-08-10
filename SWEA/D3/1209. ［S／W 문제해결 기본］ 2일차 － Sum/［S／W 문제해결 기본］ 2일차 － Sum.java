import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int T=1; T<=10; T++) {
			int test_case = sc.nextInt();
			int[][] matrix = new int[100][100];
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++)
					matrix[i][j] = sc.nextInt();
			} 
			int sum1 = 0;
			int sum2 = 0;
			int sum3 = 0;
			int sum4 = 0;
			int tempMax=0;
			for (int i=0; i<100; i++) {
				sum1+= matrix[i][i];
				sum2+= matrix[99-i][99-i];
			}
			
			
			
			for (int i=0; i<100; i++) {
				sum3=0;
				sum4=0;
				for (int j=0; j<100; j++) {
					sum3+= matrix[i][j];
					sum4+= matrix[j][i];
				}
				tempMax = Math.max(tempMax, Math.max(sum3, sum4));
			}
			
			System.out.println("#"+test_case+" "+Math.max(Math.max(sum1, sum2), tempMax));
			
		}
	}
}