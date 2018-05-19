(defglobal ?*fanSpeed* = (new nrc.fuzzy.FuzzyVariable "fan speed" 0.0 1000.0 "RPM"))

(?*fanSpeed* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 0.0 400.0))

(?*fanSpeed* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 500.0 200.0))

(?*fanSpeed* addTerm "high"
(new nrc.fuzzy.SFuzzySet 600.0 1000.0))

(bind ?airConditionedLivingRoom (new AirConditioner "Living Room Air Conditioned" ?*fanSpeed* "airConditionedLivingRoom"))
(add ?airConditionedLivingRoom)

(bind ?airConditionedRoom1 (new AirConditioner "Room 1 Air Conditioned" ?*fanSpeed* "airConditionedRoom1"))
(add ?airConditionedRoom1)

(bind ?airConditionedRoom2 (new AirConditioner "Room 2 Air Conditioned" ?*fanSpeed* "airConditionedRoom2"))
(add ?airConditionedRoom2)


(defrule defuzzifyACLivingRoom 

    (declare (salience -100))
    
    ?fanSpeedFactLivingRoom <- (Living_Room_Air_Conditioned ?fuzzyFanSpeedLivingRoom)

    =>

    (bind ?crispFanSpeedLivingRoom (?fuzzyFanSpeedLivingRoom momentDefuzzify))    
    (?airConditionedLivingRoom setFanSpeed ?crispFanSpeedLivingRoom)
    (printout t "Fan ac living room: "(?airConditionedLivingRoom getFanSpeed) crlf)
    (retract ?fanSpeedFactLivingRoom)
)

(defrule defuzzifyACRoom1 

    (declare (salience -100))    
    ?fanSpeedFactRoom1 <- (Room_1_Air_Conditioned ?fuzzyFanSpeedRoom1)

    =>

    (bind ?crispFanSpeedRoom1 (?fuzzyFanSpeedRoom1 momentDefuzzify))
    (?airConditionedRoom1 setFanSpeed ?crispFanSpeedRoom1)
    (printout t "Fan ac room1: "(?airConditionedRoom1 getFanSpeed) crlf)
    (retract ?fanSpeedFactRoom1)
) 
