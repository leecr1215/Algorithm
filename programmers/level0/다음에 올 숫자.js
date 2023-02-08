function solution(common) {
  let answer = common[common.length - 1];
  if (common[1] - common[0] === common[2] - common[1]) {
    // 등차수열
    answer += common[1] - common[0];
  } else {
    // 등비수열
    answer *= common[1] / common[0];
  }

  return answer;
}
