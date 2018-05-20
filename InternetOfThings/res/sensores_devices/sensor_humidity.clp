(defglobal ?*humidityFvar* = (new nrc.fuzzy.FuzzyVariable "humidity" 0.0 100.0 "%"))

(?*humidityFvar* addTerm "dry"
(new nrc.fuzzy.ZFuzzySet 10.0 30.0))

(?*humidityFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 50.0 30.0))

(?*humidityFvar* addTerm "humid"
(new nrc.fuzzy.SFuzzySet 70.0 90.0))

(bind ?insideHumiditySensor (new HumiditySensor "Inside Humidity Sensor" 30 ?*humidityFvar* "insideHumiditySensor"))
(add ?insideHumiditySensor)

(bind ?outsideHumiditySensor (new HumiditySensor "Outside Humidity Sensor" 20 ?*humidityFvar* "outsideHumiditySensor"))
(add ?outsideHumiditySensor)

(bind ?soilHumiditySensor (new HumiditySensor "Soil Humidity Sensor" 30 ?*humidityFvar* "soilHumiditySensor"))
(add ?soilHumiditySensor)