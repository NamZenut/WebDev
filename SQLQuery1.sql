Use Posts 

CREATE TABLE Category 
	(
	Id int not null IDENTITY(1,1) primary key,
	Name nvarchar(20),
	Description nvarchar(max),
	isStatus bit,
	CreatedDate date,
	UpdatedDate date	
	)

DROP TABLE Category 

---------------------------------


CREATE TABLE Posts
	(
	Id int not null IDENTITY(1,1) primary key,
	Title nvarchar(30) not null,
	Body nvarchar(max),
	Author nvarchar(30),
	CreatedDate date,
	UpdatedDate date,
	NumberOfLikes int,
	isStatus bit,
	FOREIGN KEY (Id) REFERENCES Category(Id)
	)

DROP TABLE Posts 

---------------------------------------

CREATE TABLE Users 
	(
	Id int not null IDENTITY(1,1) primary key,
	FirstName nvarchar(25),
	LastName nvarchar(25),
	CreatedDate date,
	UpdatedDate date,
	Username varchar(30) not null,
	Password varchar(30) not null,
	isStatus bit,
	Role int
	)

drop table Users


-------------------------------------------------

CREATE TABLE Favorite
	(
	Id int not null IDENTITY(1,1) primary key,
	LikedDate date,
	UnLikedDate date,
	FOREIGN KEY (Id) REFERENCES Users(Id),
	FOREIGN KEY (Id) REFERENCES Posts(Id)
	)

DROP TABLE Favorite

-----------------------------------------------


CREATE TABLE Comments 
	(
	Id int not null IDENTITY(1,1) primary key,
	Request nvarchar(max), 
	Respond nvarchar(max),
	CreatedDate date,
	UpdatedDate date,
	FOREIGN KEY (Id) REFERENCES Users(Id),
	FOREIGN KEY (Id) REFERENCES Posts(Id)
	)

DROP TABLE Comments