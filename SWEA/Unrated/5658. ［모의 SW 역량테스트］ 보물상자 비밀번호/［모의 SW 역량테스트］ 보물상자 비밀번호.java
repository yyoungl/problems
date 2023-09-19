import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int len = N/4;
			String in = sc.next();
			HashSet<String> check = new HashSet<>();
			
			for (int i=0; i<len; i++) {
				for (int j=0; j<N; j+=len) {
					check.add(in.substring(j, j+len));
				}
				char temp = in.charAt(0);
				in = in.substring(1) + temp;
			}
			
			Integer[] result = new Integer[check.size()];
			int idx = 0;
			for (String s: check) result[idx++] = Integer.parseInt(s, 16);
			
			Arrays.sort(result, Collections.reverseOrder());

			System.out.println("#"+test_case+" "+result[K-1]);
			
			
		}
	}

}
