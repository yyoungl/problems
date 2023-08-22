import java.util.Scanner;
import java.util.LinkedList;
import java.io.FileInputStream;

class Solution
{
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			LinkedList<Integer> code = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				code.addLast(temp);
			}
			int cNum = sc.nextInt();
			for (int i=0; i<cNum; i++) {
				String com = sc.next();
				int position = sc.nextInt();
				int len = sc.nextInt();
				int[] nums = new int[len];
				for (int idx=0; idx<len; idx++) nums[idx] = sc.nextInt();
				
				for (int idx=0; idx<len; idx++) {
					code.add(idx+position, nums[idx]);
				}
				
			}
			System.out.print("#"+test_case+" ");
			for (int i=0; i<10; i++) {
				System.out.print(code.get(i)+ " ");
			}
			
			
		}
	}
}