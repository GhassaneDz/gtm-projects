DROP TABLE IF EXISTS VOITURE;

CREATE TABLE IF NOT EXISTS VOITURE (
    ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
    MODEL VARCHAR(255) NOT NULL,
    KM VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

