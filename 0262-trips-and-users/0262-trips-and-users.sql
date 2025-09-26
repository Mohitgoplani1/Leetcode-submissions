SELECT t.request_at AS Day,
       ROUND(SUM(IF(t.status != 'completed', 1, 0)) / COUNT(*), 2) AS "Cancellation Rate"
FROM Trips t
JOIN Users u 
      ON t.client_id = u.users_id AND u.banned = 'NO'
JOIN Users d 
      ON t.driver_id = d.users_id AND d.banned = 'NO'
WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at;
