drop table if exists AuthorISBN;
drop table if exists Titles;
drop table if exists Authors;

create table if not exists Authors (
  AuthorID int not null auto_increment,
  FirstName varchar (20) not null,
  LastName varchar (30) not null,
  primary key(AuthorID)
);

create table if not exists Titles (
  ISBN varchar (20) not null,
  Title varchar (100) not null,
  EditionNumber int not null,
  Copyright varchar(4) not null,
  primary key (ISBN)
);

create table if not exists AuthorISBN (
  AuthorID int not null,
  ISBN varchar (20) not null,
  foreign key (AuthorID) references Authors(AuthorID),
  foreign key (ISBN) references Titles(ISBN)
);

INSERT INTO Authors (FirstName, LastName)
VALUES 
   ('Paul','Deitel'), 
   ('Harvey','Deitel'),
   ('Abbey','Deitel'), 
   ('Dan','Quirk'),
   ('Michael','Morgano');

INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright)
VALUES
   ('0132151006','Internet & World Wide Web How to Program',5,'2012'),
   ('0133807800','Java How to Program',10,'2015'),
   ('0132575655','Java How to Program, Late Objects Version',10,'2015'),
   ('013299044X','C How to Program',7,'2013'), 
   ('0132990601','Simply Visual Basic 2010',4,'2013'),
   ('0133406954','Visual Basic 2012 How to Program',6,'2014'),
   ('0133379337','Visual C# 2012 How to Program',5,'2014'),
   ('0136151574','Visual C++ How to Program',2,'2008'),
   ('0133378713','C++ How to Program',9,'2014'),
   ('0133764036','Android How to Program',2,'2015'),
   ('0133570924','Android for Programmers: An App-Driven Approach, Volume 1',2,'2014'),
   ('0132121360','Android for Programmers: An App-Driven Approach',1,'2012');

INSERT INTO AuthorISBN (AuthorID,ISBN)
VALUES
   (1,'0132151006'),
   (2,'0132151006'),
   (3,'0132151006'),
   (1,'0133807800'),
   (2,'0133807800'),
   (1,'0132575655'),
   (2,'0132575655'),
   (1,'013299044X'),
   (2,'013299044X'),
   (1,'0132990601'),
   (2,'0132990601'),
   (3,'0132990601'),
   (1,'0133406954'),
   (2,'0133406954'),
   (3,'0133406954'),
   (1,'0133379337'),
   (2,'0133379337'),
   (1,'0136151574'),
   (2,'0136151574'),
   (4,'0136151574'),
   (1,'0133378713'),
   (2,'0133378713'),
   (1,'0133764036'),
   (2,'0133764036'),
   (3,'0133764036'),
   (1,'0133570924'),
   (2,'0133570924'),
   (3,'0133570924'),
   (1,'0132121360'),
   (2,'0132121360'),
   (3,'0132121360'),
   (5,'0132121360');
