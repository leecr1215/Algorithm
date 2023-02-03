function solution(numbers) {
  // 젤 작은 값 2개 곱 or 젤 큰 값 2개 곱
  numbers.sort((a, b) => a - b);
  return Math.max(
    numbers[0] * numbers[1],
    numbers[numbers.length - 1] * numbers[numbers.length - 2]
  );
}
