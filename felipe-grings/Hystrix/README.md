# CREATE DOCKER WITH ENVIROMENT VARIBLES

$ docker run --name <nome_do_container> -e "CONSUMER_KEY=<credencial>" -e "CONSUMER_SECRET=<credencial>" -e "ACCESS_TOKEN=<credencial>" -e "ACCESS_TOKEN_SECRET=<credencial>" -p <porta_do_container>:<porta_da_nossa_máquina> <nome_da_imagem>
