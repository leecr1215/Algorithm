function solution(my_string, n) {
  var answer = "";
  var strArr = my_string.split("");
  strArr.map((str) => {
    for (var i = 0; i < n; i++) {
      answer += str;
    }
  });
  return answer;
}
