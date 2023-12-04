const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input = [line];
}).on("close", function () {
  str = input[0];
  const newStr = str
    .split("")
    .map((s) => {
      if (s === s.toUpperCase()) {
        // s가 대문자인 경우
        return s.toLowerCase();
      } else {
        return s.toUpperCase();
      }
    })
    .join("");
  console.log(newStr);
});
