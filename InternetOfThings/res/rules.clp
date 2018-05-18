(load-package nrc.fuzzy.jess.FuzzyFunctions)

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

;temperature sensors
(bind ?temperatureSensorGarden (assert (sensor (name "Garden Temperature Sensor") (value 0))))
(bind ?temperatureSensorLivingRoom (assert (sensor (name "Living Room Temperature Sensor") (value 0))))
(bind ?temperatureSensorKitchen (assert (sensor (name "Kitchen Temperature Sensor") (value 0))))
(bind ?temperatureSensorRoom1 (assert (sensor (name "Room 1 Temperature Sensor") (value 0))))
(bind ?temperatureSensorRoom2 (assert (sensor (name "Room 2 Temperature Sensor") (value 0))))
(bind ?temperatureSensorLargeBathroom (assert (sensor (name "Large Bathroom Temperature Sensor") (value 0))))
(bind ?temperatureSensorSmallBathroom (assert (sensor (name "Small Bathroom Temperature Sensor") (value 0))))

;humidity sensors
(bind ?insideHumiditySensor (assert (sensor (name "Inside Humidity Sensor") (value 0))))
(bind ?outsideHumiditySensor (assert (sensor (name "Outside Humidity Sensor") (value 0))))
(bind ?soilHumiditySensor (assert (sensor (name "Soil Humidity Sensor") (value 0))))


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


;windows
(bind ?window1LivingRoom (assert (device (name "Living Room Window 1") (stateName open) (state FALSE))))
(bind ?window2LivingRoom (assert (device (name "Living Room Window 2") (stateName open) (state FALSE))))
(bind ?windowKitchen (assert (device (name "Kicthen Window") (stateName open) (state FALSE))))
(bind ?windowRoom1 (assert (device (name "Room 1 Window") (stateName open) (state FALSE))))
(bind ?windowRoom2 (assert (device (name "Room 2 Window") (stateName open) (state FALSE))))

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

;air conditioned
(bind ?airConditionedLivingRoom (assert (device (name "Living Room Air Conditioned") (stateName on) (state FALSE))))
(bind ?airConditionedRoom1 (assert (device (name "Room 1 Air Conditioned") (stateName on) (state FALSE))))
(bind ?airConditionedRoom2 (assert (device (name "Room 2 Air Conditioned") (stateName on) (state FALSE))))

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

(defglobal ?*tempFvar* = (new nrc.fuzzy.FuzzyVariable "temperature" 0.0 100.0 "C"))

(?*tempFvar* addTerm "cold"
(new nrc.fuzzy.ZFuzzySet 10.0 20.0))

(?*tempFvar* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 20.0 10.0))

(?*tempFvar* addTerm "hot"
(new nrc.fuzzy.SFuzzySet 20.0 30.0))

(defglobal ?*fanSpeed* = (new nrc.fuzzy.FuzzyVariable "fan speed" 0.0 1000.0 "RPM"))

(?*fanSpeed* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 0.0 400.0))

(?*fanSpeed* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 500.0 200.0))

(?*fanSpeed* addTerm "high"
(new nrc.fuzzy.SFuzzySet 600.0 1000.0))


(bind ?windowTest (new iot.Window "window test"))
(add ?windowTest)
(bind ?acTest (new iot.AirConditioner "ac test" ?*fanSpeed*))
(add ?acTest)
(bind ?sensorTest (new iot.Sensor "sensor test" 30 ?*tempFvar*))


(add ?sensorTest)



(defrule openRoomWindow

    "Turn on room 1 AC if is too warm"
    (Sensor (name "sensor test") (fuzzyValue ?t&:(fuzzy-match ?t "hot")))

    =>

    (?windowTest setOpen TRUE)
    (update ?windowTest)
    (?acTest setFanSpeed "high")
    (update ?acTest)
    (printout t "disparei o hot" crlf)

)

(defrule openRoomWindow2

    "Turn on room 1 AC if is too warm"
    (Sensor (name "sensor test") (fuzzyValue ?t&:(fuzzy-match ?t "medium")))

    =>

    (?windowTest setOpen FALSE)
    (update ?windowTest)
    (?acTest setFanSpeed "low")
    (update ?acTest)
    (printout t "disparei o medium" crlf)


)
(run)
(?sensorTest setRealValue 11)
(update ?sensorTest)
(run)

(printout t (?windowTest isOpen) crlf)
(printout t (?acTest getFanSpeed) crlf)



