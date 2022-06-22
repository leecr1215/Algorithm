var fs = require("fs");

//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split("\n").map(Number);

var sumArr = [input[0]];

for (var i = 1; i < input.length; i++) {
  sumArr.push(sumArr[i - 1] + input[i]);
}

var minDiff = 100;
var score = sumArr[0];

console.log(sumArr.length);

for (var i = 0; i < sumArr.length; i++) {
  var minusValue = Math.abs(100 - sumArr[i]);
  if (minusValue <= minDiff) {
    minDiff = minusValue;
    score = sumArr[i];
  }
}

console.log(score);
