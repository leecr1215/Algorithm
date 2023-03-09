function solution(s, n) {
  const arr = s.split("");

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === " ") continue;

    let ascii = arr[i].charCodeAt(0);
    console.log(ascii);
    if (ascii >= 97) {
      // 소문자
      arr[i] = String.fromCharCode(
        ascii + n > 122 ? ascii + n - 26 : ascii + n
      );
    } else {
      // 대문자
      arr[i] = String.fromCharCode(ascii + n > 90 ? ascii + n - 26 : ascii + n);
    }
  }
  return arr.join("");
}
