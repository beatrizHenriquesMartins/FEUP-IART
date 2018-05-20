(defglobal ?*lightFvar* = (new nrc.fuzzy.FuzzyVariable "light" 0.0 10000.0 "K"))

(?*lightFvar* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 1000.0 4000.0))

(?*lightFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 5000.0 2000.0))

(?*lightFvar* addTerm "high"
(new nrc.fuzzy.SFuzzySet 6200.0 7500.0))

(bind ?lightSensorGarden (new LightSensor "Garden Light Sensor" 0 ?*lightFvar* "lightSensorGarden"))
(add ?lightSensorGarden)

(bind ?lightSensorKitchen (new LightSensor "Kitchen Light Sensor" 0 ?*lightFvar* "lightSensorKitchen"))
(add ?lightSensorKitchen)

(bind ?lightSensorLivingRooom (new LightSensor "Living Room Light Sensor" 0 ?*lightFvar* "lightSensorLivingRooom"))
(add ?lightSensorLivingRooom)

(bind ?lightSensorRoom1 (new LightSensor "Room 1 Light Sensor" 0 ?*lightFvar* "lightSensorRoom1"))
(add ?lightSensorRoom1)

(bind ?lightSensorRoom2 (new LightSensor "Room 2 Light Sensor" 0 ?*lightFvar* "lightSensorRoom2"))
(add ?lightSensorRoom2)

(bind ?lightSensorBasement (new LightSensor "Basement Light Sensor" 0 ?*lightFvar* "lightSensorBasement"))
(add ?lightSensorBasement)

(bind ?lightSensorSmallBathRoom (new LightSensor "Small Bathroom Light Sensor" 0 ?*lightFvar* "lightSensorSmallBathRoom"))
(add ?lightSensorSmallBathRoom)

(bind ?lightSensorLargeBathRoom (new LightSensor "Large Bathroom Light Sensor" 0 ?*lightFvar* "lightSensorLargeBathRoom"))
(add ?lightSensorLargeBathRoom)