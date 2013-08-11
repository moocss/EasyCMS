create table ec_group(
  id int primary key auto_increment,
  name varchar(100) not null,
  priority int not null default '10',
  allowPerDay int(11) not null default '4096',
  allowMaxFile int(11) not null default '1024',
  allowSuffix varchar(255) default 'jpg,jpeg,gif,png,bmp',
  needCaptcha tinyint(1)  not null default '1',
  needCheck tinyint(1) not null default '1',
  regDef tinyint(1) not null default '1'
);
create table ec_user(
  id int primary key auto_increment,
  group_id int not null,
  username varchar(100) not null,
  password varchar(100) not null,
  email varchar(100) not null,
  registerTime timestamp not null,
  registerIP varchar(50) default '127.0.0.1',
  lastLoginTime datetime,
  lastLoginIp varchar(50) default '127.0.0.1',
  loginCount int(11) not null  default '0',
  rank int(11) not null default '0',
  uploadSize int(11) not null default '0',
  uploadDate datetime,
  admin tinyint(1) not null default '0',
  viewonlyAdmin tinyint(1) not null default '0',
  selfAdmin tinyint(1) not null default '0',
  disabled tinyint(1) not null default '0',
  foreign key(group_id) references bf_group(id)
);
create table ec_user_ext(
  id int primary key auto_increment,
  uid int,
  realname varchar(100),
  gender tinyint(1),
  birthday varchar(255),
  intro varchar(255),
  comefrom varchar(150),
  qq varchar(100),
  msn varchar(100),
  phone varchar(50),
  mobile varchar(50),
  userImg varchar(255),
  userSignature varchar(255),
  foreign key(uid) references bf_user(id)
);
create table ec_role(
  id int primary key auto_increment,
  name varchar(100),
  priority int not null default '1',
  m_super tinyint(1) not null default '0',
  siteId int(11)
);