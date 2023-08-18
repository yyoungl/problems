import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
				
	}
	
	static public long factorial (int N) {
		if (N<2) return 1;
		else {
			return N * factorial(N-1);
		}
	}

}
