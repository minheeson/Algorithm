package baek_1107;

import java.util.Scanner;

public class Baek_1107 {

	static boolean[] btns = new boolean[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int channel = sc.nextInt();
		int broken = sc.nextInt();

		for (int i = 0; i < broken; i++) {
			int btn = sc.nextInt();
			btns[btn] = true;
		}

		System.out.println(countBtn(channel));

	}

	static int countBtn(int channel) {
		
		int rtn = 0;
		if (channel > 100) {
			rtn = channel - 100;
		} else {
			rtn = 100 - channel;
		}

		for (int i = 0; i <= 1000000; i++) {
			int c = i;
			int len = possible(c);
			if (len > 0) {
				int press = c - channel;
				if (press < 0) {
					press = press * (-1);
				}

				if (rtn > len + press) {
					rtn = len + press;
				}
			}
		}

		return rtn;
	}

	// 가능하면 길이 리턴, 불가능이면 0 리턴   
	static int possible(int channel) {
		int len = 0;

		if (channel == 0) {
			if (btns[0])
				return 0;
			else
				return 1;
		}
		while (channel > 0) {
			if (btns[channel % 10]) {
				return 0;
			}
			channel /= 10;
			len++;

		}

		return len;
	}

}
