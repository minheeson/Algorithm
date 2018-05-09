package swex_3000;

import java.util.Scanner;

public class SWEX_3456 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int[] bs = new int[4];
			for (int i = 0; i < 3; i++) {
				bs[i] = sc.nextInt();
			}

			int tmp = bs[0];
			int same = -1;
			int answer = 0;

			for (int i = 1; i < 3; i++) {
				if (tmp == bs[i]) {
					same = i;
				}
			}

			if (same == -1) {
				answer = tmp;
			} else {
				answer = bs[3 - same];
			}
			
			System.out.println("#" + (t++) + " " + answer);
		}
	}

}
