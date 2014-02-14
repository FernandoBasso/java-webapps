package mypkg;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.Scanner;
import java.io.InputStreamReader;

public class TestCli {

    public static void main( String args[] ) {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create( config );
        WebResource service = client.resource( getBaseURI() );

        Scanner scnr = new Scanner(new InputStreamReader(System.in));
        String op = "";
        while (!op.equals("exit")) {
            System.out.print("Digite o comando --> ");
            String str = scnr.nextLine();
            String cmd[] = str.split(",");

            op = cmd[0];
            if ( op.equals("soma") || op.equals("subt") || op.equals("mult") || op.equals("div") ) {
                MultivaluedMap params = new MultivaluedMapImpl();
                params.add("arg1", cmd[1]);
                params.add("arg2", cmd[2]);
                String res = service.path("rest").path("calc").path(String.format("%s", op)).queryParams(params).type(MediaType.TEXT_PLAIN).get(String.class);
                // String res = service.path("rest").path("calc").path("soma").queryParams(params).type(MediaType.TEXT_PLAIN).get(String.class);
                // String res = service.path("rest").path("calc").path("subt").queryParams(params).type(MediaType.TEXT_PLAIN).get(String.class);
                // String res = service.path("rest").path("calc").path("multi").queryParams(params).type(MediaType.TEXT_PLAIN).get(String.class);
                // String res = service.path("rest").path("calc").path("div").queryParams(params).type(MediaType.TEXT_PLAIN).get(String.class);
                System.out.println( res );
            }
            else if (op.equals("exit")) {
                System.out.println("Fechando o cliente.");
            }
            else {
                System.out.println("Operação inválida.");
            }
        }

        // String help;
        // help = service.path("rest").path("calc").path("help").accept(MediaType.TEXT_PLAIN).get(String.class);
        // System.out.println( help );
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/jaxrs").build();
    }
}

