function solution(X, Y) {
  const xNums = new Array(10).fill(0); // X에 있는 숫자의 각 개수 세기
  const yNums = new Array(10).fill(0);

  let common = []; // 공통된 숫자 저장할 배열

  X.split("").forEach((x) => xNums[x]++);
  Y.split("").forEach((y) => yNums[y]++);

  for (let i = 0; i < 10; i++) {
    const min = Math.min(xNums[i], yNums[i]);
    for (let j = 0; j < min; j++) {
      common.push(i);
    }
  }

  // common으로 만들 수 있는 조합 중 가장 큰 조합
  // 내림차순 정렬
  common.sort((a, b) => b - a);

  if (common.length === 0) return "-1";
  if (common[0] === 0) return "0";

  return common.join("");
}
