--
-- PostgreSQL database cluster dump
--

-- Started on 2020-12-14 21:15:42

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md59b2ca9e1895be369a82ce7709e31cfa5';






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1 (Debian 13.1-1.pgdg100+1)
-- Dumped by pg_dump version 13.0

-- Started on 2020-12-14 21:15:43

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

-- Completed on 2020-12-14 21:15:43

--
-- PostgreSQL database dump complete
--

--
-- Database "assignment_2_database" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1 (Debian 13.1-1.pgdg100+1)
-- Dumped by pg_dump version 13.0

-- Started on 2020-12-14 21:15:43

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

--
-- TOC entry 2967 (class 1262 OID 16391)
-- Name: assignment_2_database; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE assignment_2_database WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE assignment_2_database OWNER TO postgres;

\connect assignment_2_database

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

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 16419)
-- Name: family_member_spouse_mapping_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.family_member_spouse_mapping_table (
    id bigint NOT NULL,
    family_member_id_a bigint NOT NULL,
    family_member_id_b bigint NOT NULL
);


ALTER TABLE public.family_member_spouse_mapping_table OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16399)
-- Name: family_members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.family_members (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    gender_ordinal bigint NOT NULL,
    marital_status_ordinal bigint NOT NULL,
    occupation_type_ordinal bigint NOT NULL,
    annual_income double precision,
    date_of_birth date
);


ALTER TABLE public.family_members OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16397)
-- Name: household_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.household_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.household_id_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16404)
-- Name: household_members_mapping_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.household_members_mapping_table (
    id bigint NOT NULL,
    household_id bigint NOT NULL,
    family_member_id bigint NOT NULL
);


ALTER TABLE public.household_members_mapping_table OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16392)
-- Name: households; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.households (
    id bigint NOT NULL,
    housing_type_ordinal bigint NOT NULL
);


ALTER TABLE public.households OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 16419)
-- Dependencies: 204
-- Data for Name: family_member_spouse_mapping_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.family_member_spouse_mapping_table (id, family_member_id_a, family_member_id_b) FROM stdin;
\.


--
-- TOC entry 2959 (class 0 OID 16399)
-- Dependencies: 202
-- Data for Name: family_members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.family_members (id, name, gender_ordinal, marital_status_ordinal, occupation_type_ordinal, annual_income, date_of_birth) FROM stdin;
\.


--
-- TOC entry 2960 (class 0 OID 16404)
-- Dependencies: 203
-- Data for Name: household_members_mapping_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.household_members_mapping_table (id, household_id, family_member_id) FROM stdin;
\.


--
-- TOC entry 2957 (class 0 OID 16392)
-- Dependencies: 200
-- Data for Name: households; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.households (id, housing_type_ordinal) FROM stdin;
10000	0
\.


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 201
-- Name: household_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.household_id_sequence', 1, false);


--
-- TOC entry 2822 (class 2606 OID 16423)
-- Name: family_member_spouse_mapping_table family_member_spouse_mapping_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_spouse_mapping_table_pkey PRIMARY KEY (id);


--
-- TOC entry 2818 (class 2606 OID 16403)
-- Name: family_members family_members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_members
    ADD CONSTRAINT family_members_pkey PRIMARY KEY (id);


--
-- TOC entry 2820 (class 2606 OID 16408)
-- Name: household_members_mapping_table household_members_mapping_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_members_mapping_table_pkey PRIMARY KEY (id);


--
-- TOC entry 2816 (class 2606 OID 16396)
-- Name: households households_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.households
    ADD CONSTRAINT households_pkey PRIMARY KEY (id);


--
-- TOC entry 2824 (class 2606 OID 16414)
-- Name: household_members_mapping_table family_member_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT family_member_id FOREIGN KEY (family_member_id) REFERENCES public.family_members(id);


--
-- TOC entry 2825 (class 2606 OID 16424)
-- Name: family_member_spouse_mapping_table family_member_id_a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_a FOREIGN KEY (family_member_id_a) REFERENCES public.family_members(id);


--
-- TOC entry 2826 (class 2606 OID 16429)
-- Name: family_member_spouse_mapping_table family_member_id_b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_b FOREIGN KEY (family_member_id_b) REFERENCES public.family_members(id);


--
-- TOC entry 2823 (class 2606 OID 16409)
-- Name: household_members_mapping_table household_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_id FOREIGN KEY (household_id) REFERENCES public.households(id);


-- Completed on 2020-12-14 21:15:43

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1 (Debian 13.1-1.pgdg100+1)
-- Dumped by pg_dump version 13.0

-- Started on 2020-12-14 21:15:43

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

-- Completed on 2020-12-14 21:15:43

--
-- PostgreSQL database dump complete
--

-- Completed on 2020-12-14 21:15:43

--
-- PostgreSQL database cluster dump complete
--

