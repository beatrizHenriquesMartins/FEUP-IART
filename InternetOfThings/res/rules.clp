(defrule testSimpleRuleF-N

	"testSimpleRuleF-N: If Living Room Temperature Sensor is cold then Living Room Heater 1 is set to high"

	(TemperatureSensor (name "Living Room Temperature Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "cold")))

	=>

	(assert (Living_Room_Heater_1 (new FuzzyValue ?*heaterTemperature* "high")))
)

