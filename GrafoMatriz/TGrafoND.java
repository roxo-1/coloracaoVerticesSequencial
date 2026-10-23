package GrafoMatriz;
/*
Carolina Lee - 10440304
Pedro Casas Pequeno Junior - 10437031
Pedro Gabriel Guimarães Fernandes - 10437465
*/
public class TGrafoND {
	// Atributos Privados
	private	int n; // quantidade de vértices
	private	int m; // quantidade de arestas
	private	int adj[][]; //matriz de adjacência
	// Métodos Públicos
	public TGrafoND( int n) {  // construtor
	    this.n = n;
	    // No início dos tempos não há arestas
	    this.m = 0; 
	    // alocação da matriz do TGrafo
	    this.adj = new int [n][n];

	    // Inicia a matriz com zeros
		for(int i = 0; i< n; i++)
			for(int j = 0; j< n; j++)
				this.adj[i][j]=0;	
	}

	// Insere uma aresta no Grafo Não Dirigido tal que
	// v é adjacente a w
	public void insereAND(int v, int w) {
	    // testa se nao temos a aresta
	    if(adj[v][w] == 0 ){
	        adj[v][w] = 1;
			adj[w][v] = 1;
	        m++; // atualiza qtd arestas
	    }
	}
	
	// remove uma aresta v->w do Grafo Não Dirigido
	public void removeAND(int v, int w) {
	    // testa se temos a aresta
	    if(adj[v][w] == 1 ){
	        adj[v][w] = 0;
			adj[w][v] = 0;
	        m--; // atualiza qtd arestas
	    }
	}
	public void removeVND(int v) {
		if (v < 0 || v >= n) {
			System.out.println("Vértice inválido!");
			return;
		}

		int novoN = n - 1;
		int[][] novaAdj = new int[novoN][novoN];
		int novoM = 0;

		int novaLinha = 0;
		for (int i = 0; i < n; i++) {
			if (i == v) continue;
			int novaColuna = 0;
			for (int j = 0; j < n; j++) {
				if (j == v) continue;
				novaAdj[novaLinha][novaColuna] = adj[i][j];
				novaColuna++;
			}
			novaLinha++;
		}

		// recontar arestas: como o grafo é simétrico,
		// conto só a "metade de cima" da matriz para não contar cada aresta 2x
		for (int i = 0; i < novoN; i++) {
			for (int j = i + 1; j < novoN; j++) {
				if (novaAdj[i][j] == 1) {
					novoM++;
				}
			}
		}

		this.adj = novaAdj;
		this.n = novoN;
		this.m = novoM;

		System.out.println("Vértice " + v + " removido com sucesso.");
	}

    	//calcula e retorna o grau de entrada de um vértice v de um grafo dirigido
	public int inDegreeND(int v){
		int degree = 0;
		for(int i = 0; i < n; i++){
			if(adj[i][v] == 1){
				degree++;
			}
		}
		System.out.println("\nGrau de entrada é "+degree);
		return degree;
	}

	public int outDegreeND(int v){
		int degree = 0;
		for(int i = 0; i < n; i++){
			if(adj[v][i] == 1){
				degree++;
			}
		}
		System.out.println("\nGrau de saída é "+degree);
		return degree;
	}

	public int degreeND(int v){
		int entrada = inDegreeND(v);
		int saida = outDegreeND(v);
		int degree = (entrada + saida)/2;
		System.out.println("\nGrau de total é "+degree);
		return degree;
	}

	public void showND() {
	    System.out.println("n: " + n );
	    System.out.println("m: " + m );
	    for( int i=0; i < n; i++){
	    	System.out.print("\n");
	        for( int w=0; w < n; w++)
	            if(adj[i][w] == 1)
	            	System.out.print("Adj[" + i + "," + w + "]= 1" + " ");
	            else System.out.print("Adj[" + i + "," + w + "]= 0" + " ");
	    }
	    System.out.println("\nEnfim da impressao do grafo." );
	}

	/*
	Algoritmo de coloracao sequencial
	Início <dados: Grafo G = (V, E) >
		// Inicialização do vetor de classes de cores Ci com nenhum vértice e indicador da classe atual de cor k = 1
		Ci ← vazio (i = 1, ..., n) ; k ← 1;
		para i ← 1 até n faça // para todos os n vértices vi ϵ V do grafo G
			LOOP:
				se N (i) intersecção Ck = vazio então // Se algum vértice da classe atual k não fizer parte dos vizinhos de vi
					Ck ← Ck uniao { i } // O vértice vi pode ser pintado com a mesma cor da classe k
				senão
					k++; goto LOOP; // Caso contrário, vai investigar se vi pertence a próxima classe k++
				fim-se
				k ← 1; // Volta para a classe de cor inicial (k = 1) para investigar a qual classe pertence o próximo vértice vi
		fim-para
	Fim.
	*/
	public void coloracaoSequencial(){
		
	}
}
