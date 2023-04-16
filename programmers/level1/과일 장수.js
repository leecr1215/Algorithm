// 사과의 최대 점수 k
// 한 상자에 들어가는 사과 수 m
function solution(k, m, score) {
  let sum = 0;

  score.sort((a, b) => b - a);

  score.forEach((s, idx) => {
    if (idx % m === m - 1) sum += s;
  });

  // m이 3일때
  // 2, 5, 8...인덱스만 훑어야함
  // -> m으로 나눴을 때 나머지가 m-1

  return sum * m;
}
