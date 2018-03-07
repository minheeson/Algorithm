package swex_1946;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEX_1946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {

			int n = sc.nextInt();
			String result = "";

			StringBuffer sb = new StringBuffer();
			Queue<Node> queue = new LinkedList<Node>();

			for (int i = 0; i < n; i++) {
				String s = sc.next();
				int num = sc.nextInt();
				queue.add(new Node(s, num));
			}

			while (!queue.isEmpty()) {
				String s = queue.peek().s;
				int num = queue.remove().num;

				for (int i = 0; i < num; i++) {
					sb.append(s);
					if (sb.length() == 10) {
						result += sb.toString() + "\n";
						sb.setLength(0);
					}
				}

			}

			if (sb.length() != 0) {
				result += sb.toString();
			}

			System.out.println("#" + (t++) + "\n" + result);
		}

	}

	static class Node {
		String s;
		int num;

		Node(String s, int num) {
			this.s = s;
			this.num = num;
		}
	}

}
