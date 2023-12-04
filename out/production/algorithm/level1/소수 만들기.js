let answer = 0;
const picked = Array(3).fill(0);

function solution(nums) {
  combination(0, 0, nums);

  return answer;
}

const combination = (cnt, start, nums) => {
  if (cnt == 3) {
    // 더한 값이 소수인지 판별
    let sum = picked.reduce((cur, acc) => (acc += cur), 0);
    if (isPrime(sum)) {
      // 소수면
      answer++;
    }
    return;
  }

  for (let i = start; i < nums.length; i++) {
    picked[cnt] = nums[i];
    combination(cnt + 1, i + 1, nums);
  }
};

const isPrime = (number) => {
  if (number === 2 || number === 3) return true;

  for (let i = 2; i <= Math.sqrt(number); i++) {
    if (number % i === 0) return false;
  }
  return true;
};
