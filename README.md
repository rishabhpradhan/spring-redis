# Spring Redis

Sample project for Spring Redis Integration

### Prerequisites 
What you will need:
 - JDK 1.8 or later version installed
 - Maven 3.5+
   
### Build
 From the root of project directory (where pom.xml located) run the following command:
 	
 		mvn clean install      

### Run
 		java -jar target/spring-redis.jar
 			

### Sample
        Put data in redis
        curl -d '{"id": "1", "marketingClickId": "click-1-2", "details": "test"}' -H 'Content-Type: application/json' POST http://localhost:8080/spring-redis/cache/put
        
        Read data from redis
        curl http://localhost:8080/spring-redis/cache/get/1
        

