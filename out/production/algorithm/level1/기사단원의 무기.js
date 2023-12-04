function solution(number, limit, power) {
  const factorCounts = []; // 약수의 개수를 저장할 배열

  const getFactorCount = (num) => {
    // num의 약수의 개수 return
    let cnt = 0;
    for (let i = 0; i <= Math.sqrt(num); i++) {
      if (num % i === 0) cnt += 2;
      if (num / i === i) cnt--;
    }
    return cnt;
  };

  for (let i = 1; i <= number; i++) {
    const cnt = getFactorCount(i);
    cnt > limit ? factorCounts.push(power) : factorCounts.push(cnt);
  }

  return factorCounts.reduce((acc, cur) => acc + cur, 0);
}
