(defglobal ?*heaterTemperature* = (new nrc.fuzzy.FuzzyVariable "heater temperature" 0.0 100.0 "º"))

(?*heaterTemperature* addTerm "medium"
(new nrc.fuzzy.ZFuzzySet 0.0 50.0))


(?*heaterTemperature* addTerm "high"
(new nrc.fuzzy.SFuzzySet 40.0 90.0))

(bind ?heater1LivingRoom (new Heater "Living Room Heater 1" ?*heaterTemperature* "heater1LivingRoom"))
(add ?heater1LivingRoom)

(defrule defuzzifyHeater1LivingRoom

    (declare (salience -100))
    
    ?fact <- (Living_Room_Heater_1 ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heater1LivingRoom setHeaterTemperature ?crisp)
    (retract ?fact)
)

(bind ?heater2LivingRoom (new Heater "Living Room Heater 2" ?*heaterTemperature* "heater2LivingRoom"))
(add ?heater2LivingRoom)

(defrule defuzzifyHeater2LivingRoom

    (declare (salience -100))
    
    ?fact <- (Living_Room_Heater_2 ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heater2LivingRoom setHeaterTemperature ?crisp)
    (retract ?fact)
)

(bind ?heaterKitchen (new Heater "Kitchen Heater" ?*heaterTemperature* "heaterKitchen"))
(add ?heaterKitchen)

(defrule defuzzifyHeaterKitchen

    (declare (salience -100))
    
    ?fact <- (Kitchen_Heater ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heaterKitchen setHeaterTemperature ?crisp)
    (retract ?fact)
)

(bind ?heaterRoom1 (new Heater "Room 1 Heater" ?*heaterTemperature* "heaterRoom1"))
(add ?heaterRoom1)

(defrule defuzzifyHeaterRoom1

    (declare (salience -100))
    
    ?fact <- (Room_1_Heater ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heaterRoom1 setHeaterTemperature ?crisp)
    (retract ?fact)
)

(bind ?heaterRoom2 (new Heater "Room 2 Heater" ?*heaterTemperature* "heaterRoom2"))
(add ?heaterRoom2)

(defrule defuzzifyHeaterRoom2

    (declare (salience -100))
    
    ?fact <- (Room_2_Heater ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heaterRoom2 setHeaterTemperature ?crisp)
    (retract ?fact)
)

(bind ?heaterLargeBathRoom (new Heater "Large Bathroom Heater" ?*heaterTemperature* "heaterLargeBathRoom"))
(add ?heaterLargeBathRoom)

(defrule defuzzifyHeaterLargeBathRoom

    (declare (salience -100))
    
    ?fact <- (Large_Bathroom_Heater ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?heaterLargeBathRoom setHeaterTemperature ?crisp)
    (retract ?fact)
)