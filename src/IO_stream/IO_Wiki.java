package IO_stream;

import java.io.*;
import java.util.Objects;


public class IO_Wiki {

    /**
     * Um Files zu Lesen oder zu schreiben benutzt man FileWriter und FileReader Klassen. Sie lesen einzelne chars und hören bei dem Wert -1 auf
     * Damit es keine IO Exceptions kommen, müssen die Writer, Reader in einem ARM (Automatic Resource Management) Block definiert werden.
     * Wenn der Code im ARM Block ausgeführt wird, dann leert es den Puffer automatisch. Dadurch entfällt die Notwendigkeit,
     * die Funktion flush() oder close() zu benutzen.
     */
    void armExample(){
        try(FileReader fr = new FileReader(new File("Path"));){  //ARM Block
            fr.read();
            fr.close(); // Die function close() brauchen wir in diesem Fall nicht
        }catch (IOException e){
            System.out.println("We got an IOException captain");
        }
    }

    /**
     * Da die Einzelne chars zu lesen oder zu schreiben ineffizient ist, macht es sinn "Zeichen Arrays" zu benutzen
     * Es gibt mehrere overloaded Ctor von read und write functions
     int read()
     int read(char[] characters)
     int read(char[] characters, int start, int length)
     void write(int character)
     void write(char[] characters)
     void write(char[] characters, int start, int length)
     void write(String string)
     void write(String string, int start, int length)
     */

    static void charArrays(){
        String text = "Die Veranstaltung wird aufgezeichnet, um...";
        char[] charArray = text.toCharArray();
        try (FileReader fr = new FileReader(new File("Path"));
             FileWriter fw = new FileWriter(new File("Path"));
        ) {
            System.out.println(fr.read());
            fr.read(charArray, 3, 5); // return int gibt an wie viele zeichen gelesen wurden
            fw.write("Die Veranstaltung...", 5, 6);
        }   catch (IOException e){
            System.out.println("We got an IOException captain");
        }
    }

    /**
     * Es gibt mehrere Arten von Quellen z.B. StringReader/StringWriter, CharArrayReader/CharArrayWriter,
     * PipedReader/PipedWriter, aber deren methoden sind immer gleich
     * Zu guter letzt kann man custom Reader und Writer von ABC Reader und ABC Writer ableiten.
     */

    void abcReader(){
        Reader CustomReader = new Reader() {
            @Override
            public int read(char[] charArray, int start, int length) throws IOException {
                return 0; //functionalität implementieren
            }

            @Override
            public void close() throws IOException {

            }
        };
    }
    //                         Filter

    /**
     * Filter verändern den Text beim schreiben oder Lesen. Der bekanntester ist der BufferReader
     * Wie bei Reader und Writer kann man sie von ABC FilterReader, FilterWriter ableiten
     */
    static void exampleBufferedReader(){
        try(FileReader fileReader = new FileReader("Path");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            bufferedReader.lines()
                    .forEach(System.out::println);  // Diese Datei wird Zeile für Zeile in die Konsole geprintet
        }catch (IOException e){

        }
    }

    //                     IO Streams

    /**
     * Binärfiles sind nicht lesbare Dateien, die für die Verarbeitung von Maschinen gedacht sind
     * z.B. FileInputStream(String filename), FileOutputStream(String filename), FileOutputStream(String filename, boolean append)
     * die methoden sind wie bei den Writer und Reader Klassen
     * ABC für IO Streams sind InputStream un outputStream
     */

    /**
     * Path methoden
     * Letztes Pfadelement       ->  Path getFileName()
     * Pfad des Elterndirectory  ->  Path getParent()
     * Schleifen kürzen	         ->  Path normalize()
     * Absoluter Pfad            ->  Path toAbsolutePath()
     * Pfadelemente verarbeiten	 ->  void forEach(Consumer<Path>)
     */

    static void binaryIOExample(){
        try(FileInputStream fileInputStream =  new FileInputStream(new File("Path"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("Path"))
                ){
            fileInputStream.transferTo(fileOutputStream);
        }catch (IOException e){
            System.out.println("IO Exception caught");
        }
    }
    public static void main(String[] args) {
        IO_Wiki.charArrays(); // Die new File Pathname müssen definiert werden, sonst wir ein IO Exception Fehler Geschmissen
        IO_Wiki.exampleBufferedReader();
        IO_Wiki.binaryIOExample();
    }

}
