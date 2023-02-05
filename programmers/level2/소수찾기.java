import java.util.HashSet;

public class 소수찾기 {
    public static HashSet<Integer> nums = new HashSet<>(); // 숫자조합 저장
    
	public int solution(String numbers) {
        // 만들 수 있는 수를 배열에 담고
        // 그 중에 소수의 개수 세기
		int count = 0;
		permutation("", numbers);
		while(nums.iterator().hasNext()) {
			int num = nums.iterator().next();
			nums.remove(num);
			if(isPrime(num)) count++;
		}
		
        return count;
    }
    
    public void permutation(String prefix, String str) {
    	int n = str.length();
    	if(!prefix.equals("")) {
    		nums.add(Integer.parseInt(prefix));
    	}
    	for(int i = 0; i < n; i++) {
    		permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n));
    	}
    }
    
    // 소수인지 판별
    public boolean isPrime(int num) {
    	if(num == 0 || num == 1) return false;
    	
    	for(int i = 2; i <= (int)Math.sqrt(num); i++) {
    		if(num % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
