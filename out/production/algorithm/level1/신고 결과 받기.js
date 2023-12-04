function solution(id_list, report, k) {
  const reports = [...new Set(report)].map((a) => a.split(" "));
  const counts = new Map(); // 각 id 별 신고 당한 횟수 저장

  for (const report of reports) {
    counts.set(report[1], counts.get(report[1]) + 1 || 1);
  }

  const email = new Map(); // 각 id별로 받는 처리 결과 메일 개수 저장

  for (const report of reports) {
    if (counts.get(report[1]) >= k) {
      email.set(report[0], email.get(report[0]) + 1 || 1);
    }
  }

  const answer = id_list.map((id) => email.get(id) || 0);

  return answer;
}
