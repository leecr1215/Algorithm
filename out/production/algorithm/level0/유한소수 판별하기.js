function solution(a, b) {
  // 둘의 최대 공약수로 나눠서 기약 분수 만들기
  // 분모가 1이면 정수이므로 유한소수 -> 1 리턴
  // 분모의 소인수 구해서 2나 5가 있으면 1 리턴
  const gcd = (a, b) => (a % b === 0 ? b : gcd(b, a % b));
  let gcdAB = gcd(a, b);

  a = a / gcdAB;
  b = b / gcdAB;

  if (b === 1) return 1;

  for (let i = 2; i <= b; i++) {
    // 소인수지만 2,5 가 아닐때
    if (b % i === 0 && isPrime(i) && i !== 2 && i !== 5) {
      return 2;
    }
  }

  return 1;
}

function isPrime(num) {
  if (num === 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}
