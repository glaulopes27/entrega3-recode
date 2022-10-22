package agencia;

import java.util.Set;
import java.sql.Date;
import java.util.HashSet;

@SuppressWarnings("unused")
public class Compra {

	private int id_compra;

	private int id_cliente;

	private int id_pacote;

	private Date data_compra;

	private Cliente cliente;

	private Set<Pacote> pacote;

	public Compra() {
	}

	public Compra(int id_compra, int id_cliente, int id_pacote, Date data_compra, agencia.Cliente cliente,
			Set<agencia.Pacote> pacote) {
		super();
		this.id_compra = id_compra;
		this.id_cliente = id_cliente;
		this.id_pacote = id_pacote;
		this.data_compra = data_compra;
		this.cliente = cliente;
		this.pacote = pacote;
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}

	public Date getData_compra() {
		return data_compra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Pacote> getPacote() {
		return pacote;
	}

	public void setPacote(Set<Pacote> pacote) {
		this.pacote = pacote;
	}

	public void setData_compra(Date date) {
		// TODO Stub de método gerado automaticamente
		
	}

	public static void add(Compra compras) {
		// TODO Stub de método gerado automaticamente
		
	}

}
