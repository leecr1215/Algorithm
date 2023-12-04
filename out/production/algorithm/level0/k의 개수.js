function solution(i, j, k) {
  let answer = 0;
  for (let t = i; t <= j; t++) {
    const arr = String(t)
      .split("")
      .filter((numStr) => parseInt(numStr) === k);
    answer += arr.length;
  }
  return answer;
}
