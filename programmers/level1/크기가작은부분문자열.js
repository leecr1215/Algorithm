function solution(t, p) {
  let count = 0;
  const p_len = p.length;
  for (let i = 0; i < t.length - p_len + 1; i++) {
    if (parseInt(t.substring(i, i + p_len)) <= parseInt(p)) count++;
  }

  return count;
}
