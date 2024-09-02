create table role(
role_id int not null auto_increment, 
role_name char(255) not null,
primary key(role_id)
);
insert into role(role_id,role_name) value(1,admin),(2,user);





create table User(
 user_id int not null auto_increment unique,
 username char(255) not null,
 password char(255) not null,
 email char(255) not null,
 contact char(255) not null,
 role_id int not null,
 constraint foreign key(role_id) references role(role_id),
 primary key(user_id));
INSERT INTO User (username, password, email, contact, role_id) VALUES
('alex_smith', 'pass123', 'alex.smith@example.com', '5551234567', 1),
('john_doe', 'securePass', 'john.doe@example.com', '5559876543', 2),
('emma_jones', 'password456', 'emma.jones@example.com', '5552345678', 1),
('michael_brown', 'pass789', 'michael.brown@example.com', '5553456789', 2),
('olivia_wilson', 'olivia123', 'olivia.wilson@example.com', '5554567890', 1),
('james_taylor', 'james789', 'james.taylor@example.com', '5555678901', 2),
('sophia_martin', 'sophia456', 'sophia.martin@example.com', '5556789012', 1),
('liam_thomas', 'liam123', 'liam.thomas@example.com', '5557890123', 2),
('isabella_white', 'isabella789', 'isabella.white@example.com', '5558901234', 1),
('logan_harris', 'logan456', 'logan.harris@example.com', '5559012345', 2),
('mia_clark', 'mia123', 'mia.clark@example.com', '5551230987', 1),
('lucas_lewis', 'lucas789', 'lucas.lewis@example.com', '5552341098', 2),
('ava_lee', 'ava456', 'ava.lee@example.com', '5553452109', 1),
('ethan_walker', 'ethan123', 'ethan.walker@example.com', '5554563210', 2),
('amelia_hall', 'amelia789', 'amelia.hall@example.com', '5555674321', 1),
('mason_allen', 'mason456', 'mason.allen@example.com', '5556785432', 2),
('charlotte_young', 'charlotte123', 'charlotte.young@example.com', '5557896543', 1),
('henry_hernandez', 'henry789', 'henry.hernandez@example.com', '5558907654', 2),
('evelyn_king', 'evelyn456', 'evelyn.king@example.com', '5559018765', 1),
('sebastian_scott', 'sebastian123', 'sebastian.scott@example.com', '5551239876', 2),
('sophia_moore', 'sophia456', 'sophia.moore@example.com', '5552340987', 1),
('jackson_martinez', 'jackson789', 'jackson.martinez@example.com', '5553451098', 2),
('emily_davis', 'emily123', 'emily.davis@example.com', '5554562109', 1),
('benjamin_robinson', 'benjamin789', 'benjamin.robinson@example.com', '5555673210', 2),
('harper_gonzalez', 'harper456', 'harper.gonzalez@example.com', '5556784321', 1),
('daniel_perez', 'daniel123', 'daniel.perez@example.com', '5557895432', 2),
('grace_rodriguez', 'grace789', 'grace.rodriguez@example.com', '5558906543', 1),
('jacob_ramirez', 'jacob456', 'jacob.ramirez@example.com', '5559017654', 2),
('victoria_sanchez', 'victoria123', 'victoria.sanchez@example.com', '5551238765', 1),
('matthew_patel', 'matthew789', 'matthew.patel@example.com', '5552349876', 2),
('ella_kim', 'ella456', 'ella.kim@example.com', '5553450987', 1),
('joseph_smith', 'joseph123', 'joseph.smith@example.com', '5554561098', 2),
('scarlett_wang', 'scarlett789', 'scarlett.wang@example.com', '5555672109', 1),
('david_wilson', 'david456', 'david.wilson@example.com', '5556783210', 2),
('layla_clark', 'layla123', 'layla.clark@example.com', '5557894321', 1),
('gabriel_lee', 'gabriel789', 'gabriel.lee@example.com', '5558905432', 2),
('hannah_lopez', 'hannah456', 'hannah.lopez@example.com', '5559016543', 1),
('samuel_morris', 'samuel123', 'samuel.morris@example.com', '5551237654', 2),
('aria_white', 'aria789', 'aria.white@example.com', '5552348765', 1),
('andrew_mitchell', 'andrew456', 'andrew.mitchell@example.com', '5553459876', 2),
('zoe_clark', 'zoe123', 'zoe.clark@example.com', '5554560987', 1),
('nicholas_jones', 'nicholas789', 'nicholas.jones@example.com', '5555671098', 2),
('violet_martin', 'violet456', 'violet.martin@example.com', '5556782109', 1),
('dylan_king', 'dylan123', 'dylan.king@example.com', '5557893210', 2),
('aubrey_green', 'aubrey789', 'aubrey.green@example.com', '5558904321', 1),
('owen_cole', 'owen456', 'owen.cole@example.com', '5559015432', 2),
('stella_perez', 'stella123', 'stella.perez@example.com', '5551236543', 1),
('leo_hernandez', 'leo789', 'leo.hernandez@example.com', '5552347654', 2),
('nora_hill', 'nora456', 'nora.hill@example.com', '5553458765', 1),
('ryan_scott', 'ryan123', 'ryan.scott@example.com', '5554569876', 2),
('aria_thomas', 'aria789', 'aria.thomas@example.com', '5555670987', 1),
('nathaniel_king', 'nathaniel456', 'nathaniel.king@example.com', '5556781098', 2),
('chloe_morris', 'chloe123', 'chloe.morris@example.com', '5557892109', 1),
('elijah_allen', 'elijah789', 'elijah.allen@example.com', '5558903210', 2),
('lily_wright', 'lily456', 'lily.wright@example.com', '5559014321', 1),
('isaac_turner', 'isaac123', 'isaac.turner@example.com', '5551235432', 2),
('madison_lee', 'madison789', 'madison.lee@example.com', '5552346543', 1),
('anthony_martinez', 'anthony456', 'anthony.martinez@example.com', '5553457654', 2),
('camila_moore', 'camila123', 'camila.moore@example.com', '5554568765', 1),
('jackson_kim', 'jackson789', 'jackson.kim@example.com', '5555679876', 2),
('zoey_clark', 'zoey456', 'zoey.clark@example.com', '5556780987', 1),
('alexander_perez', 'alexander123', 'alexander.perez@example.com', '5557891098', 2),
('penelope_white', 'penelope789', 'penelope.white@example.com', '5558902109', 1),
('joseph_smith', 'joseph456', 'joseph.smith@example.com', '5559013210', 2),
('lucy_rodriguez', 'lucy123', 'lucy.rodriguez@example.com', '5551234321', 1),
('mateo_garcia', 'mateo789', 'mateo.garcia@example.com', '5552345432', 2),
('hazel_hall', 'hazel456', 'hazel.hall@example.com', '5553456543', 1),
('aiden_walker', 'aiden123', 'aiden.walker@example.com', '5554567654', 2),
('eleanor_martin', 'eleanor789', 'eleanor.martin@example.com', '5555678765', 1),
('logan_lee', 'logan456', 'logan.lee@example.com', '5556789876', 2);





-- prouct--



create table product(
product_id int auto_increment not null,
categories_id int not null,
product_name char(255) not null,
detailed char(255) not null,
P_quantity int not null,
P_price float not null,
primary key(product_id),
foreign key(categories_id) references categories(categories_id)
);
INSERT INTO product (product_name, detailed, P_quantity, P_price, categories_id) VALUES
('VesF', 'High quality jacket. Fashion design 2021 by Dr.L premium cloth', 1, 24.25, 3),
('TrenShirt', 'Lightweight cotton shirt, perfect for summer wear. Limited edition by Rexo', 5, 19.99, 2),
('AirStep', 'Running shoes with advanced cushioning technology. Designed for marathon runners', 10, 75.00, 1),
('LuxWatch', 'Luxury watch with Swiss movement. Limited series with sapphire glass', 3, 250.50, 4),
('PeakCap', 'Stylish cap made from breathable materials. One size fits all', 20, 15.99, 5),
('SlimJean', 'Slim-fit jeans with stretchable fabric. Modern design for everyday use', 15, 45.00, 6),
('GlideSneak', 'Sneakers designed for comfort and durability. Premium rubber sole', 12, 65.75, 1),
('CasualTee', 'Comfortable t-shirt with a relaxed fit. Made from 100% organic cotton', 30, 12.49, 2),
('WinterCoat', 'Insulated jacket with a waterproof outer layer. Ideal for cold climates', 7, 89.95, 3),
('ClassicWatch', 'Timeless wristwatch with a leather strap. Analog display with date function', 2, 120.00, 4),
('BeanieHat', 'Warm woolen beanie, perfect for winter. Available in multiple colors', 25, 18.75, 5),
('DenimJean', 'Classic blue denim jeans with a straight cut. Durable and long-lasting', 18, 40.00, 6),
('SpeedRunner', 'High-performance running shoes for athletes. Breathable mesh design', 9, 90.00, 1),
('PoloShirt', 'Elegant polo shirt with a slim fit. Made from premium cotton blend', 8, 35.00, 2),
('RainJacket', 'Waterproof jacket with a hood. Compact and easy to carry', 11, 55.99, 3),
('DigitalWatch', 'Smartwatch with fitness tracking and notifications. Compatible with iOS and Android', 4, 199.99, 4),
('TruckerCap', 'Adjustable trucker cap with a mesh back. Perfect for casual outings', 22, 16.49, 5),
('SkinnyJean', 'Skinny jeans with a trendy design. Made with a comfortable stretch fabric', 14, 42.50, 6),
('TrailShoes', 'Durable trail running shoes with extra grip. Designed for off-road adventures', 6, 82.30, 1),
('GraphicTee', 'Graphic t-shirt with unique artwork. Soft fabric with a modern fit', 17, 22.00, 2),
('LeatherJacket', 'Genuine leather jacket with a classic biker style. Timeless design', 5, 320.00, 3),
('ChronoWatch', 'Chronograph watch with a stainless steel case. Water-resistant up to 100m', 3, 280.00, 4),
('SnapbackCap', 'Cool snapback cap with embroidered logo. Adjustable fit', 21, 20.99, 5),
('BootcutJean', 'Bootcut jeans with a relaxed fit. Perfect for casual wear', 13, 48.99, 6),
('ComfortSneak', 'Everyday sneakers with memory foam insoles. Lightweight and breathable', 16, 55.00, 1),
('VNeckTee', 'V-neck t-shirt with a slim fit. Available in a variety of colors', 27, 14.99, 2),
('ParkaJacket', 'Heavy-duty parka jacket with a fur-lined hood. Built for extreme cold', 4, 150.75, 3),
('ElegantWatch', 'Minimalist watch with a thin profile. Elegant design with a leather strap', 3, 175.50, 4),
('FedoraHat', 'Classic fedora hat made from wool felt. Stylish and versatile', 18, 34.50, 5),
('DistressedJean', 'Distressed jeans with a modern look. Perfect for streetwear enthusiasts', 19, 50.00, 6),
('LightRunner', 'Lightweight running shoes with breathable mesh. Ideal for summer', 11, 70.00, 1),
('HenleyShirt', 'Henley shirt with a soft texture. Casual wear with a button placket', 23, 29.00, 2),
('BomberJacket', 'Bomber jacket with a sleek design. Made from high-quality nylon', 7, 105.99, 3),
('SportWatch', 'Sports watch with GPS and heart rate monitor. Ideal for athletes', 3, 220.00, 4),
('BucketHat', 'Bucket hat made from durable cotton. Perfect for outdoor activities', 24, 22.75, 5),
('TaperedJean', 'Tapered jeans with a modern fit. Comfortable and stylish', 20, 43.25, 6),
('UrbanSneak', 'Urban sneakers with a unique design. Made for comfort and style', 9, 85.50, 1),
('LongSleeveTee', 'Long sleeve t-shirt with a relaxed fit. Perfect for layering', 30, 17.49, 2),
('Windbreaker', 'Lightweight windbreaker with a zip-up front. Ideal for windy days', 10, 60.00, 3),
('DressWatch', 'Dress watch with a polished stainless steel case. Elegant and sophisticated', 2, 190.75, 4),
('SnapCap', 'Snapback cap with an adjustable strap. Available in various designs', 19, 19.99, 5),
('StraightJean', 'Straight-leg jeans with a classic fit. Durable and comfortable', 17, 45.00, 6),
('GymRunner', 'Running shoes designed for gym workouts. Supportive and comfortable', 8, 68.99, 1),
('StripedTee', 'Striped t-shirt with a regular fit. Made from soft cotton', 28, 20.00, 2),
('PufferJacket', 'Puffer jacket with down insulation. Lightweight yet warm', 6, 130.25, 3);






-- categories--



CREATE TABLE categories (
    categories_id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (categories_id),
    categories_name VARCHAR(255) NOT NULL
);
INSERT INTO categories (categories_name) VALUES
('shoe'),
('shirt'),
('jacket'),
('watch'),
('hat'),
('Jean');



-- Payment --
create table payment(
payment_id  int unique not null auto_increment,
product_id int not null,
user_id int not null,
foreign key(user_id) references user(user_id) ,
foreign key(product_id) references product(product_id),
primary key(payment_id)
);


create table card
(
card_id  int not null auto_increment unique,
card_n int not null unique,
cvv int not null,
email char(255) not null,
primary key (card_id)
);


insert into card(card_id,card_n,cvv,email)
value (1,123456788,4433,"mail.com"),
(2,987654321, 2323, "nana.com");




-- testing --


select * from role;
select * from categories;
select * from product;
select * from user;
select * from payment











