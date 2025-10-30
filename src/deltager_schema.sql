DROP SCHEMA IF EXISTS deltager_schema CASCADE;
CREATE SCHEMA deltager_schema;
SET search_path TO deltager_schema;

CREATE TABLE deltager
(
    mobil CHARACTER (8) PRIMARY KEY,
    hash CHARACTER (64) NOT NULL,
    salt CHARACTER (32) NOT NULL,
    fornavn CHARACTER VARYING (40),
    etternavn CHARACTER VARYING (40),
    kjonn CHARACTER VARYING (6)
);

INSERT INTO
    deltager(mobil, hash, salt, fornavn, etternavn, kjonn)
VALUES
    ('23456789', 'a8f5f167f44f4964e6c998dee827110c', 's@lt1!', 'Anne', 'Panne', 'Kvinne'),
    ('12321378', '1dcca23355272056f04fe8bf20edfce0', 'pepper2#', 'Xx-x', 'Xxx', 'Kvinne'),
    ('90123456', '5f4dcc3b5aa765d61d8327deb882cf99', 's4lt$', 'Arne', 'Arnesen', 'Mann'),
    ('34534534', 'e99a18c428cb38d5f260853678922e03', '123!abc', 'Per', 'Viskelær', 'Mann'),
    ('12345679', '098f6bcd4621d373cade4e832627b4f6', 'zzTOP!', 'Lars-Petter', 'Helland', 'Mann'),
    ('87654321', '25d55ad283aa400af464c76d713c07ad', 's0mething?', 'Maria', 'Nordli', 'Kvinne');