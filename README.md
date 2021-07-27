please follow below steps to run application :

Step1:If jar is not available in target folder then run this command to build the jar "mvn clean install"
Step2:Run this command to build the docker image "docker build -t com.element/hiking ."
Step3:Run this command to run the docker image docker "docker run -p 8080:8080 com.element/hiking"

There are 2 different controller BookingController and TrailsController.

BookingController has all the end point related to trail booking.

curl -v http://localhost:8080/booking/{bookingId} : To get the booking by specific booking id.
curl -d 'request body' http://localhost:8080/booking/bookTrail : To book a trail.
curl -X DELETE http://localhost:8080/booking/{bookingId} : To cancel a booking.

TrailController has all the end point related to trails.
curl -v http://localhost:8080/trails/alltrails : To get all the Trails AVailable.
curl -v http://localhost:8080/trails/{trailId} : To get a specific train by TrainId.
curl -d 'request body' http://localhost:8080/trails/creatTrail : To add a new trail if needed.

Replace http://localhost:8080 with your server base Url.

What more I could have done :

Note1: There are lot of business enhancements like end points for update,modify,delete the trail make it more dynamic.
Note2: Similarly for booking providing lot more functionality like sending confirmation making the hiker data 		modification more dynamic.
Note3: I have done basic level of exception handling which can be improved.
Note4: Database integration.
Note5: Write more unit and integration test cases. 