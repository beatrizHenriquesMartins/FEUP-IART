(defrule testSimpleRuleF-N

	(TemperatureSensor (name "Living Room Temperature Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "cold")))

	=>

	(assert (Living_Room_Heater_1 (new FuzzyValue ?*heaterTemperature* "high")))
)

