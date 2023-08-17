import java.util.Scanner;
import java.util.Stack;

public class Main {

		public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder originStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        String inputS = sc.next();

        String pung = sc.next();
        for (int i = 0; i < inputS.length(); i++) {
            originStr.append(inputS.charAt(i));
            int len = originStr.length();
            if (len >= pung.length()) {
                String check = originStr.substring(len - pung.length(), len);
                if (check.equals(pung)) {
                    originStr.setLength(len - pung.length());
                }
            }
        }

        if (originStr.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(originStr.toString());
        }
    }
}
