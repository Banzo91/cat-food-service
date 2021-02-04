CREATE USER 'catfoodapp'@'%' IDENTIFIED BY 'catfoodapp';

GRANT ALL PRIVILEGES ON * . * TO 'catfoodapp'@'%';

ALTER USER 'catfoodapp'@'%' IDENTIFIED WITH mysql_native_password BY 'catfoodapp';