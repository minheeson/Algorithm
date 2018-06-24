package swex_4000;

import java.util.Scanner;

public class SWEX_4406 {

	static char[] mo = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t <= tc) {
			String input = sc.next();
			String result = oper(input);
			
			System.out.println("#" + (t++)  +" "+ result);
		}

	}
	
	
	static String oper(String input) {
		char[] arr= input.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		boolean ch = false;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<5; j++) {
				if(mo[j]== arr[i]) {
					ch = true;
					break;
				}
				
			}
			
			if(!ch) {
				sb.append(arr[i]);
			}else {
				ch = false;
			}
		}
		
		return sb.toString();
		
	}

}
