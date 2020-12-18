BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




DROP TABLE IF EXISTS success_stories;

Drop table if exists catch_cats; 

DROP TABLE IF EXISTS cat_locations;


CREATE TABLE cat_locations (
       id serial NOT NULL,
       location_name varchar(255) NOT NULL,
       street_address varchar(255) NOT NULL,
       city varchar(255) NOT NULL,
       state_abbr varchar(2) NOT  NULL,
       zip_code integer NOT NULL,
       latitude decimal NOT NULL,
       longitude decimal NOT NULL,
       PRIMARY KEY (id)
       );
       
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Cozy Cat Cottage', '10344 Sawmill Road', 'Powell', 'OH', 43065, '40.147603', '-83.089515');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Colony Cats', '2740 Festival Lane', 'Dublin', 'OH', 43017, '40.09378251395264', '-83.08961751509419');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Pets Without Parents', '629 Oakland Park Avenue', 'Columbus', 'OH', 43214, '40.03282962229468', '-82.99861995970622');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('McDonald''s', '1074 Gemini Place', 'Columbus', 'OH', 43240, '40.14830510461983', '-82.98874307276557');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('The Cat Welfare Association', '741 Wetmore Road', 'Columbus', 'OH', 43214, '40.05910051891913', '-82.9993228465449');

CREATE TABLE catch_cats (
    id serial NOT NULL,
    name character varying(50) NOT NULL,
    age integer NOT NULL,
    skills character varying(255) NOT NULL,
    hair_length character varying(50),
    prior_experience_months integer NOT NULL,
    prior_jobs character varying(255),
    description character varying(255) NOT NULL,
    color character varying(255) not null,
    isFeatured boolean not null default false,
    image_name varchar(255),
    isAdopted boolean not null default false,
    strength_rating integer,
    intelligence_rating integer,
    speed_rating integer,
    stamina_rating integer,
    location_id integer NOT NULL,
    PRIMARY KEY (id),
    foreign key (location_id) references cat_locations (id),
    CONSTRAINT chk_hair_length CHECK (hair_length in ('Long','Short','Hairless')),
    CONSTRAINT chk_strength_rating CHECK (strength_rating BETWEEN 0 AND 5),
    CONSTRAINT chk_intelligence_rating CHECK (intelligence_rating BETWEEN 0 AND 5),
    CONSTRAINT chk_speed_rating CHECK (speed_rating BETWEEN 0 AND 5),
    CONSTRAINT chk_stamina_rating CHECK (stamina_rating BETWEEN 0 AND 5)
);



CREATE TABLE success_stories (
        
        id serial NOT NULL,
        cat_id integer NOT NULL,
        adopter_name varchar (50) NOT NULL,
        date_adopted date not null, 
        story text NOT NULL,
        foreign key (cat_id) references catch_cats (id)


);





--adopted
insert into catch_cats values (default, 'Keamew Reeves', 5, 'Jack of all Trades', 'Long', 5, 'Hitman', 'Gryffindor at heart', 'Brown', false, 'keanu-2.jpg',true, 3,5,4,3,1);
insert into catch_cats values (default, 'Nosferatmew', 100, 'Transmogrification', 'Short', 80, 'Count of a Forgotten European Country', 'Mysteriously nocturnal', 'Black', false, '0_CATERS_VAMPIRE_CAT_01-768x768.jpg', true, 5,4,5,3,2);
insert into catch_cats values (default, 'Paw Jovi', 45, 'Singing, being adorable','Short', 60, 'lives life to the fullest','Paw Jovi likes to eat bar food and sing karaoke', 'Tan', false, 'licking-cat.jpg', true, 3,4,2,3,2);
insert into catch_cats values (default, 'Mew.js', 2, 'Interior design, agility', 'Long', 12,'Programmer', 'Mew.js is very good at making the things behind the scenes look pretty up front', 'White, brown, gray', false, 'cat_using_computer.jpg', true, 2,4,3,3,1);
insert into catch_cats values (default, 'Kitty Purry', 3, 'Pretending to sing', 'Long', 43, 'Singer', 'Starting catfights', 'White', false, 'Katy_perry_and_kitty_purry.jpg', true, 1,1,1,1,1);
insert into catch_cats values (default, 'Mammal', 1, 'Existing, eating, sleeping', 'Hairless', 0, 'N/A', 'Likes to snuggle, but is so unattractive people generally avoid him', 'Flesh', false, 'hairlesscat.jpg',true, 2,3,4,2,2);
--need homes--
insert into catch_cats values (default, 'Pancake', 12, 'Carboloading, getting beefcake', 'Short', 4, 'Sommelier', 'Has an appreciation for the finer things in life', 'Orange', false, 'pancake.png', false, 3, 3, 3, 5, 5);
insert into catch_cats values (default, 'Genevieve', 2, 'Belly flops, marathon training', 'Short', 17, 'Bodybuilder', 'Genevieve is a part-time fitness model and loves pina coladas and long walks on the beach', 'Multi', false, 'bellycat.jpg', false, 4, 3, 4, 5, 2);
insert into catch_cats values (default, 'Izzy', 1, 'Costume design, photography, Adobe Suite', 'Short', 2, 'Seamstress', 'Izzy likes to cosplay in her spare time. Once she is bigger than the typical mouse, she looks forward to chasing them out of the house', 'Orange',false, 'leia.jpg',false, 1, 4,3,4,1);
insert into catch_cats values (default, 'Brian', 20, 'Avid guitar player and java development wizard', 'Short', 24, 'Java Development Instructor', 'Brian likes to do Bee cosplay and is a Bob Seger fanatic', 'Grey',false, 'brian.png',false, 3,4,3,4,3);
insert into catch_cats values (default, 'Rachelle', 14, 'The Lady of Perpetual Breaks', 'Short', 2, 'Assistant Java Development Instructor', 'She loves her students, her kittens, and her dog Turkey', 'Grey/White', false, 'rachelle.png',false, 2,4,2,4,2);
insert into catch_cats values (default, 'Chloe', 2, 'Drawing and sleeping', 'Short', 3, 'Ice Cream Scooper', 'Playing minecraft, draw, and that is about it', 'White/Brown', false, 'chloe1.png',false, 2,3,2,4,3);
insert into catch_cats values (default, 'Olivia', 3, 'Photgraphy, website development ', 'Short', 7, 'Optician', 'Likes to go to South Carolina, drives fast and take pictures', 'Grey', false, 'olivia.png',false, 2,4,5,3,1);
insert into catch_cats values (default, 'Josh', 5, 'Building PCs', 'Short', 9, 'Project Manager', 'Loves to build PCs and cosplay as his Spidey-sona', 'White/Orange', false, 'josh.jpg',false, 3, 3,2,4,3);
insert into catch_cats values (default, 'Elaina', 5, 'Makeup and Therapy for friends', 'Long', 6, 'Roofing Contract Specialist', 'Elaina loves to play with makeup in her spare time, and playing Dont Starve', 'Black', false, 'catsona.png',false, 3,3,5,4,3);
insert into catch_cats values (default, 'Kevin', 9, 'DESTRUCTION', 'Short', 9999, 'DESTORYER OF WORLDS', 'HATES RAINBOWS AND JOY', 'Black/Brown', false, 'image.png',false, 5,5,5,5,4);
insert into catch_cats values (default, 'Winston', 1, 'Being adorable', 'Short', 1, 'Crown Prince', 'Winston loves to lick everyone on the face', 'Mix', false, 'teacup.jpg',false, 1,1,1,1,5);
insert into catch_cats values (default, 'Sebastian', 3, 'Being smart', 'Hairless', 6, 'Head Scientist at NASA', 'Likes to read scientific articles and observing stars in the visible universe ', 'Bald', false, 'hairlesscat.jpg',false, 5,5,5,5,2);



--success stories---

insert into success_stories values (default, 1, 'Laurence of Olivier', '12/24/2019', 'I adopted Keamew in the middle of a knife fight. The other guy pulled a gun on me (totes breaking the rules) and Keamew jumped out to take the bullet. He survived and we have been buddies ever since. He will be the best man at my wedding next week!');
insert into success_stories values (default, 2, 'Cindy Lauper', '10/31/2020', 'Nosferatmew is weird because he only comes out in the evenings, but he definitely gets the job done! We have not seen a single live mouse since we adopted him, just their sad, shriveled little corpses. We make our daughter bury them out back to build character.');
insert into success_stories values (default, 3, 'Bob Belcher', '11/27/2020', 'It''s my life / It''s meow or never / I ain''t gonna live furever');
insert into success_stories values (default, 4, 'Brian Lauvray', '12/18/2020', 'Props to the Catch team. Mew.js has become a major component in my life!');
insert into success_stories values (default, 5, 'Rachelle Rauh', '12/18/2020', 'Our experience with Catch has been nothing short of phenomenal. We love our Kitty Purry! They say she used to be a singer, but we just do not hear it. In fact, whenever she meows, it sounds kind of like when you shove too many potato peels down a garbage disposal. Oh well, at least she is pretty to look at!');
insert into success_stories values (default, 6, 'Human Being', '08/13/2020', 'We are pleased with Catch. They have provided a functional cat devoid of defects.');

COMMIT TRANSACTION;
