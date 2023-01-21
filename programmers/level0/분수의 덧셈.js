function solution(numer1, denom1, numer2, denom2) {
  let denom = denom1 * denom2;
  let num = numer1 * denom2 + numer2 * denom1;

  let gcd = getGcd(denom, num);

  return [num / gcd, denom / gcd];
}

function getGcd(num1, num2) {
  if (num1 % num2 === 0) {
    return num2;
  }
  return getGcd(num2, num1 % num2);
}
