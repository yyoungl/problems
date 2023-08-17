import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.io.FileInputStream;
class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> isp = new HashMap<Character, Integer>();
		isp.put('(', 0);
		isp.put('+', 1);
		isp.put('-', 1);
		isp.put('*', 2);
		isp.put('/', 2);
		isp.put(')', -1);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String inputS = sc.next();
			char[] seq = inputS.toCharArray();
			int answer = 0;
			Stack<Character> cal = new Stack<>();
			Stack<String> num = new Stack<>();
			char[] postfix = new char[N];
			int idx = 0;

//			System.out.println(Arrays.toString(seq));

			for (int i = 0; i < N; i++) {
				char s = seq[i];
				if (Character.isDigit(s))
					postfix[idx++] = s;
				else if (s == '(')
					cal.push(s);
				else if (s == ')') {
					while (!cal.isEmpty() && cal.peek() != '(') {
						postfix[idx++] = cal.pop();
					}
					char bracket = cal.pop();
//					System.out.println("bracket: "+bracket);
				} else {
					while (!cal.isEmpty() && isp.get(cal.peek()) >= isp.get(s)) {
						postfix[idx++] = cal.pop();
					}
					cal.push(s);
					if (i == N - 1 && cal.isEmpty())
						break;
				}
//				System.out.println(Arrays.toString(postfix));
			}

			for (int i = 0; i < idx; i++) {
				char p = postfix[i];
				if (Character.isDigit(p)) {
					num.push(Character.toString(p));
				} else {
					int a = Integer.valueOf(num.pop());
					int b = Integer.valueOf(num.pop());
					if (p == '+')
						num.push(Integer.toString(a + b));
					else if (p == '*')
						num.push(Integer.toString(a * b));
				}
			}

			System.out.println("#" + test_case + " " + num.pop());

		}
	}
}