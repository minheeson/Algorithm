package swex_1984;

import java.util.Arrays;
import java.util.Scanner;

public class SWEX_1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int[] input = new int[10];
			for (int i = 0; i < 10; i++) {
				input[i] = sc.nextInt();
			}

			Arrays.sort(input);

			double sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += input[i];
			}

			double avg = sum / 8;

			int m = (int) (sum / 8);
			int result = 0;
			if (avg - m >= 0.5) {
				result = m + 1;
			} else {
				result = m;
			}

			System.out.println("#" + (t++) + " " + result);
		}
	}

}
