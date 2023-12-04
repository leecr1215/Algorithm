function solution(n) {
  var answer = 0;
  for (let i = 1; i <= n; i++) {
    if (n < factorial(i)) {
      answer = i - 1;
      break;
    }
    if (n === factorial(i)) {
      answer = i;
      break;
    }
  }
  return answer;
}

function factorial(n) {
  let result = 1;
  for (let i = 2; i <= n; i++) {
    result *= i;
  }
  return result;
}
