package swex_2814;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEX_2814 {

	static int ans;
	static ArrayList<Integer> list[];
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			list = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			ans = 0;

			for (int i = 0; i < n + 1; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				list[x].add(y);
				list[y].add(x);
			}

			for (int i = 1; i <= n; i++) {
				visited[i] = true;
				recursion(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + (t++) + " " + ans);

		}
	}

	static void recursion(int cur, int length) {

		ans = Math.max(ans, length);
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			recursion(next, length + 1);
			visited[next] = false;
		}

	}

}
