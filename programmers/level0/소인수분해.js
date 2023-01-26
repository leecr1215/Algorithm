function solution(n) {
  // 10000 이하의 소수 배열에 저장
  const arr = prime(n);
  const answer = [];
  let num = n;

  for (let i = 0; i < arr.length; i++) {
    if (num % arr[i] === 0) {
      answer.push(arr[i]);
      num = num / arr[i];
    }
  }

  return answer;
}

function prime(n) {
  const arr = [];
  for (let i = 2; i <= n; i++) {
    if (isPrime(i)) arr.push(i);
  }
  return arr;
}

function isPrime(n) {
  if (n === 2) return true;
  for (let i = 2; i <= parseInt(Math.sqrt(n)); i++) {
    if (n % i === 0) {
      return false;
    }
  }
  return true;
}
