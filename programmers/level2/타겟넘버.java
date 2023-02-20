class 타겟넘버 {
    static int result;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return result;
    }
    
    public void dfs(int cnt, int[] numbers, int target, int sum){
        if(cnt == numbers.length){ // numbers를 다 돌았을 때
            if(sum == target){ // 전체 합이 target과 같다면
                result++; // 방법의 개수++
            }    
            return;
        }
        
        dfs(cnt + 1, numbers, target, sum + numbers[cnt]);
        dfs(cnt + 1, numbers, target, sum - numbers[cnt]);
        
    }
}