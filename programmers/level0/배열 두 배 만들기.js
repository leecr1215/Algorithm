function solution(numbers) {
  var answer = numbers.reduce((arr, cur) => {
    arr.push(cur * 2);
    return arr;
  }, []);
  return answer;
}
