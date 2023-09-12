
DROP TABLE IF EXISTS public."Business";

DROP TABLE IF EXISTS public."Company";

CREATE TABLE IF NOT EXISTS public."Company"
(
    siret integer NOT NULL PRIMARY KEY,
    designation character varying(200),
    "HQaddress" character varying(250),
    type integer,
    totalvalue integer NOT NULL DEFAULT 0,
    tax double precision NOT NULL DEFAULT 0.0,
    currency character varying(3)
);

INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (123654865, 'ma petite entreprise', '', 1, 2500000, 0,'EUR');
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (78454568, 'ceetiz', '13-15 Rue des Sablons, 75116 Paris', 2, 95000000, 0,'EUR');
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (546872654, 'clubmed', '11 Rue de cambrai, 75119 Paris', 2, 6500000, 0, 'EUR');
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (465210257, 'TF1', '3 Rue Jean Moulin, 92220 Issy les Moulineaux', 2, 83200000, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (563470132, 'La Fnac', '3 rue des roses, 21000 Dijon', 2, 2305000, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (032587431, 'Burger king', '', 1, 28066540, 0, 'USD');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (88899332, 'Dupont ou Dupond', '', 1, 12000, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (224411003, 'Ben & Jerry''s', '25 Avenue du Sucre, 59000 Lille', 2, 77500000, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (33014987, 'Je cree ma boite', '', 1, 88800, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (68963215, 'Universal', '20 boulevard d''Hollywood, 13001 Marseille', 2, 2000150, 0);	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (887443201, 'Tartenpion company', '', 1, 5000, 0, 'EUR');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (66442009, 'coca cola company', '1 place du trocadero, 75008 Paris', 2, 99999900, 0, 'USD');	
	
INSERT INTO public."Company"(
	siret, designation, "HQaddress", type, totalvalue, tax, currency)
	VALUES (5556952, '2 hot 4 U ', '', 1, 6000278, 0, 'USD');	
	