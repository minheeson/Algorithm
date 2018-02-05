package baek_1525;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1525 {

	public static final int[] dx = { 0, 0, 1, -1 };
	public static final int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int start = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					temp = 9;
				}
				start = start * 10 + temp;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// <배열 순서, 이동 횟수>  
		map.put(start, 0);
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int now_num = queue.remove();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z / 3;
			int y = z % 3;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x * 3 + y);
					next.setCharAt(x * 3 + y, next.charAt(nx * 3 + ny));
					next.setCharAt(nx * 3 + ny, temp);
					int num = Integer.parseInt(next.toString());
					if (!map.containsKey(num)) {
						map.put(num, map.get(now_num) + 1);
						queue.add(num);
					}
				}
			}
		}
		
		if (map.containsKey(123456789)) {
			System.out.println(map.get(123456789));
		} else {
			System.out.println("-1");
		}
	}

}
