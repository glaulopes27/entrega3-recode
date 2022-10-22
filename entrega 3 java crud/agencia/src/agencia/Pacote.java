package agencia;

public class Pacote {
	
	    private int id_pacote;
	 
	    private String nome_pacote;
	  
	    private double valor_pacote;
	  
	    private Compra compra;
	 
	    public Pacote () {
	    }

		public Pacote(int id_pacote, String nome_pacote, double valor_pacote, agencia.Compra compra) {
			super();
			this.id_pacote = id_pacote;
			this.nome_pacote = nome_pacote;
			this.valor_pacote = valor_pacote;
			this.compra = compra;
		}

		public int getId_pacote() {
			return id_pacote;
		}

		public void setId_pacote(int id_pacote) {
			this.id_pacote = id_pacote;
		}

		public String getNome_pacote() {
			return nome_pacote;
		}

		public void setNome_pacote(String nome_pacote) {
			this.nome_pacote = nome_pacote;
		}

		public double getValor_pacote() {
			return valor_pacote;
		}

		public void setValor_pacote(double valor_pacote) {
			this.valor_pacote = valor_pacote;
		}

		public Compra getCompra() {
			return compra;
		}

		public void setCompra(Compra compra) {
			this.compra = compra;
		}
	    
	    
}
