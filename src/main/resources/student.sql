CREATE TABLE public.student
(
    "studentId" serial NOT NULL,
    name character varying(50),
    "admissionMean" double precision,
    "civilStatus" character varying(10),
    gender character varying(10),
    age integer,
    "currentYear" integer,
    cnp character varying(13),
    email character varying(50),
    "phoneNumber" character varying(15),
    faculty character varying(20),
    "dormRef" serial,
    PRIMARY KEY ("studentId"),
    CONSTRAINT "dormFK" FOREIGN KEY ("dormRef")
        REFERENCES public.dorm ("dormId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.student
    OWNER to postgres;