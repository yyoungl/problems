import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] solutions = new int[N];
        int sum = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i=0; i<N; i++) solutions[i] = sc.nextInt();
        Arrays.sort(solutions);
        int left = 0;
        int right = N-1;
        while (left < right) {
            int result = solutions[left] + solutions[right];
            if (sum > Math.abs(result)) {
                sum = Math.abs(result);
                answer[0] = solutions[left];
                answer[1] = solutions[right];

                if (result == 0) break;
            }
            if (result < 0) left++;
            else right--;
        }

        System.out.println(answer[0] + " " +answer[1]);
    }
}
