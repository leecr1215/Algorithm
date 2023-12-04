function solution(array) {
  array.sort((a, b) => {
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
  });
  return array[parseInt(array.length / 2)];
}
