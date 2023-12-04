function solution(rsp) {
  const arr = rsp.split("");
  let answer = "";

  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === "2") {
      answer += "0";
    } else if (arr[i] === "0") {
      answer += "5";
    } else {
      answer += "2";
    }
  }

  return answer;
}
