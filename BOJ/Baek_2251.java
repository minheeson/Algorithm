package baek_2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_2251 {

	static final int[] from = { 0, 0, 1, 1, 2, 2 };
	static final int[] to = { 1, 2, 0, 2, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] cap = new int[3];

		for (int i = 0; i < 3; i++) {
			cap[i] = sc.nextInt();
		}

		int sum = cap[2];

		boolean[][] check = new boolean[201][201];
		boolean[] ans = new boolean[201];

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, 0));
		check[0][0] = true;
		ans[cap[2]] = true;

		while (!queue.isEmpty()) {
			int[] cur = new int[3];
			Pair p = queue.remove();
			cur[0] = p.first;
			cur[1] = p.second;
			cur[2] = sum - cur[0] - cur[1];

			for (int i = 0; i < 6; i++) {
				int[] next = { cur[0], cur[1], cur[2] };
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;

				if (next[to[i]] >= cap[to[i]]) { 
					// 물통의 용량보다 더 많이 들어있는 경우    
					next[from[i]] = next[to[i]] - cap[to[i]];
					next[to[i]] = cap[to[i]];
				}

				if (!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					queue.add(new Pair(next[0], next[1]));
					if (next[0] == 0) {
						ans[next[2]] = true;
					}

				}

			}
		}
		
		for(int i=0; i<=cap[2]; i++) {
			if(ans[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

	}

	static class Pair{
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

}
