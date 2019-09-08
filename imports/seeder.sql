use blog_db;


drop table if exists documents;
drop table if exists posts;
drop table if exists user_roles;
drop table if exists users;

create table users(
id int unsigned not null auto_increment,
role tinyint(1),
username varchar(240) not null,
email varchar(240) not null,
password varchar(120) not null,
primary key (id)
);


create table posts (
id int unsigned not null auto_increment,
user_id int unsigned not null,
title varchar(30) not null,
body varchar(1000) not null,
category varchar(100) not null,
status tinyint(1) not null,
image varchar(512),
foreign key (user_id) references users(id)
on delete cascade,
primary key (id)
);

INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,"Kibo","Curabitur.vel.lectus@antedictum.net","Lectus A Associates"),(0,"Keefe","eleifend@porttitor.ca","Enim Institute"),(1,"Darius","orci.lacus@tristiquepharetra.edu","Morbi Tristique Ltd"),(0,"Ezra","a@magnanecquam.co.uk","Gravida Sagittis Duis Incorporated"),(1,"Knox","nulla@dolorFuscefeugiat.co.uk","Facilisis Facilisis Magna Corporation"),(0,"Upton","ante.blandit.viverra@ullamcorper.com","Consectetuer Euismod Industries"),(2,"Zachery","egestas@dolorelit.co.uk","Augue Malesuada PC"),(2,"Shad","id.libero@Classaptenttaciti.org","Nisl LLC"),(2,"Wyatt","eu@ascelerisquesed.com","Pede Ac Urna Inc."),(1,"Ralph","tellus@nibhQuisquenonummy.edu","Nullam Velit Dui Associates");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (0,"Guy","gravida.Aliquam.tincidunt@Namtempordiam.net","Enim LLC"),(2,"Walter","Sed@Nullamlobortisquam.com","Quis Pede Institute"),(2,"Malachi","quis@ascelerisquesed.net","Aliquam Adipiscing Corporation"),(2,"Jerome","fringilla@Sed.co.uk","Mollis Institute"),(0,"Conan","Etiam.bibendum@velitinaliquet.ca","Nisl Maecenas Malesuada Industries"),(1,"Elliott","Nunc.ut@placerateget.net","Tristique Senectus Institute"),(0,"Evan","fermentum.convallis@Fuscediam.edu","Vulputate Consulting"),(2,"Calvin","ullamcorper.Duis@Nullam.com","Non Industries"),(0,"Erasmus","lacinia.vitae@tempor.com","Dictum Eleifend Nunc Associates"),(0,"Tucker","parturient@fringilla.co.uk","Convallis Associates");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (0,"Cullen","semper@mollisInteger.edu","Semper Pretium Inc."),(0,"Garrison","ornare.elit.elit@Nullaeuneque.co.uk","Donec Institute"),(1,"Baker","pharetra.ut.pharetra@arcu.edu","Viverra Donec Tempus Foundation"),(1,"Uriah","eu.eleifend@necmauris.ca","Tristique Senectus Associates"),(2,"Wayne","Phasellus.libero@a.com","Est Inc."),(1,"Alvin","velit@arcuVestibulumante.ca","Mollis Phasellus Associates"),(2,"Addison","fringilla@molestiepharetra.com","Pretium PC"),(2,"Brock","justo.faucibus@purus.co.uk","Eget Limited"),(2,"Tanner","Sed.eget.lacus@scelerisque.edu","Fringilla Donec Feugiat LLC"),(1,"Colby","amet.metus.Aliquam@sodalesnisi.net","Morbi Accumsan Laoreet LLC");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,"Carter","nisl.elementum@risus.net","Ut Institute"),(1,"Simon","Cras.dolor@arcu.org","Penatibus Ltd"),(0,"Kieran","nonummy@pretiumaliquet.ca","Lobortis Corporation"),(0,"Acton","Phasellus.nulla.Integer@acsem.co.uk","A Ultricies Corp."),(2,"Patrick","lectus.rutrum.urna@diamvelarcu.ca","Curabitur Ut Inc."),(1,"Lance","risus.Nulla.eget@utnullaCras.com","Elit A Inc."),(2,"Wesley","odio.Etiam@aliquam.ca","Mauris Ut LLP"),(1,"Dalton","Morbi.vehicula.Pellentesque@DonectinciduntDonec.edu","Malesuada Vel Institute"),(0,"Carter","placerat.Cras.dictum@adipiscingenimmi.edu","Dictum Cursus Industries"),(1,"Oren","vitae@adipiscingMaurismolestie.co.uk","Felis Donec Tempor Foundation");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (0,"Ferris","imperdiet.nec.leo@dictumsapienAenean.edu","Netus LLP"),(1,"Tiger","vulputate.lacus@felispurus.co.uk","Diam Ltd"),(0,"Jamal","dictum@tinciduntneque.org","At Lacus Quisque Corp."),(2,"Sebastian","pellentesque.tellus@sempereratin.edu","Nisi A Odio Foundation"),(0,"Duncan","dapibus@Donecnon.org","Quam Limited"),(0,"Porter","blandit.enim@feugiat.edu","Nonummy Ipsum Inc."),(0,"Omar","Pellentesque.ultricies@loremfringillaornare.co.uk","Nunc LLC"),(0,"William","sit.amet@arcu.edu","Sagittis Associates"),(1,"Macon","Duis@Nuncullamcorpervelit.org","Malesuada Augue Ut Industries"),(1,"Ciaran","elit.erat.vitae@sit.co.uk","Duis Sit Amet Company");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (1,"Ignatius","dui.nec@vestibulumMaurismagna.ca","Lacus Pede Sagittis Industries"),(0,"Kato","pede@hendrerit.co.uk","Nullam Company"),(2,"Boris","Duis.sit@Pellentesquetincidunttempus.co.uk","Curabitur Institute"),(1,"Brett","dolor@loremacrisus.net","Sem LLP"),(1,"Tiger","dapibus@vestibulumnec.edu","Ut Eros LLP"),(2,"James","eget.mollis@IntegerurnaVivamus.co.uk","Sapien LLC"),(0,"Melvin","nulla.magna.malesuada@magna.net","Arcu Et Associates"),(0,"Walker","sit.amet@ametluctusvulputate.org","Bibendum Fermentum Metus Institute"),(0,"Tanner","conubia.nostra@pretium.edu","Eleifend Vitae Foundation"),(0,"Grady","ullamcorper.eu.euismod@Cras.edu","Non Lacinia At LLP");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,"Kieran","sapien.molestie.orci@velvenenatis.net","Dapibus LLP"),(1,"Louis","non.enim@etmalesuada.edu","Amet Risus Donec Foundation"),(1,"Cameron","sapien.molestie@ultricesposuerecubilia.co.uk","Nunc Quisque Incorporated"),(1,"Arsenio","cursus.a.enim@Vestibulumaccumsan.edu","Nunc Nulla Vulputate Consulting"),(0,"Brennan","nec.urna.et@Maecenas.edu","Gravida Aliquam Tincidunt LLC"),(2,"Vernon","Lorem.ipsum.dolor@semperauctorMauris.ca","Curae; Phasellus Consulting"),(1,"Gannon","nibh@amet.edu","Sagittis Nullam LLP"),(1,"Nathan","purus@elementumpurusaccumsan.ca","Lorem Ipsum Dolor LLP"),(1,"Mannix","turpis.Nulla@Namconsequatdolor.ca","Consequat Auctor Nunc Company"),(1,"Beau","nascetur@arcuiaculisenim.org","Luctus Ltd");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,"Brock","sapien@Infaucibus.ca","Mauris Foundation"),(0,"Jackson","pretium.aliquet.metus@ipsumleoelementum.edu","Tincidunt Nibh Consulting"),(0,"Otto","mauris.eu@SeddictumProin.ca","Faucibus Incorporated"),(2,"Garrison","adipiscing.elit@estacfacilisis.ca","Arcu Consulting"),(2,"Nathaniel","dis.parturient@Crasvulputatevelit.edu","Et Magnis Dis Associates"),(0,"Alec","est.congue@lectusNullamsuscipit.edu","Malesuada Foundation"),(2,"Travis","nec@Namtempordiam.edu","Nibh Dolor Nonummy Associates"),(1,"Roth","Lorem@estNunc.net","Aliquet Magna Corp."),(0,"Kennan","Suspendisse.sagittis@odio.ca","Consequat Company"),(1,"Garrison","vitae.dolor@orci.edu","Lectus Convallis Est Company");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (0,"Yardley","tincidunt@acipsum.ca","Turpis Egestas Corp."),(0,"Malik","tellus@sapienimperdiet.com","Orci Lobortis Augue Associates"),(1,"Elton","eros.non@maurisblandit.org","A Foundation"),(0,"Chancellor","tellus@vitae.co.uk","Dui Cum Foundation"),(0,"Yoshio","rhoncus.id@mauriserateget.ca","Ipsum Industries"),(1,"Uriel","ante@commodo.org","Fermentum Arcu Vestibulum Corp."),(1,"Lewis","pede@nisiCumsociis.net","Vel Est Inc."),(0,"Colorado","Aliquam@nonummyac.net","Aliquam Gravida LLC"),(1,"Seth","Praesent@iaculisnec.ca","Tellus Justo Sit Ltd"),(0,"Dalton","Sed@Quisque.com","Et Consulting");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,"Uriah","at.arcu.Vestibulum@et.edu","Non Corp."),(0,"Tanner","vel.lectus@dolor.ca","Lacus Pede Incorporated"),(0,"Vernon","amet@musDonec.ca","Augue Porttitor Interdum PC"),(1,"Jeremy","quis.turpis.vitae@mollislectuspede.com","Pretium Neque PC"),(0,"Shad","massa.Integer@dolor.net","Augue Sed Molestie Institute"),(0,"Evan","iaculis.aliquet.diam@ut.org","Nulla Magna Malesuada Inc."),(2,"Dillon","Sed.eu@ultricessitamet.net","Enim Ltd"),(2,"Eaton","mi.Aliquam@fringillaporttitor.co.uk","Purus Duis LLP"),(1,"Harrison","torquent@variusorci.ca","Quisque Tincidunt Pede Associates"),(1,"Malik","blandit.at.nisi@gravidamauris.ca","Lobortis Mauris Suspendisse Corporation");
INSERT INTO `users` (`role`,`username`,`email`,`password`) VALUES (2,'nestor', 'nestor@gmail.com', 'password');


INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (99,"Volvo","stews","random",1,"Finale"),(61,"Cadillac","soups","math",1,"Borland"),(68,"Citroën","seafood","random",0,"Finale"),(55,"Vauxhall","noodles","math",2,"Yahoo"),(28,"BMW","desserts","code",2,"Borland"),(73,"Volvo","soups","food",1,"Lavasoft"),(51,"Dodge","seafood","health",2,"Cakewalk"),(5,"Mahindra and Mahindra","desserts","code",1,"Chami"),(67,"Vauxhall","soups","science",0,"Adobe"),(27,"Dacia","sandwiches","math",2,"Altavista");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (26,"BMW","pies","health",0,"Yahoo"),(76,"Dongfeng Motor","seafood","science",2,"Adobe"),(96,"Peugeot","pies","food",2,"Yahoo"),(12,"Dongfeng Motor","noodles","random",0,"Chami"),(62,"GMC","seafood","random",1,"Apple Systems"),(19,"FAW","seafood","random",0,"Borland"),(3,"Chrysler","soups","science",2,"Microsoft"),(98,"MINI","seafood","health",1,"Microsoft"),(32,"Daihatsu","seafood","random",0,"Apple Systems"),(25,"Cadillac","pasta","random",2,"Adobe");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (86,"Kenworth","soups","random",2,"Sibelius"),(93,"Mahindra and Mahindra","seafood","random",2,"Yahoo"),(92,"Seat","sandwiches","math",0,"Google"),(62,"Dongfeng Motor","stews","code",2,"Chami"),(52,"Dacia","cereals","random",1,"Borland"),(23,"Volvo","salads","code",0,"Adobe"),(13,"RAM Trucks","sandwiches","random",2,"Altavista"),(44,"Hyundai Motors","desserts","health",0,"Lycos"),(19,"Ford","noodles","health",2,"Cakewalk"),(32,"GMC","seafood","random",1,"Borland");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (52,"Chrysler","pasta","code",2,"Adobe"),(53,"Nissan","salads","science",1,"Cakewalk"),(5,"Chevrolet","noodles","code",1,"Borland"),(23,"Volkswagen","salads","code",2,"Google"),(56,"Chrysler","cereals","health",0,"Altavista"),(68,"FAW","pies","health",1,"Borland"),(62,"Porsche","soups","math",0,"Lavasoft"),(63,"Audi","desserts","code",0,"Borland"),(28,"Renault","sandwiches","random",2,"Microsoft"),(97,"Jeep","seafood","random",1,"Adobe");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (46,"Daihatsu","pasta","science",0,"Apple Systems"),(57,"Skoda","stews","code",2,"Chami"),(41,"Lincoln","seafood","health",0,"Microsoft"),(53,"FAW","desserts","science",0,"Borland"),(17,"JLR","desserts","random",2,"Yahoo"),(25,"Seat","stews","health",2,"Apple Systems"),(57,"Mercedes-Benz","soups","math",0,"Altavista"),(20,"Lexus","salads","math",1,"Sibelius"),(30,"Buick","soups","science",2,"Finale"),(51,"Chrysler","desserts","science",0,"Lycos");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (3,"Mazda","sandwiches","science",1,"Chami"),(7,"Lexus","cereals","science",0,"Cakewalk"),(48,"Maruti Suzuki","desserts","science",0,"Google"),(76,"Daihatsu","pasta","science",0,"Microsoft"),(1,"General Motors","stews","science",1,"Lavasoft"),(73,"MINI","salads","health",1,"Altavista"),(75,"Audi","desserts","math",1,"Google"),(53,"Kenworth","cereals","random",0,"Lycos"),(91,"Dacia","seafood","food",0,"Apple Systems"),(50,"Volkswagen","stews","code",1,"Finale");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (76,"Suzuki","pies","random",1,"Adobe"),(17,"Subaru","pasta","science",2,"Microsoft"),(28,"Volvo","stews","health",0,"Finale"),(82,"Lexus","desserts","random",0,"Altavista"),(73,"Chevrolet","desserts","health",0,"Chami"),(35,"Isuzu","soups","health",1,"Adobe"),(33,"Volkswagen","pies","science",0,"Adobe"),(91,"Mitsubishi Motors","pies","food",1,"Cakewalk"),(80,"Dodge","noodles","health",0,"Adobe"),(97,"Mazda","pies","science",2,"Google");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (43,"Daihatsu","pasta","health",1,"Chami"),(50,"Fiat","salads","random",0,"Adobe"),(96,"Smart","stews","health",2,"Adobe"),(64,"Volvo","noodles","random",1,"Adobe"),(22,"Mitsubishi Motors","seafood","food",0,"Chami"),(40,"Subaru","sandwiches","random",0,"Adobe"),(64,"BMW","soups","health",0,"Sibelius"),(42,"Honda","noodles","code",0,"Altavista"),(52,"Vauxhall","salads","random",2,"Macromedia"),(12,"JLR","stews","health",0,"Lycos");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (13,"Skoda","desserts","code",0,"Chami"),(75,"Skoda","desserts","food",2,"Altavista"),(62,"Fiat","cereals","health",0,"Google"),(73,"Porsche","sandwiches","health",1,"Macromedia"),(100,"Seat","stews","food",1,"Borland"),(41,"Volvo","sandwiches","food",0,"Lavasoft"),(20,"Kenworth","soups","science",0,"Lycos"),(50,"Honda","stews","random",1,"Google"),(49,"GMC","soups","science",1,"Google"),(57,"Infiniti","seafood","health",1,"Finale");
INSERT INTO `posts` (`user_id`,`title`,`body`,`category`,`status`,`image`) VALUES (54,"Ferrari","pasta","code",2,"Chami"),(58,"BMW","salads","code",2,"Adobe"),(10,"Smart","soups","science",0,"Sibelius"),(73,"Maruti Suzuki","seafood","math",0,"Lycos"),(44,"Audi","pasta","health",0,"Borland"),(75,"Chevrolet","cereals","code",1,"Adobe"),(25,"RAM Trucks","desserts","science",1,"Macromedia"),(56,"Lexus","salads","math",2,"Chami"),(77,"Ferrari","seafood","math",1,"Macromedia"),(56,"Citroën","stews","health",1,"Finale");
