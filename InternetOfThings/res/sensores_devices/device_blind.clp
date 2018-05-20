(defglobal ?*percentageClosed* = (new nrc.fuzzy.FuzzyVariable "blind percentage closed" 0.0 100.0 "%"))

(?*percentageClosed* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 0.0 20.0))

(?*percentageClosed* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 50.0 30.0))

(?*percentageClosed* addTerm "high"
(new nrc.fuzzy.SFuzzySet 70.0 85.0))

(bind ?blindWindow1LivingRoom (new Blind "Living Room Window 1 Blind" ?*percentageClosed* "blindWindow1LivingRoom"))
(add ?blindWindow1LivingRoom)

(defrule defuzzifyBlindWindow1LivingRoom

    (declare (salience -100))
    
    ?fact <- (Living_Room_Window_1_Blind ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?blindWindow1LivingRoom setPercentageClosed ?crisp)
    (retract ?fact)
)

(bind ?blindWindow2LivingRoom (new Blind "Living Room Window 2 Blind" ?*percentageClosed* "blindWindow2LivingRoom"))
(add ?blindWindow2LivingRoom)

(defrule defuzzifyBlindWindow2LivingRoom

    (declare (salience -100))
    
    ?fact <- (Living_Room_Window_2_Blind ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?blindWindow2LivingRoom setPercentageClosed ?crisp)
    (retract ?fact)
)

(bind ?blindWindowKitchen (new Blind "Kicthen Window Blind" ?*percentageClosed* "blindWindowKitchen"))
(add ?blindWindowKitchen)

(defrule defuzzifyBlindWindowKitchen

    (declare (salience -100))
    
    ?fact <- (Kicthen_Window_Blind ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?blindWindowKitchen setPercentageClosed ?crisp)
    (retract ?fact)
)

(bind ?blindWindowRoom1 (new Blind "Room 1 Window Blind" ?*percentageClosed* "blindWindowRoom1"))
(add ?blindWindowRoom1)

(defrule defuzzifyBlindWindowRoom1

    (declare (salience -100))
    
    ?fact <- (Room_1_Window_Blind ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?blindWindowRoom1 setPercentageClosed ?crisp)
    (retract ?fact)
)

(bind ?blindWindowRoom2 (new Blind "Room 2 Window Blind" ?*percentageClosed* "blindWindowRoom2"))
(add ?blindWindowRoom2)

(defrule defuzzifyBlindWindowRoom2

    (declare (salience -100))
    
    ?fact <- (Room_2_Window_Blind ?fuzzy)

    =>

    (bind ?crisp (?fuzzy weightedAverageDefuzzify))    
    (?blindWindowRoom2 setPercentageClosed ?crisp)
    (retract ?fact)
)
