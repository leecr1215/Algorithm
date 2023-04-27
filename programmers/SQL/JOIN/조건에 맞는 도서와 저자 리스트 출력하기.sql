-- 코드를 입력하세요
SELECT book_id, author_name, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
from book inner join author
on book.author_id = author.author_id
where book.category = '경제'
order by published_date;