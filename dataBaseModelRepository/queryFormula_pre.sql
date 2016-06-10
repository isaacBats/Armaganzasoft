SELECT m.tipo, CONCAT(df.value, df.type) as porcentaje, '10%' as teorico 
FROM detail_form df 
INNER JOIN materials m ON df.material_id = m.id 
WHERE df.form_id = 1;