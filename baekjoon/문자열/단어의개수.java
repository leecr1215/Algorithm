package ���ڿ�;

import java.util.Scanner;

public class �ܾ��ǰ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		
		String[] arr = st.split(" ");
		
		int result = arr.length;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("")) {
				result--;
			}
		}
		
		System.out.println(result);
	}
}
