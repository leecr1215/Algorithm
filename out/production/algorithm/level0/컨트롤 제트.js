function solution(s) {
  const arr = s.split(" ");
  let sum = 0;
  arr.map((str, idx) => {
    if (str !== "Z") {
      sum += Number(str);
    } else {
      sum -= arr[idx - 1];
    }
  });

  return sum;
}
