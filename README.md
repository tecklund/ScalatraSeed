# ScalatraSeed

This is a seed project for Scalatra with Flyway for migrations and Anorm for db access. Steps to start a local server:
1. `docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d -p3306:3306 mysql:5.7`
2. `mysql -uroot -h localhost --protocol tcp -proot -e "create database PUBLIC;"`
3. `create database PUBLIC`
4. `exit`
5. `gradle mapprun`

Try it out with `http://localhost:8080/ScalatraSeed/dragons`

You can also run the test suite with `./test.sh`. This will execute both 'unit' tests against the models and 'integration' tests against the HTTP endpoints.

This seed is equipped with easy environment switching. These system properties are configurable:
1. dbUrl - jdbc string your application will use to connect to your database
2. dbUser - username your application will use to connect to the database
3. dbPassword - password your appliaction will use to connect to the database
4. flyway.url - jdbc string that flyway will use during migrations
5. flyway.user - username for flyway
6. flyway.password - password for flyway

There is also a Docker file. To create and run a docker image perform these steps:
1. `gradle war`
2. `docker build .`
3. `docker run -it -p8080:8080 -eDBURL=<jbdc url> -eDBUSER=root -eDBPASSWORD=password <container id>`

Check out the `setenv.sh` file to see what environment variables you can pass in to your docker container.
