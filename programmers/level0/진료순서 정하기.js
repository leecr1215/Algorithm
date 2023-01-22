function solution(emergency) {
  const arr = [...emergency].sort((a, b) => {
    return b - a;
  });

  const dict = [];
  let important = 1;
  arr.map((num, idx) => dict.push([num, important++]));

  const answer = [];

  for (let i = 0; i < emergency.length; i++) {
    for (let j = 0; j < emergency.length; j++) {
      if (emergency[i] === dict[j][0]) {
        answer.push(dict[j][1]);
        break;
      }
    }
  }

  return answer;
}
