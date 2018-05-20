(defglobal ?*waterTemperature* = (new nrc.fuzzy.FuzzyVariable "water temperature" 0.0 100.0 "ª"))

(?*waterTemperature* addTerm "medium"
(new nrc.fuzzy.ZFuzzySet 0.0 30.0))

(?*waterTemperature* addTerm "high"
(new nrc.fuzzy.SFuzzySet 20.0 70.0))

(bind ?waterHeater (new WaterHeater "Water Heater" ?*waterTemperature* "waterHeater"))
(add ?waterHeater)

(defrule defuzzifyWaterHeater

    (declare (salience -100))
    
    ?fact <- (Water_Heater ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?waterHeater setWaterTemperature ?crisp)
    (retract ?fact)
)