function solution(spell, dic) {
  let answer = 2;

  dic.map((word) => {
    let check = true;
    spell.map((char) => {
      if (!word.includes(char)) {
        check = false;
        console.log(word, char);
      }
    });

    if (check === true) {
      answer = 1;
    }
  });

  return answer;
}
