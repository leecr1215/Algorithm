function solution(numbers) {
  var sum = numbers.reduce((acc, cur) => {
    return acc + cur;
  }, 0);

  return sum / numbers.length;
}
