import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			int[] A = new int[5];
			int[] B = new int[5];
			boolean isDraw = true;
			
			int cardA = sc.nextInt();
			for (int idx=0; idx<cardA; idx++) {
				A[sc.nextInt()]++;
			}
			
			int cardB = sc.nextInt();
			for (int idx=0; idx<cardB; idx++) {
				B[sc.nextInt()]++;
			}
			
			for (int idx=4; idx>0; idx--) {
				if (A[idx] > B[idx]) {
					System.out.println("A");
					isDraw = false;
					break;
				} else if (A[idx] < B[idx]) {
					System.out.println("B");
					isDraw = false;
					break;
				} else continue;
			}
			
			if (isDraw) System.out.println("D");
			
		}
	}

}
