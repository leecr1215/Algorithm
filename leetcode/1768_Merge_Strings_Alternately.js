/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function (word1, word2) {
  let words = "";

  const minLen = Math.min(word1.length, word2.length);

  // minLen 만큼은 번갈아 가면서
  for (let i = 0; i < minLen; i++) {
    words += word1[i] + word2[i];
  }

  // 나머지 긴 string은 붙이기
  words +=
    word1.length > word2.length ? word1.slice(minLen) : word2.slice(minLen);

  return words;
};
