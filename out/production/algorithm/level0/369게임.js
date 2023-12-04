function solution(order) {
  const arr = String(order).match(/['3','6','9']/g);
  return arr === null ? 0 : arr.length;
}
