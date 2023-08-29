import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			long M = sc.nextInt();
			char[] binary = new char[30];
			String result = binary(M);
			for (int i=0; i<30; i++) binary[i] = '0';
			int len = result.length();
			for (int i=0; i<len; i++) {
				binary[29-i] = result.charAt(len-i-1);
			}
			
			
			boolean check = true;
			for (int i=0; i<N; i++) {
				if (binary[29-i] == '0') {
					check = false;
					break;
				}
			}
			
			if (!check) System.out.println("#"+test_case+" OFF");
			else System.out.println("#"+test_case+" ON");
		}
	}
	
	public static String binary(long M) {
		
		String result = "";
		
		while (M > 0) {
			result = Long.toString(M%2) + result;
			M = M/2;
		}
		
		return result;
		
	}

}
