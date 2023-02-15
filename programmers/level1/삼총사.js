let answer = 0;
let N;
let collect = [0, 0, 0];
// N개 중 3개뽑기
// NC3

function solution(number) {
  N = number.length;
  combination(0, number, 0);
  return answer;
}

function combination(cnt, number, start) {
  if (cnt == 3) {
    sum = collect.reduce((acc, cur) => (acc += cur), 0);
    if (sum === 0) answer++;
    return;
  }

  for (let i = start; i < N; i++) {
    collect[cnt] = number[i];
    combination(cnt + 1, number, i + 1);
  }
}
