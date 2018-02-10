package chap_01;

public class p01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "aabcccdeff";
		System.out.println(compress(test));
	}

	static String compress(String s) {
		int count = 1;
		String rtn = "";
		for (int i = 1, len = s.length(); i < len; i++) {

			if (s.charAt(i - 1) != s.charAt(i)) {
				rtn += s.charAt(i - 1);
				rtn += count;
				count = 1;

			} else {
				count++;
			}
			if (i == s.length() - 1) {
				rtn += s.charAt(i - 1);
				rtn += count;
				return rtn;
			}

		}

		return rtn;
	}
}
