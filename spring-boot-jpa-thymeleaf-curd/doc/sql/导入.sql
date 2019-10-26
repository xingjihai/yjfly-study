create table import_collection
(
   id                   int(11) comment 'id',
   name                 varchar(255) comment 'name'
);
alter table import_collection comment '导入集合';

create table import_settings_detail
(
   id                   int(11) not null comment 'id',
   import_collection_id int(11) comment '集合id',
   table_name           varchar(255) comment '表名',
   table_field          varchar(255) comment '表字段',
   key                  varchar(255) comment '关键字',
   sheet_num            int(2) comment '标签页面',
   type_code            varchar(255) comment '类型代号(字典、部门、日期等)',
   format               varchar(255) comment '类型格式',
   primary key (id)
);
alter table import_settings_detail comment '导入详细配置信息表';

