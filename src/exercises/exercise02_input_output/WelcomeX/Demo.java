package exercises.exercise02_input_output.WelcomeX;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        /***
         * Welcome Mr/Mrs X, we successfuly intercepted R. Schiedermeiers HTTP Requests,
         * however since he uses TLS they are Encrypted!
         *
         * We want to know what his Search History entails. Please Help us with this crucial task.
         *
         *
         * Task 1)
         * Create the MrXReader, that extends a FilterReader-
         * Define the read() function to decrypt each SchiederEncrypted Char.
         * IMPORTANT: SchiederEncryption shifts every CHARACTER to the LEFT by 10
         *
         *
         *
         * Sadly our Intern mixed intercepted packets with packets from Mr.Ruckerts Emails,
         * specifically every THIRD Packet should be removed.
         *
         * Task 2)
         *
         * Create a PrintWriter, that Skips every THIRD data Packet (input to writer), and
         * writes the Rest to the Console
         *
         *
         * Success Criteria: You should see a functional Link printed on your console!
         *
         *
         */


        //<<UNCOMMENT THIS DEMO TO TEST YOUR CODE>>
//         try(Reader baseReader = new FileReader("<<YourAbsolutePathTo/RSPacketsEncrypted.txt>>");
//             MrXReader myReader = new MrXReader(baseReader);
//             PrintWriter myPrinter = new PrintWriter(System.out);
//             PrintWriter myFileWriter = new MrXWriter(myPrinter)
//             ) {
//
//             int line = myReader.read();
//
//             while (line > 10) {
//
//                 myFileWriter.print((char) line);
//
//                 line = myReader.read();
//
//                 ;
//             }
//
//         }



    }
}
