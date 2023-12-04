function solution(num_list) {
  var odd = 0;
  var even = 0;
  num_list.map((num) => (num % 2 === 0 ? even++ : odd++));
  return [even, odd];
}
