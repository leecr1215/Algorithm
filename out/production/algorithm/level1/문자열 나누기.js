function solution(s) {
  let answer = 0; // 분해할 문자열의 개수

  while (s.length !== 0) {
    let x = 0;
    let notX = 0;
    let i; // idx

    for (i = 0; i < s.length; i++) {
      if (s[0] == s[i]) {
        x++;
      } else {
        notX++;
      }
      if (x == notX) {
        break;
      }
    }
    s = s.substring(i + 1);
    answer++;
  }

  return answer;
}
