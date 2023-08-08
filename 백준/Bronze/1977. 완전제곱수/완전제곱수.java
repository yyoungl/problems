import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 0;
		int cnt = 0;
		int sum = 0;
		for (int i = N; i <= M; i++) {
			if (isSquare(i)) {
				sum+=i;
				cnt++;
				if (cnt==1) min = i;
			}
		}
		if (cnt == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	static boolean isSquare(int n) {
		int odd = 1;
		while (n > 0) {
			n -= odd;
			odd += 2;
			if (n==0) return true;
		}
		return false;
	}
}
