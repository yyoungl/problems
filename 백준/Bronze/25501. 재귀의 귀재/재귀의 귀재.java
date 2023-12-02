import java.util.*;

public class Main {

    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc=1; tc<=T; tc++) {
            cnt = 0;
            String str = sc.next();
            System.out.println(isPalindrome(str)+" "+cnt);
        }
    }

    static int recursion(String str, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l+1, r-1);
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length()-1);
    }

}
