package 문자열;

import java.util.Scanner;

public class 크로아티아_알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == 'c' && i < s.length() - 1) {			// ���� ch �� c ���?
				//���� ch ���� ���ڰ� '=' �Ǵ� '-' �̶��?
				if(s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {		
					// i+1 ������ �ϳ��� �����̹Ƿ� ���� ���ڸ� �ǳ� �ٱ� ���� 1 ����
					i++;		
				}
				
			}
		    
			else if(c == 'd' && i < s.length() - 1) {
				if(s.charAt(i + 1) == '-') {	// d- �� ���
						i++;
					}
				else if(s.charAt(i + 1) == 'z' && i < s.length() - 2) {
					
					if(s.charAt(i + 2) == '=') {	// dz= �� ���
						i += 2;
					}
				}
			}
		    
			else if((c == 'l' || c == 'n') && i < s.length() - 1) {
				if(s.charAt(i + 1) == 'j') {	// lj �Ǵ� nj �� ���
					i++;
				}
			}
		    
 
			else if((c == 's' || c == 'z') && i < s.length() - 1) {
				if(s.charAt(i + 1) == '=') {	// s= �Ǵ�z= �� ���
					i++;
				}
			
		    }
		    
			result++;
 
		}
 
		
		System.out.println(result);
	}
}
