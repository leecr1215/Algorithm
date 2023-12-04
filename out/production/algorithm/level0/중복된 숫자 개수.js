function solution(array, n) {
  let count = 0;

  array.map((num) => (num == n ? count++ : null));

  return count;
}
