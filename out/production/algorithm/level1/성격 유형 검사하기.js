// choices
// 1~3이면 비동의 (점수 : 3 2 1)
// 4~6이면 동의 (점수 : 1 2 3)
function solution(survey, choices) {
  const types = { R: 0, T: 0, C: 0, F: 0, J: 0, M: 0, A: 0, N: 0 };
  let answer = "";

  for (let i = 0; i < choices.length; i++) {
    const [leftType, rightType] = survey[i].split("");
    const result = Math.abs(choices[i] - 4);
    if (choices[i] < 4) {
      // 비동의 : 왼쪽 타입
      types[leftType] += result;
    } else if (choices[i] > 4) {
      // 동의 : 오른쪽 타입
      types[rightType] += result;
    }
  }

  const type = Object.keys(types);

  for (let i = 0; i < type.length; i += 2) {
    const leftType = types[type[i]];
    const rightType = types[type[i + 1]];

    if (leftType >= rightType) {
      // 같거나 클 때는 왼쪽 요소
      answer += type[i];
    } else {
      // 작은 때는 오른쪽 요소
      answer += type[i + 1];
    }
  }
  return answer;
}
