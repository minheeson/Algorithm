package chap_01;

public class p01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "abcd";
		String test2 = "aaaaaabccdee";
		System.out.println(compress(test));
		System.out.println(betterCompress(test));

		System.out.println(compress(test2));
		System.out.println(betterCompress(test2));
	}

	static String compress(String s) {
		int count = 1;
		String rtn = "";
		char last = s.charAt(0);
		for (int i = 1, len = s.length(); i < len; i++) {
			if (last != s.charAt(i)) {
				rtn = rtn + last + count;
				count = 1;
				last = s.charAt(i);
			} else {
				count++;
			}

		}

		return rtn + last + count;
	}

	static int countCompress(String s) {
		int size = 0;
		int count = 1;
		char last = s.charAt(0);

		for (int i = 1, len = s.length(); i < len; i++) {
			if (last != s.charAt(i)) {
				size = size + 1 + String.valueOf(count).length();
				count = 1;
				last = s.charAt(i);
			} else {
				count++;
			}
		}

		return size + 1 + String.valueOf(count).length();
	}

	static String betterCompress(String s) {
		if (s.length() < countCompress(s)) {
			return s;
		}

		StringBuffer sb = new StringBuffer();
		char last = s.charAt(0);
		int count = 1;

		for (int i = 1, len = s.length(); i < len; i++) {
			if (last != s.charAt(i)) {
				sb.append(last);
				sb.append(count);
				last = s.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}

		sb.append(last);
		sb.append(count);
		
		return sb.toString();
	}
}
