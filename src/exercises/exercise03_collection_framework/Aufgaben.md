# Aufgaben: Collection-Framework

Hallo zusammen, die Aufgaben zum Collection-Framework habe ich von der alten Praktikums-Seite vom Schiedermeier, daher zu jeder Aufgabe die jeweilige Aufgabenstellung.

Außerdem ist keine `main`-Methode notwendig - einfach die Tests laufen lassen bzw. fixen.

## Aufgabe 1: Josephus

Der König begnadigt an seinem Geburtstag ein paar eingekerkerte Gefangene. Er gibt seinem Kerkermeister vorher einen Zettel mit

1. einer Pechzahl und
2. der Anzahl glücklicher Gefangener, die er freilässt. 

Die Gefangenen stellen sich in einer Reihe auf. Dann liest der Kerkermeister die Pechzahl und die Anzahl der Glücklichen vor.

Ab dem ersten Gefangenen zählen diese der Reihe nach hoch. Wer die Pechzahl nennt (nennen muss), der verlässt die Reihe und bleibt im Kerker. Der nächste fängt wieder bei 1 an. So geht es reihum weiter, bis nur noch die Anzahl Glücklicher übrig ist.

### Aufgabe

Schreiben Sie für den König ein Programm Josephus, mit dem er experimentieren kann.

- Der Konstruktor erhält eine Liste mit Namen der Gefangenen.
- Die Methode `List<String> hailTheKing(int bad, int happy)` zählt mit der Pechzahl (`bad`) ab, so lang mehr als die festgesetzte Anzahl (`happy`) Namen übrig ist und liefert am Ende die verbleibenden Namen zurück. 

Der König verspricht ganz fest: Die Namensliste ist nicht null, die Pechzahl und die Anzahl Glücklicher wenigstens 1. Aber Sie sollten lieber sicher gehen.

### Beispiel

**Von links nach rechts und oben nach unten lesen. (sprich: "Gefangener A sagt '1', Gefangener B sagt '2' und ist somit raus.")**

| **Gefangener A** | **Gefangener B** | **Gefangener C** | **Gefangener D** | **Gefangener E** |
|------------------|------------------|------------------|------------------|------------------|
| 1                | -                | -                | -                | -                |
| -                | 2 -> Raus        | -                | -                | -                |
| -                | -                | 1                | -                | -                |
| -                | -                | -                | 2 -> Raus        | -                |
| -                | -                | -                | -                | 1                |
| 2 -> Raus        | -                | -                | -                | -                |
| -                | -                | 1                | -                | -                |
| -                | -                | -                | -                | 2 -> Raus        |
| -                | -                | Übrig            | -                | -                |

## Aufgabe 2: ThinLine

Der generische Containertyp ThinLine speichert Elemente vom Typ `E`. Er adressiert die Elemente mit einem Index, wie ein Array oder eine Liste. Anders als ein Array oder eine Liste geht eine ThinLine davon aus, das die meisten Elemente den Defaultwert haben und nur wenige Elemente einen anderen. Sie speichert daher nicht alle Elemente einzeln ab, sondern nur die „interessanten“ Elemente, die nicht den Defaultwert haben. Nur für diese merkt sie sich Index und Wert.

Implementieren Sie das Interface `ThinLine` mit einer konkreten Klasse `TheThinLine`.

Über das Interface hinaus definiert Ihre Klasse einen
- Default-Ctor, der als Defaultwert null verwendet. Dazu kommt ein 
- Custom-Ctor mit einem Parameter für den Defaultwert.

### Beispiel

Ein Demoprogramm zeigt die Arbeitsweise:
```
ThinLine<Integer> many = new TheThinLine<>(0);

many.replace(1, 1);
many.replace(2_000_000_000, 1);
System.out.println(many.lastAt()); // 2_000_000_000
System.out.println(many.read(2_000_000_000)); // 1
System.out.println(many.read(2_000_000_001)); // 0

many.insert(2_000_000_000, 2);
System.out.println(many.lastAt()); // 2_000_000_001
System.out.println(many.read(2_000_000_000)); // 2
System.out.println(many.read(2_000_000_001)); // 1

System.out.println(many.delete(2)); // 0
System.out.println(many.lastAt()); // 2_000_000_000
System.out.println(many.read(2_000_000_000)); // 1
System.out.println(many.read(2_000_000_001)); // 0

many.replace(2_000_000_000, 0);
System.out.println(many.lastAt()); // 1_999_999_999
```