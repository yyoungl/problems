import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		
		Set<String> hear = new HashSet<>();
		Set<String> see = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		
		for (int i=0; i<a; i++) {
			hear.add(sc.next());
		}
		for (int i=0; i<b; i++) {
			see.add(sc.next());
		}
		
		for (String s: hear) {
			if (see.contains(s)) answer.add(s); 
		}
		
		String[] result = new String[answer.size()];
		int idx = 0;
		
		for (String s: answer) result[idx++] = s;
		
		Arrays.sort(result);
		System.out.println(result.length);
		for (String s: result) System.out.println(s);
		
	}

}
