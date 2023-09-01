import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] in = new int[9];
	static boolean[] chk = new boolean[18];
	static int[] kyu = new int[9];
	static int[] result;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			result = new int[2];
			chk = new boolean[19];
			for (int i=0; i<9; i++) {
				kyu[i] = sc.nextInt();
				chk[kyu[i]] = true;
			}
			int idx = 0;
			permutation(0);
			System.out.println("#"+test_case+" "+result[0]+" "+result[1]);
			
		}
		
	}
	
	static int[] permutation(int idx) {
		if (idx==9) {
			int kyuScore = 0;
			int inScore = 0;
			for (int i=0; i<9; i++) {
				if (in[i] > kyu[i]) inScore += in[i]+kyu[i];
				else if (kyu[i] > in[i]) kyuScore+= in[i]+kyu[i];
			}
			if (kyuScore > inScore) result[0]++;
			else if (inScore > kyuScore) result[1]++;
			return result;
		}
		
		
		for (int i=1; i<=18; i++) {
			if (chk[i]) continue;
			in[idx] = i;
			chk[i] = true;
			permutation(idx+1);
			chk[i] =false;
		}
		return result;
	}

}
