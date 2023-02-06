function solution(babbling) {
  return babbling
    .map((_) => _.replace(/aya|ye|woo|ma/g, ""))
    .filter((str) => str === "").length;
}
