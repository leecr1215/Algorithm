function solution(age) {
  var answer = "";
  let arr = String(age).split("");
  arr.map((num, idx) => {
    arr[idx] = String.fromCharCode(Number(num) + 97);
  });

  return arr.join("");
}
