// a의 부모를 찾음
const findSet = (parent, a) => {
  if (a === parent[a]) return a;
  return (parent[a] = findSet(parent, parent[a]));
};

// a와 b를 union
// b의 짱이 a의 짱 속으로 들어감
const union = (parent, a, b) => {
  const rootA = findSet(parent, a);
  const rootB = findSet(parent, b);

  if (rootA == rootB) return false;

  parent[rootB] = parent[rootA];

  return true;
};

// 최소 신장 트리
function solution(n, costs) {
  const parent = new Array(n).fill(0).map((_, idx) => idx); // 부모를 저장하는 배열

  // 비용이 적은 순으로 정렬
  costs.sort((a, b) => a[2] - b[2]);

  let result = 0;

  costs.forEach((cost) => {
    const node1 = cost[0];
    const node2 = cost[1];

    // 만약 부모가 다르면 union
    if (union(parent, node1, node2)) {
      result += cost[2];
    }
  });

  return result;
}
