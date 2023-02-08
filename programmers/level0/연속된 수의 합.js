function solution(num, total) {
  const arr = [];
  let sum = 0;

  if (num % 2 === 0) {
    // 짝수

    let left = parseInt(total / num);
    let right = parseInt(total / num + 1);
    sum += left + right;

    arr.push(left);
    arr.push(right);

    while (true) {
      if (sum == total && arr.length == num) break;
      left--;
      right++;
      sum += left + right;
      arr.push(left);
      arr.push(right);
    }
  } else {
    let left = total / num;
    let right = total / num;
    sum += left;

    arr.push(left);
    while (true) {
      if (sum == total && arr.length == num) break;
      left--;
      right++;
      sum += left + right;

      arr.push(left);
      arr.push(right);
    }
  }
  return arr.sort((a, b) => a - b);
}
