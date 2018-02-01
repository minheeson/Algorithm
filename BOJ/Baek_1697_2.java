package baek_1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1697_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] time = new int[100001];
		boolean[] visited = new boolean[100001];

		int subin = sc.nextInt();
		int sister = sc.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(subin);
		visited[subin] = true;
		Arrays.fill(time, Integer.MAX_VALUE);
		time[subin] = 0;

		while (!queue.isEmpty()) {
			int nowS = queue.remove();
			if (nowS == sister) {
				System.out.println(time[nowS]);
				break;
			}

			if (check(nowS + 1) && !visited[nowS + 1]) {
				queue.add(nowS + 1);
				visited[nowS + 1] = true;
				int t = time[nowS] + 1;
				if (time[nowS + 1] > t) {
					time[nowS + 1] = t;
				}

			}

			if (check(nowS - 1) && !visited[nowS - 1]) {
				queue.add(nowS - 1);
				visited[nowS - 1] = true;
				int t = time[nowS] + 1;
				if (time[nowS - 1] > t) {
					time[nowS - 1] = t;
				}

			}

			if (check(nowS * 2) && !visited[nowS * 2]) {
				queue.add(nowS * 2);
				visited[nowS * 2] = true;
				int t = time[nowS] + 1;
				if (time[nowS * 2] > t) {
					time[nowS * 2] = t;
				}

			}

		}

		// System.out.println(time[sister]);

	}

	static boolean check(int pos) {
		if (pos < 0 || pos > 100000) {
			return false;
		}
		return true;
	}

}
