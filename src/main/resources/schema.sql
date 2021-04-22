DROP table if exists Batches;
create table Batches(
batch_id int PRIMARY KEY,
name VARCHAR(50) NOT NULL,
batch VARCHAR(50) NOT NULL,
price INT,
quantity INT,
Manufacturer)
nested table Manufacturer