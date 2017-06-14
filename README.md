# ScalatraSeed

This is a seed project for Scalatra with Anorm. Steps to start a local server:
1. `docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d -p3306:3306 mysql:5.7`
2. `mysql -uroot -h localhost --protocol tcp -proot`
3. `create database PUBLIC`
4. `exit`
5. `gradle mapprun`

Try it out with `http://localhost:8080/ScalatraSeed/dragons`

You can also run the test suite with `./test.sh`. This will execute both 'unit' tests against the models and 'integration' tests against the HTTP endpoints.