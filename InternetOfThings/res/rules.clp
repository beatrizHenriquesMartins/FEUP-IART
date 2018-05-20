(defrule Regra_de_caca

	"Regra_de_caca: If Basement Light Sensor is low then Security Alarm is set to On and Kitchen Heater is set to high"

	(LightSensor (name "Basement Light Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "low")))

	=>

	(?securityAlarm setState "On")
	(assert (Kitchen_Heater (new FuzzyValue ?*heaterTemperature* "high")))
)

(defrule fefsdf

	"fefsdf: If Room 1 Temperature Sensor is cold then Room 1 Heater is set to high"

	(TemperatureSensor (name "Room 1 Temperature Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "cold")))

	=>

	(assert (Room_1_Heater (new FuzzyValue ?*heaterTemperature* "high")))
)

(defrule khb

	"khb: If Room 1 Temperature Sensor is hot then Room 1 Heater is set to 0.0"

	(TemperatureSensor (name "Room 1 Temperature Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "hot")))

	=>

	(?heaterRoom1 setHeaterTemperature 0.0)
)

