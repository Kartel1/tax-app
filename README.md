# tax-app
taxApp Company tax calculator

To run the application:

Install Docker : https://hub.docker.com/?overlay=onboarding

Install Docker-compose : https://docs.docker.com/compose/install/

go to /myapp/myapp directory on the project

Open a Vim

write :

docker build -t myapp .

then:

docker-compose up -d

you can see logs by writting : docker-compose logs -f myapp

Or you can go to the navigator at the address : http://127.0.0.1:8080/  to open adminer UI

login: postgres

password: example
