drop database if exists db_auction_manager;
create database db_auction_manager;
use db_auction_manager;

-- 材料分为两种，一种是NPC出售的，一种是采集的
-- NPC出售的叫做材料
-- 采集的叫做商品

drop table if exists equip_items;
drop table if exists tb_equip;
drop table if exists category_item;
drop table if exists tb_item;
drop table if exists tb_category;

create table tb_category (
	id integer unsigned primary key auto_increment,
	name varchar(64) unique not null,
	parent_id integer unsigned,
	CONSTRAINT `fk_category_category_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `tb_category` (`id`)
);

insert into tb_category values
	(1, '商人', null),
	(2, '专业', null),
	(3, '裁缝商人', 1),
	(4, '制皮商人', 1),
	(5, '附魔商人', 1),
	(6, '裁缝', 2),
	(7, '制皮', 2),
	(8, '附魔', 2);


create table tb_item (
	id integer unsigned primary key auto_increment,
	name varchar(128) unique not null,
	price long not null
);

insert into tb_item values 
	(1, '粗线', 10),
	(2, '细线', 100),
	(3, '盐', 50),
	(4, '普通木柴', 38),
	(5, '亚麻布', 50),
	(6, '毛料', 100),
	(7, '丝绸', 200),
	(8, '魔纹布', 500),
	(9, '符文布', 1000),
	(10, '轻皮', 50),
	(11, '轻毛皮', 100),
	(12, '中皮', 80),
	(13, '中毛皮', 350),
	(14, '重皮', 180),
	(15, '重毛皮', 200),
	(16, '厚皮', 600);


create table category_item (
	category_id integer unsigned not null,
	item_id integer unsigned not null,
	primary key (category_id, item_id),
	CONSTRAINT `fk_category_item_category_id` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`),
	CONSTRAINT `fk_category_item_item_id` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`id`)
);

insert into category_item values 
	(3, 1),
	(3, 2),
	(4, 1),
	(4, 2),
	(4, 3),
	(5, 4),
	(6, 5),
	(6, 6),
	(6, 7),
	(6, 8),
	(6, 9),
	(7, 10),
	(7, 11),
	(7, 12),
	(7, 13),
	(7, 14),
	(7, 15),
	(7, 16);


create table tb_equip (
	id integer unsigned primary key auto_increment,
	name varchar(128) unique not null,
	sell_to_npc_price long,
	category_id integer unsigned,
	CONSTRAINT `fk_equip_category_id` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`)
);

insert into tb_equip values 
	(1, '软底亚麻靴', 100, 6),
	(2, '褶皱皮短裤', 100, 7),
	(3, '山地护肩', 1199, 7),
	(4, '野人护腿', 100, 7);

create table equip_items (
	equip_id integer unsigned,
	item_id integer unsigned,
	quantity integer not null,
	primary key (equip_id, item_id),
	CONSTRAINT `fk_equip_items_equip_id` FOREIGN KEY (`equip_id`) REFERENCES `tb_equip` (`id`),
	CONSTRAINT `fk_equip_items_item_id` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`id`)
);

insert into equip_items values 
	(1, 5, 10),
	(1, 10, 2),
	(1, 2, 1),
	(2, 10, 5),
	(2, 1, 5),
	(3, 13, 1),
	(3, 3, 1),
	(3, 12, 4),
	(3, 2, 1);


