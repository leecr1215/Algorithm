/*
 - 코스 요리 메뉴는 최소 2가지 이상의 단품메뉴
 - 최소 2명 이상의 손님이 주문한 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
 
key 로 A~Z 저장
value로 주문 개수 저장
 
*/

// key : A~Z , value : 주문 개수
let alphaMap = new Map();

function solution(orders, course) {
  let result = []; // 결과를 저장할 배열

  orders.map((order) => {
    course.map((num) => {
      let orderArr = order.split("").sort(); // 사전 순으로 정렬
      let picked = new Array(num).fill(0);
      combination(0, 0, num, orderArr, picked);
    });
  });

  const alphaArr = [...alphaMap];

  course.map((num) => {
    // 요리 num개 코스 모은 array
    const numArr = alphaArr.filter((alpha) => alpha[0].length == num);

    // 횟수 내림차순으로 정렬
    numArr.sort((a, b) => b[1] - a[1]);

    // 제일 많은 횟수를 가진 arr
    let max = 2;

    for (const [key, value] of numArr) {
      if (value >= max) {
        max = value;
        result.push(key);
      }
    }
  });

  return result.sort();
}

// cnt : 현재까지 뽑은 개수
// orderArr.length개 중에 num개 뽑기
function combination(start, cnt, num, orderArr, picked) {
  if (cnt == num) {
    // 해시 맵에 picked 넣기

    console.log(picked);
    const str = picked.join("");

    if (alphaMap.has(str)) {
      alphaMap.set(str, alphaMap.get(str) + 1);
    } else {
      alphaMap.set(str, 1);
    }
    return;
  }

  for (let i = start; i < orderArr.length; i++) {
    picked[cnt] = orderArr[i];
    combination(i + 1, cnt + 1, num, orderArr, picked);
  }
}
