package level2;

public class N개의최소공배수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,6,8,14}));
		
		System.out.println("========");
		
		System.out.println(solution(new int[] {1,2,3}));
	}
    public static int solution(int[] arr) {
    	
    	for(int i = 0; i < arr.length-1; i++) {
    		// i와 i+1과의 최소공배수 구하기
    		int gcd = getGcd(arr[i],arr[i+1]);
    		int lcm = lcm(arr[i],arr[i+1],gcd);
    		arr[i+1]=lcm;
    	}
    	
        int answer = arr[arr.length-1];
        return answer;
    }
    
    public static int getGcd(int a, int b) {
    	if(a%b==0) return b;
    	
    	return getGcd(b, a%b);
    }
    
    public static int lcm(int a, int b, int gcd) {
    	return a*b/gcd;
    }
}