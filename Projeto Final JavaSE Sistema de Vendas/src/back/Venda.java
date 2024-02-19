package back;

public class Venda {

	// atributos

	private Cliente cliente; // venda relacionada à um cliente específico cadastrado anteriormente
	private Produtos produto; // venda relacionada aos produtos específicos registrados
	private Funcionario funcionarioResp; // venda feita por um funcionário já registrado
	private String statusVenda;
	private double desconto;
	private double valorTotal;
	private int numeroFatura;
	private String formaPagamento;

	// construtores

	public Venda() {
		super();
	}

	public Venda(Cliente cliente, Produtos produto, Funcionario funcionarioResp, String statusVenda, double desconto,
			double valorTotal, int numeroFatura, String formaPagamento) {
		super();
		this.cliente = cliente;
		this.produto = produto;
		this.funcionarioResp = funcionarioResp;
		this.statusVenda = statusVenda;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
		this.numeroFatura = numeroFatura;
		this.formaPagamento = formaPagamento;
	}

	// CONSTRUTOR PARA FINALIZAR VENDA

	public Venda(Cliente cliente2, Produtos itens) {
		// TODO Auto-generated constructor stub
	}

	// getters e setters

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public Funcionario getFuncionarioResp() {
		return funcionarioResp;
	}

	public void setFuncionarioResp(Funcionario funcionarioResp) {
		this.funcionarioResp = funcionarioResp;
	}

	public String getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(String statusVenda) {
		this.statusVenda = statusVenda;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(int numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	// metodos

	// fazer um construtor para pegar info do carrinho e add na classe venda com +
	// infos

}
