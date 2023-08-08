import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i=1; i<=N; i++) {
			boolean check = true;
			String strNum = String.valueOf(i);
			char[] tempDigits = strNum.toCharArray();
			int[] digits = new int[tempDigits.length];
			for (int j=0; j<tempDigits.length; j++) {
				digits[j] = Integer.valueOf(tempDigits[j])-'0';
			}
			for (int j=0; j<digits.length-2; j++) {
				if (!(digits[j+1]-digits[j] == digits[j+2]-digits[j+1]))
					check = false;
			}
			if (check == true) cnt++;
		}
		System.out.println(cnt);
	}

}
