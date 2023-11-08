package presentation;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.*;
import java.util.Map;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

public class FilesAndPaths {

    public static void main(String[] args) throws IOException {

        /**Filesystemelemente
         * Paths - Interface für "Bewohner" eines Filesystems
         *
         */


        //Erzeugen von Path-Objekten mit Factory → Path-kompatibels Objekt (konkreter Typ ist ohne Bedeutung)
        Path path1 = Path.of("C:/Users/Isabella/IdeaProjects/SE2QuestionBank/src/presentation/TestFile.txt");
        System.out.println(path1);

        /**Eigenschaften
         * statische Methoden der Klasse Files*/

        // Existenz
        boolean existence = exists(path1);

        // Länge (Anzahl Bytes) -> wirft evtl. IO-Exception
        long size = Files.size(path1);

        // Lesbarkeit
        boolean readable = isReadable(path1);

        // Schreibbarkeit
        boolean writable = isWritable(path1);

        // Besitzer
        UserPrincipal owner = getOwner(path1);
        String ownerName = owner.getName();

        // Zeitpunkt der letzten Änderung
        FileTime lastModified = getLastModifiedTime(path1);
        long time = lastModified.toMillis();

        /** Setter
         *
         * Zeitpunkt der letzten Änderung
         *
         *
         * */

        //Zeitpunkt der letzten Änderung
        LocalDate newLocalDate = LocalDate.of(1997, 12, 31);

        // year, month, dayOfMonth, hour, minute, second
        LocalDateTime newLocalDateTime = LocalDateTime.of(1999, 9, 30, 10, 30, 22);

        // convert LocalDateTime to Instant
        Instant instant = newLocalDateTime.toInstant(ZoneOffset.UTC);

        // convert LocalDate to Instant, need a time zone
        instant = newLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // convert instant to filetime
        // update last modified time of a file
        Files.setLastModifiedTime(path1, FileTime.from(instant));


        // Besitzer
        FileSystem fileSystem = path1.getFileSystem();
        UserPrincipalLookupService service = fileSystem.getUserPrincipalLookupService();
        UserPrincipal newOwner = service.lookupPrincipalByName("R.Schiedermeier");
        setOwner(path1, newOwner);


        /** Attribute Views
         * Zeitmarken: modified:letzte Änderung des Inhalts - changed: letzte Änderung der Metadaten - acces: letzter Zugriff auf Inhalt
         *
         * basic: lastAccesTime, lastModifiedTime, size, creationTime, isSymbolicLink, isRegularFile, fileKey, isOther, isDirectory -> alternativ *
         * dos: basic + readonly, hidden, system, archive
         * posix: basic + owner, permissions, group
         */
        Map<String, Object> attributes = Files.readAttributes(path1, "posix");
        System.out.println(attributes);


        /** Pfade
         *
         * Pfad = Liste von Pfadelementen, dazwischen Pfadtrenner(systemabhängig): /
         *
         * Konstanten:
         * String seperator
         * char seperatorChar
         */

        /** Path Methoden */

        // Letztes Pfadelement
        Path fileName = path1.getFileName();

        // Pfad des Elterndirectories
        Path parent = path1.getParent();

        // Schleifen kürzen
        Path normalized = path1.normalize();

        // Absoluter Pfad
        Path absolute = path1.toAbsolutePath();
        Path root = path1.getRoot(); // null bei relativen Pfaden

        // Pfadelement verarbeiten
        /** ??????????*/


        /** Konstruktion von Pfaden */

        // Aus Strings
        Path path2 = Path.of("test");

        // Aus bestehenden Pfaden

        // relativen Pfad konstruieren -> this.relativize(that) - kürzt that um this
        Path ab = Path.of("/a/b");
        Path abcd = Path.of("/a/b/c/d");
        ab.relativize(abcd);

        // Pfade zusammenfügen -> this.resolve(that) - verlängert this um that
        Path cd = Path.of("/c/d");
        ab.resolve(cd); // equals abcd von oben

        Path xy = Path.of("/x/y");
        ab.resolveSibling(xy); // Ergebnis: /a/x/y

        /** Directories */

        // Typabfragen

        boolean isFile = Files.isRegularFile(path1);
        boolean oisDirectory = Files.isDirectory(path1);
        // Wenn beide false weder noch

        // Auslesen des Inhalts eines Directory
        Path directory = Path.of("dirctory");
        Stream<Path> content = Files.list(directory);

        // Rekursiver Durchlauf eines Directorybaumes:
        Stream<Path> allContent = Files.walk(directory);


        /** Filesystem
         *
         * Methoden zu:
         * Länge: long size(),
         * Ob Normales File: boolean isFile(),
         * Ob Directory: boolean isDirectory(),
         * Zeitpunkt der letzten Änderung: FileTime lastModifiedTime()
         */

        // Rekursiver Durchlauf Stream<Path> Files.find(Path start, int maxLevel, matcher)
        // BiPredicate<Path, BasicFileAttributes> matcher -> entscheidet ob Element erfasst wird
        Files.find(path1, Integer.MAX_VALUE, (path, att) -> att.isRegularFile()).forEach(System.out::println);


        /** Files */
        File file1 = path1.toFile();
        File file2 = new File("test" + System.currentTimeMillis());
        System.out.println(file1);

        /** Methoden */

        file2.getName(); // Dateiname aus dem Konstruktor
        file2.getPath(); // Pfad (kann auch dem Dateinamen entsprechen)

        file2.getParent() ;     // Liefert String
        file2.getParentFile();  // Liefert File

        file2.getAbsolutePath(); // Liefert String
        file2.getAbsoluteFile(); // Liefert File


        /**
         * Path: kann besser mit Matadaten(z.B. informationen über das File) umgehen.
         * File: kann keine symbolic links, rename() funktioniert nicht immer; kann Directories erstellen
         *
         * Beide können in einender umgewandelt werden:
         * .toPath()
         * .toFile()
         *
         * Weiterführende Links:
         * https://www.baeldung.com/java-path-vs-file (englisch)
         * https://www.happycoders.eu/de/java/dateinamen-verzeichnisnamen-konstruieren-file-path-paths/ (deutsch)
         */
    }

}





