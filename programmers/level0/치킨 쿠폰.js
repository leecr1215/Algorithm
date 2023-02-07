function solution(chicken) {
  var answer = 0; // 서비스 치킨의 수
  while (chicken >= 10) {
    answer = answer + parseInt(chicken / 10);
    chicken = (chicken % 10) + parseInt(chicken / 10);
  }
  return answer;
}
