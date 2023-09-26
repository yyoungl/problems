import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static HashMap<String, String> friends;
	static HashMap<String, Integer> cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int network = sc.nextInt();
			friends = new HashMap<>();
			cnt = new HashMap<>();
			
			// 관계를 맵에 넣어주기
			for (int i=0; i<network; i++) {
				String person1 = sc.next();
				String person2 = sc.next();
				
				friends.putIfAbsent(person1, person1);
				friends.putIfAbsent(person2, person2);
				cnt.putIfAbsent(person1, 1);
				cnt.putIfAbsent(person2, 1);
				
				String parent1 = find(person1);
				String parent2 = find(person2);
				union(parent1, parent2);
				
				System.out.println(cnt.get(parent2));
				
			}
			
			
		}
	}
	
	
	static String find(String person) {
		if (!person.equals(friends.get(person))) {
			friends.put(person, find(friends.get(person)));
		}
		return friends.get(person);
	}
	
	static void union(String person1, String person2) {
		if (person1.equals(person2)) return;
		else {
			friends.put(person1, person2);
			cnt.put(person2, cnt.get(person2)+cnt.get(person1));
		}
	}

}
