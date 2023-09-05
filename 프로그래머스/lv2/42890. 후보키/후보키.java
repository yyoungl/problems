import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    static int R;
	static int C;
	static HashSet<Integer> result = new HashSet<>();
    public int solution(String[][] relation) {
        
        R = relation.length;
        C = relation[0].length;
        combination(C, relation);
        
        return result.size();
    }
    
    static void combination(int C, String[][] relation) {

		for (int i = 0; i < (1 << C); i++) {
			ArrayList<Integer> comb = new ArrayList<>();
			for (int j = 0; j < C; j++) {
				if ((i & (1 << j)) > 0) {
					comb.add(j);
				}
			}

			for (int d : comb)
				System.out.print(d + " ");
			System.out.println();

			HashSet<String> chk = new HashSet<String>();

			// 유일성 검사
			// 인덱스 조합으로 만든 개인정보의 조합으로 string을 만들고 set에 담는다.
			boolean isOkay = true;
			for (int d = 0; d < R; d++) {
				String str = "";
				for (int com : comb) {
					str += relation[d][com];
				}
				
				System.out.println("str: "+str);
				if (chk.contains(str)) {
					isOkay = false;
				} else {
					chk.add(str);
				}
			}

			if (!isOkay)
				continue;

			boolean isMinimum = true;
			// 최소성 검사
			for (int re : result) {
				if ((re & i) == re) {
					isMinimum = false;
				}
			}
			System.out.println("i: "+i+" isMinimum: "+isMinimum);
			if (isMinimum)
				result.add(i);

		}

	}
}