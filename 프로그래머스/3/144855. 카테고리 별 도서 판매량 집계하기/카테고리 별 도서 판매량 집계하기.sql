select
    CATEGORY, sum(sales) as TOTAL_SALES
from
    book_sales bs
        join book b on b.book_id = bs.book_id
where
    year(sales_date) = 2022
    and month(sales_date) = 1
group by 
    category 
order by 
    category asc