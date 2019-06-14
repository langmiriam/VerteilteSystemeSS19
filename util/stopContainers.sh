#!/bin/sh
echo "Stopping containers...\n"
docker stop mysql_customer mysql_order mysql_product
echo "\n"
docker ps
echo "\nDone."
