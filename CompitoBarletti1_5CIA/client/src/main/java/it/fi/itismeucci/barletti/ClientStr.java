package it.fi.itismeucci.barletti;
    
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class ClientStr {
    String nomeServer = "localhost";
    int portaServer = 19191;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;
    ArrayList<Biglietto> list = new ArrayList<>();
    Messaggio messaggio = new Messaggio(list);
    XmlMapper xmlMapper = new XmlMapper();

    public Socket connetti()throws JsonMappingException, JsonProcessingException
    {
        System.out.println("2 CLIENT: partito in esecuzione . . .");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(nomeServer, portaServer);
            outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

            String xml = xmlMapper.writeValueAsString(messaggio);
            outVersoServer.writeBytes(xml+'\n');

            Messaggio m = xmlMapper.readValue(inDalServer.readLine(), Messaggio.class);
            System.out.println(m.toString());
        } catch (UnknownHostException e) {
            System.out.println("Host sconosciunto");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connesione !");
            System.exit(1);
        }
        return mioSocket;
    }

   
    //XmlMapper xmlMapper = new XmlMapper();
    //;
    //;

    public void acquista()
    {
        try {
        for(;;){
            System.out.println("4 . . . inserisci l'identificativo del biglietto da acquistare"+'\n');
            stringaUtente = tastiera.readLine();
            System.out.println("5 . . . invio la stringa al server e attendo . . .");
            outVersoServer.writeBytes(stringaUtente+'\n');
            stringaRicevutaDalServer = inDalServer.readLine();

            if(stringaRicevutaDalServer.equals("FINE")){
                mioSocket.close();
                return;
            }
            
            System.out.println("8 . . . risposta dal server"+'\n'+stringaRicevutaDalServer);
            }
        }
        catch(Exception e){}
    }
}

