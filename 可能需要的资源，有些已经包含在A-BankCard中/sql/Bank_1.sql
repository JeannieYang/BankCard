create database Bank
on (
	name = Bank,
	filename = 'd:\SQL Work\Bank.mdf',
	size = 20,
	filegrowth = 10
)
log on (
	name = Bank_log,
	filename = 'd:\SQL Work\Bank_log.mdf',
	size = 10,
	filegrowth = 10%
)

use Bank
create table bankuser
(
	ID varchar(10) not null unique,
	[password] char(20) not null,
	username char(20) not null,
	phone varchar(20) null,
	[date] varchar(20) null,
	[money] dec(9,3) null,
	[state] varchar(10) not null,
	[address] char(10) null
)

create table [admin]
(
	ID varchar(10) not null unique,
	[password] char(20) not null
)

create table userevent
(
	InputID varchar(10),
	[date] varchar(20) null,
	[money] dec(9,3),
	OutputID varchar(10)
)



use Bank
exec sp_addumpdevice 'disk','back_bank',
'd:\Study\大二上\数据库\课程设计\back_bank.dat'

use Bank
exec sp_addumpdevice 'disk','backLog_bank',
'd:\Study\大二上\数据库\课程设计\back_bank.log'

backup database Bank to back_bank
backup log Bank to back_bank