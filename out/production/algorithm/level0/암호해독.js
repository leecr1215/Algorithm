function solution(cipher, code) {
  return [...cipher].filter((alpha, idx) => (idx + 1) % code === 0).join("");
}
