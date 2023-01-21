function solution(my_string, letter) {
  let arr = my_string.split("");

  arr = arr.filter((char) => char !== letter);
  return arr.join("");
}
