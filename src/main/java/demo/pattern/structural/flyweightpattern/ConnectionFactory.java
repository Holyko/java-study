package demo.pattern.structural.flyweightpattern;

import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {
	
	private List<Connection> connections;
	
	private int size = 3;
	
	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private void build() {
		List<Connection> connections = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Connection conn = new Connection(i, "a", "b", "c");
			connections.add(conn);
		}
		this.connections = connections;
	}
	
	private ConnectionFactory () {
		this.build();
	}
	
	public static ConnectionFactory instance() {
		return new ConnectionFactory();
	}

}
