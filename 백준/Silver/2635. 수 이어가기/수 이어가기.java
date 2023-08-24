import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> maxList = new ArrayList<>();
		for (int i = N; i >= 0; i--) {
			ArrayList<Integer> nums = new ArrayList<>();
			nums.add(N);
			nums.add(i);
			int size = nums.size();
			while (true) {
				int a = nums.get(size - 2);
				int b = nums.get(size - 1);
				if (a - b < 0)
					break;
				nums.add(a - b);
				size++;
			}

			if (maxList.size() < size) {
				maxList = (ArrayList<Integer>) nums.clone();
			}
		}

		System.out.println(maxList.size());
		for (int c : maxList)
			System.out.print(c + " ");

	}

}
