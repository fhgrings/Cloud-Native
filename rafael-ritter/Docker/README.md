INSTRUÇÕES PARA RODAR WEBAPP PELO DOCKER:

1. Ir até a pasta do projeto e gerar .war com o comando:
  $ ./gradlew clean war

2. Mover o .war gerado na pasta /build/libs/ para a pasta Docker

3. Ir até a pasta Docker, onde está o Dockerfile e, agora, o .war recém gerado, e builder a imagem com o comando:
  $ docker build -t myimage .

4. Rodar um container com a imagem recém buildada, com o comando:
  $ docker run --name mycontainer -p 8080:8080 myimage

Pronto! Agora você pode acessar a aplicação na sua máquina por: http://localhost:8080/
