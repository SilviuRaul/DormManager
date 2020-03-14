CREATE TABLE public.dorm
(
    "dormId" serial NOT NULL,
    name character varying(10),
    "roomSize" integer,
    "dormType" character varying(15),
    "numberOfRooms" integer,
    PRIMARY KEY ("dormId")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.dorm
    OWNER to postgres;