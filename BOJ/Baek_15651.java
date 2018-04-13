package baek_15000;

import java.util.Scanner;

public class Baek_15651 {

	static int n, m;
	static int[] output;
	static StringBuffer sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		output = new int[m];
		sb = new StringBuffer();

		for (int i = 0; i < n; i++) {
			output[0] = i + 1;
			dfs(1);
		}

		System.out.println(sb.toString());
	}

	static void dfs(int num) {

		if (num == m) {
			for (int i = 0; i < m; i++) {
				sb.append(output[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			output[num] = i + 1;
			dfs(num + 1);
		}

	}

}
