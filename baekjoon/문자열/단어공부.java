package ���ڿ�;

import java.util.HashMap;
import java.util.Scanner;

public class �ܾ���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		
		String s = sc.next().toUpperCase();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int value = 1;
			if(map.containsKey(c)){
				value = map.get(c) + 1;
			}
			map.put(c, value);
		}
		
		int maxValue = 0;
		char maxKey = 0;
		
		for(char key: map.keySet()) {
			int value = map.get(key);
			if(maxValue < value) {
				maxValue = value;
				maxKey = key;
			}
		}
		
		// ���� ���� ���� ���ĺ� ���� �� �����ϴ��� Ȯ��
		int num = 0;
		for(char key: map.keySet()) {
			if(map.get(key)==maxValue) {
				num++;
			}
		}
		
		if(num > 1) {
			System.out.println("?");
		}else {
			System.out.println(maxKey);
		}
	}
}
