import java.util.Scanner;
import java.util.HashMap;
import java.io.FileInputStream;
class Solution
{
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> days = new HashMap<Integer, Integer>();
		days.put(1, 31);
		days.put(2, 28);
		days.put(3, 31);
		days.put(4, 30);
		days.put(5, 31);
		days.put(6, 30);
		days.put(7, 31);
		days.put(8, 31);
		days.put(9, 30);
		days.put(10, 31);
		days.put(11, 30);
		days.put(12, 31);
		
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			int answer = 0;
			if (month1 == month2) answer+= day2-day1+1;
			else {
				answer += days.get(month1)-day1+day2+1;
				for (int i=month1+1; i<month2; i++) {
					answer+= days.get(i);
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
		
		
	}
}