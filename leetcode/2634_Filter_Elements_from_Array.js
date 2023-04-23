/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
  const result = [];
  arr.forEach((n, idx) => {
    if (fn(n, idx)) result.push(n);
  });
  return result;
};
