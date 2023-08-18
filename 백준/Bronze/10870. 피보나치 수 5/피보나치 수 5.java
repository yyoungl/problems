import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fibo(N));
				
	}
	
	static public long fibo (int N) {
		if (N==1) return 1;
		else if (N==0) return 0;
		else {
			return fibo(N-1) + fibo(N-2);
		}
	}

}
