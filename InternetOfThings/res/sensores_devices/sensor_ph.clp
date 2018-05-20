(defglobal ?*phFvar* = (new nrc.fuzzy.FuzzyVariable "ph" 0.0 14.0))

(?*phFvar* addTerm "very_acid"
(new nrc.fuzzy.ZFuzzySet 2.5 5.0))

(?*phFvar* addTerm "acid"
(new nrc.fuzzy.PIFuzzySet 4.0 1.0))

(?*phFvar* addTerm "neutral"
(new nrc.fuzzy.PIFuzzySet 7.0 1.0))

(?*phFvar* addTerm "alkalin"
(new nrc.fuzzy.PIFuzzySet 7.5 1.0))

(?*phFvar* addTerm "very_alkalin"
(new nrc.fuzzy.SFuzzySet 9.0 12.0))

(bind ?pHSensorPool (new PhSensor "Swiming pool PH Sensor" 7 ?*phFvar* "pHSensorPool"))
(add ?pHSensorPool)

(bind ?pHSensorGarden (new PhSensor "Garden PH Sensor" 7 ?*phFvar* "pHSensorGarden"))
(add ?pHSensorGarden)