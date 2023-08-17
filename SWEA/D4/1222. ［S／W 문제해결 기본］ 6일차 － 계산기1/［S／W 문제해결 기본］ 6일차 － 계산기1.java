import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int test_case=1; test_case<=10; test_case++) {
			int N = sc.nextInt();
			String inputS = sc.next();
			char[] seq = inputS.toCharArray();
			int answer = 0;
			Stack<Character> cal = new Stack<>();
			Stack<String> num = new Stack<>();
			char[] postfix = new char[N];
			int idx = 0;
			for (int i=0; i<N; i++) {
				if (seq[i] == '+' && !cal.isEmpty()) {
					postfix[idx++] = cal.pop();
					cal.push(seq[i]);
				} else if (seq[i] == '+' && cal.isEmpty())  {
					cal.push(seq[i]);
				} else postfix[idx++] = seq[i];
			}
			postfix[idx] = cal.pop();
						
			for (int i=0; i<N; i++) {
				if (postfix[i] != '+') num.push(Character.toString(postfix[i]));
				else {
					int a = Integer.valueOf(num.pop());
					int b = Integer.valueOf(num.pop());
					num.push(Integer.toString(a+b));
				}
			}
			System.out.println("#"+test_case+" "+num.pop());
		}
	}

}