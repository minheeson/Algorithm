package baek_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1697 {
	// 큐 정리, offer&add 차이

	private static Scanner sc;
	private static final int MAX = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> queue = new LinkedList<Integer>();

		sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int sister = sc.nextInt();
		boolean[] visited = new boolean[MAX];
		int[] dist = new int[MAX];

		queue.add(subin);
		visited[subin] = true;
		dist[subin] = 0;

		while (!queue.isEmpty()) {
			int now = queue.remove();
			if (now - 1 >= 0 && !visited[now - 1]) {
				queue.add(now - 1);
				visited[now - 1] = true;
				dist[now - 1] = dist[now] + 1;
			}
			if (now + 1 < MAX && !visited[now + 1]) {
				queue.add(now + 1);
				visited[now + 1] = true;
				dist[now + 1] = dist[now] + 1;
			}
			if (now * 2 < MAX && !visited[now * 2]) {
				queue.add(now * 2);
				visited[now * 2] = true;
				dist[now * 2] = dist[now] + 1;
			}
		}

		System.out.println(dist[sister]);

	}

}
