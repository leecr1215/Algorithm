function solution(name, yearning, photo) {
  var answer = [];
  photo.forEach((tc) => {
    let sum = 0;
    tc.forEach((n) => {
      const index = name.findIndex((name) => name === n);
      if (index !== -1) {
        sum += yearning[index];
      }
    });
    answer.push(sum);
  });
  return answer;
}
