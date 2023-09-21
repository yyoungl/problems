
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int tempK = K;
		String input = sc.next();
		Stack<Character> stack = new Stack<>();
		int L = input.length();
		for (int i = 0; i < L; i++) {
			char temp = input.charAt(i);

			while (!stack.isEmpty() && stack.peek() < temp && tempK > 0) {
				stack.pop();
				tempK--;

			}
			stack.push(temp);
		}

		StringBuilder result = new StringBuilder();
		
		while(!stack.isEmpty()) {
			if (stack.size() == N-K) break;
			stack.pop();
		}

		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		result.reverse();

		System.out.println(result.toString());

	}

}
