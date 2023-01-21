function solution(n) {
  const pizza = 7;
  var answer = 1;

  while (true) {
    if (pizza * answer >= n) {
      break;
    } else {
      answer++;
    }
  }
  return answer;
}
