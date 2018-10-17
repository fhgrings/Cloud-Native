INSTRUÇÕES PARA RODAR APLICAÇÃO COM DOCKER:
  1. Gerar .jar com o comando
  
    $ ./gradlew clean fatJar
  2. Mover o .jar gerado para a pasta Docker
  3. Buildar a imagem com o comando
  
    $ docker build -t <nome_da_imagem> .
  4. Rodar um container a partir da imagem recém buildada, com o comando:
  
    $ docker run --name <nome_do_container> -p <porta_do_container>:<porta_da_nossa_máquina> <nome_da_imagem>
Pronto! Agora podemos acessar a aplicação na nossa máquina pela porta mapeada!
