function solution(dots) {
  const x_dots = [];
  const y_dots = [];

  for (let i = 0; i < dots.length; i++) {
    x_dots.push(dots[i][0]);
    y_dots.push(dots[i][1]);
  }

  return (
    (Math.max(...x_dots) - Math.min(...x_dots)) *
    (Math.max(...y_dots) - Math.min(...y_dots))
  );
}
