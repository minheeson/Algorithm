package swex_3000;

import java.util.Scanner;

public class SWEX_3376 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		long[] arr = new long[101];
		arr[0] = 0;
		arr[1] = arr[2] = arr[3] = 1;
		for (int i = 4; i < 101; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		while (t <= tc) {

			int x = sc.nextInt();

			System.out.println("#" + (t++) + " " + arr[x]);

		}
	}

}
