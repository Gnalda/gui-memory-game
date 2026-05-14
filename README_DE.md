> 🇬🇧 [English Version – README.md](README.md)

# GUI Memory Game

Ein GUI-basiertes Memory-Kartenspiel für zwei Spieler, entwickelt mit Java Swing.

## Über das Projekt

Das Projekt ist eine Weiterentwicklung vom Repo „console-memory-game" und gehört ebenfalls zu meinen ersten vollständig selbstständig entwickelten Programmen. Auch dieses Projekt spiegelt meine ersten Schritte in der Softwareentwicklung wider und soll meine Entwicklung als Programmierer dokumentieren.

Das Projekt wurde für GitHub lauffähig aufbereitet, d.h. es wurde teilweise modifiziert. Die Modifikationen umfassen den Austausch der Assets durch eigene Fotografien, das Entfernen von Audio-Sounds sowie die Behebung einzelner defekter Codestellen.
Um den ursprünglichen Programmierstil und rudimentäre Entwicklungsansätze authentisch zu dokumentieren, wurde trotz bekannter Fehlerquellen und mangelhafter Codequalität bewusst auf eine weitergehende Optimierung verzichtet.

## Features

- **1v1-Spielmodus** — Zwei Spieler treten lokal an Tastatur und Maus gegeneinander an. Ziel ist es, möglichst viele passende Kartenpaare aufzudecken.

- **Mehrere Spielfeldgrößen** — Vor dem Spielstart kann zwischen drei Schwierigkeitsstufen gewählt werden:
  - 16 Karten
  - 36 Karten
  - 64 Karten

- **Grafische Benutzeroberfläche** — Das Spiel läuft in einem Java-Swing-Vollbildfenster mit bildbasierten Karten, Spielerpanels und Live-Punktestand.

- **Zuganzeige** — Der aktuelle Spieler wird durch ein grünes „Am Zug"-Label hervorgehoben.

- **Automatische Spielauswertung** — Sobald alle Kartenpaare gefunden wurden, endet das Spiel automatisch und gibt den Gewinner bekannt.

---

## Voraussetzungen

- **Java:** JDK 8 – 16

  > ⚠️ **Wichtig:** Dieses Projekt verwendet `java.util.Observable` und `java.util.Observer`, die in Java 9 als veraltet markiert und in **Java 17 vollständig entfernt** wurden. Der Code lässt sich **ab Java 17 ohne Anpassung nicht mehr kompilieren**. Bitte eine JDK-Version zwischen 8 und 16 verwenden.
  >
  > 📥 Passendes JDK herunterladen: [https://adoptium.net](https://adoptium.net) — dort unter *„Other platforms & versions"* Version **11** oder **16** auswählen

- **Betriebssystem:** Windows, macOS oder Linux

---

## Installation & Start

1. Repository klonen oder herunterladen
2. In das `src`-Verzeichnis wechseln:

```
cd gui-memory-game/src
```

3. Java-Dateien kompilieren:

```
javac *.java
```

4. Spiel starten:

```
java MemoryGUI
```

> **Hinweis:** Der Ordner `assets/` muss innerhalb von `src/` verbleiben, damit die Bilder zur Laufzeit korrekt gefunden werden.

---

## Spielanleitung

### 1. Spiel starten

Programm wie oben beschrieben starten. Das Hauptmenü erscheint.

### 2. Spielfeldgröße wählen

Einen der drei Buttons anklicken, um ein Spiel zu starten:

- `16 Karten`
- `36 Karten`
- `64 Karten`

<img src="src/assets/rdme/menue-rdme.PNG" width="700"/>

### 3. Karten aufdecken

Eine beliebige verdeckte Karte anklicken, um sie aufzudecken. Jeder Zug besteht aus genau zwei Karten.

<img src="src/assets/rdme/init-playmet-rdme.PNG" width="700"/>

### 4. Paare finden

- Wenn beide Karten übereinstimmen:
  - bleiben sie sichtbar
  - der Spieler erhält einen Punkt
  - der Spieler darf weiterspielen

<img src="src/assets/rdme/playmet-rdme.PNG" width="700"/>

### 5. Spiel gewinnen

Das Spiel endet automatisch, sobald alle Paare gefunden wurden. Der Spieler mit den meisten Punkten gewinnt.

<img src="src/assets/rdme/result-playmet-rdme.PNG" width="700"/>

---

## Spielregeln

- Das Spiel wird von **Spieler 1** und **Spieler 2** gespielt
- Spieler 1 beginnt immer
- Jeder Zug besteht aus genau zwei aufgedeckten Karten
- Bei einem Paar: Karten bleiben sichtbar, Punkt + weiter am Zug
- Bei keinem Paar: Karten werden nach kurzer Verzögerung wieder umgedreht, der andere Spieler ist dran
- Das Spiel endet, wenn alle Paare gefunden wurden

---

## Projektstruktur

```
gui-memory-game/
├── src/
│   ├── MemoryGUI.java       # Hauptmenü (View)
│   ├── PlaymetGUI.java      # Spielansicht mit Spielerpanels (View)
│   ├── Game.java            # Spiellogik & Kartenlayout (Model + Observer)
│   ├── Card.java            # Einzelne Karte als Komponente (Model)
│   ├── Player.java          # Spielerzustand & Zuglogik (Model + Observable)
│   ├── ActionHandler.java   # Ereignis-Controller (Controller)
│   └── assets/
│       ├── card-img/        # Kartenbilder (A–Z und Sonderzeichen)
│       ├── misc-img/        # Menühintergrund & Kartenrückseite
│       └── rdme/            # Screenshots für die README
├── README.md
├── README_DE.md
├── LICENSE
├── LICENSE_ASSETS.md
└── .gitignore
```

---

## Lizenz

Der Quellcode dieses Projekts ist unter der [MIT-Lizenz](LICENSE) veröffentlicht.  
© 2026 Hermann Schmidt

---

## Bildlizenz

Die Bilder in `src/assets/card-img/` und `src/assets/misc-img/` sind persönliche Fotografien von Hermann Schmidt aus verschiedenen Jahren und fallen **nicht** unter die MIT-Lizenz.

Sie sind lizenziert unter [CC BY-NC 4.0](https://creativecommons.org/licenses/by-nc/4.0/) — sie dürfen im Rahmen dieses Projekts angesehen und genutzt werden, jedoch **nicht für kommerzielle Zwecke verwendet oder außerhalb dieses Projekts weitergegeben werden**.

Vollständige Lizenzbedingungen: [LICENSE_ASSETS.md](LICENSE_ASSETS.md)