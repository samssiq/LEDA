package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new BidirectionalBubbleSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTest2(Integer[] array, int leftIndex, int rightIndex) {
		if(!((array.length <= 1) || (leftIndex > rightIndex) || (rightIndex >= array.length) || (leftIndex < 0))){
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
	
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy1, array);
		} 
		else {
			implementation.sort(array, leftIndex, rightIndex);
			Assert.assertArrayEquals(array, array);
		}
	}
}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	//Testando o caso de um array ser vazio e a tentativa de ordenar uma parte de seus elementos.
	public void testSort06(){
		genericTest2(vetorVazio, 0, 7);
	}

	@Test
	//Testando a tentativa de ordenação a partir do meio do array até o final, início até o final e posições aleatórias.
	public void testSort07(){
		genericTest2(vetorTamPar, vetorTamPar.length/2, vetorTamPar.length - 1);
		genericTest2(vetorTamPar, 0 , vetorTamPar.length - 1);
		genericTest2(vetorTamPar, 2, 5);
	}

	@Test
	//Testando a tentativa de ordenação a partir do meio do array até o final, início até o final e posições aleatórias.
	public void testSort08(){
		genericTest2(vetorTamImpar, vetorTamImpar.length/2, vetorTamImpar.length - 1);
		genericTest2(vetorTamImpar, 0 , vetorTamImpar.length - 1);
		genericTest2(vetorTamImpar, 2, 5);
	}
	@Test
	//Testando a tentativa de ordenação analisando o caso de valores iguais.
	 public void testSort09(){
		genericTest2(vetorValoresIguais, vetorValoresIguais.length/2, vetorValoresIguais.length - 1);
		genericTest2(vetorValoresIguais, 0 , vetorTamImpar.length - 1);
		genericTest2(vetorValoresIguais, 2, 5);
		genericTest2(vetorValoresIguais, 2, 2);
	 }

	@Test
	//Testando a tentativa de ordenação analisando o caso de valores repetidos
	 public void testSort10(){
		genericTest2(vetorValoresRepetidos, vetorValoresRepetidos.length/2, vetorValoresRepetidos.length - 1);
		genericTest2(vetorValoresRepetidos, 0 , vetorValoresRepetidos.length - 1);
		genericTest2(vetorValoresRepetidos, 2, 5);
		genericTest2(vetorValoresRepetidos, 3, 3);
	 }



	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}