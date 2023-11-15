
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		long answer = pow(A, B, C);
		
		System.out.println(answer);
	}
	
	static long pow(long A, long B, long C) {
		if (B==0) return 1;
		long N = pow(A, B/2, C);
		if (B%2==0) return N * N % C;
		else return (N*N%C)*A%C;
	}

}
