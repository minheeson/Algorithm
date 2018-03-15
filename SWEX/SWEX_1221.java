package swex_1221;

import java.util.Scanner;

public class SWEX_1221 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] planet = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t++ <= tc) {
			String tcase = sc.next();
			int n = sc.nextInt();

			// String[] map = new String[n];

			int zro = 0;
			int one = 0;
			int two = 0;
			int thr = 0;
			int fore = 0;
			int fiv = 0;
			int six = 0;
			int svn = 0;
			int egt = 0;
			int nin = 0;

			for (int i = 0; i < n; i++) {
				String temp = sc.next();
				if (temp.equals("ZRO")) {
					zro++;
				} else if (temp.equals("ONE")) {
					one++;
				} else if (temp.equals("TWO")) {
					two++;
				} else if (temp.equals("THR")) {
					thr++;
				} else if (temp.equals("FOR")) {
					fore++;
				} else if (temp.equals("FIV")) {
					fiv++;
				} else if (temp.equals("SIX")) {
					six++;
				} else if (temp.equals("SVN")) {
					svn++;
				} else if (temp.equals("EGT")) {
					egt++;
				} else {
					nin++;
				}
			}

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < zro; i++) {
				sb.append("ZRO ");
			}
			for (int i = 0; i < one; i++) {
				sb.append("ONE ");
			}
			for (int i = 0; i < two; i++) {
				sb.append("TWO ");
			}
			for (int i = 0; i < thr; i++) {
				sb.append("THR ");
			}
			for (int i = 0; i < fore; i++) {
				sb.append("FOR ");
			}
			for (int i = 0; i < fiv; i++) {
				sb.append("FIV ");
			}
			for (int i = 0; i < six; i++) {
				sb.append("SIX ");
			}
			for (int i = 0; i < svn; i++) {
				sb.append("SVN ");
			}
			for (int i = 0; i < egt; i++) {
				sb.append("EGT ");
			}
			for (int i = 0; i < nin; i++) {
				sb.append("NIN ");
			}

			System.out.println(tcase + "\n" + sb.toString());

		}

	}

}
