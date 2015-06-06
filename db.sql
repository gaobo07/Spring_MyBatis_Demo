DROP table demo.Admin;

CREATE TABLE demo.Admin
(
  Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  Username VARCHAR(255),
  Password VARCHAR(255),
  Name  VARCHAR(255),
  Team  VARCHAR(255),
  Role VARCHAR(255) COMMENT '管理员;组长;员工;'
);
