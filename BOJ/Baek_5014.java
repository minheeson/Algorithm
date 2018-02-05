package baek_5014;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_5014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt(); // 총 층수
		int s = sc.nextInt(); // 강호 위치
		int g = sc.nextInt(); // 스타트링크
		int u = sc.nextInt(); // 위로 u층 이동
		int d = sc.nextInt(); // 아래로 d층 이동

		boolean[] visited = new boolean[f + 1];
		int[] cost = new int[f + 1];
		Arrays.fill(cost, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		cost[s] = 0;

		while (!q.isEmpty()) {
			int now = q.remove();

			if (now == g) {
				break;
			}

			int next = now + u;
			if (next > 0 && next <= f && !visited[next]) {
				visited[next] = true;
				cost[next] = cost[now] + 1;
				q.add(next);
			}
			next = now - d;
			if (next > 0 && next <= f && !visited[next]) {
				visited[next] = true;
				cost[next] = cost[now] + 1;
				q.add(next);
			}

		}
		
		if(cost[g]>-1) {
			System.out.println(cost[g]);
		}else {
			System.out.println("use the stairs");
		}
		

	}

}
