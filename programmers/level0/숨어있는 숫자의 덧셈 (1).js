function solution(my_string) {
  const numArr = my_string
    .match(/\d/g)
    .map((n) => Number(n))
    .reduce((acc, cur) => (acc += cur));
  return numArr;
}
