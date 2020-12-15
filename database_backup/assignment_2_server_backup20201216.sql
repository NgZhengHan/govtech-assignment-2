--
-- PostgreSQL database cluster dump
--

-- Started on 2020-12-16 03:25:39

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

-- Started on 2020-12-16 03:25:39

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

-- Completed on 2020-12-16 03:25:39

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

-- Started on 2020-12-16 03:25:40

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
-- TOC entry 2975 (class 1262 OID 16391)
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

--
-- TOC entry 205 (class 1259 OID 16434)
-- Name: family_member_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.family_member_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.family_member_id_sequence OWNER TO postgres;

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
-- TOC entry 206 (class 1259 OID 16436)
-- Name: household_members_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.household_members_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.household_members_id_sequence OWNER TO postgres;

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
-- TOC entry 2967 (class 0 OID 16419)
-- Dependencies: 204
-- Data for Name: family_member_spouse_mapping_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.family_member_spouse_mapping_table (id, family_member_id_a, family_member_id_b) FROM stdin;
\.


--
-- TOC entry 2965 (class 0 OID 16399)
-- Dependencies: 202
-- Data for Name: family_members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.family_members (id, name, gender_ordinal, marital_status_ordinal, occupation_type_ordinal, annual_income, date_of_birth) FROM stdin;
1	John Doe	2	2	4	150000	2020-12-15
2	John Doe	2	2	4	150000	2020-12-15
3	John Doe	2	2	4	150000	2020-12-16
4	John Doe	2	2	4	150000	2020-12-16
5	John Doe	2	2	4	150000	2020-12-16
6	John Doe	2	2	4	150000	2020-12-16
7	John Doe	2	2	4	150000	2020-12-16
\.


--
-- TOC entry 2966 (class 0 OID 16404)
-- Dependencies: 203
-- Data for Name: household_members_mapping_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.household_members_mapping_table (id, household_id, family_member_id) FROM stdin;
22	4	1
23	4	2
24	4	3
25	4	4
\.


--
-- TOC entry 2963 (class 0 OID 16392)
-- Dependencies: 200
-- Data for Name: households; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.households (id, housing_type_ordinal) FROM stdin;
5	4
6	4
7	4
8	4
9	4
10	4
11	4
12	4
13	4
14	4
15	4
16	4
17	4
18	4
19	4
20	4
21	4
22	4
23	4
24	4
25	4
4	4
26	4
27	4
28	4
29	4
30	3
\.


--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 205
-- Name: family_member_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.family_member_id_sequence', 7, true);


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 201
-- Name: household_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.household_id_sequence', 30, true);


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 206
-- Name: household_members_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.household_members_id_sequence', 41, true);


--
-- TOC entry 2828 (class 2606 OID 16423)
-- Name: family_member_spouse_mapping_table family_member_spouse_mapping_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_spouse_mapping_table_pkey PRIMARY KEY (id);


--
-- TOC entry 2822 (class 2606 OID 16403)
-- Name: family_members family_members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_members
    ADD CONSTRAINT family_members_pkey PRIMARY KEY (id);


--
-- TOC entry 2824 (class 2606 OID 16408)
-- Name: household_members_mapping_table household_members_mapping_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_members_mapping_table_pkey PRIMARY KEY (id);


--
-- TOC entry 2820 (class 2606 OID 16396)
-- Name: households households_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.households
    ADD CONSTRAINT households_pkey PRIMARY KEY (id);


--
-- TOC entry 2826 (class 2606 OID 16443)
-- Name: household_members_mapping_table unique_key_1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT unique_key_1 UNIQUE (household_id, family_member_id);


--
-- TOC entry 2830 (class 2606 OID 16414)
-- Name: household_members_mapping_table family_member_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT family_member_id FOREIGN KEY (family_member_id) REFERENCES public.family_members(id);


--
-- TOC entry 2831 (class 2606 OID 16424)
-- Name: family_member_spouse_mapping_table family_member_id_a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_a FOREIGN KEY (family_member_id_a) REFERENCES public.family_members(id);


--
-- TOC entry 2832 (class 2606 OID 16429)
-- Name: family_member_spouse_mapping_table family_member_id_b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_b FOREIGN KEY (family_member_id_b) REFERENCES public.family_members(id);


--
-- TOC entry 2829 (class 2606 OID 16409)
-- Name: household_members_mapping_table household_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_id FOREIGN KEY (household_id) REFERENCES public.households(id);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 2975
-- Name: DATABASE assignment_2_database; Type: ACL; Schema: -; Owner: postgres
--

REVOKE CONNECT,TEMPORARY ON DATABASE assignment_2_database FROM PUBLIC;
REVOKE ALL ON DATABASE assignment_2_database FROM postgres;
GRANT ALL ON DATABASE assignment_2_database TO postgres WITH GRANT OPTION;


-- Completed on 2020-12-16 03:25:40

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

-- Started on 2020-12-16 03:25:40

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

-- Completed on 2020-12-16 03:25:40

--
-- PostgreSQL database dump complete
--

-- Completed on 2020-12-16 03:25:40

--
-- PostgreSQL database cluster dump complete
--

