SELECT 
	o.date_issue AS 'fecha',
	o.quantity AS 'cantidad_orden', 
	CONCAT(c.name, ' ', c.last_name ) AS 'cliente', 
	c.address AS 'direccion', 
	c.movil AS 'telefono', 
	c.rfc AS 'rfc', 
	( SELECT name FROM forms WHERE id = do.form_id ) AS 'formula',
	( SELECT id FROM forms WHERE id = do.form_id ) AS 'id_formula', 
	do.id AS 'id_detalle',
	p.contact AS 'contacto_entrega', 
	p.mobil AS 'telefono_entrega', 
	p.address AS 'direccion_entrega',
	p.value AS 'cantidad_parcial',
	r.num_remision AS 'remision'
FROM orders o
INNER JOIN customers c ON o.costumer_id = c.id
INNER JOIN detail_orders do ON do.order_id = o.id
INNER JOIN partitions p ON p.detail_order_id = do.id
INNER JOIN remission r ON o.remission_id = r.id
WHERE o.num_orden = 'MX-00000023';
