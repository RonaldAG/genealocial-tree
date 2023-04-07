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
	
	public void alterarAncestral(String nomeAntigo, String novoNome) {
		Pessoa pessoa = this;
		do {
			if(pessoa.getNome().equals(nomeAntigo)) {
				pessoa.setNome(novoNome);
				break;
			}
			pessoa = pessoa.getMae();
		} while(pessoa != null);
	}
	
	public void deserdaPessoa(String nomePessoa) {
		Pessoa pessoa = this;
		
		//Verify if is the first person that it will be desorded
		if(pessoa.getNome().equals(nomePessoa)) {
			pessoa.setNome(pessoa.getMae().getNome());
			pessoa.setMae(pessoa.getMae().getMae());
		}
		else {
			//Pass through the family three and check if that is a person with the name passed
			do {
				if(pessoa.getMae().getNome().equals(nomePessoa)) {
					pessoa.setMae(pessoa.getMae().getMae());
					break;
				}
				pessoa = pessoa.getMae();
			} while(pessoa != null);
		}
				
	}
	
	public void adotaPessoa(String nomeMae, String nomeAdotado) {
		Pessoa adotado = new Pessoa();
		adotado.setNome(nomeAdotado);
		
		Pessoa pessoa = this;
		
		if(pessoa.getNome().equals(nomeMae)) {
			Pessoa aux = new Pessoa();
			aux.setNome(this.getNome());
			aux.setMae(this.getMae());
			
			this.setNome(adotado.getNome());
			this.setMae(aux);
		}
		else {
			Pessoa pessoaAnterior = new Pessoa();
			do {
				if(pessoa.getNome().equals(nomeMae)) {
					pessoaAnterior.setMae(adotado);
					adotado.setMae(pessoa);
				}
				
				pessoaAnterior = pessoa;
				pessoa = pessoa.getMae();
			} while(pessoa != null);
				
		}
		
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}
	
	
}
