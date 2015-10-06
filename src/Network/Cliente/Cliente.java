package Network.Cliente;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

public class Cliente extends Client{

public static int TIMEOUT=5000;
	
	private String nombre;
	private Kryo kryo;
	
	public void conectar(int puerto, String ip){
		this.start();
		try {
			this.connect(TIMEOUT, ip, puerto);
			kryo= this.getKryo();
			kryo.register(String.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}

