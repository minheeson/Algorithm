package swex_1989;

import java.util.Scanner;

public class SWEX_1989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			String input = sc.next();
			char[] inputArr = input.toCharArray();

			int result = 1;
			for (int i = 0; i < inputArr.length / 2; i++) {
				if (inputArr[i] != inputArr[inputArr.length - 1 - i]) {
					result = 0;

				}
			}

			System.out.println("#" + (t++) + " " + result);
		}
	}

}
