import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Number {
        long num;
        long cnt;

        public Number(long num, long cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long answer = Integer.MAX_VALUE;
        Queue<Number> q = new LinkedList<>();
        q.add(new Number(A, 0));
        while (!q.isEmpty()) {
            Number now = q.poll();
            long num = now.num;
            long cnt = now.cnt;
            if (num == B) answer = Math.min(answer, cnt);
            String str = num + "1";
            if (Long.parseLong(str) <= B) {
                q.add(new Number(Long.parseLong(str), cnt + 1));
            }
            if (num * 2 <= B) {
                q.add(new Number(2 * num, cnt + 1));
            }

        }
        if (answer < Integer.MAX_VALUE)
            System.out.println((answer + 1));
        else System.out.println(-1);
    }
}
