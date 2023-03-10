function solution(A, B) {
  // A는 오름차순, B는 내림차순으로 정렬
  A.sort((a, b) => a - b);
  B.sort((a, b) => b - a);

  return A.reduce((acc, cur, idx) => acc + cur * B[idx], 0);
}
