--client
drop table utente cascade constraints;

drop table articolo cascade constraints;

drop table ordine cascade constraints;

drop table ordine_articolo cascade constraints;

drop table immagine cascade constraints;

--sequenze
drop sequence articolo_seq;

drop sequence ordine_seq;

--admin
drop table amministratore cascade constraints;

drop view report;