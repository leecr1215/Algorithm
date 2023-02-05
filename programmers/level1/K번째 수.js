function solution(array, commands) {
  const answer = []; // 결과를 저장할 배열

  for (let i = 0; i < commands.length; i++) {
    const arr = array
      .slice(commands[i][0] - 1, commands[i][1])
      .sort((a, b) => a - b);
    answer.push(arr[commands[i][2] - 1]);
  }
  console.log([10, 9, 8].sort((a, b) => a - b));
  return answer;
}
