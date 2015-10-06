package Network.Servidor;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import Network.Cliente.Cliente;

public class ReceptorConexion extends Listener{
	@Override
	public void received(Connection connection, Object object) {
		System.out.println(object.getClass().toString());
	}

}
