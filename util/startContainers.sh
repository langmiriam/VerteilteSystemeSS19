#!/bin/sh
echo "Starting containers...\n"
docker start mysql_customer mysql_order mysql_product
echo "\n"
docker ps
echo "\nDone."
