function solution(array) {
  max = Math.max(...array);
  return [max, array.findIndex((num) => num === max)];
}
