import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] sudoku = new int[9][9];
			boolean isOkay = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 가로 체크
			for (int r = 0; r < 9; r++) {
				boolean[] check = new boolean[10];
				for (int c = 0; c < 9; c++) {
					if (check[sudoku[r][c]] == true) {
						isOkay = false;
						break;
					} else {
						check[sudoku[r][c]] = true;
					}
				}
			}

			if (isOkay == false) {
				System.out.println("#"+test_case+" " +0);
				continue;
			}

			for (int c = 0; c < 9; c++) {
				boolean[] check = new boolean[10];
				for (int r = 0; r < 9; r++) {
					if (check[sudoku[r][c]] == true) {
						isOkay = false;
						break;
					} else {
						check[sudoku[r][c]] = true;
					}
				}
			}

			if (isOkay == false) {
				System.out.println("#"+test_case+" " +0);
				continue;
			}

			for (int i = 0; i < 7; i += 3) {
				for (int j = 0; j < 7; j += 3) {
//					System.out.println("i, j: " + i+", "+j);
					boolean[] check = new boolean[10];
					for (int r = i; r < i + 3; r++) {
						for (int c = j; c < j + 3; c++) {
//							System.out.println("r, c: " + r+", "+c);
//							System.out.println("sudoku[r][c]: " + soduku[r][c]+"  ");
							if (check[sudoku[r][c]] == true) {
								isOkay = false;
								break;
							} else {
								check[sudoku[r][c]] = true;
							}
						}
					}
				}
			}

			if (isOkay == false) {
				System.out.println("#"+test_case+" " +0);
			} else
				System.out.println("#"+test_case+" " +1);

		}
	}
}