insert into customer_status values (1, 'Alive');
insert into customer_status values (2, 'On hold');
insert into customer_status values (3, 'Terminated');

insert into CUSTOMER (id, name, status_id) values (1000, 'Dablist', 3);
insert into CUSTOMER (id, name, status_id) values (1001, 'Jaxnation', 2);
insert into CUSTOMER (id, name, status_id) values (1002, 'Izio', 3);
insert into CUSTOMER (id, name, status_id) values (1003, 'Podcat', 3);
insert into CUSTOMER (id, name, status_id) values (1004, 'Twimbo', 2);
insert into CUSTOMER (id, name, status_id) values (1005, 'Oyope', 2);
insert into CUSTOMER (id, name, status_id) values (1006, 'Meetz', 2);
insert into CUSTOMER (id, name, status_id) values (1007, 'Skinix', 1);
insert into CUSTOMER (id, name, status_id) values (1008, 'Wordpedia', 1);
insert into CUSTOMER (id, name, status_id) values (1009, 'Topicblab', 2);

INSERT INTO AUTHORITY (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITY (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_USER');
INSERT INTO AUTHORITY (USERNAME, AUTHORITY) VALUES ('diego', 'ROLE_ADMIN');
INSERT INTO AUTHORITY (USERNAME, AUTHORITY) VALUES ('diego', 'ROLE_USER');
INSERT INTO AUTHORITY (USERNAME, AUTHORITY) VALUES ('user', 'ROLE_USER');

INSERT INTO USER (USERNAME, PASSWORD, ACTIVE) VALUES ('user', '{bcrypt}$2a$10$CxEywTh/5OQYD1bdevaUpeUlXwNJfbAX9k3G5I18N4/rNn9LgAWRS', true);
INSERT INTO USER (USERNAME, PASSWORD, ACTIVE) VALUES ('admin', '{bcrypt}$2a$10$0a9YahNgkS5riodPPMgIdOEu/H7HBTCXgzsjIqAYeK9OpdWfMMhoy', true);

/* password 4321 */
INSERT INTO USER (USERNAME, PASSWORD, ACTIVE) VALUES ('diego', '{bcrypt}$2a$10$SlMiFBFFEv..xsXCU5vEbellI4Cr3ULI7sbOR4/JeHV49ptTqxUUW', true);