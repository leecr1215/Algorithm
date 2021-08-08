package 문자열;

import java.util.Scanner;

public class 크로아티아_알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == 'c' && i < s.length() - 1) {			// 만약 ch 가 c 라면?
				//만약 ch 다음 문자가 '=' 또는 '-' 이라면?
				if(s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {		
					// i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
					i++;		
				}
				
			}
		    
			else if(c == 'd' && i < s.length() - 1) {
				if(s.charAt(i + 1) == '-') {	// d- 일 경우
						i++;
					}
				else if(s.charAt(i + 1) == 'z' && i < s.length() - 2) {
					
					if(s.charAt(i + 2) == '=') {	// dz= 일 경우
						i += 2;
					}
				}
			}
		    
			else if((c == 'l' || c == 'n') && i < s.length() - 1) {
				if(s.charAt(i + 1) == 'j') {	// lj 또는 nj 일 경우
					i++;
				}
			}
		    
 
			else if((c == 's' || c == 'z') && i < s.length() - 1) {
				if(s.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
					i++;
				}
			
		    }
		    
			result++;
 
		}
 
		
		System.out.println(result);
	}
}
