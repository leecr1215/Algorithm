function solution(polynomial) {
  const arr = polynomial.split(" ");
  let xCount = 0;
  let num = 0;

  arr.map((n) => {
    if (n.includes("x")) {
      const temp = n.split("x");

      if (temp[0] === "") {
        xCount++;
      } else {
        xCount += parseInt(temp[0]);
      }
    } else {
      if (n != "+") num += parseInt(n);
    }
  });

  var answer = "";
  if (xCount === 1) {
    answer += "x";
  } else if (xCount > 1) {
    answer = xCount + "x";
  }

  if (num !== 0) {
    if (answer !== "") answer += " + ";
    answer += num;
  }

  return String(answer);
}
