function solution(numbers, direction) {
  var answer = [];
  if (direction === "right") {
    answer = numbers.slice(0, numbers.length - 1);
    answer.unshift(numbers[numbers.length - 1]);
  } else {
    answer = numbers.slice(1);
    answer.push(numbers[0]);
  }
  return answer;
}

console.log(solution([1, 2, 3], "right"));
console.log(solution([4, 455, 6, 4, -1, 45, 6], "left"));
