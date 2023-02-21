function solution(n) {
  let three = n.toString(3);
  return parseInt(three.split("").reverse().join(""), 3);
}
