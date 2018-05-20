(defglobal ?*weightFvar* = (new nrc.fuzzy.FuzzyVariable "weight" 0.0 200.0 "kg"))

(?*weightFvar* addTerm "ligth"
(new nrc.fuzzy.ZFuzzySet 10.0 60.0))

(?*weightFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 50.0 30.0))

(?*weightFvar* addTerm "heavy"
(new nrc.fuzzy.SFuzzySet 50.0 100.0))


(bind ?pressureSensorCouch (new WeightSensor "Couch Pressure Sensor" 0 ?*weightFvar* "pressureSensorCouch"))
(add ?pressureSensorCouch)

(bind ?pressureSensorBedRoom1 (new WeightSensor "Room 1 Bed Pressure Sensor" 0 ?*weightFvar* "pressureSensorBedRoom1"))
(add ?pressureSensorBedRoom1)

(bind ?pressureSensorBedRoom2 (new WeightSensor "Room 2 Bed Pressure Sensor" 0 ?*weightFvar* "pressureSensorBedRoom2"))
(add ?pressureSensorBedRoom2)