package 기타;

import java.util.Scanner;

public class 백준_1259 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			if(str.equals("0")) break;
			
			int index = str.length();
			boolean check = true;
			
			for(int i = 0; i < index; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println("yes");
			}else {
				System.out.println("no");
				
			}
		}

	}
}
