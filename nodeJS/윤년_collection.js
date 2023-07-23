const date = new Date();
const year = date.getFullYear();
const month = date.getMonth();

const test = (year) => {
  if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
    return 29;
  } else {
    return 28;
  }
};

var days = [31, test(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

console.log(days[month] + " days for " + year + "-" + (month + 1));
