///////Application

Aufgabe: Ein Java-Programm soll �autocomplete�[Auto-Complete] 
(Princeton University's Algorithms and Data Structures course, 
https://www.cs.princeton.edu/courses/archive/fall14/cos226/assignments/autocomplete.html) implementiert werden. 
Dabei wird Maven eingesetzt. 

///////Anforderungen:

Gegeben ist eine Reihe von N Strings und positiven Gewichten (weights). 
F�r ein gegebenes Pr?fix, werden alle Strings, die mit dem Pr?fix beginnen, in absteigender Reihenfolge des Gewichts, aufgelistet.
Es gibt h?chstens 1 + [log2 N] Vergleiche in worst case bei Methoden firstIndexOf() and lastIndexOf().