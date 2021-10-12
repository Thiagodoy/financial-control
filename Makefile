SHELL := /bin/bash # Use bash syntax

# Configure environment.
# ----------------------

ifneq ($(MAKECMDGOALS),clean)
-include .env
endif

export TZ=America/Sao_Paulo
export USER_ID=$(shell id -u)

# @TODO Hack for MacOSX or other OS which has the same group id
#       than the containers user.
export GROUP_ID=$(shell if [ `id -g` == '20' ]; then echo '1000'; else echo `id -g`; fi)

in:
	@docker exec -it $(PROJECT_NAME) sh

install:
	@mvn clean install package

start:
	@docker-compose up -d
	@docker logs $(PROJECT_NAME) -f

stop:
	@docker-compose stop

prune:
	@docker-compose down

restart:
	@docker-compose down
	@docker-compose up -d

run:
	mvn clean install package -DskipTests
	docker-compose up -d
	@docker logs $(PROJECT_NAME) -f

remove:
	@docker-compose down
	@docker rmi personal/$(PROJECT_NAME) -f

deploy:
	docker-compose down
	docker rmi personal/$(PROJECT_NAME) -f
	mvn clean install package -DskipTests 
	docker-compose -f docker-compose.yml up -d
	@docker logs $(PROJECT_NAME) -f


