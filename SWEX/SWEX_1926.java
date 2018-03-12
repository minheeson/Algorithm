package swex_1926;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEX_1926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			int temp = i;
			int count = 0;

			while (temp >= 10) {
				int m = temp / 10;
				if (m == 3 || m == 6 || m == 9) {
					count++;
				}

				temp = temp - 10 * m;
			}

			if (temp == 3 || temp == 6 || temp == 9) {
				count++;
			}

			if (count != 0) {
				String in = "";
				for (int k = 0; k < count; k++) {
					in += "-";
				}
				list.add(in);

			} else {
				list.add(String.valueOf(i));
			}

		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

}
