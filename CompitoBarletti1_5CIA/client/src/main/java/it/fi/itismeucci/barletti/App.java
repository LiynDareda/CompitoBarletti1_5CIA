package it.fi.itismeucci.barletti;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class App 
{
    public static void main( String[] args ) throws JsonMappingException, JsonProcessingException
    {
        ClientStr cliente = new ClientStr();
        cliente.connetti();
    }
}
