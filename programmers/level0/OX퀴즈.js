function solution(quiz) {
  let answer = [];
  quiz.map((q) => {
    const arr = q.split(" ");
    let result = Number(arr[0]);
    const quizAnswer = Number(arr[arr.length - 1]);
    for (let i = 1; i < arr.length - 2; i += 2) {
      if (arr[i] === "-") {
        result -= Number(arr[i + 1]);
      } else {
        // + 연산자
        result += Number(arr[i + 1]);
      }
    }
    result === quizAnswer ? answer.push("O") : answer.push("X");
  });
  return answer;
}
