SELECT product_name
FROM CUSTOMERS c
    INNER JOIN ORDERS o
        ON c.id = o.customer_id
WHERE name = :name