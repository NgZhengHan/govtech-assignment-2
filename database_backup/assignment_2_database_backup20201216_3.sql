PGDMP     &                    x            assignment_2_database    13.1 (Debian 13.1-1.pgdg100+1)    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16391    assignment_2_database    DATABASE     i   CREATE DATABASE assignment_2_database WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
 %   DROP DATABASE assignment_2_database;
                postgres    false            �           0    0    DATABASE assignment_2_database    ACL     �   REVOKE CONNECT,TEMPORARY ON DATABASE assignment_2_database FROM PUBLIC;
REVOKE ALL ON DATABASE assignment_2_database FROM postgres;
GRANT ALL ON DATABASE assignment_2_database TO postgres WITH GRANT OPTION;
                   postgres    false    2978            �            1259    16434 (   family_member_spouse_mapping_id_sequence    SEQUENCE     �   CREATE SEQUENCE public.family_member_spouse_mapping_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.family_member_spouse_mapping_id_sequence;
       public          postgres    false            �            1259    16419 "   family_member_spouse_mapping_table    TABLE     �   CREATE TABLE public.family_member_spouse_mapping_table (
    id bigint NOT NULL,
    family_member_id_a bigint NOT NULL,
    family_member_id_b bigint NOT NULL
);
 6   DROP TABLE public.family_member_spouse_mapping_table;
       public         heap    postgres    false            �            1259    16399    family_members    TABLE     8  CREATE TABLE public.family_members (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    gender_ordinal bigint NOT NULL,
    marital_status_ordinal bigint NOT NULL,
    occupation_type_ordinal bigint NOT NULL,
    annual_income double precision,
    date_of_birth date,
    spouse_id bigint
);
 "   DROP TABLE public.family_members;
       public         heap    postgres    false            �            1259    16397    household_id_sequence    SEQUENCE     ~   CREATE SEQUENCE public.household_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.household_id_sequence;
       public          postgres    false            �            1259    16436    household_members_id_sequence    SEQUENCE     �   CREATE SEQUENCE public.household_members_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.household_members_id_sequence;
       public          postgres    false            �            1259    16404    household_members_mapping_table    TABLE     �   CREATE TABLE public.household_members_mapping_table (
    id bigint NOT NULL,
    household_id bigint NOT NULL,
    family_member_id bigint NOT NULL
);
 3   DROP TABLE public.household_members_mapping_table;
       public         heap    postgres    false            �            1259    16392 
   households    TABLE     e   CREATE TABLE public.households (
    id bigint NOT NULL,
    housing_type_ordinal bigint NOT NULL
);
    DROP TABLE public.households;
       public         heap    postgres    false            �          0    16419 "   family_member_spouse_mapping_table 
   TABLE DATA           h   COPY public.family_member_spouse_mapping_table (id, family_member_id_a, family_member_id_b) FROM stdin;
    public          postgres    false    204   j'       �          0    16399    family_members 
   TABLE DATA           �   COPY public.family_members (id, name, gender_ordinal, marital_status_ordinal, occupation_type_ordinal, annual_income, date_of_birth, spouse_id) FROM stdin;
    public          postgres    false    202   �'       �          0    16404    household_members_mapping_table 
   TABLE DATA           ]   COPY public.household_members_mapping_table (id, household_id, family_member_id) FROM stdin;
    public          postgres    false    203   �'       �          0    16392 
   households 
   TABLE DATA           >   COPY public.households (id, housing_type_ordinal) FROM stdin;
    public          postgres    false    200   (       �           0    0 (   family_member_spouse_mapping_id_sequence    SEQUENCE SET     V   SELECT pg_catalog.setval('public.family_member_spouse_mapping_id_sequence', 7, true);
          public          postgres    false    205            �           0    0    household_id_sequence    SEQUENCE SET     D   SELECT pg_catalog.setval('public.household_id_sequence', 30, true);
          public          postgres    false    201            �           0    0    household_members_id_sequence    SEQUENCE SET     L   SELECT pg_catalog.setval('public.household_members_id_sequence', 45, true);
          public          postgres    false    206                       2606    16423 J   family_member_spouse_mapping_table family_member_spouse_mapping_table_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_spouse_mapping_table_pkey PRIMARY KEY (id);
 t   ALTER TABLE ONLY public.family_member_spouse_mapping_table DROP CONSTRAINT family_member_spouse_mapping_table_pkey;
       public            postgres    false    204                       2606    16403 "   family_members family_members_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.family_members
    ADD CONSTRAINT family_members_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.family_members DROP CONSTRAINT family_members_pkey;
       public            postgres    false    202                       2606    16408 D   household_members_mapping_table household_members_mapping_table_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_members_mapping_table_pkey PRIMARY KEY (id);
 n   ALTER TABLE ONLY public.household_members_mapping_table DROP CONSTRAINT household_members_mapping_table_pkey;
       public            postgres    false    203                       2606    16396    households households_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.households
    ADD CONSTRAINT households_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.households DROP CONSTRAINT households_pkey;
       public            postgres    false    200            
           2606    16443 ,   household_members_mapping_table unique_key_1 
   CONSTRAINT     �   ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT unique_key_1 UNIQUE (household_id, family_member_id);
 V   ALTER TABLE ONLY public.household_members_mapping_table DROP CONSTRAINT unique_key_1;
       public            postgres    false    203    203                       2606    16450 /   family_member_spouse_mapping_table unique_key_2 
   CONSTRAINT     �   ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT unique_key_2 UNIQUE (family_member_id_a, family_member_id_b);
 Y   ALTER TABLE ONLY public.family_member_spouse_mapping_table DROP CONSTRAINT unique_key_2;
       public            postgres    false    204    204                       2606    16414 0   household_members_mapping_table family_member_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT family_member_id FOREIGN KEY (family_member_id) REFERENCES public.family_members(id);
 Z   ALTER TABLE ONLY public.household_members_mapping_table DROP CONSTRAINT family_member_id;
       public          postgres    false    2822    202    203                       2606    16424 5   family_member_spouse_mapping_table family_member_id_a    FK CONSTRAINT     �   ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_a FOREIGN KEY (family_member_id_a) REFERENCES public.family_members(id);
 _   ALTER TABLE ONLY public.family_member_spouse_mapping_table DROP CONSTRAINT family_member_id_a;
       public          postgres    false    204    2822    202                       2606    16429 5   family_member_spouse_mapping_table family_member_id_b    FK CONSTRAINT     �   ALTER TABLE ONLY public.family_member_spouse_mapping_table
    ADD CONSTRAINT family_member_id_b FOREIGN KEY (family_member_id_b) REFERENCES public.family_members(id);
 _   ALTER TABLE ONLY public.family_member_spouse_mapping_table DROP CONSTRAINT family_member_id_b;
       public          postgres    false    204    2822    202                       2606    16409 ,   household_members_mapping_table household_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.household_members_mapping_table
    ADD CONSTRAINT household_id FOREIGN KEY (household_id) REFERENCES public.households(id);
 V   ALTER TABLE ONLY public.household_members_mapping_table DROP CONSTRAINT household_id;
       public          postgres    false    200    203    2820                       2606    16444    family_members spouse_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.family_members
    ADD CONSTRAINT spouse_id FOREIGN KEY (spouse_id) REFERENCES public.family_members(id) NOT VALID;
 B   ALTER TABLE ONLY public.family_members DROP CONSTRAINT spouse_id;
       public          postgres    false    202    202    2822            �      x������ � �      �   G   x�3�����Sp�O�4BNCS �4202�54�54���2"J�1!Uf U&D�2%J�Q�̉R���� �5�      �   %   x�32�4�4�22RF\F&@ʘ��H�p��qqq K3I      �   I   x�˹�0�X(�#���^��9��Kg��ݽ��ILB�,�	��� #�"� ��?PAT�QzI���     