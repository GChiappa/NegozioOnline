--articolo
insert into utente values('Aldo','Baglio','Milano','20000', TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'AlBa', 'e4k^Rd%fgT9t*t2TA�S5y!s58u_dak^Rd%fgT9t*t2TA�S5y!s58u_d3k^Rd%fgT9t*t2TA�S5y!s58u_29k^Rd%fgT9t*t2TA�S5y!s58u_bk^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_f2k^Rd%fgT9t*t2TA�S5y!s58u_bbk^Rd%fgT9t*t2TA�S5y!s58u_e2k^Rd%fgT9t*t2TA�S5y!s58u_1ek^Rd%fgT9t*t2TA�S5y!s58u_20k^Rd%fgT9t*t2TA�S5y!s58u_adk^Rd%fgT9t*t2TA�S5y!s58u_49k^Rd%fgT9t*t2TA�S5y!s58u_48k^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_90k^Rd%fgT9t*t2TA�S5y!s58u_', 'AlBa@mail.it');
insert into utente values('Giovanni','Storti','Milano','20000', TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'GioSto', 'e4k^Rd%fgT9t*t2TA�S5y!s58u_dak^Rd%fgT9t*t2TA�S5y!s58u_d3k^Rd%fgT9t*t2TA�S5y!s58u_29k^Rd%fgT9t*t2TA�S5y!s58u_bk^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_f2k^Rd%fgT9t*t2TA�S5y!s58u_bbk^Rd%fgT9t*t2TA�S5y!s58u_e2k^Rd%fgT9t*t2TA�S5y!s58u_1ek^Rd%fgT9t*t2TA�S5y!s58u_20k^Rd%fgT9t*t2TA�S5y!s58u_adk^Rd%fgT9t*t2TA�S5y!s58u_49k^Rd%fgT9t*t2TA�S5y!s58u_48k^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_90k^Rd%fgT9t*t2TA�S5y!s58u_', 'GioSto@mail.it');
insert into utente values('Giacomo','Poretti','Milano','20000', TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'GiaPor', 'e4k^Rd%fgT9t*t2TA�S5y!s58u_dak^Rd%fgT9t*t2TA�S5y!s58u_d3k^Rd%fgT9t*t2TA�S5y!s58u_29k^Rd%fgT9t*t2TA�S5y!s58u_bk^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_f2k^Rd%fgT9t*t2TA�S5y!s58u_bbk^Rd%fgT9t*t2TA�S5y!s58u_e2k^Rd%fgT9t*t2TA�S5y!s58u_1ek^Rd%fgT9t*t2TA�S5y!s58u_20k^Rd%fgT9t*t2TA�S5y!s58u_adk^Rd%fgT9t*t2TA�S5y!s58u_49k^Rd%fgT9t*t2TA�S5y!s58u_48k^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_90k^Rd%fgT9t*t2TA�S5y!s58u_', 'GiaPor@mail.it');

insert into articolo values(articolo_seq.nextval, 'Apple', 'Mac Pro', 2340);
insert into articolo values(articolo_seq.nextval, 'Apple', 'IPhone 13', 1460);
insert into articolo values(articolo_seq.nextval, 'Samsung', 'Galaxy Fold', 2170);
insert into articolo values(articolo_seq.nextval, 'Samsung', 'Lavastoviglie XTR', 350);
insert into articolo values(articolo_seq.nextval, 'HP', 'Laptop', 899);

insert into ordine values(ordine_seq.nextval, 1500, TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'AlBa');
insert into ordine values(ordine_seq.nextval, 4500, TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'AlBa');
insert into ordine values(ordine_seq.nextval, 9545, TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'GioSto');
insert into ordine values(ordine_seq.nextval, 650, TO_DATE('2003/05/03', 'yyyy/mm/dd'), 'GiaPor');

insert into ORDINE_ARTICOLO values(1,1,5);
insert into ORDINE_ARTICOLO values(2,3,15);
insert into ORDINE_ARTICOLO values(3,2,5);
insert into ORDINE_ARTICOLO values(4,5,2);

insert into immagine values(1, 'img/MacPro.jpg', 'Mac Pro');
insert into immagine values(2, 'img/IPhone13.jpg', 'IPhone 13');
insert into immagine values(3, 'img/GalaxyFold.jpg', 'Galaxy Fold');
insert into immagine values(4, 'img/LavastoviglieXTR.jpg', 'Lavastoviglie XTR');
insert into immagine values(5, 'img/LaptopHP.jpg', 'Laptop HP');



insert into amministratore values('admin','e4k^Rd%fgT9t*t2TA�S5y!s58u_dak^Rd%fgT9t*t2TA�S5y!s58u_d3k^Rd%fgT9t*t2TA�S5y!s58u_29k^Rd%fgT9t*t2TA�S5y!s58u_bk^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_f2k^Rd%fgT9t*t2TA�S5y!s58u_bbk^Rd%fgT9t*t2TA�S5y!s58u_e2k^Rd%fgT9t*t2TA�S5y!s58u_1ek^Rd%fgT9t*t2TA�S5y!s58u_20k^Rd%fgT9t*t2TA�S5y!s58u_adk^Rd%fgT9t*t2TA�S5y!s58u_49k^Rd%fgT9t*t2TA�S5y!s58u_48k^Rd%fgT9t*t2TA�S5y!s58u_dek^Rd%fgT9t*t2TA�S5y!s58u_90k^Rd%fgT9t*t2TA�S5y!s58u_','giovanni@admin.it');

commit

