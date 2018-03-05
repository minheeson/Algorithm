package swex_1936;

import java.util.Scanner;

public class SWEX_1936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==1) {
			if(b==2) {
				System.out.println("B");
			}else {
				System.out.println("A");
			}
		}else if(a==2) {
			if(b==3) {
				System.out.println("B");
			}else {
				System.out.println("A");
			}
		}else {
			if(b==1) {
				System.out.println("B");
			}else {
				System.out.println("A");
			}
		}
		
	}

}
