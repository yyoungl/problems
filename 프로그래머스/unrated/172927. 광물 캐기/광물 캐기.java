import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] picks, String[] minerals) {
		int tired = 0;
		int pickSum = 0;
		for (int pick : picks)
			pickSum += pick;
		int len;
		
		if (pickSum*5 < minerals.length) {
			len = pickSum*5;
		} else {
			len = minerals.length;
		}

		String[] mineralFinal = new String[len];
		
		for (int pick =0 ; pick <len; pick++) {
			mineralFinal[pick] = minerals[pick];
		}

		
		
		Integer[] value = new Integer[pickSum];
		Arrays.fill(value, 0);

		int i = 0;
		int idx = 0;
		while (i < len) {
			switch (mineralFinal[i]) {
			case "diamond":
				value[idx] += 100;
				break;
			case "iron":
				value[idx] += 10;
				break;
			case "stone":
				value[idx] += 1;
			}
			if (i % 5 == 4)
				idx++;
			i++;
		}

		Arrays.sort(value, Collections.reverseOrder());

		int index = 0;
		for (int j = 0; j < 3; j++) {
			while (picks[j] > 0) {
				if (j == 0) {
					tired += value[index] / 100;
					value[index] %= 100;
					tired += value[index] / 10;
					value[index] %= 10;
					tired += value[index];
					value[index] %= 1;

				} else if (j == 1) {
					tired += (value[index] / 100) * 5;
					value[index] %= 100;
					tired += value[index] / 10;
					value[index] %= 10;
					tired += value[index];
					value[index] %= 1;

				} else if (j == 2) {
					tired += (value[index] / 100) * 25;
					value[index] %= 100;
					tired += (value[index] / 10) * 5;
					value[index] %= 10;
					tired += value[index];
					value[index] %= 1;

				}
				picks[j] -= 1;

				if (value[index] == 0)
					index++;
			}
		}
        return tired;

    }
}