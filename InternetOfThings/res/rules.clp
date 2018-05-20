(defrule Regra_de_caca

	"Regra_de_caca: If Basement Light Sensor is low then Security Alarm is set to On and Kitchen Heater is set to high"

	(LightSensor (name "Basement Light Sensor") (fuzzyValue ?v0&:(fuzzy-match ?v0 "low")))

	=>

	(?securityAlarm setState "On")
	(assert (Kitchen_Heater (new FuzzyValue ?*heaterTemperature* "high")))
)

