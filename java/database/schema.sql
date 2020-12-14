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
    PRIMARY KEY (id),
    CONSTRAINT chk_hair_length CHECK (hair_length in ('Long','Short','Hairless'))
);





CREATE TABLE success_stories (
        
        id serial NOT NULL,
        cat_id integer NOT NULL,
        adopter_name varchar (50) NOT NULL,
        date_adopted date not null, 
        story varchar (255) NOT NULL,
        foreign key (cat_id) references catch_cats (id)


);



insert into catch_cats values (default, 'Test Name', 3, 'Test Skills', 'Long', 16, 'Test Job', 'Test Description', 'test color', false);


COMMIT TRANSACTION;
