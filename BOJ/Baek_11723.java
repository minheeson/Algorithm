package baek_11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_11723 {

	static int[] arr = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());

		int bitmask = 0;
		int data = 0;
		String[] arr;

		while (count-- > 0) {
			arr = br.readLine().split(" ");
			String cmd = arr[0];

			switch (cmd) {

			case "add":
				data = Integer.parseInt(arr[1]);
				bitmask = (bitmask | (1 << data));
				break;

			case "remove":
				data = Integer.parseInt(arr[1]);
				bitmask = (bitmask & ~(1 << data));
				break;

			case "check":
				data = Integer.parseInt(arr[1]);
				bw.write(((bitmask & (1 << data)) >> data) + "\n");
				break;

			case "toggle":
				data = Integer.parseInt(arr[1]);
				bitmask = bitmask ^ (1 << data);
				break;

			case "all":
				bitmask = (1 << 21) - 1;
				break;

			case "empty":
				bitmask = 0;
				break;
			}

		}

		bw.flush();

		bw.close();
		br.close();

	}

}
