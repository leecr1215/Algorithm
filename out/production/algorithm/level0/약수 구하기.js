function solution(n) {
  var answer = [];
  for (let i = 1; i <= parseInt(Math.sqrt(n)); i++) {
    if (n % i === 0) {
      answer.push(i);
      if (n / i != i) answer.push(n / i);
    }
  }
  return answer.sort((a, b) => a - b);
}
