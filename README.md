##To run app via jar write in console:
-java -jar target/amarchuk.springboot-0.0.1-SNAPSHOT.jar

##To start using app lets start local service with command:
-sudo service mysql start
 
 ## How to test REST endpoints in Postman:
 1. To delete user - use Delete method, write url 'http://localhost:8097/delete/2' (where 2 is id of animal)
 2. To create animal - use POST method, write url 'http://localhost:8097/new
    and add body of object:
{
    "name": "cat",
    "color": "WHITE"
}


## URL for Swagger API Docs Json
1. http://localhost:8097/v2/api-docs

 
 


