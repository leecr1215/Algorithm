function solution(lines) {
  // -100~100 => 0~200
  const counts = Array.from({ length: 201 }, () => 0);

  for (let i = 0; i < lines.length; i++) {
    for (let j = lines[i][0]; j < lines[i][1]; j++) {
      counts[j + 100]++;
    }
  }

  const answer = counts
    .filter((num) => num > 1)
    .reduce((acc, cur) => (acc += 1), 0);

  return answer;
}
