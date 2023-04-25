/**
 * @return {Generator<number>}
 */
var fibGenerator = function* () {
  const fibo = [0, 1];
  for (let i = 2; i <= 51; i++) {
    fibo.push(fibo[i - 2] + fibo[i - 1]);
    yield fibo[i - 2];
  }
};

/**
 * 다른 사람 코드
 *  
var fibGenerator = function*() {
  let a = 0
  let b = 1

  while (true) {
    yield a;
    [a, b] = [b, a + b]
  }
};
 */

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
