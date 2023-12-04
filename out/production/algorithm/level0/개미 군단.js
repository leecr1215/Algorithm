function solution(hp) {
  let antCount = 0;
  let hh = hp;

  // 장군개미
  antCount += parseInt(hh / 5);
  hh = hh % 5;

  // 병정개미
  antCount += parseInt(hh / 3);
  hh = hh % 3;

  antCount += hh;

  return antCount;
}
