-- AVAILABILITY
-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시
-- 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'
-- 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시
-- 자동차 ID와 AVAILABILITY 리스트를 출력

# SELECT h.CAR_ID, IF(
#     DATE_FORMAT(h.START_DATE, '%Y-%m%d') <= '2022-10-16'
#     AND DATE_FORMAT(h.END_DATE, '%Y-%m%d') >= '2022-10-16'
#     , '대여 중', '대여 가능') AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
# GROUP BY h.CAR_ID
# ORDER BY h.CAR_ID;

SELECT
    CAR_ID,
    -- 3. '대여중' 상태(1)가 그룹 내에 하나라도 있었다면(MAX=1) '대여중'을,
    --    아니라면 '대여 가능'을 반환합니다.
    IF(MAX(
        -- 2. 2022년 10월 16일이 대여 기간에 포함되면 1, 아니면 0을 반환
        IF('2022-10-16' BETWEEN START_DATE AND END_DATE, 1, 0)
    ) = 1, '대여중', '대여 가능') AS AVAILABILITY
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- 1. WHERE 절 없이 모든 기록을 가져와 CAR_ID 별로 그룹화
GROUP BY
    CAR_ID
ORDER BY
    CAR_ID DESC; -- (보통 이 문제는 DESC로 정렬해야 통과됩니다)