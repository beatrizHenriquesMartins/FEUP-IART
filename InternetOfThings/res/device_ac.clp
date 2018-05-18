(defglobal ?*fanSpeed* = (new nrc.fuzzy.FuzzyVariable "fan speed" 0.0 1000.0 "RPM"))

(?*fanSpeed* addTerm "low"
(new nrc.fuzzy.ZFuzzySet 0.0 400.0))

(?*fanSpeed* addTerm "medium"
(new nrc.fuzzy.PIFuzzySet 500.0 200.0))

(?*fanSpeed* addTerm "high"
(new nrc.fuzzy.SFuzzySet 600.0 1000.0))

(bind ?acTest (new iot.AirConditioner "ac test" ?*fanSpeed*))
(add ?acTest)