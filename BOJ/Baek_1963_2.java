package baek_1963;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1963_2 {
	static boolean[] prime = new boolean[10001];
	static boolean[] visited;
	static int[] cost = new int[10001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Arrays.fill(prime, true);
		
		prime[1] = false;
		for (int i = 2; i <= 10000; i++) {
			for (int j = i * i; j <= 10000; j += i) {
				prime[j] = false;
			}
		}

		int c = sc.nextInt();
		while (c-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			Arrays.fill(cost, Integer.MAX_VALUE);
			visited = new boolean[10001];
			
			
			int result = minCount(x, y);

			if (result == -1) {
				System.out.println("Impossible");
			} else {
				System.out.println(result);
			}
		}

	}

	static int minCount(int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		visited[x] = true;
		cost[x] = 0;
		while (!queue.isEmpty()) {
			int nowX = queue.remove();
			// if (nowX == y) {
			// return cost[y];
			// }

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					int nextX = change(nowX, i, j);
					if (nextX != -1) {
						if (!visited[nextX] && prime[nextX]) {
							visited[nextX] = true;
							if (cost[nextX] > cost[nowX] + 1)
								cost[nextX] = cost[nowX] + 1;
							queue.add(nextX);
						}
					}

				}
			}

		}

		return cost[y];
	}

	// num의 from번째 인덱스를 to로 바꿈
	static int change(int num, int from, int to) {
		int unit = 1000;
		for (int i = 0; i < from; i++) {
			unit /= 10;
		}

		int m = (int) num / unit;
		m = m % 10;

		num = num - (m * unit) + (to * unit);

		if (num < 1000) {
			return -1;
		}

		return num;

	}

}
