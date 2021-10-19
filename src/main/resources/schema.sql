DROP TABLE IF EXISTS "mt_user_role";
DROP TABLE IF EXISTS "mt_user";
DROP TABLE IF EXISTS "mt_role";


---CREATE TABLE---
CREATE TABLE "mt_role"
(
    "id"   serial      NOT NULL,
    "name" varchar(50) NOT NULL,
    CONSTRAINT "mt_role_pk" PRIMARY KEY ("id")
) WITH (
      OIDS = FALSE
      );

CREATE TABLE "mt_user" (
                           "id" serial NOT NULL,
                           "username" varchar(50) NOT NULL UNIQUE,
                           "password" varchar(200) NOT NULL,
                           "email" varchar(50) NOT NULL UNIQUE,
                           CONSTRAINT "mt_user_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );

CREATE TABLE "mt_user_role" (
                                "id" serial NOT NULL,
                                "fk_user_id" integer NOT NULL,
                                "fk_role_id" integer NOT NULL,
                                CONSTRAINT "mt_user_role_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );
ALTER TABLE "mt_user_role" ADD CONSTRAINT "mt_user_role_fk0" FOREIGN KEY ("fk_user_id") REFERENCES "mt_user"("id");
ALTER TABLE "mt_user_role" ADD CONSTRAINT "mt_user_role_fk1" FOREIGN KEY ("fk_role_id") REFERENCES "mt_role"("id");

---INSERT TABLE---
INSERT INTO "mt_role" (id,name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO "mt_role" (id,name) VALUES (default,'ROLE_KULLANICI');

INSERT INTO "mt_user" (id, username, email, password) VALUES (default, 'Turkuaz', 'turkuazsengul', 'qwe.1234');
INSERT INTO "mt_user" (id, username, email, password) VALUES (default, 'Dodo', 'dodo@yahoo.com',  'qwe.1234');

INSERT INTO "mt_user_role" (id, fk_user_id, fk_role_id) VALUES (default, 1, 1);
INSERT INTO "mt_user_role" (id, fk_user_id, fk_role_id) VALUES (default, 2, 2);

