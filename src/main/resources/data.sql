insert into token (id, apikey,enabled) values(1,'12345',true);

insert into users ( id, email, enabled, expired, first_name, last_name, locked, mobile, password, role )
	values (1, 'bodrudduja@rokomari.com', true, false, 'Bodrudduja', 'Chowdhury', false, '0123456789', 'superadmin','ROLE_SUPERADMIN');

insert into users ( id, email, enabled, expired, first_name, last_name, locked, mobile, password, role )
	values (2, 'ariful@rokomari.com', true, false, 'Ariful', 'Amin', false, '0223456789', 'admin','ROLE_ADMIN');

insert into users ( id, email, enabled, expired, first_name, last_name, locked, mobile, password, role )
	values (3, 'habib@rokomari.com', true, false, 'Habib', 'Ullah', false, '0323456789', 'user','ROLE_USER');
