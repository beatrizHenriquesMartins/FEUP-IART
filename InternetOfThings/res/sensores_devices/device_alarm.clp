(bind ?alarmRoom1 (new Alarm "Room 1 Alarm" "alarmRoom1"))
(add ?alarmRoom1)

(bind ?alarmRoom2 (new Alarm "Room 2 Alarm" "alarmRoom2"))
(add ?alarmRoom2)


; ;alarm
; (bind ?alarmRoom1 (assert (device (name "Room 1 Alarm") (stateName on) (state FALSE))))
; (bind ?alarmRoom2 (assert (device (name "Room 2 Alarm") (stateName on) (state FALSE))))