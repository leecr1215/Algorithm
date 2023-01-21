function solution(slice, n) {
  var answer = 1; // 피자의 판수
  while (true) {
    if (answer * slice >= n) break;
    answer++;
  }
  return answer;
}
