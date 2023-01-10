#!/bin/sh

cp /etc/mysql/conf.d/source/* /etc/mysql/conf.d/
chown mysql:mysql /etc/mysql/mysql.conf.d/mysqld.cnf
chmod 0444 /etc/mysql/mysql.conf.d/mysqld.cnf

/entrypoint.sh mysqld
