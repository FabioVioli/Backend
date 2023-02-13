CREATE TABLE IF NOT EXISTS clienti (
	id SERIAL,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	dataNascita INT4 NOT NULL,
	regioneResidenza VARCHAR,
	CONSTRAINT clienti_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS prodotti (
	id SERIAL,
	descrizione VARCHAR NOT NULL,
	inProduzione BOOLEAN NOT NULL,
	inCommercio BOOLEAN NOT NULL,
	dataAttivazione INT4 NOT NULL,
	dataDisattivazione INT4 NOT NULL,
	CONSTRAINT prodotti_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fornitori (
	id SERIAL,
	denominazione VARCHAR NOT NULL,
	regioneResidenza VARCHAR NOT NULL,
	CONSTRAINT fornitori_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fatture (
	id SERIAL,
	tipologia VARCHAR NOT NULL,
	importo INT8 NOT NULL,
	iva INT4 NOT NULL,
	idCliente INT4 NOT NULL,
	dataFattura int4 NOT NULL,
	numeroFornitore INT4 NOT NULL,
	CONSTRAINT fatture_pk PRIMARY KEY (id),
	CONSTRAINT clienti_pk FOREIGN KEY (id) REFERENCES clienti(id),
	CONSTRAINT fornitori_pk FOREIGN KEY (id) REFERENCES fornitori(id)
);



INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Amazon','Seattle');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Facebook','Menlo Park');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Twitter','San Francisco');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Decathlon','Lille');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Epicode','Milan');

INSERT INTO clienti (nome, cognome, datanascita,regioneresidenza) VALUES ('Tony','Caproni',1982, 'Calabria');
INSERT INTO clienti (nome, cognome, datanascita,regioneresidenza) VALUES ('Dario','Lampa',1980, 'Emilia Romagna');
INSERT INTO clienti (nome, cognome, datanascita,regioneresidenza) VALUES ('Silvio','Berlusconi',1800, 'Lombardia');
INSERT INTO clienti (nome, cognome, datanascita,regioneresidenza) VALUES ('Felice','Di Domenica',1982, 'Abruzzo');
INSERT INTO clienti (nome, cognome, datanascita,regioneresidenza) VALUES ('Gana','Pante',1800, 'Abruzzo');

INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione ) VALUES ('Palla',FALSE,TRUE,2000,2040);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione ) VALUES ('Ananas',TRUE,TRUE,2010,2030);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione ) VALUES ('Libro',FALSE,TRUE,1015,2040);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione ) VALUES ('Padella',TRUE,TRUE,2010,2040);

INSERT INTO fatture (tipologia,importo,iva,datafattura,idcliente,numerofornitore) VALUES ('A',200,10,2000,2,3);
INSERT INTO fatture (tipologia,importo,iva,datafattura,idcliente,numerofornitore) VALUES ('B',200,15,1995,3,5);
INSERT INTO fatture (tipologia,importo,iva,datafattura,idcliente,numerofornitore) VALUES ('A',200,15,2015,1,1);
INSERT INTO fatture (tipologia,importo,iva,datafattura,idcliente,numerofornitore) VALUES ('A',200,10,2015,4,4);
INSERT INTO fatture (tipologia,importo,iva,datafattura,idcliente,numerofornitore) VALUES ('B',200,20,2012,5,2);

-------------------------------------------------------- EXERCISES


drop table clienti, fornitori, prodotti, fatture

SELECT nome,cognome FROM clienti WHERE datanascita = 1982;
SELECT COUNT (fatture.id) FROM fatture WHERE iva = 20;
--
SELECT * FROM prodotti WHERE prodotti.dataattivazione = 2010 and (inproduzione = TRUE or incommercio = TRUE);
