function solution(sides) {
  let max = Math.max(...sides);
  let min = Math.min(...sides);
  let count = 0;
  // 가장 긴 변이 max일때(sides 중 긴 num)
  for (let i = max - min + 1; i <= max; i++) {
    count++;
  }

  // 새로 들어올 값이 제일 긴 변일 때
  for (let i = max + 1; i < max + min; i++) {
    count++;
  }

  return count;
}
