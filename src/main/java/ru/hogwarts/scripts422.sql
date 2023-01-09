CREATE TABLE persons
(
    id SERIAL PRIMARY KEY,
    name   VARCHAR,
    age    INTEGER,
    id_driver_license INTEGER DEFAULT 0,
    car_id INTEGER REFERENCES cars (id)
);

CREATE TABLE cars
    (
        brand VARCHAR,
        model VARCHAR,
        price NUMERIC CHECK (price > 0),
        id SERIAL PRIMARY KEY
    );