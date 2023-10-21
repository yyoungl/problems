
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int C;
	static StringBuilder sb;
	static ArrayList<Integer> vowel;
	static char[] letters;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		vowel = new ArrayList<>();
		sb = new StringBuilder();

		char[] result = new char[N];
		letters = new char[C];
		for (int i = 0; i < C; i++) {
			char c = sc.next().charAt(0);
			letters[i] = c;
		}

		Arrays.sort(letters);

		for (int i = 0; i < C; i++) {
			char c = letters[i];
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowel.add(i);
		}

		combination(0, 0, 0, 0, result);

		System.out.println(sb.toString());

	}

	static void combination(int idx, int start, int mo, int ja, char[] result) {
		if (idx == N) {
			
			if (mo > 0 && ja > 1) {
				for (char c : result)
					sb.append(c);
				sb.append("\n");
				return;
			}
			
			return;
		}

		for (int i = start; i < C; i++) {
			boolean flagMo = false;
			boolean flagJa = false;
			if (vowel.contains(i)) {
				mo++;
				flagMo = true;
			}
			else {
				ja++;
				flagJa = true;
			}
			result[idx] = letters[i];
			combination(idx + 1, i + 1, mo, ja, result);
			if(flagMo) mo--;
			if(flagJa) ja--;
		}

	}

}
