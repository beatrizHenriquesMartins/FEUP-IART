(load-package nrc.fuzzy.jess.FuzzyFunctions)
(import nrc.fuzzy.*)

/*

regras

    - se chover fechar janela
    - se dia abrir preciana
    - se noite fechar janela preciana
    - se cama > peso cama e hora > despertar -> tocar despertador
    - se sensor movimento divisão -> acender luz 



*/


(deftemplate sensor
     "A specific sensor."
    (slot name (type STRING))
    (slot value))

(deftemplate clock extends sensor
     "A clock sensor."
    (slot hour (type INTEGER))
    (slot minute (type INTEGER)))

(deftemplate device
     "A device"
    (slot name (type STRING))
    (slot stateName (type STRING))
    (slot state))



;ph sensor
(bind ?pHSensorPool (assert (sensor (name "Swiming pool PH Sensor") (value 0))))

;movement sensor
(bind ?movementSensorGarage (assert (sensor (name "Garage Movement Sensor") (value FALSE))))
(bind ?movementSensorGarden (assert (sensor (name "Garden Movement Sensor") (value FALSE))))
(bind ?movementSensorBasement (assert (sensor (name "Basement Movement Sensor") (value FALSE))))
(bind ?movementSensorLivingRoom (assert (sensor (name "Living Room Movement Sensor") (value FALSE))))
(bind ?movementSensorRoom1 (assert (sensor (name "Room 1 Movement Sensor") (value FALSE))))
(bind ?movementSensorRoom2 (assert (sensor (name "Room 2 Movement Sensor") (value FALSE))))

;clock
(bind ?clock (assert (clock (name "Clock") (hour 0) (minute 0))))

;pressure sensor
(bind ?pressureSensorCouch (assert (sensor (name "Couch Pressure Sensor") (value 0))))
(bind ?pressureSensorBedRoom1 (assert (sensor (name "Room 1 Bed Pressure Sensor") (value 0))))
(bind ?pressureSensorBedRoom2 (assert (sensor (name "Room 2 Bed Pressure Sensor") (value 0))))

;light sensor
(bind ?lightSensorGarden (assert (sensor (name "Garden Light Sensor") (value 0))))
(bind ?lightSensorKitchen (assert (sensor (name "Kitchen Light Sensor") (value 0))))
(bind ?lightSensorLivingRooom (assert (sensor (name "Living Room Light Sensor") (value 0))))
(bind ?lightSensorRoom1 (assert (sensor (name "Room 1 Light Sensor") (value 0))))
(bind ?lightSensorRoom2 (assert (sensor (name "Room 2 Light Sensor") (value 0))))
(bind ?lightSensorBasement (assert (sensor (name "Basement Light Sensor") (value 0))))
(bind ?lightSensorSmallBathRoom (assert (sensor (name "Small Bathroom Light Sensor") (value 0))))
(bind ?lightSensorLargeBathRoom (assert (sensor (name "Large Bathroom Light Sensor") (value 0))))


;blinds
(bind ?blindWindow1LivingRoom (assert (device (name "Living Room Window 1 Blind") (stateName open) (state FALSE))))
(bind ?blindWindow2LivingRoom (assert (device (name "Living Room Window 2 Blind") (stateName open) (state FALSE))))
(bind ?blindWindowKitchen (assert (device (name "Kicthen Window Blind") (stateName open) (state FALSE))))
(bind ?blindWindowRoom1 (assert (device (name "Room 1 Window Blind") (stateName open) (state FALSE))))
(bind ?blindWindowRoom2 (assert (device (name "Room 2 Window Blind") (stateName open) (state FALSE))))

;lights
(bind ?lightGarden (assert (device (name "Garden Light") (stateName on) (state FALSE))))
(bind ?lightGarage (assert (device (name "Garage Light") (stateName on) (state FALSE))))
(bind ?light1LivingRoom (assert (device (name "Living Room Light 1") (stateName on) (state FALSE))))
(bind ?light2LivingRoom (assert (device (name "Living Room Light 2") (stateName on) (state FALSE))))
(bind ?light3LivingRoom (assert (device (name "Living Room Light 3") (stateName on) (state FALSE))))
(bind ?light1Kitchen (assert (device (name "Kitchen Light 1") (stateName on) (state FALSE))))
(bind ?light2Kitchen (assert (device (name "Kitchen Light 2") (stateName on) (state FALSE))))
(bind ?lightRoom1 (assert (device (name "Room 1 Light") (stateName on) (state FALSE))))
(bind ?lightRoom2 (assert (device (name "Room 2 Light") (stateName on) (state FALSE))))
(bind ?lightLargeBathRoom (assert (device (name "Large Bathroom Light") (stateName on) (state FALSE))))
(bind ?lightSmalBathRoom (assert (device (name "Small Bathroom Light") (stateName on) (state FALSE))))

;heaters
(bind ?heater1LivingRoom (assert (device (name "Living Room Heater 1") (stateName on) (state FALSE))))
(bind ?heater2LivingRoom (assert (device (name "Living Room Heater 2") (stateName on) (state FALSE))))
(bind ?heaterKitchen (assert (device (name "Kitchen Heater") (stateName on) (state FALSE))))
(bind ?heaterRoom1 (assert (device (name "Room 1 Heater") (stateName on) (state FALSE))))
(bind ?heaterRoom2 (assert (device (name "Room 2 Heater") (stateName on) (state FALSE))))
(bind ?heaterLargeBathRoom (assert (device (name "Large Bathroom Heater") (stateName on) (state FALSE))))

;caldeira
(bind ?waterHeater (assert (device (name "Water Heater") (stateName on) (state 25))))


;doors
(bind ?doorFront (assert (device (name "Front Door") (stateName open) (state FALSE))))
(bind ?doorLivingRoom (assert (device (name "Living Room Door") (stateName open) (state FALSE))))
(bind ?doorKitchen (assert (device (name "Kitchen Door") (stateName open) (state FALSE))))
(bind ?doorGarage (assert (device (name "Garage Door") (stateName open) (state FALSE))))
(bind ?doorBasement (assert (device (name "Basement Door") (stateName open) (state FALSE))))
(bind ?doorLargeBathroom (assert (device (name "Large Bathroom Door") (stateName open) (state FALSE))))
(bind ?doorSmallBathroom (assert (device (name "Small Bathroom Door") (stateName open) (state FALSE))))
(bind ?doorRoom1 (assert (device (name "Room 1 Door") (stateName open) (state FALSE))))
(bind ?doorRoom2 (assert (device (name "Room 2 Door") (stateName open) (state FALSE))))

;security alarm
(bind ?alarm (assert (device (name "Security Alarm") (stateName on) (state FALSE))))

;alarm
(bind ?alarmRoom1 (assert (device (name "Room 1 Alarm") (stateName on) (state FALSE))))
(bind ?alarmRoom2 (assert (device (name "Room 2 Alarm") (stateName on) (state FALSE))))


(defrule openWindow
    "Open window if is too warm"
    (sensor {name == "Living Room Temperature Sensor" && value > 22 })
    (clock {name == "Clock" && hour > 7 && hour < 19})

    =>

    (modify ?window1LivingRoom (state TRUE))
    (modify ?window2LivingRoom (state TRUE))
)



(defrule HighAC

    (TemperatureSensor (name "Living Room Temperature Sensor") (fuzzyValue ?t&:(fuzzy-match ?t "hot")))
    (HumiditySensor (name "Inside Humidity Sensor") (fuzzyValue ?h&:(fuzzy-match ?h "humid")))


    =>

    (assert (fanSpeedLivingRoom (new FuzzyValue ?*fanSpeed* "high")))
    (assert (fanSpeedRoom1 (new FuzzyValue ?*fanSpeed* "high")))

    (printout t "disparei o high" crlf)

)

(defrule MediumAc

    (TemperatureSensor (name "Living Room Temperature Sensor") (fuzzyValue ?t&:(fuzzy-match ?t "medium")))


    =>

    (assert (fanSpeedLivingRoom (new FuzzyValue ?*fanSpeed* "medium")))
    (assert (fanSpeedRoom1 (new FuzzyValue ?*fanSpeed* "low")))
    (?window1LivingRoom setOpen TRUE)
    (printout t "disparei o medium" crlf)


)

(defrule LowAc

    (TemperatureSensor (name "Living Room Temperature Sensor") (fuzzyValue ?t&:(fuzzy-match ?t "cold")))


    =>

    (assert (fanSpeedLivingRoom (new FuzzyValue ?*fanSpeed* "low")))
    (printout t "disparei o low" crlf)


)

(defrule defuse 

    (declare (salience -100))
    
    (TemperatureSensor (name "Living Room Temperature Sensor") (realValue ?realValue))
    ?fanSpeedFactLivingRoom <- (fanSpeedLivingRoom ?fuzzyFanSpeedLivingRoom)
    ?fanSpeedFactRoom1 <- (fanSpeedRoom1 ?fuzzyFanSpeedRoom1)

    =>

    (bind ?crispFanSpeedLivingRoom (?fuzzyFanSpeedLivingRoom momentDefuzzify))
    (bind ?crispFanSpeedRoom1 (?fuzzyFanSpeedRoom1 momentDefuzzify))
    
    (?airConditionedLivingRoom setFanSpeed ?crispFanSpeedLivingRoom)
    (?airConditionedRoom1 setFanSpeed ?crispFanSpeedRoom1)
    (printout t "Fan ac living room: "(?airConditionedLivingRoom getFanSpeed) crlf)
    (printout t "Fan ac room1: "(?airConditionedRoom1 getFanSpeed) crlf)
    (printout t (?window1LivingRoom isOpen) crlf)
    (retract ?fanSpeedFactLivingRoom)
    (retract ?fanSpeedFactRoom1)
)  


(defrule teste

    (TemperatureSensor {name == "Living Room Temperature Sensor" && realValue > 40})

    =>

    (?window1LivingRoom setOpen FALSE)
    (printout t "disparei o teste" crlf)

)

(run)
(?temperatureSensorLivingRoom setRealValue 17)
(?insideHumiditySensor setRealValue 90)
(update ?temperatureSensorLivingRoom)
(update ?insideHumiditySensor)
(run)

(?temperatureSensorLivingRoom setRealValue 42)
(update ?temperatureSensorLivingRoom)
(run)

