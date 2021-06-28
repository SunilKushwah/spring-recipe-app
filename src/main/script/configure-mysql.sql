## use to run mysql db docker image
#docker run --name mysqldb -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d mysql

# connect to mysql and run as root
CREATE DATABASE sun_dev;
CREATE DATABASE sun_prod;

#create database service accounts
CREATE USER 'sun_dev_user'@'localhost' IDENTIFIED BY 'sun';
CREATE USER 'sun_prod_user'@'localhost' IDENTIFIED BY 'sun';
CREATE USER 'sun_dev_user'@'%' IDENTIFIED BY 'sun';
CREATE USER 'sun_prod_user'@'%' IDENTIFIED BY 'sun';

#database grants
GRANT SELECT ON sun_dev.* to 'sun_dev_user'@'localhost';
GRANT INSERT ON sun_dev.* to 'sun_dev_user'@'localhost';
GRANT UPDATE ON sun_dev.* to 'sun_dev_user'@'localhost';
GRANT DELETE ON sun_dev.* to 'sun_dev_user'@'localhost';
GRANT SELECT ON sun_prod.* to 'sun_prod_user'@'localhost';
GRANT INSERT ON sun_prod.* to 'sun_prod_user'@'localhost';
GRANT UPDATE ON sun_prod.* to 'sun_prod_user'@'localhost';
GRANT DELETE ON sun_prod.* to 'sun_prod_user'@'localhost';
GRANT SELECT ON sun_dev.* to 'sun_dev_user'@'%';
GRANT INSERT ON sun_dev.* to 'sun_dev_user'@'%';
GRANT UPDATE ON sun_dev.* to 'sun_dev_user'@'%';
GRANT DELETE ON sun_dev.* to 'sun_dev_user'@'%';
GRANT SELECT ON sun_prod.* to 'sun_prod_user'@'%';
GRANT INSERT ON sun_prod.* to 'sun_prod_user'@'%';
GRANT UPDATE ON sun_prod.* to 'sun_prod_user'@'%';
GRANT DELETE ON sun_prod.* to 'sun_prod_user'@'%';
