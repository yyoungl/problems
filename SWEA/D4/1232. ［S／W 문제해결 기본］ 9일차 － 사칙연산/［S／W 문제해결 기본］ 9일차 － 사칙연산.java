import java.util.Scanner;
class Node {
	int num;
	String data;
	int left;
	int right;

	public Node(int num) {
		this.num = num;
		this.data = null;
		this.left = 0;
		this.right = 0;
	}

}
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력된 노드 번호 * 2 가 8(N, 총 노드의 개수) 보다 작다면 당연히 자식이 있음
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.valueOf(sc.nextLine());
			Node[] tree = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				// 1 - 2 3
				String inputS = sc.nextLine();
				String[] s = inputS.split(" ");
//				System.out.println(Arrays.toString(s));
				if (s.length == 4) {
					int num = Integer.valueOf(s[0]);
					tree[num] = new Node(num);
					tree[num].data = s[1];
					tree[num].left = Integer.valueOf(s[2]);
					tree[num].right = Integer.valueOf(s[3]);
				} else {
					int num = Integer.valueOf(s[0]);
					tree[num] = new Node(num);
					tree[num].data = s[1];
				}
				
				
			}
			System.out.print("#" + test_case + " ");
			System.out.println((int) postorderTraverse(1, tree));

		}
	}

	static double postorderTraverse(int node, Node[] tree) {

		if (Character.isDigit(tree[node].data.charAt(0))) {
			return Double.valueOf(tree[node].data);
		}

		double a = postorderTraverse(tree[node].left, tree);
		double b = postorderTraverse(tree[node].right, tree);

		if (tree[node].data.equals("+")) {
			return a + b;
		} else if (tree[node].data.equals("-")) {
			return a - b;
		} else if (tree[node].data.equals("*")) {
			return a * b;
		} else {
			return a / b;
		}
	}

}
