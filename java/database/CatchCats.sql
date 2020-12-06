Create Table Catch_Cats(
Id serial primary key,
Name varchar(50) not null,
Age int not null,
Skills varchar(255) not null,
Hair_Length varchar(50),
Prior_Experience_Months int not null,
Prior_Jobs varchar(255),
Description varchar(255) not null,

constraint chk_Hair_Length check(Hair_Length IN ('Long', 'Short', 'Hairless'))

);

