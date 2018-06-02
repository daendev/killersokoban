# Killer Sokoban

Komplex Java alkalmazás részletes tervekkel, MVC tervezési minta alapján, JavaFX grafikus megjelenítéssel.

[Grafikus felület specifikációja](https://drive.google.com/file/d/1pARGKhdfDhk8MjuEa7c4fPM1tCtF2jL-/view?usp=sharing)

### Fordítás

JavaFX szükséges hozzá. Telepítés Ubuntun:
```
$ sudo apt-get install openjfx
```

`jfxrt.jar` elérési útja (JavaFX alkalmazásokhoz szükséges):
```
JFXRT_PATH=/path/to/your/jfxrt.jar
```
Az enyém pl. itt van: `/usr/share/java/openjfx/jre/lib/ext/jfxrt.jar`

Fordítás:
```
javac -cp $FXRT_PATH -d . $(find src/ -name "*.java")
```

### Futtatás

```
java -cp ${FXRT_PATH}:. killersokoban.SokobanApp
```
