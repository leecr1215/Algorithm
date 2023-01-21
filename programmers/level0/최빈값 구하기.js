function solution(array) {
  counts = new Array(1001);
  counts.fill(0);
  array.map((num) => {
    counts[num]++;
  });

  max = Math.max(...counts);
  maxIndex = 0;
  countMax = 0;
  for (var i = 1; i < counts.length; i++) {
    if (counts[i] === max) {
      maxIndex = i;
      countMax++;
    }
    if (countMax > 1) {
      maxIndex = -1;
      break;
    }
  }
  return maxIndex;
}
