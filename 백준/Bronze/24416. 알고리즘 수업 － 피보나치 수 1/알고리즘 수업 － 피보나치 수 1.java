
import java.util.Scanner;

public class Main {
	static int answer1 = 0;
	static int answer2 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		fibo1(N);
		fibo2(N);
		
		System.out.println(answer1+ " "+answer2);
	}
	
	static int fibo1(int N)
	{
		if (N==1 || N==2) {
			answer1++;
			return 1;
		} else return fibo1(N-1) + fibo1(N-2);
	}
	
	static void fibo2(int N) {
		int[] fibo = new int[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 1;
		for (int i=3; i<=N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
			answer2++;
		}
	}

}
