import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] nums = new boolean[10001];
		for (int i=1; i<10001; i++) {
			int check = i;
			String strNum = String.valueOf(i);
			
			char[] digits = strNum.toCharArray();

			for (int j=0; j<digits.length; j++) {
				check += Integer.valueOf(digits[j])-'0';
			}
			if (check > 10000) continue;
			else {
				nums[check] = true;
			}

		}
		
		for (int i=1; i<10001; i++) {
			if (nums[i] == false)
				System.out.println(i);
		}
	}

}
