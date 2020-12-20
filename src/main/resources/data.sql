INSERT INTO users(username, password, enabled) values('user', 'user123', true);
INSERT INTO users(username, password, enabled) values('admin', 'admin123', true);
INSERT INTO users(username, password, enabled) values('disabled', 'disabled', false);
--INSERT INTO users(username, password, enabled) values('disabled', 'disabled', true);

INSERT INTO authorities(username, authority) values ('user', 'ROLE_USER');
INSERT INTO authorities(username, authority) values ('admin', 'ROLE_ADMIN');
--INSERT INTO authorities(username, authority) values ('disabled', 'ROLE_ADMIN');