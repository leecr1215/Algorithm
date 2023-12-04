function solution(n, arr1, arr2) {
  const answer = [];

  for (let i = 0; i < n; i++) {
    const s = (arr1[i] | arr2[i]).toString(2);
    answer.push("0".repeat(n - s.length) + s);
  }
  return answer
    .map((str) => str.replaceAll(/1/gi, "#"))
    .map((str) => str.replaceAll(/0/gi, " "));
}
