INSERT INTO regiones (id, name) VALUES (1, 'Sudamerica');
INSERT INTO regiones (id, name) VALUES (2, 'Centroamerica');
INSERT INTO regiones (id, name) VALUES (3, 'Norteamerica');
INSERT INTO regiones (id, name) VALUES (4, 'Europa');
INSERT INTO regiones (id, name) VALUES (5, 'Africa');
INSERT INTO regiones (id, name) VALUES (6, 'Asia');
INSERT INTO regiones (id, name) VALUES (7, 'Oceania');
INSERT INTO regiones (id, name) VALUES (8, 'Antartica');

INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(1, 'Diana', 'Centeno', 'diancha@gmail.com', '2018-01-01');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(3, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(3, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(3, 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(8, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(7, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(6, 'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(5, 'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (regiones_id, name, last_name, email, create_at) VALUES(4, 'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

INSERT INTO users (username, password, enabled, name, last_name) VALUES ('andres','$2a$10$D8TBvOG6lLMUd7menDJGTeM3sWspz7np2HRRIJKm2nzjRAwBHhdGW',1,'Andres Williams','Joe Dans');
INSERT INTO users (username, password, enabled, name, last_name) VALUES ('admin','$2a$10$mGyC0.51xU0Mv/e6Kv0dGuZiFHn4yLnjHzPEE0GIj.OqEFq1lQOiO',1,'Antony','Velasquez');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 1);