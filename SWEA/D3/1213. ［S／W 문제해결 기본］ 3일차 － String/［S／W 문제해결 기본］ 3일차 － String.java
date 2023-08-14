import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			String search = sc.next();
			String str = sc.next();
			int answer = 0;
			for (int i = 0; i + search.length() <= str.length(); i++) {
				String target = "";
				for (int d = 0; d < search.length(); d++) {
					target += str.charAt(i + d);
				}
				boolean isSame=true;
				
				for (int idx = 0; idx < search.length(); idx++) {
					if (target.charAt(idx) != search.charAt(idx)) isSame = false;
				}
				
				if (isSame) answer++;
			}
			
			System.out.println("#"+test_case+" "+answer);

		}
	}
}