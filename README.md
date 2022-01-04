# SL_Simulator
Simulates the Super League<br>

Der Super League Simulator ist eine Applikation, die alle 10 schweizer Fussballmannschaften
gegenüberstellt. Mit vorgegebenen Werten wird von den einzelnen Spieltagen bis zur ganzen Season simuliert und dem User ausgegeben.

## Design
#### Kick Off Class Diagram
![KlassenDiagramKickOff](Diagrams/KickOffClassDiagram.png)
<br>Nach recherchen und austausch mit dem Klassenlehrer Herr Pangri, zeichnete ich grob die wichtigsten Klassen in einem Klassendiagramm auf.

#### Use Case Diagram
![UseCase](Diagrams/usecase.png)
<br>Mein Programm hat das Ziel die Liga zu simulieren und danach auszugeben, daher gibt es eigentlich nur einen Use Case.
Um auch die Frage zu beantworten, wie lange ein Team braucht um die Liga zu gewinnen, gibt es alternativ noch die Möglichkeit die Liga so lang zu simulieren, bis da Team an der Spitze ist.

## Planung & Umsetzung
Der Kern des Projekts ist die Match Engine. Ich hatte verschiedene Varianten wie ich die Bewertung der Teams lösen konnte: <br>
mit einem einzelnen Wert (z.B das Fifa Rating), mit mehreren Werten(z.B einen für Offensive, einen für Defensive), mit elf Werten pro Mannschaft representativ für die 11 Spieler.
Ich stieg mit dem einzelen Wert ein. Den Wert entnahm ich gleich dem Fifa Spiel. Der beste Wert hatte YB mit 71, den schlechtesten Lausanne mit 66. <br>
Die Resultate waren nicht wie gewünscht. Die Ligatabellen waren sehr zufällig. Die Werte waren zu nah bei einander. Weiter machte es keinen Sinn mit einer Skala von 100 
zu Arbeiten wenn ich in einer geschlossen Liga simuliere die ja für sich ist. <br>
Ich entschied mich für die zweite Variante. Jedes Team erhielt auf der Skala 0-10 einen Wert für die Offensive und die Defensive.<br>
Nach ein Paar Tests waren die Ergebnisse vielverprechend. YB wurde oft Meister, aber auch der FC Zürich konnte hin und wieder mal brillieren.
Ich passte die Werte immer wieder an bis es für meine Wahrnehmung der Super League stimmte.
<br><br>
In der gegenüberstellung der Teams an einem Spieltag musste ich kreativ werden.
Zuerst gab ich den Team eine Tagesform mit, die ihres Rating um 2 nach oben oder unten schraubt.
Danach erhielten beide Team sechs Chancen ein Tor zu erzielen. Während diesen Chances
lies ich sowohl das Rating des stürmenden Team, so wie auch das des verteidigenden Teams mit einfliessen. 
Aber ein wenig Zufall musste auch dabei sein. Sonst hätten die schlechteren Team gar keine Chance.
<br><br>
Sobald die Match Engine so stand und diverse Resultate lieferte, konnte ich mich an die Details setzten.
Ich nahm einen User Input in Form eines Lieblingsteams entgegen, gab die Möglichkeit die Liga so viel wie man will auf ein Mal zu simulieren und gab natürlich die Schlusstabelle in der Konsole aus.

#### Sequence Diagram
![SequenceDiagram](Diagrams/SequenceDiagram.png)

#### Class Diagram Final Product
![Class Diagram Final Product](Diagrams/ClassDiagramFinal.png)

## Testing
Beim Testing priorisierte ich die wichtigsten Methoden meines Programms: die Match Engine und die Ligatabelle<br>
Ich beantwortete die wichtigsten Fragen: <br>
Gewinnt in der Regel das stärke Team?<br>
Werden die Punkte richtig verteilt?<br>
Funktioniert die Sortierung nach den festgelegten Regeln?<br>

Die Test waren Erfolgreich und bestätigten ein sauberes Arbeiten.

<br>

## Fazit
Die Arbeit an diesem Projekt hat mir grossen Spass bereitet. Besonders das Anpassen der Daten und darauf die Simulation wieder und wieder laufen zu lassen war sehr Spannend.
