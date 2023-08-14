import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			int t = Integer.parseInt(sc.next());
			char[][] letters = new char[100][100];
			for (int i=0; i<100; i++) {
				String in = sc.next();
				for (int j=0; j<100; j++) {
					letters[i][j] = in.charAt(j);
				}
			}
			int maxLen = -1;
			boolean isPalin = true;
			for (int r=0; r<100; r++) {
				for (int c=0; c<100; c++) {
					for (int d=0; d+c<100; d++) {
						String word = "";
						isPalin=true;
						for (int i=0; i<=d; i++) word+=letters[r][c+i];
						for (int i=0; i<word.length()/2; i++) {
							if (word.charAt(i) != word.charAt(word.length()-i-1)) {
								isPalin = false;
								break;
							}
						}
						if (isPalin==true) maxLen = Math.max(maxLen, word.length());
					}
					
					for (int d=0; d+r<100; d++) {
						String word = "";
						isPalin=true;
						for (int i=0; i<=d; i++) word+= letters[r+i][c];
						for (int i=0; i<word.length()/2; i++) {
							if (word.charAt(i) != word.charAt(word.length()-i-1)) {
								isPalin = false;
								break;
							}
						}
						if (isPalin==true) maxLen = Math.max(maxLen, word.length());
					}
				}
			}
			System.out.println("#"+test_case+" "+maxLen);
		}
		
	}
}