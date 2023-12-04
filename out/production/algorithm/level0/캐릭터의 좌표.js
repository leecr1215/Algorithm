function solution(keyinput, board) {
  const lr_max = parseInt(board[0] / 2);
  const ud_max = parseInt(board[1] / 2);
  const answer = [0, 0];

  keyinput.map((key) => {
    if (key === "left") {
      if (answer[0] - 1 >= lr_max * -1) {
        answer[0] -= 1;
      }
    } else if (key === "right") {
      if (answer[0] + 1 <= lr_max) {
        answer[0] += 1;
      }
    } else if (key === "up") {
      if (answer[1] + 1 <= ud_max) {
        answer[1] += 1;
      }
    } else {
      if (answer[1] - 1 >= ud_max * -1) {
        answer[1] -= 1;
      }
    }
  });

  answer[0] =
    answer[0] >= lr_max
      ? lr_max
      : answer[0] <= lr_max * -1
      ? lr_max * -1
      : answer[0];
  answer[1] =
    answer[1] >= ud_max
      ? ud_max
      : answer[1] <= ud_max * -1
      ? ud_max * -1
      : answer[1];
  return answer;
}
