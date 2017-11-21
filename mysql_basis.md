**sql 结构化查询语言**  
#### mysql：  
命令行`cmd`*`win`*     
清屏：`cls` *`win*`  
启动：`net start mysql` *`win`*   
停止：`net stop mysql` *`win`*   
登陆：  
`mysql -uroot -p (-P8081 -h127.0.0.1)`
#### 退出：
`exit;`  
`quit;`  
`\q`  
#### mysql 参数  
`-D database=name`  打开指定数据库  
`--delimiter = name`  制定分割符  
`-h --host=name`  服务器名称   本地回环地址`127.0.0.1`  
`-V, --version`  输出版本信息并且退出  
`-u --user=name`  用户名  
`-P --port=#` 端口号  
`--prompt=name`  设置提示符  
`-p --password`  密码  
默认本地地址默认端口（我的8081）

#### 修改提示符：
`mysql>prompt` 提示符  
`\D`  完整的日期  
`\h`  服务器名称  
`\u`  当前用户  
`\d`  当前数据库  
`SELECT VERSION();` 显示当前服务器版本  
`SELECT NOW();`  显示当前日期时间  
`SELECT USER();`  显示当前用户  
**关键字与函数名称全部大写  
数据库名称、表名称、字段名称全部小写  
SQL语句必须以分号结束;**

创建数据库:`CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name [DEFAULT](编码方式) CHARACTER SET [=] charset_name;`  

创建指定编码方式的表：`CREATE DATABASE IF NOT EXISTS db_name CHARACTER SET gbk;`

修改数据库：`ALTER {DATABASE | SCHEMA} [db_name] [DEFAULT] CHARACTER SET [=] charset_name;`

删除数据库`DROP {DATABSE | SCHEMA} [IF NOT EXISTS] db_name;`

查看当前服务器下的数据库列表`SHOW {DATABASES | SCHEMAS} [LIKE 'pattern' | WHERE expr];`

查看创建数据库的命令`SHOW CREATE DATABASE db_name;`

打开数据库`USE db_name;`  
显示打开的数据库`SELECT DATABASE();`  
显示所有数据库`SHOW DATABSES;`  

数据表
行：记录
列：字段

创建数据表
```
CREATE TABLE [IF NOT EXISTS] table_name (
	column_name data_type,
	...
);
```
查看数据表`SHOW TABLES [FROM db_name] [LIKE ''|WHERE expr];`

查看数据表结构`SHOW COLUMNS FROM tbl_name;`

插入记录`INSERT [INTO] tbl_name [(col_name,...)] VALUES(val,..)`

记录查找`SELECT expr,... FROM tbl_name;`

空值与非空  
`NULL`，字段可以为空  
`NOT NULL`, 字段禁止为空  

`AUTO_INCREAMENT`
自动编号，且必须与主键组合使用  
默认情况下，起始值为1，每次增量为1  

主键约束 `PRIMARY KEY`
每张数据表只能存在一个主键  
主键保证记录的唯一性  
主键自动为`NOT NULL`  

唯一约束 `UNIQUE KEY`  
唯一约束可以保证记录的唯一性  
唯一约束的字段可以为空值（NULL）   
每张数据表可以存在多个唯一约束   

默认约束 `DEFAULT`  
当插入数据时，如果没有明确为字段赋值，则自动赋值为默认值  

外键约束 FOREIGN 实现数据表的一对一或一对多  
`FOREIGN KEY (pid) REFERENCES fath_tb_name(id);`
父表和子表必须使用相同的存储引擎，而且禁止使用临时表  
数据表的存储引擎只能是INNODB  
外键列和参照列必须具有相似的数据类型，其中数字的长度或是否有符号必须相同；而字符的长度则可以不同
外键和参照列必须创建索引。如果外键不存在索引的话，mysql将自动创建索引  
约束保证数据完整性和一致性，分为标记约束和列级约束  

查看索引`SHOW INDEX FROM table_name;`
`\G`以网格形式呈现  

外键约束的参照操作  
`CASCADE`:从父表删除或更新且自动删除或更新子表中匹配的行  
`SET NULL`:从父表删除或更新行，并设置子表中的外键列为NULL。如果使用该选项，必须保证子表列没有指定NOT NULL  
`RESTRICT`:拒绝对父表的删除或更新操作  
`NO ACTION`:标准sql的关键字，在mysql中与RESTRICT相同  

对一个数据列建立的约束，称为列级约束.  
对多个数据列建立的约束，称为表级约束.  
列级约束既可以在列定义时声明，也可以在列定义后声明.  
表级约束只能在列定义后声明  

修改数据表  
添加单列`ALTER TABLE tb_name ADD [COLUMN] col_name column_definition [FIRST | AFTER col_name ];`
添加多列`ALTER TABLE tb_name ADD [COLUMN] (col_name column_definition,...);`
删除列
单列 `ALTER TABLE tb_name DROP [COLUMN] col_name;`
多列 `ALTER TABLE tb_name DROP [COLUMN] col_name DROP [COLUMN] col_name;`
