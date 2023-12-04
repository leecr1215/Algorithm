function solution(M, N) {
  /*
    가로로 n-1만큼 자르고,
    세로로 n*(m-1) 만큼 자른다.
    n-1 + n*(m-1) = nm -1
    */

  return N * M - 1;
}
