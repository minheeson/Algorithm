package swex_1000;

import java.util.Scanner;

public class SWEX_1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;
		while (t <= tc) {

			int n = sc.nextInt();
			String num = sc.next();

			char[] nums = num.toCharArray();

			for (int j = 0; j < n; j++) {

				char last = nums[0];
				int li = 0;

				for (int i = 1; i < n; i++) {
					if (nums[i] == 'a') {
						continue;
					}

					if (nums[i] == last) {
						nums[li] = nums[i] = 'a';
						if (i <= n - 3) {
							last = nums[i + 1];
							li = i + 1;
							i++;
						}

					} else {
						last = nums[i];
						li = i;
					}

				}

			}

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				if (nums[i] != 'a') {
					sb.append(nums[i]);
				}
			}

			System.out.println("#" + (t++) + " " + sb.toString());

		}
	}

}
