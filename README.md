# Berlin Clock Kata
Exercice Berlin Clock Kata (source : http://agilekatas.co.uk/katas/BerlinClock-Kata)

## Compilation 
Tache maven : mvn clean install

## Utilisation
Utilisation Spring Boot pour exposer en REST la méthode de conversion.
Si vous souhaitez lancer le programme : 
- via eclipse, lancer la classe BerlinClockKataLauncher, et appeler via l'URL : http://127.0.0.1:8080/clockConverter/digitalToBerlin?time={heure format HH:MM:SS}
- avec le jar : java -jar <nomdujar> puis appel de l'URL : http://127.0.0.1:8080/clockConverter/digitalToBerlin?time={heure format HH:MM:SS}

## Test
Utilisation de la librairie cucumber.
Scénarios décrit dans le fichier src/test/resources/features/convert-digital-to-berlin-time.feature
