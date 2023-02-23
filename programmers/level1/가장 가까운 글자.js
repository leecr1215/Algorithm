function solution(s) {
  const answer = [];
  for (let i = 0; i < s.length; i++) {
    let target = s[i];
    let temp = -1;

    for (let j = 0; j < i; j++) {
      if (target == s[j]) {
        temp = i - j;
      }
    }

    answer.push(temp);
  }

  return answer;
}
