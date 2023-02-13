function solution(dots) {
  const leanArr = [];
  for (let i = 0; i < dots.length; i++) {
    for (let j = i + 1; j < dots.length; j++) {
      const curLean = (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
      if (leanArr.includes(curLean)) return 1;
      leanArr.push(curLean);
    }
  }
  return 0;
}
