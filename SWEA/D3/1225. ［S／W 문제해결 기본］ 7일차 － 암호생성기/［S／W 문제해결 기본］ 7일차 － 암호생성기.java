import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			int T = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}
			
			int sub = 1;
			while (true) {
				int num = q.poll();
				if (num - sub <= 0) {
					q.add(0);
					break;
				}
				q.add(num-sub);
				sub++;
				if (sub == 6) sub = 1;
			}
			
			System.out.print("#"+T+" ");
			for (int i: q)
				System.out.print(i+ " ");
			
		}
	}
}