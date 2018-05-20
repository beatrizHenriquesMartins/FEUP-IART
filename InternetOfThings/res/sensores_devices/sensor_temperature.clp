(defglobal ?*tempFvar* = (new nrc.fuzzy.FuzzyVariable "temperature" 0.0 100.0 "C"))

(?*tempFvar* addTerm "cold"
(new nrc.fuzzy.ZFuzzySet 10.0 20.0))

(?*tempFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 20.0 10.0))

(?*tempFvar* addTerm "hot"
(new nrc.fuzzy.SFuzzySet 20.0 30.0))

(bind ?temperatureSensorGarden (new TemperatureSensor "Garden Temperature Sensor" 30 ?*tempFvar* "temperatureSensorGarden"))
(add ?temperatureSensorGarden)

(bind ?temperatureSensorLivingRoom (new TemperatureSensor "Living Room Temperature Sensor" 30 ?*tempFvar* "temperatureSensorLivingRoom"))
(add ?temperatureSensorLivingRoom)

(bind ?temperatureSensorKitchen (new TemperatureSensor "Kitchen Temperature Sensor" 30 ?*tempFvar* "temperatureSensorKitchen"))
(add ?temperatureSensorKitchen)

(bind ?temperatureSensorRoom1 (new TemperatureSensor "Room 1 Temperature Sensor" 10 ?*tempFvar* "temperatureSensorRoom1"))
(add ?temperatureSensorRoom1)

(bind ?temperatureSensorRoom2 (new TemperatureSensor "Room 2 Temperature Sensor" 30 ?*tempFvar* "temperatureSensorRoom2"))
(add ?temperatureSensorRoom2)

(bind ?temperatureSensorLargeBathroom (new TemperatureSensor "Large Bathroom Temperature Sensor" 30 ?*tempFvar* "temperatureSensorLargeBathroom"))
(add ?temperatureSensorLargeBathroom)

(bind ?temperatureSensorSmallBathroom (new TemperatureSensor "Small Bathroom Temperature Sensor" 30 ?*tempFvar* "temperatureSensorSmallBathroom"))
(add ?temperatureSensorSmallBathroom)