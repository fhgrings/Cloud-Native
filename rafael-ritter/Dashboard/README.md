**INSTRUÇÕES PARA RODAR MICROSSERVIÇOS COM DOCKER:**
  1. Gerar .jar de cada um dos 3 microsserviços com o comando
  
    $ ./gradlew clean build
  2. Mover cada .jar gerado para a sua respectiva pasta Docker
  3. Buildar cada imagem com o comando
  
    $ docker build -t <nome_da_imagem> .
  4. Rodar um container para cada imagem recém buildada, com o comando:
  
    $ docker run --name <nome_do_container> -p <porta_do_container>:<porta_da_nossa_máquina> <nome_da_imagem>
  OBS.: No caso do microsseviço do Twitter, como são necessárias credenciais, é preciso configurá-las como variáveis de ambiente ao rodar o container. Então, o comando a ser usado será o seguinte:
  
    $ docker run --name <nome_do_container> -e "OAUTH_CONSUMER_KEY=<credencial>" -e "OAUTH_CONSUMER_SECRET=<credencial>" -e "OAUTH_ACCESS_TOKEN=<credencial>" -e "OAUTH_ACCESS_TOKEN_SECRET=<credencial>" -p <porta_do_container>:<porta_da_nossa_máquina> <nome_da_imagem>
Pronto! Agora podemos acessar cada microsserviço na nossa máquina pelas portas mapeadas!

**INSTRUÇÕES PARA ACESSAR O DASHBOARD**
  1. Acessar _http://localhost:8082/hystrix_
  2. Informar o endereço _localhost:8082/actuator/hystrix.stream_
  3. Clicar em _Monitor Stream_.

Pronto!
