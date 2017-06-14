# ScalatraSeed

This is a seed project for Scalatra with Anorm. Steps to start a local server:
1. `docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d -p3306:3306 mysql:5.7`
2. `mysql -uroot -h localhost --protocol tcp -proot`
3. `create database PUBLIC`
4. `exit`
5. `gradle mapprun`

Try it out with `http://localhost:8080/ScalatraSeed/dragons`

You can also run the test suite with `./test.sh`. This will execute both 'unit' tests against the models and 'integration' tests against the HTTP endpoints.

This seed is equipped with easy environment switching. The environment defaults to 'local', with the database defaults stored in gradle.properties. You can override these properties by simply setting the system params like this `gradle -Denv=qa mapprun`

There is also a Docker file. To create and run a docker image perform these steps:
1. `gradle war`
2. `docker build .`
3. `docker run -it -p8080:8080 -eENV=qa -eDBUSER=root <container id>`

Check out the `setenv.sh` file to see what environment variables you can pass in to your docker container.