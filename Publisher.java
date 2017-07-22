import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import io.nats.client.Connection;
import io.nats.client.ConnectionFactory;

public class Publisher { 
  
 public String url="nats://localhost:4222";
 
 public ConnectionFactory cf = new ConnectionFactory(url);
 
 
    String subject="alarm";
    String payload="Helloooo";

    String usageString =
            "\nUsage: java OldPublisher [options]"+subject+"Hi message"+"\n\nOptions:\n"
                    + "    -s, --server   <url>            STAN server URL(s)\n";

    Publisher(String[] args) throws IOException, TimeoutException {
     System.out.println("URL===="+url);
     System.out.println("args===="+args);
        parseArgs(args);
        if (subject == null) {
            usage();
        }
    }

    void usage() {
        System.err.println(usageString);
        System.exit(-1);
    }

    void run() throws IOException, TimeoutException {
    
       // ConnectionFactory cf = new ConnectionFactory(url);       
        try (Connection nc = cf.createConnection()) {
            nc.publish(subject, payload.getBytes());
            System.err.printf("Published [%s] : '%s'\n", subject, payload);
        } catch (TimeoutException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
    }

    private void parseArgs(String[] args) {
        if (args == null || args.length < 2) {
            usage();
            return;
        }

        List<String> argList = new ArrayList<String>(Arrays.asList(args));

        // The last arg should be subject and payload
        // get the payload and remove it from args
        payload = argList.remove(argList.size() - 1);

        // get the subject and remove it from args
        subject = argList.remove(argList.size() - 1);;

        // Anything left is flags + args
        Iterator<String> it = argList.iterator();
        while (it.hasNext()) {
            String arg = it.next();
            switch (arg) {
                case "-s":
                case "--server":
                    if (!it.hasNext()) {
                        usage();
                    }
                    it.remove();
                    url = it.next();
                    it.remove();
                    continue;
                default:
                    System.err.printf("Unexpected token: '%s'\n", arg);
                    usage();
                    break;
            }
        }
    }

    /**
     * Publishes a message to a subject.
     * 
     * @param args the subject, message payload, and other arguments
     */
    public static void main(String[] args) {
        try {
         System.out.println("Started=========");
            new Publisher(args).run();
            System.out.println("Ended=========");
        } catch (IOException | TimeoutException e) {       
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        }
       // System.exit(0);
    }

}