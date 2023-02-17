function solution(n) {
  let answer = 0;
  const arr = new Array(n + 1).fill(true); // 초깃값 설정
  const end = Math.sqrt(n);

  for (let i = 2; i <= end; ++i) {
    // 이미 소수가 아닌 인덱스는 건너뛴다.
    if (!arr[i]) continue;

    // 소수가 아닌 데이터는 false로 입력한다.
    for (let k = i * 2; k <= n; k += i) {
      arr[k] = false;
    }
  }

  // 소수의 갯수를 구한다.
  for (let i = 2; i <= n; ++i) {
    if (arr[i]) answer++;
  }
  return answer;
}
