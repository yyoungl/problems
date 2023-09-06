
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String str = sc.next();
			if (str.equals("0")) break;
			
			char[] sArray = str.toCharArray();
			
			boolean isOkay = true;
			for (int i=0; i<sArray.length/2; i++) {
				if (sArray[i] != sArray[sArray.length-1-i]) isOkay = false;
			}
			
			if (isOkay) System.out.println("yes");
			else System.out.println("no");
			
		}
		
	}

}
