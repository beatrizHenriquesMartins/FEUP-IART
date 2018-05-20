(defglobal ?*irrigationSystemPower* = (new nrc.fuzzy.FuzzyVariable "Irrigation System Power" 0.0 100.0))

(?*irrigationSystemPower* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 0.0 40.0))

(?*irrigationSystemPower* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 50.0 20.0))

(?*irrigationSystemPower* addTerm "high"
(new nrc.fuzzy.SFuzzySet 60.0 100.0))

(bind ?irrigationSystemGarden (new IrrigationSystem "Garden Irrigation System" ?*irrigationSystemPower* "irrigationSystemGarden"))
(add ?irrigationSystemGarden)


(defrule defuzzifyGardenIrrigationSystem 

    (declare (salience -100))
    ?powerFactIrrigationSystemGarden <- (Garden_Irrigation_System ?fuzzyPowerIrrigationSystem)

    =>

    (bind ?crispPowerIrrigationSystem (?fuzzyPowerIrrigationSystem weightedAverageDefuzzify))    
    (?irrigationSystemGarden setIrrigationSystemPower ?crispPowerIrrigationSystem)
    (printout t "Irrigation System power: "(?irrigationSystemGarden getIrrigationSystemPower) crlf)
    (retract ?powerFactIrrigationSystemGarden)
)