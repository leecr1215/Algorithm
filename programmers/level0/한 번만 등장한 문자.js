function solution(s) {
  const counts = Array(26).fill(0);
  s.split("").map((char) => counts[char.charCodeAt(0) - 97]++);

  const solutionArr = [];
  counts.map((count, idx) => {
    if (count === 1) {
      solutionArr.push(String.fromCharCode(97 + idx));
    }
  });
  return solutionArr.join("");
}
