package baek_15000;

import java.util.Scanner;

public class Baek_15650 {

	static int n, m;
	static boolean[] visited;
	static int[] output;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n];
		output = new int[m];

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			output[0] = i + 1;
			dfs(1);
			visited[i] = false;

		}

	}

	static void dfs(int num) {
		if (num == m) {
			if (check(output)) {
				for (int i = 0; i < m; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
			}

			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[num] = i + 1;
				dfs(num + 1);
				visited[i] = false;
			}
		}
	}

	static boolean check(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}

		return true;
	}

}
