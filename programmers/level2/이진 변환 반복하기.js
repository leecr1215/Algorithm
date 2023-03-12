function solution(s) {
  let zeroCnt = 0; // 제거된 모든 0의 개수
  let binaryCnt = 0; // 이진 변환의 횟수

  while (s != "1") {
    const len = s.length; // 기존 s의 길이

    s = s.replaceAll("0", ""); // 0 제거
    zeroCnt += len - s.length; // 제거된 0 개수
    s = s.length.toString(2); // 길이를 2진법으로 변환
    binaryCnt++;
  }

  return [binaryCnt, zeroCnt];
}
