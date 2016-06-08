SELECT df.order, ope.code, ope.name, mat.name, CONCAT(df.value, df.type) as value 
FROM detail_form df
INNER JOIN operations ope on df.operation_id = ope.id
INNER JOIN materials mat oN df.material_id = mat.id
WHERE form_id = 1
