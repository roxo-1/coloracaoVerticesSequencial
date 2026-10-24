package GrafoMatriz;


import java.io.IOException;

public class TesteGrafoMatriz {
	public static void main(String args[]) throws IOException {
		TGrafoND g = new TGrafoND(5);
		g.insereAND(1 , 2);
		g.insereAND(1,5);
		g.insereAND(2,3);
		g.insereAND(2,4);
		g.insereAND(3,4);
		g.insereAND(4,5);
		g.showND();
		g.coloracaoSequencial();



		TGrafoND g2 = new TGrafoND(9);
		g2.insereAND(1, 6); // A-F
		g2.insereAND(1, 7); // A-G
		g2.insereAND(1, 9); // A-I
		g2.insereAND(2, 3); // B-C
		g2.insereAND(2, 8); // B-H
		g2.insereAND(3, 5); // C-E
		g2.insereAND(3, 8); // C-H
		g2.insereAND(4, 5); // D-E
		g2.insereAND(4, 6); // D-F
		g2.insereAND(4, 8); // D-H
		g2.insereAND(5, 7); // E-G
		g2.insereAND(6, 7); // F-G
		g2.insereAND(6, 9); // F-I
		g2.insereAND(7, 8); // G-H
		g2.insereAND(7, 9); // G-I
		g2.showND();
		g2.coloracaoSequencial();
	}	
}