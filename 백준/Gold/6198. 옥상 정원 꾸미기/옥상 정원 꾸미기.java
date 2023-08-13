import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long answer = 0;
		long[] buildings = new long[N];
		for (int i=0; i<N; i++) {
			buildings[i] = sc.nextInt();
		}
		for (int i=0; i<N; i++) {
            long current = buildings[i];
			for (int j=i+1; j<N; j++) {
                long next = buildings[j];
				if (current <= next) {
					break;
				} else answer++;
			}
		}
		System.out.println(answer);
	}

}
