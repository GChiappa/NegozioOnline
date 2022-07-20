-- client
create table utente(
	nome varchar2(30) not null,
	cognome varchar2(30) not null,
	indirizzo varchar2(75) not null,
	cap char(5) not null,
	nascita date not null,
	username varchar2(10), --chiave
	password varchar2(1000) not null, --valore grande perche criptata
	email varchar2(50) not null unique,
	constraint p_username primary key(username)
);

create table articolo(
	id_articolo int,
	marca varchar2(30) not null,
	modello varchar2(30) not null,
	prezzo number(8,2) not null,
	constraint p_idarticolo primary key(id_articolo)
);

create table ordine(
	id_ordine int,
	totale number(9,2) not null,
	data date not null,
	username varchar2(10),
	constraint p_id_ordine primary key(id_ordine),
	constraint f_username foreign key(username) references utente(username) on delete cascade
);

create table ordine_articolo(
	id_ordine int,
	id_articolo int,
	quantita int default 1,
	constraint p_oa primary key(id_ordine,id_articolo),
	constraint f_idordine foreign key(id_ordine) references ordine(id_ordine) on delete cascade,
	constraint f_idarticolo foreign key(id_articolo) references articolo(id_articolo) on delete cascade
);

create table immagine(
	id_immagine primary key references articolo(id_articolo),
	url varchar2(50) not null,
	descrizione varchar2(500) not null
);


-- sequenze

create sequence articolo_seq;
create sequence ordine_seq;


-- admin

create table amministratore(
	username varchar2(10), --chiave
	password varchar2(1000) not null, --valore grande perche criptata
	email varchar2(50) not null unique,
	constraint p_useradmin primary key(username)
);

create view report as
select UTENTE.USERNAME, email, ORDINE.ID_ORDINE, totale, sum(quantita) as qta
from UTENTE, ORDINE, ARTICOLO, ordine_articolo
where
	ORDINE.ID_ORDINE = ordine_articolo.id_ordine
	and
	ARTICOLO.id_articolo = ordine_articolo.id_articolo
	and
	UTENTE.USERNAME = ORDINE.USERNAME
group by UTENTE.USERNAME, email, ORDINE.ID_ORDINE, totale
order by UTENTE.USERNAME, ORDINE.ID_ORDINE
;









