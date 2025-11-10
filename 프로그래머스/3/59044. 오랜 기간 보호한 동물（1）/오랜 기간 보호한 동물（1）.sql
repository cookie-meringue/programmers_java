-- 코드를 입력하세요
-- limit 3
-- out 에 없는 in의 모든 동물을 날짜순으로 정렬 후 3개만 가져온다.
SELECT ai.NAME, ai.DATETIME
FROM ANIMAL_INS ai
WHERE ai.ANIMAL_ID NOT IN (
    SELECT ANIMAL_ID
    FROM ANIMAL_OUTS
)



-- JOIN ANIMAL_OUTS ao ON ai.ANIMAL_ID != ao.ANIMAL_ID
ORDER BY ai.DATETIME
LIMIT 3;