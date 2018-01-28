#mini-twitter

A simple twitter api.

You can also check for documentation localhost:8080/swagger-ui.html when application running.

##Endpoints:
-GET /message => gets messages by user and by people user follows
@param String search
example: localhost:8080/api/user/message?search=elit

-GET /followers => gets followers for a user
example: localhost:8080/api/user/followers

-GET /followingList => gets people a user follows
example: localhost:8080/api/user/followingList

-PUT /unfollow/{unfollowUserId} => for when a user unfollows someone
@Path param long unfollowUserId
example: localhost:8080/api/user/2

PUT /follow/{followedUserId} => for when a user unfollows someone
@Path param long followedPersonId
example: localhost:8080/api/user/follow/2

GET /userListWithMostPopulerPair => get a list of all users paired with their most popular followers
example: localhost:8080/api/userListWithMostPopulerPair

#Notes
-Basic Authentication require for each api (default password : "password" for each user)
-Used lombok for validation(like @NotNull), encapsulation, hash and equals methods and toString method.

#Testing
-Unit tests also using same in-memory H2 database(schema and data).
-If needed will share postman collection.

