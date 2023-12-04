function solution(numbers, k) {
  var target = (k - 1) * 2;
  return numbers[target % numbers.length];
}
