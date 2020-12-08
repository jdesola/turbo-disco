--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 11.6


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: catch_cats; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.catch_cats (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    age integer NOT NULL,
    skills character varying(255) NOT NULL,
    hair_length character varying(50),
    prior_experience_months integer NOT NULL,
    prior_jobs character varying(255),
    description character varying(255) NOT NULL,
    color character varying(255)
    CONSTRAINT chk_hair_length CHECK (((hair_length)::text = ANY ((ARRAY['Long'::character varying, 'Short'::character varying, 'Hairless'::character varying])::text[])))
);


ALTER TABLE public.catch_cats OWNER TO postgres;

--
-- Name: catch_cats_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.catch_cats_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.catch_cats_id_seq OWNER TO postgres;

--
-- Name: catch_cats_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.catch_cats_id_seq OWNED BY public.catch_cats.id;


--
-- Name: catch_cats id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.catch_cats ALTER COLUMN id SET DEFAULT nextval('public.catch_cats_id_seq'::regclass);


--
-- Data for Name: catch_cats; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.catch_cats (id, name, age, skills, hair_length, prior_experience_months, prior_jobs, description) FROM stdin;
1	Test Name	3	Test Skills	Long	16	Test Job	Test Description    
2	Rachelle	13	Coding, assisting, giving breaks	Long	23	Tech Elevator Assistant Instructor       Our lady of perpetual breaks, loves Brittany Spears, has a dog named Turkey
       
\.


--
-- Name: catch_cats_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.catch_cats_id_seq', 2, true);


--
-- Name: catch_cats catch_cats_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.catch_cats
    ADD CONSTRAINT catch_cats_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

