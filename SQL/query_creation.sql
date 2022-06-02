CREATE TABLE user(
	id SMALLINT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(255),
    gender VARCHAR(6) NOT NULL CHECK(gender IN ("Male", "Female", "Other")),
    phone SMALLINT UNSIGNED NOT NULL,
    type VARCHAR(15) NOT NULL CHECK(type IN("Customer", "DeliveryMan", "Administrator")),
    email VARCHAR(30) NOT NULL UNIQUE,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    CONSTRAINT pk_user_id PRIMARY KEY (id)
    )ENGINE=InnoDB;


CREATE TABLE address(
	id SMALLINT AUTO_INCREMENT,
    code VARCHAR(8) NOT NULL UNIQUE,
    quarter VARCHAR(50) NOT NULL,
    mark VARCHAR(100),
    country VARCHAR(30) NOT NULL DEFAULT 'Yaoundé',
    iduser SMALLINT NOT NULL,
    CONSTRAINT pk_address_id PRIMARY KEY (id),
    CONSTRAINT fk_address_user_id FOREIGN KEY(iduser) REFERENCES user(id)
    )ENGINE=InnoDB;

CREATE TABLE delivery(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
    state BOOLEAN NOT NULL DEFAULT FALSE,
    iduser SMALLINT NOT NULL,
    CONSTRAINT pk_delivery_id PRIMARY KEY (id),
    CONSTRAINT fk_delivery_user_id FOREIGN KEY(iduser) REFERENCES user(id)
    )ENGINE=InnoDB;

CREATE TABLE payment(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
    totalprice DOUBLE NOT NULL DEFAULT 0,
    iduser SMALLINT NOT NULL,
    CONSTRAINT pk_payment_id PRIMARY KEY (id),
    CONSTRAINT fk_payment_user_id FOREIGN KEY(iduser) REFERENCES user(id)
    )ENGINE=InnoDB;

CREATE TABLE shopping_list(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
	idpayment SMALLINT NOT NULL,
    iddelivery SMALLINT NOT NULL,
    iduser SMALLINT NOT NULL,
    CONSTRAINT pk_shopping_list_id PRIMARY KEY (id),
    CONSTRAINT fk_shopping_list_user_id FOREIGN KEY(iduser) REFERENCES user(id),
    CONSTRAINT fk_shopping_list_payment_id FOREIGN KEY(idpayment) REFERENCES payment(id),
    CONSTRAINT fk_shopping_list_delivery_id FOREIGN KEY(iddelivery) REFERENCES delivery(id)
    )ENGINE=InnoDB;

CREATE TABLE category(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL DEFAULT 'Uncategory',
    CONSTRAINT pk_category_id PRIMARY KEY (id)
    )ENGINE=InnoDB;

CREATE TABLE product(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    unitprice DOUBLE NOT NULL DEFAULT 0,
    description VARCHAR(255),
    quantityList SMALLINT UNSIGNED DEFAULT 0,
    idcategory SMALLINT NOT NULL,
    CONSTRAINT pk_product_id PRIMARY KEY (id),
    CONSTRAINT fk_product_category_id FOREIGN KEY(idcategory) REFERENCES category(id)
    )ENGINE=InnoDB;

CREATE TABLE image(
	id SMALLINT AUTO_INCREMENT,
    reference VARCHAR(15) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL DEFAULT 'Image',
    url VARCHAR(100) NOT NULL UNIQUE,
    idproduct SMALLINT NOT NULL,
    CONSTRAINT pk_image_id PRIMARY KEY (id),
    CONSTRAINT fk_image_product_id FOREIGN KEY(idproduct) REFERENCES product(id)
    )ENGINE=InnoDB;

CREATE TABLE product_shopping_list(
	idshoppinglist SMALLINT NOT NULL,
    idproduct SMALLINT NOT NULL,
    CONSTRAINT pk_product_shopping PRIMARY KEY(idshoppinglist, idproduct),
    CONSTRAINT fk_product_product FOREIGN KEY (idproduct) REFERENCES product(id),
    CONSTRAINT fk_shopping_shopping FOREIGN KEY (idshoppinglist) REFERENCES shopping_list(id)
    )ENGINE=InnoDB;

INSERT INTO category(reference, name) VALUES
	('milk', 'Produits laitiers'),
    ('meat', 'Viandes'),
    ('fat', 'Matières grasses'),
    ('legumes', 'Légumes & fruits'),
    ('cereal', 'Céréales & Dérivés'),
    ('sugar', 'Sucres & Produits sucrés'),
    ('drink', 'Boissons');
    
INSERT INTO product(reference, name, unitprice, description, idcategory) VALUES
	('MI001', 'Dolait', 100, 'Vendu uniquement en paquet. Sachet de lait caillé', 1),
    ('ME001', 'Filet de boeuf', 1250, 'Vendu en 1/2Kg. Viande cértifié halal', 1),
	('LE001', 'Banane mûr', 125, 'Banane bien ferme, mûr et cultivés dans la région de l\'ouest du Cameroun', 4);
    
    ALTER TABLE user CHANGE phone phone BIGINT UNSIGNED NOT NULL;
    
INSERT INTO user(name, surname, gender, phone, type, email, username, password) VALUES
	('TOTO', 'Junior', 'Male', 655787878, 'Customer', 'totojunior@gmail.com', 'toto_junior', 'toto'),
	('TATA', 'Christelle', 'Female', 651787878, 'Customer', 'tatachristelle@gmail.com', 'tata_christelle', 'tata'),
	('TITOUNE', 'Yves', 'Male', 654787878, 'Customer', 'titouneyves@gmail.com', 'titoune_yves', 'titoune');
    
    ALTER TABLE shopping_list CHANGE idpayment idpayment SMALLINT;
	ALTER TABLE shopping_list CHANGE iddelivery iddelivery SMALLINT;
    
INSERT INTO shopping_list(reference, iduser) VALUES
	('TOT001', 1),
	('TOT002', 1),
	('TAT001', 2),
	('TIT001', 3);

INSERT INTO product_shopping_list VALUES
	(1, 1), /* Ajout dans la liste du client X id = 1 le produit id=1 */
    (1, 2),
    (1, 3),
    (2, 1),
    (3, 1),
	(4, 2);
