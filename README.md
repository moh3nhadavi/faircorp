# Faircorp
## This project is the backend of faircorp application.
This application has been built with Java spring boot which is a good framework of Java programming language.  
<br>
Due to the analysis, I decided to add 5 entities:
- Buildings
- Rooms
- Windows
- Heaters
- Sensors

Building is the base entity and each room belongs to a building.
Also, windows, heaters, and sensors are in a room. 

### You can find an online version of the project here [here](https://mohsen-hadavi.cleverapps.io)

### To test the APIs, you can follow this [link](https://mohsen-hadavi.cleverapps.io/swagger-ui/index.html)

API documentation
-----------------

### Building

- GET /api/buildings/{username} : get a building by username

### Room

- GET /api/buildings/{building_username}/rooms : get all rooms of a building by building username
- GET /api/rooms/{id} : get a room by id
- POST /api/buildings/{building_username}/rooms : create or update a room
- DELETE /api/buildings/{building_username}/rooms/{id} : delete a room by id

### Window

- GET /api/rooms/{room_id}/windows : get all windows of a room by room_id
- GET /api/rooms/{room_id}/windows/{id} : get a window by id
- POST /api/rooms/{room_id}/windows : create or update a window
- DELETE /api/rooms/{room_id}/windows/{id} : delete a window by id
- PUT /api/rooms/{room_id}/windows/{id}/switch : switch a window by id

### Heater

- GET /api/rooms/{room_id}/heaters : get all heaters of a room by room_id
- GET /api/rooms/{room_id}/heaters/{id} : get a heater by id
- POST /api/rooms/{room_id}/heaters : create or update a heater
- DELETE /api/rooms/{room_id}/heaters/{id} : delete a heater by id
- PUT /api/rooms/{room_id}/heaters/{id}/switch : switch a heater by id

### Sensor

- GET /api/rooms/{room_id}/sensors : get all sensors of a room by room_id
- GET /api/rooms/{room_id}/sensors/{id} : get a sensor by id
- POST /api/rooms/{room_id}/sensors : create or update a sensor
- DELETE /api/rooms/{room_id}/sensors/{id} : delete a sensor by id
