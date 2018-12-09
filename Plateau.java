package jeu;

import java.util.Random;

public abstract class Plateau {
	protected boolean estBloquer = true;
	int grandeur = 5;
	protected int[][] tableau = new int[grandeur][grandeur];
	

	public Plateau() {

	}
	
	public void setGrandeur(int x) {
		grandeur = x;
	}

	public int generer2ou4() {
		Random r = new Random();
		int n = r.nextInt(2);
		if (n == 1) {
			n = 2;
		} else if (n == 0) {
			n = 4;
		}
		return n;
	}

	public int multiplication(int valeur) {
		return valeur * 2;
	}

	public int division(int valeur) {
		return valeur / 2;
	}

	public void deplacement(String choix) {
		estBloquer = true;
		int ligne;
		int colonne;
		int c = 0;
		boolean[] changement = { false, false, false, false, false, false };
		switch (choix) {
		case "H":
			while (c < grandeur -1) {
				for (colonne = 0; colonne < grandeur; colonne++) {
					for (ligne = 1; ligne < grandeur; ligne++) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne - 1][colonne] == 0) {
								tableau[ligne - 1][colonne] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne - 1][colonne] && !changement[colonne]) {

								tableau[ligne - 1][colonne] = multiplication(tableau[ligne - 1][colonne]);
								tableau[ligne][colonne] = 0;
								changement[colonne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;

		case "B":

			while (c < grandeur-1) {
				for (colonne = 0; colonne < grandeur; colonne++) {
					for (ligne = grandeur-2; ligne >= 0; ligne--) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne + 1][colonne] == 0) {
								tableau[ligne + 1][colonne] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;
							} else if (tableau[ligne][colonne] == tableau[ligne + 1][colonne] && !changement[colonne]) {
								tableau[ligne + 1][colonne] = multiplication(tableau[ligne + 1][colonne]);
								tableau[ligne][colonne] = 0;
								changement[colonne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		case "G":

			while (c < grandeur-1) {
				for (ligne = 0; ligne < grandeur; ligne++) {
					for (colonne = 1; colonne < grandeur; colonne++) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne][colonne - 1] == 0) {
								tableau[ligne][colonne - 1] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne][colonne - 1] && !changement[ligne]) {
								tableau[ligne][colonne - 1] = multiplication(tableau[ligne][colonne - 1]);
								tableau[ligne][colonne] = 0;
								changement[ligne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		case "D":

			while (c < grandeur-1) {
				for (ligne = 0; ligne < grandeur; ligne++) {
					for (colonne = grandeur-2; colonne >= 0; colonne--) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne][colonne + 1] == 0) {
								tableau[ligne][colonne + 1] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne][colonne + 1] && !changement[ligne]) {
								tableau[ligne][colonne + 1] = multiplication(tableau[ligne][colonne + 1]);
								tableau[ligne][colonne] = 0;
								changement[ligne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		}
	}
}
