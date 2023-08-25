import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			String s = sc.next();
			int len = s.length();
			char[] result = new char[len];
			for (int i=0; i<len; i++) result[i] = '0';
			char[] memory = s.toCharArray();
			int cnt = 0;
			for (int i=0; i<len; i++) {
				if (result[i] != memory[i]) {
					cnt++;
					if (result[i] == '1') {
						for (int j=i; j<len; j++) {
							result[j] = '0';
						}
					} else if (result[i] =='0') {
						for (int j=i; j<len; j++) {
							result[j] = '1';
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}

}
