CREATE TABLE serology(
  IDNum varchar(10),
  IDType varchar(2)  ,
  FirstName varchar(20),
  LastName varchar(20) ,
  ResultDate date,
  BirthDate date,
  Labcode varchar(6) ,
  StickerNumber varchar(40) ,
  Antidoters INT,
  KitNumber varchar(3),
  HaveAntidotes BOOLEAN DEFAULT false,
  PRIMARY KEY (IDNum)
)

