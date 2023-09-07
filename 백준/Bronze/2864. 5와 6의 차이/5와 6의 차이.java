	import java.util.Arrays;
	import java.util.Scanner;
	
	public class Main {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String A = sc.next();
			String B = sc.next();
			
			char[] charA = A.toCharArray();
			char[] charB = B.toCharArray();
			
			
			String strA = "";
			String strB = "";
			for (int i=0; i<charA.length; i++) {
				if (charA[i] == '6') charA[i] = '5';
				strA += charA[i];
			}
			
			for (int i=0; i<charB.length; i++) {
				if (charB[i] == '6') charB[i] = '5';
				strB += charB[i];
			}
			
			int a = Integer.valueOf(strA);
			int b = Integer.valueOf(strB);
			
			System.out.print((a+b)+" ");
			
			strA = "";
			strB = "";
			
			for (int i=0; i<charA.length; i++) {
				if (charA[i] == '5') charA[i] = '6';
				strA += charA[i];
			}
			
			for (int i=0; i<charB.length; i++) {
				if (charB[i] == '5') charB[i] = '6';
				strB += charB[i];
			}
			
			a = Integer.valueOf(strA);
			b = Integer.valueOf(strB);
			
			System.out.println((a+b));
		}
	
	}
