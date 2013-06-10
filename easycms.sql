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
)