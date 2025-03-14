
INSERT INTO public.bank_user(email, name, password, phone, role) VALUES ('u201723834@upc.edu.pe', 'Christian Enrique Delgado Sanchez', 'intibank', '956254710', 'USER');
INSERT INTO public.bank_user(email, name, password, phone, role) VALUES ('u202326224@upc.edu.pe', 'Luis Felipe Huaranca Berrospi', 'intibank', '967807471', 'USER');
INSERT INTO public.bank_user(email, name, password, phone, role) VALUES ('u20231d758@upc.edu.pe', 'Yerson Santiago Peralta Pastor', 'intibank', '939675806', 'USER');
INSERT INTO public.bank_user(email, name, password, phone, role) VALUES ('u202324341@upc.edu.pe', 'Wilmer Andres Quispe Gomez', 'intibank', '942736232', 'USER');

INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-4567890123','641',12500.50, 1);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-3210987654','312',2500.50, 1);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-4455667788','435',500.50, 1);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-5544332211','632',8500.50, 1);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-5690125678','451',15400.50, 2);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-1235623456','765',11500.50, 2);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-6789678901','351',8500.50, 2);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-0987098765','513',5500.50, 2);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-2345643457','643',16500.50, 3);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-7801659012','532',1100.50, 3);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-3456784568','422',1200.50, 3);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-8901234562','166',450.50, 3);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-7870123464','577',17500.50, 4);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-9872951712','775',11000.50, 4);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-6238723788','436',6500.50, 4);
INSERT INTO public.account(card_number, cvv, balance, user_id) VALUES ('0011-0814-8712873282','175',850.50, 4);

INSERT INTO public.tbl_tipo_servicio (nombre_servicio) VALUES ('Recibo de servicio');
INSERT INTO public.tbl_tipo_servicio (nombre_servicio) VALUES ('Telefonía móvil');
INSERT INTO public.tbl_tipo_servicio (nombre_servicio) VALUES ('Tarjeta de crédito');

INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Entel');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Luz del Sur');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Plus');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Sedapal');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Claro');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Movistar');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Win');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Wow');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Fiberlux');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Fiberline');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Fiberpro');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (1, 'Internet Nubyx');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (2, 'Claro Telefonía');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (2, 'Movistar Telefonía');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (2, 'Entel Telefonía');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (2, 'Bitel Telefonía');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta BBVA');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta CMR Banco Falabella');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta Interbank');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta Scotiabank');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta BCP');
INSERT INTO public.tbl_proveedor_servicio (id_tiposervicio, nombre_proveedor) VALUES (3, 'Tarjeta Banbif');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,1,'SUM-00001','2025-01-15','2025-02-14',69.90,'Atrasado');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,1,'SUM-00002','2025-02-15','2025-03-14',69.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,1,'SUM-00003','2025-03-15','2025-04-14',69.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,4,'SUM-00011','2025-01-10','2025-02-09',110.90,'Atrasado');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,4,'SUM-00012','2025-02-10','2025-03-09',110.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,4,'SUM-00013','2025-02-10','2025-04-09',110.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,5,'SUM-00021','2025-01-05','2025-02-04',190.90,'Pagado');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,5,'SUM-00022','2025-02-05','2025-03-04',190.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,5,'SUM-00023','2025-02-05','2025-04-04',190.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,14,'956254710','2025-01-25','2025-02-24',89.90,'Pagado');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,14,'956254710','2025-02-25','2025-03-24',89.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,14,'956254710','2025-02-25','2025-04-24',89.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,17,'CUOTA 01','2025-01-08','2025-02-07',120.50,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,17,'CUOTA 02','2025-02-08','2025-03-07',120.50,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,17,'CUOTA 03','2025-03-08','2025-04-07',120.50,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,17,'CUOTA 04','2025-04-08','2025-05-07',120.50,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,17,'CUOTA 05','2025-05-08','2025-06-07',120.50,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,18,'CUOTA 01','2025-01-13','2025-02-12',30.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,18,'CUOTA 02','2025-02-13','2025-03-12',30.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,18,'CUOTA 03','2025-03-13','2025-04-12',30.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,18,'CUOTA 04','2025-04-13','2025-05-12',30.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,18,'CUOTA 05','2025-05-13','2025-06-12',30.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,19,'CUOTA 01','2025-01-24','2025-02-23',45.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,19,'CUOTA 02','2025-02-24','2025-03-23',45.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,19,'CUOTA 03','2025-03-24','2025-04-23',45.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,19,'CUOTA 04','2025-04-24','2025-05-23',45.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,19,'CUOTA 05','2025-05-24','2025-06-23',45.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,20,'CUOTA 01','2025-01-03','2025-02-02',149.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,20,'CUOTA 02','2025-02-03','2025-03-02',149.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,20,'CUOTA 03','2025-03-03','2025-04-02',149.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,20,'CUOTA 04','2025-04-03','2025-05-02',149.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,20,'CUOTA 05','2025-05-03','2025-06-02',149.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,21,'CUOTA 01','2025-01-11','2025-02-10',549.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,21,'CUOTA 02','2025-02-11','2025-03-10',549.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,21,'CUOTA 03','2025-03-11','2025-04-10',549.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,21,'CUOTA 04','2025-04-11','2025-05-10',549.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,21,'CUOTA 05','2025-05-11','2025-06-10',549.90,'Pendiente');

INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,22,'CUOTA 01','2025-01-16','2025-02-15',740.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,22,'CUOTA 02','2025-02-16','2025-03-15',740.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,22,'CUOTA 03','2025-03-16','2025-04-15',740.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,22,'CUOTA 04','2025-04-16','2025-05-15',740.90,'Pendiente');
INSERT INTO public.tbl_recibo (id_user, id_proveedor, numero_suministro, fecha_emision, fecha_vencimiento, monto, estado_pago) VALUES (1,22,'CUOTA 05','2025-05-16','2025-06-15',740.90,'Pendiente');




INSERT INTO transaction (id, amount, notes, timestamp, type, account_id)
VALUES
    (1, 100.00, 'Depósito inicial', '2025-03-10 08:30:00', 'DEPOSIT', 9),
    (2, 50.00, 'Transferencia a cuenta 10', '2025-03-11 10:15:00', 'TRANSFER', 9),
    (3, 50.00, 'Recepción de transferencia desde cuenta 9', '2025-03-11 10:16:00', 'TRANSFER', 10),
    (4, 20.00, 'Retiro en cajero', '2025-03-12 14:00:00', 'WITHDRAW', 11),
    (5, 30.00, 'Transferencia a cuenta 12', '2025-03-13 09:45:00', 'TRANSFER', 11),
    (6, 30.00, 'Recepción de transferencia desde cuenta 11', '2025-03-13 09:46:00', 'TRANSFER', 12),
    (7, 200.00, 'Depósito en sucursal', '2025-03-14 11:30:00', 'DEPOSIT', 10);
