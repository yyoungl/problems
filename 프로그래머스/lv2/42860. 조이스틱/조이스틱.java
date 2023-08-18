class Solution {
    public int solution(String name) {
        int answer = 0;
		int len = name.length();
		char[] nameArr = name.toCharArray();

		for (int i = 0; i < len; i++) {
			int diff = nameArr[i] - 'A';
			answer += Math.min(diff, 26 - diff);
		}

		int min = len - 1;
		for (int i = 0; i < len; i++) {
			int index = i + 1;
			while (index < len && nameArr[index] == 'A') {
				index++;
			}
			if (index - i > 1) {
				min = Math.min(min, Math.min(2 * (len - index) + i, 2 * i + len - index));
			}
		}

		return answer + min;
    }
}