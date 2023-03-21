function solution(people, limit) {
    // people 오름차순 정렬
    people.sort((a,b)=>a-b);
    
    let startIdx = 0;
    let endIdx = people.length-1;
    
    let cnt = 0;
    
    while(startIdx <= endIdx){
        if(people[startIdx]+people[endIdx] <= limit){
            // 둘이 같이 탈 수 있음
            cnt++;
            startIdx++;
            endIdx -= 1;
        }else{
            // 둘이 같이 탈 수 없음 -> 무거운 사람은 하나의 보트로
            cnt++;
            endIdx -= 1;
        }
    }
    
    
    return cnt;
}