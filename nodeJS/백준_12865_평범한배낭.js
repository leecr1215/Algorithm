var fs = require("fs");
var filePath = __dirname + "/input.txt";
//var filePath = "/dev/stdin";

var input = fs.readFileSync(filePath).toString().trim().split("\n");

const NK = input[0].split(" ").map(Number);

const N = NK[0]; // 물건의 개수
const K = NK[1]; // 버틸 수 있는 무게

const weights = [0];
const values = [0];

let temp;
for (let i = 1; i < N + 1; i++) {
  temp = input[i].split(" ").map(Number);
  weights.push(temp[0]);
  values.push(temp[1]);
}

// dp[i][w]
// 버틸 수 있는 무게가 w일 때,
// 0~i까지의 물건을 이용해 만들 수 있는 최대가치
const dp = Array.from(Array(N + 1), () => Array(K + 1).fill(0));

// dp[i][w]?

// 현재 내 물건을 포함했을 때 가치?
// -> dp[i-1][w-내물건무게] + 내물건가치

// 현재 내 물건을 포함하지 않을 때의 가치?
// dp[i-1][w]

// 근데 만약 내 물건의 무게가 버틸 수 있는 무게보다 무거우면?
// dp[i-1][w]

for (let i = 1; i <= N; i++) {
  for (let w = 1; w <= K; w++) {
    // 내 물건 무게 > 버틸 수 있는 무게
    if (weights[i] > w) {
      dp[i][w] = dp[i - 1][w];
    } else {
      dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
    }
  }
}

console.log(dp[N][K]);
