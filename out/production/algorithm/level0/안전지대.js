function solution(board) {
  // 상, 하, 좌, 우, 오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위
  const dx = [-1, 1, 0, 0, -1, 1, 1, -1];
  const dy = [0, 0, -1, 1, 1, 1, -1, -1];
  const n = board.length;
  const visited = Array.from(Array(n), () => Array(n).fill(0));

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 1) {
        visited[i][j] = 1;
        for (let k = 0; k < 8; k++) {
          const nx = i + dx[k];
          const ny = j + dy[k];
          if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] === 0) {
            visited[nx][ny] = 1;
          }
        }
      }
    }
  }

  let count = 0;
  // 안전 지역 칸수 (0의 개수) 세기
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (visited[i][j] === 0) {
        count++;
      }
    }
  }

  return count;
}
