package it.fi.itismeucci.barletti;
import java.net.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    Biglietto b1 = new Biglietto(1, "palco 1-a");
    Biglietto b2 = new Biglietto(2, "palco 2-a");
    Biglietto b3 = new Biglietto(3, "tribuna 4-c");
    Biglietto b4 = new Biglietto(4, "parterre 5-f");
    Biglietto b5 = new Biglietto(5, "spalti 7-a");

    ArrayList<Biglietto> list = new ArrayList<>();
        
    XmlMapper xmlMapper = new XmlMapper();

    public Socket attendi()
    {
      try {
          System.out.println("1 Server partito in esecuzione . . .");
          if(server == null){
            server = new ServerSocket(19191);
            list.add(b1);
            list.add(b2);
            list.add(b3);
            list.add(b4);
            list.add(b5);
          }
          
          client = server.accept();
          inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
          outVersoClient = new DataOutputStream(client.getOutputStream());

          Messaggio messaggio = new Messaggio(list);
          String xml = xmlMapper.writeValueAsString(messaggio);
          outVersoClient.writeBytes(xml+'\n');
      } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Errore durante l'istanza del sever !");
          System.exit(1);
      }  
      return client;
    }

    public void comunica()
    {
        try {
            do{
                System.out.println("3 benvenuto client, quale biglietto vuoi acquistare? Attendo . . .");
                stringaRicevuta = inDalClient.readLine();
                System.out.println("6 ricevuta la stampa dal client : " + stringaRicevuta);

                //deserializzazione e rimozione biglietti comprati
                String stringaRicevuta = xmlMapper.readValue(inDalClient.readLine(), String.class);
                for(int i = 0; i < list.size(); i++)
                {
                    if(list.get(i).getIdentificativo() == Integer.parseInt(stringaRicevuta))
                    {
                        list.remove(i);
                    }
                }

                System.out.println("7 Invio la stringa modificata al client . . .");

                
                if(stringaModificata.equals("FINE"))
                    client.close();
            }while(!(stringaModificata.equals("FINE")));
        } catch (Exception e) {
            //TODO: handle exception
        }
        

    }
}