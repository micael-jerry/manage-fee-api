insert into groups(id,name,description) values(0,'G1','groups one'),
    (1,'G2','group two'),
    (2,'G3','group three');


insert into school_year(id,start_year,end_year) values(0,'2021','2022'),
    (1,'2022','2023');



    insert into my_user(
        id,lastname,firstname,sex,birth_date,
        address,phone,email,username,password,role
    ) values (
        0,'admin','admin','M','2003-05-13',
        'address_admin','1234567890','admin@gmail.com','admin',
        '$2a$10$y6n7HoU.lCetC6/mj4rPLOdbSk.EE8DfUKmtaqsq.6WlY/lrRPCUW',
        'manager'
    );


insert into my_user(id,group_id,address,birth_date,email,entrance_date,firstname, lastname,sex, phone, role ) values 
('1','1','Lawrence','1996-9-17','Bill1@gmail.com','2021-10-6','Bill','Senger','M','032-4630-904','student'),
('2','1','Yuba City','1996-11-19','Amanda2@gmail.com','2021-5-25','Amanda','Smith','M','030-2426-686','student'),
('3','1','Murraychester','2004-12-10','Meghan3@gmail.com','2021-2-15','Meghan','Borer','M','036-2178-230','student'),
('4','1','Chicopee','1991-11-14','Krista4@gmail.com','2021-1-14','Krista','Williamson','F','030-9695-847','student'),
('5','1','New Howard','1998-9-15','Deon5@gmail.com','2021-7-12','Deon','Shanahan','F','034-9223-919','student'),
('6','1','East Idellachester','1998-5-2','Miguel6@gmail.com','2021-3-19','Miguel','Dietrich','M','034-9577-212','student'),
('7','1','Nolanstead','1991-7-11','Peggie7@gmail.com','2021-8-19','Peggie','Torp','F','036-9801-209','student'),
('8','1','Bryanaboro','2003-6-25','Reggie8@gmail.com','2021-1-18','Reggie','Walter','F','031-9458-582','student'),
('9','1','Korycester','1994-5-5','Rusty9@gmail.com','2021-7-11','Rusty','Schinner','M','036-7578-628','student'),
('10','1','South Seanmouth','1990-2-6','Hope10@gmail.com','2021-7-7','Hope','Wintheiser','M','039-1272-938','student'),
('11','1','Fort Osbaldostead','1995-7-26','Erika11@gmail.com','2021-10-2','Erika','Osinski','M','033-1136-239','student'),
('12','1','Eliezerworth','2003-9-22','Laurie12@gmail.com','2021-1-2','Laurie','Swift','F','031-6316-398','student'),
('13','1','Port Eleonore','1992-12-2','Chet13@gmail.com','2021-12-17','Chet','Runolfsson','M','038-0780-999','student'),
('14','1','New Skylar','2007-10-9','Ethel14@gmail.com','2021-5-20','Ethel','Kautzer','M','033-7832-262','student'),
('15','1','Blazestead','2009-11-19','Sarai15@gmail.com','2021-9-5','Sarai','Skiles','M','034-7850-834','student'),
('16','1','Port Onie','2001-2-11','Kyle16@gmail.com','2021-12-24','Kyle','McCullough','M','039-6972-551','student'),
('17','1','Angieborough','1994-2-27','Citlalli17@gmail.com','2021-3-18','Citlalli','Torphy','M','031-5439-280','student'),
('18','1','Ullrichberg','1996-12-23','Rocky18@gmail.com','2021-8-23','Rocky','Pacocha','M','033-6084-637','student'),
('19','1','Bergstromfield','2000-7-5','Felipa19@gmail.com','2021-12-3','Felipa','Carroll','F','039-8726-891','student'),
('20','1','Fritschtown','1996-10-1','Berta20@gmail.com','2021-7-6','Berta','Schowalter','M','030-8322-068','student');


insert into my_user(id,group_id,address,birth_date,email,entrance_date,firstname, lastname,sex, phone, role ) values 
('21','2','Hesselmouth','2002-9-13','Vita1@gmail.com','2021-9-1','Vita','Nienow','M','032-2085-924','student'),
('22','2','Watsonville','1994-9-28','Lilly2@gmail.com','2021-6-7','Lilly','Weissnat','F','030-3562-762','student'),
('23','2','West Felton','1993-2-15','Cassie3@gmail.com','2021-8-24','Cassie','Conn','F','038-1460-988','student'),
('24','2','Lake Brookstad','2000-9-27','Alene4@gmail.com','2021-4-11','Alene','Smitham','F','033-4841-921','student'),
('25','2','Rutherfordside','1995-5-31','Coralie5@gmail.com','2021-4-22','Coralie','Dietrich','M','033-5730-634','student'),
('26','2','Los Angeles','1997-9-1','Jovan6@gmail.com','2021-3-11','Jovan','Ebert','M','034-6305-287','student'),
('27','2','Mohrfield','2009-4-19','Fredrick7@gmail.com','2021-10-2','Fredrick','Abbott','F','038-0639-217','student'),
('28','2','El Centro','2007-10-31','Christop8@gmail.com','2021-1-29','Christop','Shields','F','037-0136-879','student'),
('29','2','Fort Andre','1994-9-21','Marco9@gmail.com','2021-7-27','Marco','Macejkovic','M','035-5269-949','student'),
('30','2','Elianberg','2000-1-27','Abbie10@gmail.com','2021-2-14','Abbie','Reichel','F','036-7043-345','student'),
('31','2','Memphis','1999-5-13','Austin11@gmail.com','2021-5-31','Austin','Goyette','F','033-4087-454','student'),
('32','2','Lake Rhea','1998-4-5','Robin12@gmail.com','2021-1-15','Robin','Tremblay','F','031-3173-846','student'),
('33','2','Homestead','2000-12-9','Britney13@gmail.com','2021-10-24','Britney','Hilpert','F','034-7466-176','student'),
('34','2','Herbertland','2004-6-21','Gay14@gmail.com','2021-7-25','Gay','Predovic','M','032-5371-573','student'),
('35','2','South Arlenefield','1990-12-12','Rosalee15@gmail.com','2021-8-10','Rosalee','Skiles','M','038-4236-655','student'),
('36','2','Port Leolacester','1991-9-24','Aidan16@gmail.com','2021-9-10','Aidan','Robel','F','034-6245-021','student'),
('37','2','North Fern','2006-2-19','Shyanne17@gmail.com','2021-6-25','Shyanne','Mertz','M','032-9124-217','student'),
('38','2','Port Vidafurt','1999-12-7','Jarvis18@gmail.com','2021-11-8','Jarvis','Stokes','F','030-5872-925','student'),
('39','2','Long Beach','2000-8-6','Simone19@gmail.com','2021-3-13','Simone','Bartoletti','M','034-6124-804','student'),
('40','2','North Richland Hills','1996-9-1','Ashley20@gmail.com','2021-4-3','Ashley','Morissette','M','030-3020-498','student');



insert into fee(id,description,total_amount,type,school_year_id,student_id) values 
('1','Totam ut teunde assumenda tempore.','1000000','TUITION','0','1'),
('2','Unde aliquto anid ad et. Sed fugiat quis labore repellendus sit.','1000000','TUITION','0','2'),
('3','Iure repellvitai sed et. Consequuntur itaque quia ut quasi repellat quia ut. Perferendis ea architecto distinctio.','1000000','TUITION','0','3'),
('4','Ipsa praes quiaDignissimos qui quam qui laborum tempore nostrum. In blanditiis quis fuga.','1000000','TUITION','0','4'),
('5','Voluptas quin aut.','1000000','TUITION','0','5'),
('6','Sint vitae  qui enim rum. Possimus adipisci eum incidunt sit.','1000000','TUITION','0','6'),
('7','Nemo animi in ducimus.us ut eius cumque itaque. Ut quia eos odit odit. Sapiente esse soluta reiciendis ipsum dolorem.','1000000','TUITION','0','7'),
('8','Necessitatique perspitatis corporis cum numquam. Maiores non voluptatem et aspernatur porro. Commodi quia voluptas vitae deleniti.','1000000','TUITION','0','8'),
('9','Deserunt t ipsum omnis.','1000000','TUITION','0','9'),
('10','Aperiam rutem et voluptatibus.','1000000','TUITION','0','10'),
('11','Voluptateptatum aut distinctio sunt et. Officia et perferendis ea qui. Nesciunt quam dolor reiciendis quo quas.','1000000','TUITION','0','11'),
('12','Quo reic sint itaque dicta maxime quasi eveniet nihil. Quia officia et eos.','1000000','TUITION','0','12'),
('13','Aliquam quia simiihil ex tenetur qui incidunt. Voluptate repudiandae soluta unde atque voluptates eos omnis quis.','1000000','TUITION','0','13'),
('14','Ut at qvoluptatem id.','1000000','TUITION','0','14'),
('15','Rerum see odit rerum consequuntur asperiores dolores rem eos. Corporis quis placeat quia assumenda alias odio. Non doloremque animi sint sit nihil. Corporis quia ipsa.','1000000','TUITION','0','15'),
('16','Qui omni.','1000000','TUITION','0','16'),
('17','Conseqem veniam molestiae rerum id. Deserunt culpa repudiandae quia.','1000000','TUITION','0','17'),
('18','Expediident. Harum consequuntur impedit eos. Modi ducimus assumenda soluta et doloremque modi. Labore vero quia molestiae id quo fugit asperiores.','1000000','TUITION','0','18'),
('19','Qui ns ipsum odio. Quae omnis et nobis.','1000000','TUITION','0','19'),
('20','Officque sed ipsum mollitia quibusdam nam voluptate veniam et distinctio. Nulla quaerat eos pariatur quo facilis.','1000000','TUITION','0','20');


insert into transaction(id,amount,date,fee_id, description) values 
('1','800000','2021-11-23','1','Nesciuntrum vitae explicabo. Aperiam ptatem hic quo. Sint qui iste vitae aut perferendis necessitatibus.'),
('2','200000','2021-2-4','2','Quo non eui tempora illum asperiores nanditiis pit porro rerum molestias aliquam harum id quod ab.'),
('3','400000','2021-10-7','3','Qui eum nditiis qui et. Qui et veniam consectetur.'),
('4','800000','2022-9-20','4','Id ut nesi accusantium voluptas fuga.'),
('5','700000','2022-4-25','5','Aperiam t voluptas consequatur ut voluptatibus. Vero quidem mollitia non est fugit rem asperiores omnis animi.'),
('6','200000','2022-8-3','6','Id dicta at consectetur vel quos similique saepe in velit.'),
('7','100000','2022-7-25','7','Libero es dolor exercitatluptas ut eius velit. Deserunt in neque eaque.'),
('8','900000','2022-9-25','8','Cumque qadipisci omnis nulla nesciunt.'),
('9','500000','2021-3-21','9','Quam conluptates in quos. Fugiat minima et rerum est.'),
('10','500000','2022-8-12','10','Labor non quo. Est quia ut porro reprehenderit ex quia.'),
('12','600000','2022-9-19','12','Veriteserunt non.'),
('13','200000','2022-6-29','13','Iste  utm facere et alias dolorem. Ut sed eius unde ad. Eum harum accusantium eveniet et.'),
('14','900000','2021-10-19','14','Ratiim.  amet. Voluptates earum asperiores.'),
('15','100000','2022-6-14','15','Aut veditnatus eligendi tempore eius. Enim atque minima molestiae. Expedita dolores illo sequi repellendus.'),
('16','500000','2021-2-2','16','Nam add. Vicia sed cupiditatestiae ipsum molestiae. Voluptatem odit et officia eius ut incidunt dicta quis.'),
('17','200000','2022-10-18','17','Quisiliqquam.'),
('18','600000','2022-8-1','18','Nemo atium.'),
('19','800000','2022-6-18','19','Et silum error quae quia quidem.'),
('20','300000','2022-9-24','20','Possiat voluptatem cuum recusandae expedita. Laudantium natus quas aliquid.');