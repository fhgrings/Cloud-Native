<h1><strong>Running Docker</strong></h1>

<b>First of all it's important to mention that this tutorial consider that the reader uses and UNIX based version of OS,
and already have docker properly installed on it, if you haven'tm here's a link that may clarify things</b>

Link: https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-18-04

0.All the commands performed here, should happen inside de TollAPI/ directory, so, first things first, get yourself placed there.

1.After clonning the project the first thing you must do is to build the project using gradle:
Run the following command "./gradlew clean war", that being sucessfull,
you will have the TollAPI.war file inside your /build/libs/ directory.

2.Open the dockerfile (still inside TollAPI/), and change the ENV PATH, to the according one in you computer.

3.The next step is to build the dockerfile image on your docker, to do so, you must run the following command:
"sudo docker build -t dockerfile .", and wait until the operation is finished and write down the given image id, you will
use it in the following step

4. Finally, if everything have occured properly, you must now be able to run the container, to do so, run this command:
"sudo docker run --name="[desired-container-name] -it -p [desired-port]:8080 [image-id]", with that, the tollAPI app,
should be running in the chosen port.
