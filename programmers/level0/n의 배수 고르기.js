function solution(n, numlist) {
  const arr = numlist.filter((num) => num % n === 0);
  return arr;
}
