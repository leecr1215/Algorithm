function solution(array, n) {
  const minus = array.map((element) => Math.abs(n - element));
  let min = Math.min(...minus);
  const solutionArr = [];
  minus.map((diff, idx) => {
    if (diff === min) solutionArr.push(array[idx]);
  });

  return Math.min(...solutionArr);
}
