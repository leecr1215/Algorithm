function solution(before, after) {
  let answer = 0;
  if (
    before.split("").sort().toString() === after.split("").sort().toString()
  ) {
    answer = 1;
  }
  return answer;
}
