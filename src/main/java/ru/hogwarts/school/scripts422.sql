CREATE TABLE persons
(
    name   VARCHAR,
    age    INTEGER,
    id     BOOLEAN DEFAULT 0,
    car_id INTEGER REFERENCES cars (id)
);

CREATE TABLE cars
    (
        brand VARCHAR,
        model VARCHAR,
        price NUMERIC CHECK (price > 0),
        id SERIAL PRIMARY KEY
    );