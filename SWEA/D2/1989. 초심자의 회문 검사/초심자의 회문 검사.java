
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			String in = sc.next();
			boolean isOkay = true;
			for (int i=0; i<in.length()/2; i++) {
				if (in.charAt(i) != in.charAt(in.length()-i-1	)) {
					isOkay = false;
					break;
				}
			}
			if (isOkay) System.out.println("#"+test_case+" "+1); else System.out.println("#"+test_case+" "+0);
		}
	}

}