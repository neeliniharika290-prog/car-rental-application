--
-- PostgreSQL database dump
--

\restrict bUb5Fe8nQT8ExzeKzfOcqgb1xLF3NyrtZLsODrexgpELwP9FZEY9tyRf3VO1uzu

-- Dumped from database version 18.7
-- Dumped by pg_dump version 18.6

-- Started on 2026-11-23 22:00:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 221 (class 1259 OID 16422)
-- Name: bookings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bookings (
    booking_id integer NOT NULL,
    customer_id integer,
    car_id integer,
    rental_days integer NOT NULL,
    total_amount numeric(10,2),
    booking_date date DEFAULT CURRENT_DATE,
    status character varying(20) DEFAULT 'Booked'::character varying,
    CONSTRAINT bookings_rental_days_check CHECK ((rental_days > 0))
);
ALTER TABLE ONLY public.bookings ALTER COLUMN booking_id SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN customer_id SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN car_id SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN rental_days SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN total_amount SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN booking_date SET (pg_attver=40835320);
ALTER TABLE ONLY public.bookings ALTER COLUMN status SET (pg_attver=40835320);


ALTER TABLE public.bookings OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16414)
-- Name: cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cars (
    car_id integer NOT NULL,
    car_name character varying(100) NOT NULL,
    brand character varying(50),
    model_year integer,
    rent_per_day numeric(10,2),
    availability character varying(20) DEFAULT 'Available'::character varying
);
ALTER TABLE ONLY public.cars ALTER COLUMN car_id SET (pg_attver=40632104);
ALTER TABLE ONLY public.cars ALTER COLUMN car_name SET (pg_attver=40632104);
ALTER TABLE ONLY public.cars ALTER COLUMN brand SET (pg_attver=40632104);
ALTER TABLE ONLY public.cars ALTER COLUMN model_year SET (pg_attver=40632104);
ALTER TABLE ONLY public.cars ALTER COLUMN rent_per_day SET (pg_attver=40632104);
ALTER TABLE ONLY public.cars ALTER COLUMN availability SET (pg_attver=40632104);


ALTER TABLE public.cars OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16406)
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    customer_id integer NOT NULL,
    customer_name character varying(100) NOT NULL,
    phone character varying(15) NOT NULL,
    age integer,
    email character varying(100)
);
ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET (pg_attver=40451952);
ALTER TABLE ONLY public.customers ALTER COLUMN customer_name SET (pg_attver=40451952);
ALTER TABLE ONLY public.customers ALTER COLUMN phone SET (pg_attver=40451952);
ALTER TABLE ONLY public.customers ALTER COLUMN age SET (pg_attver=40451952);
ALTER TABLE ONLY public.customers ALTER COLUMN email SET (pg_attver=40981880);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 5024 (class 0 OID 16422)
-- Dependencies: 221
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bookings (booking_id, customer_id, car_id, rental_days, total_amount, booking_date, status) FROM stdin;
1	101	1	3	4500.00	2026-11-22	Cancelled
2	101	1	2	3000.00	2026-11-22	Cancelled
3	101	1	2	3000.00	2026-11-23	Booked
4	101	1	2	3000.00	2026-11-23	Cancelled
\.


--
-- TOC entry 5023 (class 0 OID 16414)
-- Dependencies: 220
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cars (car_id, car_name, brand, model_year, rent_per_day, availability) FROM stdin;
1	Swift	Maruti	2023	1500.00	Available
\.


--
-- TOC entry 5022 (class 0 OID 16406)
-- Dependencies: 219
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customers (customer_id, customer_name, phone, age, email) FROM stdin;
101	Chandana	9875437939	22	\N
105	AnjaliSharma	9876543210	\N	anjali.sharma@gmail.com
106	Rahul	9876543210	\N	rahul.test@gmail.com
\.


--
-- TOC entry 4872 (class 2606 OID 16431)
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (booking_id);


--
-- TOC entry 4870 (class 2606 OID 16421)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (car_id);


--
-- TOC entry 4868 (class 2606 OID 16413)
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);


--
-- TOC entry 4873 (class 2606 OID 16437)
-- Name: bookings bookings_car_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_car_id_fkey FOREIGN KEY (car_id) REFERENCES public.cars(car_id);


--
-- TOC entry 4874 (class 2606 OID 16432)
-- Name: bookings bookings_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


-- Completed on 2026-11-23 22:00:55

--
-- PostgreSQL database dump complete
--

\unrestrict bUb5Fe8nQT8ExzeKzfOcqgb1xLF3NyrtZLsODrexgpELwP9FZEY9tyRf3VO1uzu

