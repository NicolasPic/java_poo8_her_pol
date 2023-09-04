package entidades;

public class ProdutoImportado extends Produto{

	private Double taxaCustom;

	public ProdutoImportado() {
		super();
	}
	
	public ProdutoImportado(String nome, Double preco, Double taxaCustom) {
		super(nome, preco);
		this.taxaCustom = taxaCustom;
	}

	public Double getTaxaCustom() {
		return taxaCustom;
	}

	public void setTaxaCustom(Double taxaCustom) {
		this.taxaCustom = taxaCustom;
	}
	
	@Override
	public String tagPreco() {
		return super.tagPreco() + "(Taxa customizada: $ " + taxaCustom + ")";
	}
	
}
