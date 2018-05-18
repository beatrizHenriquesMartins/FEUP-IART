(defglobal ?*tempFvar* = (new nrc.fuzzy.FuzzyVariable "temperature" 0.0 100.0 "C"))

(?*tempFvar* addTerm "cold"
(new nrc.fuzzy.ZFuzzySet 10.0 20.0))

(?*tempFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 20.0 10.0))

(?*tempFvar* addTerm "hot"
(new nrc.fuzzy.SFuzzySet 20.0 30.0))

(bind ?sensorTest (new iot.Sensor "sensor test" 30 ?*tempFvar*))
(add ?sensorTest)