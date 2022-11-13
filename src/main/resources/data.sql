INSERT INTO BUILDING(username, name, out_temperature) VALUES('mmm', 'Hotel 1', 25.4);
INSERT INTO BUILDING(username, name, out_temperature) VALUES('sss', 'Hotel 2', 44.4);

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature,building_username) VALUES(-10, 'Room1', 1, 22.3, 20.0, 'mmm');
INSERT INTO ROOM(id, name, floor,building_username) VALUES(-9, 'Room2', 1,'mmm');
INSERT INTO ROOM(id, name, floor,building_username) VALUES(-8, 'Room3', 3,'sss');

INSERT INTO HEATER(id, status, name, power, room_id) VALUES(-10, 1, 'Heater1', 2000, -10);
INSERT INTO HEATER(id, status, name, power, room_id) VALUES(-9, 1, 'Heater2', null, -10);

INSERT INTO RWINDOW(id, status, name, room_id) VALUES(-10, 1, 'Window 1', -10);
INSERT INTO RWINDOW(id, status, name, room_id) VALUES(-9, 1, 'Window 2', -10);
INSERT INTO RWINDOW(id, status, name, room_id) VALUES(-8, 1, 'Window 1', -9);
INSERT INTO RWINDOW(id, status, name, room_id) VALUES(-7, 1, 'Window 2', -9);

INSERT INTO SENSOR(id,name,temperature,room_id) VALUES(-10, 'Sensor 1', 8.9, -10);
INSERT INTO SENSOR(id,name,temperature,room_id) VALUES(-9, 'Sensor 2', 13.2, -10);
INSERT INTO SENSOR(id,name,temperature,room_id) VALUES(-8, 'Sensor 3', -5.6, -10);
