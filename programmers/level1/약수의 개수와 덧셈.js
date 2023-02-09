function solution(left, right) {
  let answer = 0;
  // left 부터 right 까지의 수들의 약수 개수 구하기
  for (let i = left; i <= right; i++) {
    let count = 0; // i의 약수 개수를 저장

    // j는 1부터 i의 제곱근까지의 수
    // j가 i의 약수인지 확인
    for (let j = 1; j <= Math.sqrt(i); j++) {
      if (i % j === 0) {
        // i가 j로 나누어 떨어지면 약수이다.
        count++;
        if (i / j != j) count++; // i = 25, j = 5의 경우 5를 2번 세면 안됨.
      }
    }
    // 약수의 개수가 짝수면 더하고 홀수면 빼기
    count % 2 === 0 ? (answer += i) : (answer -= i);
  }
  return answer;
}
