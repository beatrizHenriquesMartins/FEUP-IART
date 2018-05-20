(defglobal ?*timeFvar* = (new nrc.fuzzy.FuzzyVariable "time" 0.0 1440.0))

(?*timeFvar* addTerm "early_morning"
(new nrc.fuzzy.ZFuzzySet 330.0 480.0))

(?*timeFvar* addTerm "morning"
(new nrc.fuzzy.PIFuzzySet 600 120.0))

(?*timeFvar* addTerm "late_morning"
(new nrc.fuzzy.PIFuzzySet 480 30.0))

(?*timeFvar* addTerm "noon"
(new nrc.fuzzy.PIFuzzySet 720.0 0.0))

(?*timeFvar* addTerm "afternoon"
(new nrc.fuzzy.ZFuzzySet 721 1140.0))

(?*timeFvar* addTerm "evening"
(new nrc.fuzzy.PIFuzzySet 1080.0 60.0))

(?*timeFvar* addTerm "nigth"
(new nrc.fuzzy.PIFuzzySet 1380.0 60.0))

(?*timeFvar* addTerm "late_night"
(new nrc.fuzzy.SFuzzySet 1320.0 1440))

(?*timeFvar* addTerm "late_night_morning"
(new nrc.fuzzy.ZFuzzySet 180.0 300.0))

(bind ?clock (new Clock "Clock" 720 ?*timeFvar* "clock"))
(add ?clock)