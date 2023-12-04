function solution(s) {
  const stack = [];
  let idx = 0;

  while (idx < s.length) {
    if (stack.length !== 0 && stack[stack.length - 1] === s[idx]) {
      // 스택이 비지 않고 현재 스택에 top에 있는 값이 s[idx]와 같을 때
      stack.pop();
      idx++;
    } else {
      // 스택이 비었거나 현재 스택에 top에 있는 값이 s[idx]와 같지 않을 때
      stack.push(s[idx++]);
    }
  }

  // 스택이 비었다면 짝지어 제거 가능
  return stack.length == 0 ? 1 : 0;
}
