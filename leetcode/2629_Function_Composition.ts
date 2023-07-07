type F = (x: number) => number;

function compose(functions: F[]): F {
  return function (x) {
    let result = x;

    if (functions.length !== 0) {
      functions.reverse().forEach((f) => {
        result = f(result);
      });
    }

    return result;
  };
}

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
