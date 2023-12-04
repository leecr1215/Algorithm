function solution(k, score) {
  var answer = []; // 발표 점수 저장
  const arr = []; // 명예의 전당 저장 (크기는 k)

  for (let i = 0; i < Math.min(k, score.length); i++) {
    arr.push(score[i]);
    answer.push(Math.min(...arr));
  }

  arr.sort((a, b) => a - b); // 내림차순 정렬

  for (let i = k; i < score.length; i++) {
    const temp = arr.shift();
    if (score[i] > temp) {
      arr.push(score[i]);
    } else {
      arr.push(temp);
    }

    arr.sort((a, b) => a - b); // 내림차순 정렬

    answer.push(Math.min(...arr));
  }

  return answer;
}
