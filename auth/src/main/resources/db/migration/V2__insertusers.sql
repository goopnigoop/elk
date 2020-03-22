INSERT INTO app_user (id, password, username) VALUES (1, '$2a$07$cg2zygjMovilY24BQ4o5TuiBKbL/FPSXEnywntlSAeg73iYjFkeEe', 'admin');
INSERT INTO authority (id, authority_name) VALUES (1, 'ADMIN');
INSERT INTO authority (id, authority_name) VALUES (2, 'USER');
INSERT INTO user_authorities (user_id, authority_id) VALUES (1, 1);