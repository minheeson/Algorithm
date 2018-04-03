package baek_11052;

import java.util.Scanner;

public class Baek_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] map = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			map[i] = sc.nextInt();
		}

		int[] d = new int[n + 1];

		for (int i = 1; i < n + 1; i++) { // i개 팔아서 얻을 수 있는 최대수익
			for (int j = 1; j <=i; j++) { //
				d[i] = Math.max(d[i], d[i - j] + map[j]);
			}
		}

		System.out.println(d[n]);

	}

}
