import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			Queue<String> inputCard = new LinkedList<>();
			for (int i=0; i<N; i++)
				inputCard.add(sc.next());
			
			Queue<String> odd = new LinkedList<>();
			Queue<String> even = new LinkedList<>();
			
			
			for (int i=0; i<N/2; i++) 
				odd.add(inputCard.poll());
			
			
			if (N%2 == 1) odd.add(inputCard.poll());
			
			for (int i=N/2; i<N; i++)
				even.add(inputCard.poll());
			
			
			
			System.out.print("#"+test_case+" ");
			for (int i=0; i<N; i++) {
				if (i%2 == 0) {
					System.out.print(odd.poll() + " ");
				} else {
					System.out.print(even.poll() + " ");
				}
			}
			System.out.println();
			
		}
	}

}
