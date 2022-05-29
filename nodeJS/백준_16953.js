var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split(" ");

var A = parseInt(input[0]);
var B = parseInt(input[1]);

var cnt = 1;
var check = true;

/* 풀이방법
문제는 A->B지만, 풀이는 B->A를 만들 수 있는가로 생각.
B에서 2로 나누어 떨어지면 B를 2로 나누고 다시 B에 저장한 뒤cnt를 1 늘린다.
B에서 맨 뒤가 1이면 B에서 맨 뒤인 1을 제거하고 다시 B에 저장한 뒤 cnt를 1 늘린다.
2로 나눠지면서 맨 뒤가 1인 수는 없으므로 if, else if를 사용.

만약 B가 2로도 안 나누어 떨어지고 맨 뒤가 1도 아니면 절대 A가 될 수 없다.
따라서 바로 break하고 check를 false로 변경한다. 

while문이 끝나고, 최종적으로 A와 B가 같은지 비교해서 다르면 B로부터 A가 안 만들어 진 것이므로, 
check를 false로 변경한다. 

*/

while (B > A) {
  if (B % 2 == 0) {
    B = B / 2;
    cnt += 1;
  } else if (B.toString().charAt(B.toString().length - 1) === "1") {
    const temp = B.toString().substring(0, B.toString().length - 1);
    B = parseInt(temp);
    cnt += 1;
  } else {
    check = false;
    break;
  }
}

if (B != A) {
  check = false;
}

if (check == false) {
  console.log(-1);
} else {
  console.log(cnt);
}
