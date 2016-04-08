-- Table: public."User"

-- DROP TABLE public."User";

CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  username character varying(20) NOT NULL,
  password character varying(255) NOT NULL,
  email character varying(50) NOT NULL,
  address character varying(100),
  usertype character varying(10) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."User"
  OWNER TO postgres;