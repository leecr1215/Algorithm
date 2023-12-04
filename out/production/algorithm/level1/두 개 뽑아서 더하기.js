const arr = new Array(2).fill(0);
let answer = [];

function solution(numbers) {
  combination(0, 0, numbers);
  answer = answer.sort((a, b) => a - b);
  return [...new Set(answer)];
}

// numbers.length 중에 2개 뽑기
function combination(cnt, start, numbers) {
  if (cnt == 2) {
    let sum = 0;
    arr.map((n) => (sum += n));
    answer.push(sum);
    return;
  }

  for (let i = start; i < numbers.length; i++) {
    arr[cnt] = numbers[i];
    combination(cnt + 1, i + 1, numbers);
  }
}
