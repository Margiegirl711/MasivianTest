--------------------------------------------------------
-- Archivo creado  - domingo-agosto-04-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ADDRESS
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_ADDRESS"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  CYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_CALCULATOR
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_CALCULATOR"  MINVALUE 0 MAXVALUE 9999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  CYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_COMPANY
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_COMPANY"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  CYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_GEO
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_GEO"  MINVALUE 1 MAXVALUE 9999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  CYCLE ;
--------------------------------------------------------
--  DDL for Table USER_MASIVIAN
--------------------------------------------------------

  CREATE TABLE "USER_MASIVIAN" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(2000 BYTE), 
	"USERNAME" VARCHAR2(2000 BYTE), 
	"EMAIL" VARCHAR2(2000 BYTE), 
	"PHONE" VARCHAR2(2000 BYTE), 
	"WEBSITE" VARCHAR2(2000 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  CREATE TABLE "ADDRESS_USER_MASIVIAN" 
   (	"USER_ID" NUMBER, 
	"ADDRESS_ID" NUMBER, 
	"STREET" VARCHAR2(2000 BYTE), 
	"SUITE" VARCHAR2(2000 BYTE), 
	"CITY" VARCHAR2(2000 BYTE), 
	"ZIPCODE" VARCHAR2(2000 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table CALCULADORA
--------------------------------------------------------

  CREATE TABLE "CALCULADORA" 
   (	"CALCULADORA_ID" NUMBER(13,0), 
	"OPERACION_ID" NUMBER(13,0), 
	"VALORA" NUMBER(13,0), 
	"VALORB" NUMBER(13,0), 
	"RESULTADO" NUMBER(13,0), 
	"MENSAJE" VARCHAR2(2000 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table OPERACIONES
--------------------------------------------------------

  CREATE TABLE "OPERACIONES" 
   (	"OPERACION_ID" NUMBER(13,0), 
	"DESCRIPCION" VARCHAR2(200 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table COMPANY_USER_MASIVIAN
--------------------------------------------------------

  CREATE TABLE "COMPANY_USER_MASIVIAN" 
   (	"USER_ID" NUMBER, 
	"COMPANY_ID" NUMBER, 
	"NAME" VARCHAR2(2000 BYTE), 
	"CATCHPHRASE" VARCHAR2(2000 BYTE), 
	"BS" VARCHAR2(2000 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table GEO_ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  CREATE TABLE "GEO_ADDRESS_USER_MASIVIAN" 
   (	"USER_ID" NUMBER, 
	"ADDRESS_ID" NUMBER, 
	"GEO_ID" NUMBER, 
	"LAT" VARCHAR2(2000 BYTE), 
	"LNG" VARCHAR2(2000 BYTE)
   ) ;


Insert into OPERACIONES (OPERACION_ID,DESCRIPCION) values ('1','Adicion');
Insert into OPERACIONES (OPERACION_ID,DESCRIPCION) values ('2','Division');
Insert into OPERACIONES (OPERACION_ID,DESCRIPCION) values ('3','Multiplicacion');
Insert into OPERACIONES (OPERACION_ID,DESCRIPCION) values ('4','Sustraccion');
commit;
--------------------------------------------------------
--  DDL for Index USER_MASIVIAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_MASIVIAN_PK" ON "USER_MASIVIAN" ("ID") ;
--------------------------------------------------------
--  DDL for Index ADDRES_USER_MASIVIAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADDRES_USER_MASIVIAN_PK" ON "ADDRESS_USER_MASIVIAN" ("ADDRESS_ID");
--------------------------------------------------------
--  DDL for Index CALCULADORA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALCULADORA_PK" ON "CALCULADORA" ("CALCULADORA_ID") ;
--------------------------------------------------------
--  DDL for Index OPERACIONES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "OPERACIONES_PK" ON "OPERACIONES" ("OPERACION_ID")  ;
--------------------------------------------------------
--  DDL for Index COMPANY_USER_MASIVIAN_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPANY_USER_MASIVIAN_PK1" ON "COMPANY_USER_MASIVIAN" ("COMPANY_ID") ;
--------------------------------------------------------
--  DDL for Index GEO_ADDRESS_USER_MASIVIAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GEO_ADDRESS_USER_MASIVIAN_PK" ON "GEO_ADDRESS_USER_MASIVIAN" ("GEO_ID")  ;
--------------------------------------------------------
--  Constraints for Table USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "USER_MASIVIAN" ADD CONSTRAINT "USER_MASIVIAN_PK" PRIMARY KEY ("ID");
  ALTER TABLE "USER_MASIVIAN" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "ADDRESS_USER_MASIVIAN" ADD CONSTRAINT "ADDRES_USER_MASIVIAN_PK" PRIMARY KEY ("ADDRESS_ID");
  ALTER TABLE "ADDRESS_USER_MASIVIAN" MODIFY ("ADDRESS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALCULADORA
--------------------------------------------------------

  ALTER TABLE "CALCULADORA" ADD CONSTRAINT "CALCULADORA_PK" PRIMARY KEY ("CALCULADORA_ID");
  ALTER TABLE "CALCULADORA" MODIFY ("CALCULADORA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OPERACIONES
--------------------------------------------------------

  ALTER TABLE "OPERACIONES" ADD CONSTRAINT "OPERACIONES_PK" PRIMARY KEY ("OPERACION_ID");
  ALTER TABLE "OPERACIONES" MODIFY ("OPERACION_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMPANY_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "COMPANY_USER_MASIVIAN" ADD CONSTRAINT "COMPANY_USER_MASIVIAN_PK_1" PRIMARY KEY ("COMPANY_ID");
  ALTER TABLE "COMPANY_USER_MASIVIAN" MODIFY ("COMPANY_ID" NOT NULL ENABLE);
  ALTER TABLE "COMPANY_USER_MASIVIAN" MODIFY ("USER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GEO_ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "GEO_ADDRESS_USER_MASIVIAN" ADD CONSTRAINT "GEO_ADDRESS_USER_MASIVIAN_PK" PRIMARY KEY ("GEO_ID");
  ALTER TABLE "GEO_ADDRESS_USER_MASIVIAN" MODIFY ("GEO_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "ADDRESS_USER_MASIVIAN" ADD CONSTRAINT "ADDRESS_USER_MASIVIAN_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USER_MASIVIAN" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALCULADORA
--------------------------------------------------------

  ALTER TABLE "CALCULADORA" ADD CONSTRAINT "CALCULADORA_FK1" FOREIGN KEY ("OPERACION_ID")
	  REFERENCES "OPERACIONES" ("OPERACION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMPANY_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "COMPANY_USER_MASIVIAN" ADD CONSTRAINT "COMPANY_USER_MASIVIAN_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USER_MASIVIAN" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GEO_ADDRESS_USER_MASIVIAN
--------------------------------------------------------

  ALTER TABLE "GEO_ADDRESS_USER_MASIVIAN" ADD CONSTRAINT "GEO_ADDRESS_USER_MASIVIAN_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USER_MASIVIAN" ("ID") ENABLE;
  ALTER TABLE "GEO_ADDRESS_USER_MASIVIAN" ADD CONSTRAINT "GEO_ADDRESS_USER_MASIVIAN_FK2" FOREIGN KEY ("ADDRESS_ID")
	  REFERENCES "ADDRESS_USER_MASIVIAN" ("ADDRESS_ID") ENABLE;
