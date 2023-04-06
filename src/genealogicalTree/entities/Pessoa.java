package genealogicalTree.entities;

public class Pessoa {
	private String nome;
	private Pessoa mae;
	
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Pessoa mae) {
		
	}
	
	public void setNome(String nome) {
		this.nome= nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setMae(Pessoa mae) {
		this.mae = mae;
	}
	
	public Pessoa getMae() {
		return this.mae;
	}
	
	public void adicionaAncestral(Pessoa ancestral) {
		Pessoa pessoa = this;
		while(pessoa.getMae() != null) {
			pessoa = pessoa.getMae();
		}
		
		pessoa.setMae(ancestral);
	}

	public void exibiArvoreGenealogica() {
		Pessoa pessoa = this;
		do {
			System.out.println(pessoa);
			pessoa = pessoa.getMae();
		} while(pessoa != null);
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}
	
	
}
