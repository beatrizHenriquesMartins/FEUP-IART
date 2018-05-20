(defglobal ?*movFvar* = (new nrc.fuzzy.FuzzyVariable "movement" 0.0 1.0))

(?*movFvar* addTerm "yes"
(new nrc.fuzzy.PIFuzzySet 1.0 0.0))

(?*movFvar* addTerm "no"
(new nrc.fuzzy.PIFuzzySet 0.0 0.0))

(bind ?movementSensorGarage (new MovementSensor "Garage Movement Sensor" 0 ?*movFvar* "movementSensorGarage"))
(add ?movementSensorGarage)

(bind ?movementSensorGarden (new MovementSensor "Garden Movement Sensor" 0 ?*movFvar* "movementSensorGarden"))
(add ?movementSensorGarden)

(bind ?movementSensorBasement (new MovementSensor "Basement Movement Sensor" 0 ?*movFvar* "movementSensorBasement"))
(add ?movementSensorBasement)

(bind ?movementSensorLivingRoom (new MovementSensor "Living Room Movement Sensor" 0 ?*movFvar* "movementSensorLivingRoom"))
(add ?movementSensorLivingRoom)

(bind ?movementSensorRoom1 (new MovementSensor "Room 1 Movement Sensor" 0 ?*movFvar* "movementSensorRoom1"))
(add ?movementSensorRoom1)

(bind ?movementSensorRoom2 (new MovementSensor "Room 2 Movement Sensor" 0 ?*movFvar* "movementSensorRoom2"))
(add ?movementSensorRoom2)