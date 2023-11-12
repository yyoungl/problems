
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[8];
		PriorityQueue<Integer> proNums = new PriorityQueue<>();
		int[] chk = new int[151];
		
		for (int i=0; i<8; i++) {
			int input = sc.nextInt();
			chk[input] = i+1;
		}
		
		int cnt = 0;
		int sum = 0;
		int last = 151;
		while(true) {
			if (cnt == 5) break;
			
			
			for (int i=last-1; i>=0; i--) {
				if (chk[i] > 0) {
					last = i;
					sum += i;
					proNums.add(chk[i]);
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(sum);
		for (int i=0; i<5; i++)
			System.out.print(proNums.poll()+" ");
	}

}
