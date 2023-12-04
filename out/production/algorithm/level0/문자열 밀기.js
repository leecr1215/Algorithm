function solution(A, B) {
  const arr = [A];

  // 문자열 민 걸 arr에 저장
  // ["hello","elloh","llohe","lohel","ohell"]
  for (let i = 1; i < A.length; i++) {
    arr.push(arr[i - 1][A.length - 1] + arr[i - 1].substring(0, A.length - 1));
  }

  console.log(arr);

  const idx = arr.findIndex((num) => num === B);

  return idx;
  // return (B + B).indexOf(A);
}
