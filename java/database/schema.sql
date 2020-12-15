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
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Homeless to Home Animal Rescue and Cat Sanctuary', '1745 Marion-Waldo Road', 'Marion', 'OH', 43302, '41.80000434461222', '-82.10635851250001');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Paws & Whiskers Cat Shelter', '32 Hillwyck Drive', 'Toledo', 'OH', 43615, '42.14671967905339', '-82.92257586953126');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Colony Cats', '2740 Festival Lane', 'Dublin', 'OH', 43017, '40.09378251395264', '-83.08961751509419');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Cat Tails', '6622 Beach Drive SW', 'Ocean Isle Beach', 'NC', 28469, '36.0421218', '-78.0222493');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Pets Without Parents', '629 Oakland Park Avenue', 'Columbus', 'OH', 43214, '40.03282962229468', '-82.99861995970622');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Cats Haven', '2603 N College Avenue', 'Indianapolis', 'IN', 46205, '39.804364', '-86.144398');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('McDonald''s', '1074 Gemini Place', 'Columbus', 'OH', 43240, '40.14830510461983', '-82.98874307276557');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('The Cat Welfare Association', '741 Wetmore Road', 'Columbus', 'OH', 43214, '40.05910051891913', '-82.9993228465449');
insert into cat_locations (location_name, street_address, city, state_abbr, zip_code, latitude, longitude) values ('Best Friends Lifesaving Center', '307 W Broadway', 'New York', 'NY', 10013, '40.77352015741932', '-73.68874422343505');

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
        story varchar (255) NOT NULL,
        foreign key (cat_id) references catch_cats (id)


);





insert into catch_cats values (default, 'Test Name', 3, 'Test Skills', 'Long', 16, 'Test Job', 'Test Description', 'test color', false, null, false, 3, 2, 5, 1, 1);


COMMIT TRANSACTION;
