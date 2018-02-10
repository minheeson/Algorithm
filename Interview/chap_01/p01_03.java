package chap_01;

public class p01_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Mr John Smith    ";
		int len = 13;
		
		System.out.println(change(input, len));

	}

	static String change(String s, int len) {
		char[] arr = new char[s.length()];
		int pos = 0;

		for (int i = 0; i < len; i++) {
			char now = s.charAt(i);

			if (now == ' ') {
				arr[pos++] = '%';
				arr[pos++] = '2';
				arr[pos++] = '0';
			} else {
				arr[pos++] = now;
			}
		}

		return new String(arr);
	}

}
