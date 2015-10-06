package Network.Servidor;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

public class Servidor {
	
	private static Servidor servidor;
	
	private Server server;
	private ReceptorConexion receptor;
	private Kryo kryo;
	
	private Servidor(int puertoTCP) {
		server=new Server();
		server.start();
		try {
			server.bind(puertoTCP);
			kryo=server.getKryo();
			System.out.println(kryo);
			kryo.register(String.class);
			//System.out.println("Conectado el puerto "+puertoTCP);
			receptor=new ReceptorConexion();
			//System.out.println("Receptor creado");
			server.addListener(receptor);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Servidor getServidor(){
		return servidor;
	}
	
	public static Servidor getServidor(int puerto){
		if(servidor==null){
			servidor=new Servidor(puerto);
		}
		return servidor;
	}

}
