function solution(my_string) {
  const set = new Set(my_string.split(""));
  var answer = [...set];
  return answer.join().replaceAll(",", "");
}
