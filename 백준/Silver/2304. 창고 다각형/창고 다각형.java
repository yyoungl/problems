import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        int[] c = new int[1001];
        int maxC = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            int L = sc.nextInt();
            c[L]= sc.nextInt();
            maxC = Math.max(c[L], maxC);
            start = Math.min(L, start);
            end = Math.max(L, end);
        }
        
        
        int temp = c[start];
        int answer = 0;
        for (int i=start+1; i<=end; i++) {
        	if (temp > c[i]) stack.push(i);
        	else {
        		while(!stack.isEmpty()) {
        			int a = stack.pop();
        			c[a] = temp;
        		}
        		temp = c[i];
        	}
        }
        
        stack.clear();
        temp = c[end];
        for (int i=end-1; i>=start; i--) {
        	if (temp>c[i]) stack.push(i);
        	else {
        		while (!stack.isEmpty()) {
        			int a = stack.pop();
        			c[a] = temp;
        		}
        		temp= c[i];
        	}
        }
        
        int result = 0;
        for (int i=start; i<=end; i++) {
        	result += c[i];
        }
        
        System.out.println(result);
        
	}

}
