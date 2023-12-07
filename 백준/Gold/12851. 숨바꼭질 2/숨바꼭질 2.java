import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] costArr = new int[100001];
        costArr[N] = 1;
        q.add(N);

        int cnt = 0;
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (answer < costArr[curr]) break;

            int[] nextPos = {curr + 1, curr - 1, 2 * curr};
            for (int next : nextPos) {

                if (next == K) {
                    answer = costArr[curr];
                    cnt++;
                }

                if (!isValid(next)) continue;
                if (costArr[next] == 0 || costArr[next] == costArr[curr] + 1) {
                    q.add(next);
                    costArr[next] = costArr[curr] + 1;
                }
            }


        }

        System.out.println(answer + "\n" + cnt);

    }

    static boolean isValid(int n) {
        return n >= 0 && n <= 100000;
    }
}
