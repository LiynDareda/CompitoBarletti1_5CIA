package it.fi.itismeucci.barletti;


public class App 
{
    public static void main( String[] args )
    {
        

        

        ServerStr servente = new ServerStr();
        while(true){
            servente.attendi();
            servente.comunica();
            }
    }
}
