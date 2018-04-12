package swex_2817;

import java.util.Scanner;

public class SWEX_2817 {

	static int n;
	static int s;
	static int ans;
	static int[] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			n = sc.nextInt();
			s = sc.nextInt();
			ans = 0;

			map = new int[n];
			for (int i = 0; i < n; i++) {
				map[i] = sc.nextInt();
			}

			recursion(0, 0);
			System.out.println("#" + (t++) + " " + ans);

		}
	}

	static void recursion(int index, int sum) {

		if (index == n) {
			if (sum == s) {
				ans++;
			}
			return;
		}

		recursion(index + 1, sum);
		recursion(index + 1, sum + map[index]);
	}

}
