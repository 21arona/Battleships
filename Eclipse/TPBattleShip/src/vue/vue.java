package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class vue implements ActionListener {
	JFrame fenetre;

	int cptPortAvion;
	int cptDestroyer;
	int cptSousMarin;
	int cptPatrouille;
	int cptPortAvionIA;
	int cptDestroyerIA;
	int cptSousMarinIA;
	int cptPatrouilleIA;
	int cptLigne;
	int nbCaseBateauIA;
	int cptTabDejaFais;

	JButton replay;
	JButton quitter;
	JButton[] jbTab1;
	JButton[] jbTab2;
	int[] iAButtonDejaFais;
	JLabel jLabelInfoEnnemi;

	String portAvion;
	String destroyer;
	String sousMarin;
	String patrouille;
	JTextArea jTextArea;

	private JButton setting;

	 int nbCaseBateauJoueur;

	public void setjLabelInfoEnnemi(JLabel jLabelInfoEnnemi) {
		this.jLabelInfoEnnemi = jLabelInfoEnnemi;
	}

	public vue() {
		this.jbTab1 = new JButton[100];
		this.jbTab2 = new JButton[100];
		this.iAButtonDejaFais = new int[100];

	}

	public void placerJoueur(int horizontal, int indice, int i, int emplacementOn, Color color) {

		String emplacementOn2 = String.valueOf(emplacementOn);
		if (horizontal == 0) {
			if (indice > 96) {
				this.jbTab1[indice - i].setBackground(color);
				this.jbTab1[indice - i].setName(emplacementOn2);
			} else {
				this.jbTab1[indice + i].setBackground(color);
				this.jbTab1[indice + i].setName(emplacementOn2);
			}
		} else {
			if (indice > 69) {
				this.jbTab1[indice - (i * 10)].setBackground(color);
				this.jbTab1[indice - (i * 10)].setName(emplacementOn2);
			} else {
				this.jbTab1[indice + (i * 10)].setBackground(color);
				this.jbTab1[indice + (i * 10)].setName(emplacementOn2);
			}
		}

	}

	public void placerIA(int horizontal, int indice, int i, int emplacementOn, Color color) {

		String emplacementOn2 = String.valueOf(emplacementOn);
		if (horizontal == 0) {
			if (indice > 96) {
				this.jbTab2[indice - i].setBackground(color);
				this.jbTab2[indice - i].setName(emplacementOn2);
			} else {
				this.jbTab2[indice + i].setBackground(color);
				this.jbTab2[indice + i].setName(emplacementOn2);
			}
		} else {
			if (indice > 69) {
				this.jbTab2[indice - (i * 10)].setBackground(color);
				this.jbTab2[indice - (i * 10)].setName(emplacementOn2);
			} else {
				this.jbTab2[indice + (i * 10)].setBackground(color);
				this.jbTab2[indice + (i * 10)].setName(emplacementOn2);

			}
		}

	}

	public void placer() {
		// PlacerJoueur
		int indice = (int) (Math.random() * 25);
		int horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 3; i++) {
			this.placerJoueur(horizontal, indice, i, -1, Color.black);
		}
		indice = (int) (Math.random() * 25) + 25;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 3; i++) {
			this.placerJoueur(horizontal, indice, i, -2, Color.yellow.darker());
		}
		indice = (int) (Math.random() * 25) + 50;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 2; i++) {
			this.placerJoueur(horizontal, indice, i, -3, Color.magenta.darker());
		}

		indice = (int) (Math.random() * 25) + 75;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 4; i++) {
			this.placerJoueur(horizontal, indice, i, -4, Color.green.darker());
		}
		this.nbCaseBateauJoueur = this.compterNbCaseBateauJoueur();

		// PlacerIA
		indice = (int) (Math.random() * 25);
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 3; i++) {
			this.placerIA(horizontal, indice, i, -1, null);
		}
		indice = (int) (Math.random() * 25) + 25;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 3; i++) {
			this.placerIA(horizontal, indice, i, -2, null);
		}
		indice = (int) (Math.random() * 25) + 50;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 2; i++) {
			this.placerIA(horizontal, indice, i, -3, null);
		}

		indice = (int) (Math.random() * 25) + 74;
		horizontal = (int) (Math.random() * 2);
		for (int i = 0; i < 4; i++) {
			this.placerIA(horizontal, indice, i, -4, null);
		}
		this.nbCaseBateauIA = this.compterNbCaseBateauIA();
	}

	public void reset() {
		this.cptDestroyer = 0;
		this.cptPatrouille = 0;
		this.cptSousMarin = 0;
		this.cptPortAvion = 0;
		this.cptDestroyerIA = 0;
		this.cptPatrouilleIA = 0;
		this.cptSousMarinIA = 0;
		this.cptPortAvionIA = 0;

		for (int i = 0; i < jbTab1.length; i++) {
			jbTab1[i].setName("" + i);
			jbTab1[i].setBackground(null);
			jbTab2[i].setName("" + i);
			jbTab2[i].setBackground(null);
		}
		this.placer();
		
		
	}

	public void grille() {

		this.fenetre.getContentPane().setBackground(new Color(600));

		String url = "titless.png";
		ImageIcon icone = new ImageIcon(url);
		this.fenetre.add(new JLabel(icone), BorderLayout.CENTER);

		JLabel pnl3 = new JLabel();
		pnl3.setLayout(new GridLayout(4, 5));

		JLabel labell = new JLabel("MENU", SwingConstants.CENTER);
		labell.setForeground(Color.WHITE);
		pnl3.add(labell);

		Icon icon = new ImageIcon("restart.png");
		this.replay = new JButton(icon);
		this.replay.setName("reset");
		this.replay.addActionListener(this);
		pnl3.add(this.replay, BorderLayout.WEST);

		Icon icon2 = new ImageIcon("setting.png");
		this.setting = new JButton(icon2);
		pnl3.add(this.setting, BorderLayout.NORTH);
		this.setting.setName("setting");
		this.setting.addActionListener(this);

		Icon icon3 = new ImageIcon("quitter.png");
		this.quitter = new JButton(icon3);
		this.quitter.setName("quitter");
		this.quitter.addActionListener(this);
		pnl3.add(this.quitter, BorderLayout.EAST);

		this.fenetre.add(pnl3);

		JPanel panelA = new JPanel();
		panelA.setBackground(Color.pink);
		panelA.add(new JLabel("COMMENT JOUER ?", SwingConstants.CENTER));
		panelA.add(new JLabel(""));
		panelA.add(new JLabel(" "));
		panelA.add(new JLabel("Le but du jeu est de couler tous les engins de l'adversaire.					"));
		panelA.add(new JLabel("Pour cela, chacun votre tour, vous devez essayer"));
		panelA.add(new JLabel("	de « tirer » sur ses navires en devinant leurs positions.				"));
		panelA.add(new JLabel("	Pour tirer, il suffit cliquer dans la zone adverse "));
		panelA.add(new JLabel("	puis voir le resultat si tu l'as eu ou pas			"));
		panelA.add(new JLabel("Si le bateau de votre opposant se trouve à cette position"));
		panelA.add(new JLabel("alors il est touché et vous pouvez rejouer.		"));
		panelA.add(new JLabel("	Pour couler le navire, il faut le toucher entièrement.			"));
		panelA.add(new JLabel("C’est-à-dire qu’un bateau prenant 5 cases "));
		panelA.add(new JLabel(" doit être atteint en ses 5 cases pour être coulé."));
		panelA.add(new JLabel("Le premier à faire detruire tous les ships de l’autre a gagné."));
		panelA.setForeground(Color.ORANGE);
		panelA.add(new JLabel(""));

		this.fenetre.add(panelA);

		JPanel pnl = new JPanel();
		pnl.setPreferredSize(new Dimension(450, 450));
		pnl.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < this.jbTab1.length; i++) {
			JButton jb = new JButton();
			jb.setName(String.valueOf(i));
			pnl.add(this.jbTab1[i] = jb);

		}
		this.fenetre.add(pnl);

		JPanel pnl2 = new JPanel();
		pnl2.setPreferredSize(new Dimension(450, 450));
		pnl2.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < this.jbTab2.length; i++) {
			JButton jb2 = new JButton();
			jb2.setName(String.valueOf(i));
			jb2.addActionListener(this);
			pnl2.add(this.jbTab2[i] = jb2);

		}

		JPanel panel = (new JPanel());
		panel.add(new JButton("☠️☠️☠️☠️‍☠️_[BIENVENUE DANS BATTLESHIP]_☠️☠️☠️☠️‍☠️"));

		panel.add(new JLabel("HISTORIQUE DE COMBAT"));
		panel.add(new JLabel(
				"🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️🧑‍✈️"));

		this.jTextArea = new JTextArea(16, 40);
		this.jTextArea.setText("Info :");
		panel.add(this.jTextArea);

		this.fenetre.add(panel);
		this.fenetre.add(pnl2);

		this.fenetre.setVisible(true);

	}

	public void demarrer() {
		this.fenetre = new JFrame("BattleShip");
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setSize(400, 350);
		this.fenetre.setLocation(0, 0);

		this.fenetre.setLayout(new GridLayout(2, 2));

		this.fenetre.setVisible(true);
	}

	public void ButtonImage() {
		Icon icon = new ImageIcon("battleships.png");
		JButton btn = new JButton(icon);
		btn.setBounds(40, 80, 200, 50);
	}

	public void Tutoriel() {

		System.out.println(
				"					Le but du jeu est de couler tous les bateaux de l'adversaire.					");
		System.out.println(
				"				Pour cela, chacun votre tour, vous devez essayer de « tirer » sur ses navires en devinant leurs positions.				");
		System.out.println(
				"			Pour tirer, il suffit cliquer dans la zone adverse puis voir le resultat si tu l'as eu ou pas			");
		System.out.println(
				"		Si le bateau de votre opposant se trouve à cette position alors il est touché et vous pouvez rejouer.		");
		System.out.println("	Pour couler le navire, il faut le toucher entièrement.			");
		System.out.println(
				"C’est-à-dire qu’un bateau prenant 5 cases doit être atteint en ses 5 cases pour être coulé. Le premier à faire detruire tous les ships de l’autre a gagné.");
	}

	public static void main(String[] args) {
		vue jeu = new vue();
		jeu.demarrer();
		jeu.grille();
		jeu.placer();
		System.out.println();

	}

	public JButton verifictionButton() {
		int random = (int) (Math.random() * 100);
		

		int i = 0;
		boolean egaliter = true;
		do {

			if (random == this.iAButtonDejaFais[i]) {
				random = (int) (Math.random() * 100);
				i=0;
				System.out.println("1");
			}
			else if (random != this.iAButtonDejaFais[i] && i < this.cptTabDejaFais) {
				i++;
				System.out.println("2");

			}
			else if (random != this.iAButtonDejaFais[i] && i == this.cptTabDejaFais) {
				egaliter = false;
				System.out.println("3");
			}

		} while (egaliter);

		JButton IAButton = this.jbTab1[random];
		this.iAButtonDejaFais[this.cptTabDejaFais] = random;
		this.cptTabDejaFais++;

		return IAButton;
	}

	public void IAAttack() {

		JButton IAButton = this.verifictionButton();
		if (Integer.valueOf(IAButton.getName()) == -1 || Integer.valueOf(IAButton.getName()) == -2
				|| Integer.valueOf(IAButton.getName()) == -3 || Integer.valueOf(IAButton.getName()) == -4) {
			IAButton.setBackground(Color.red);
			if (Integer.valueOf(IAButton.getName()) == -1) {
				this.destroyer = "Destroyer";
				String InfoEnnemi = "HA NON!!!!!L'ennemi a toucher votre " + this.destroyer;
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptDestroyerIA++;
			} else if (Integer.valueOf(IAButton.getName()) == -2) {
				this.sousMarin = "Sous-Marin";
				String InfoEnnemi = "HA NON!!!!!L'ennemi a toucher votre " + this.sousMarin;
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptSousMarinIA++;
			} else if (Integer.valueOf(IAButton.getName()) == -3) {
				this.patrouille = "Patrouille";
				String InfoEnnemi = "HA NON!!!!!L'ennemi a toucher votre " + this.patrouille;
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptPatrouilleIA++;
			} else if (Integer.valueOf(IAButton.getName()) == -4) {
				this.portAvion = "Port-Avion";
				String InfoEnnemi = "HA NON!!!!!L'ennemi a toucher votre" + this.portAvion;
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptPortAvionIA++;
			}

		} else if (Integer.valueOf(IAButton.getName()) != -1 && Integer.valueOf(IAButton.getName()) != -2
				&& Integer.valueOf(IAButton.getName()) != -3 && Integer.valueOf(IAButton.getName()) != -4) {
			IAButton.setBackground(Color.blue);
		}
		this.perdu();
		
	}

	public void menuSetting() {

		JFrame maNewFrame = new JFrame();
		maNewFrame.getContentPane().setBackground(new Color(600));
		maNewFrame.setLayout(new GridLayout(5, 1));
		maNewFrame.setBounds(0, 0, 400, 350);
		;
		JLabel label = new JLabel("SETTINGS", SwingConstants.CENTER);
		label.setForeground(Color.WHITE);

		maNewFrame.add(label);

		JLabel label1 = new JLabel(
				"Informations ennemis : Porte Avion [1]         ,Destroyer [1]         ,Sous marin [1]         ,Patrouille [1]          ",
				SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		maNewFrame.add(new JLabel());
		maNewFrame.add(label1);

		JLabel label2 = new JLabel("DETRUISEZ LES ", SwingConstants.CENTER);
	}

	public int compterNbCaseBateauIA() {
		int valeur = 0;
		for (int i = 0; i < jbTab2.length; i++) {
			if (Integer.valueOf(jbTab2[i].getName()) < 0) {
				valeur++;
			}
		}
		return valeur;
	}
	
	public int compterNbCaseBateauJoueur() {
		int valeur = 0;
		for (int i = 0; i < jbTab1.length; i++) {
			if (Integer.valueOf(jbTab1[i].getName()) < 0) {
				valeur++;
			}
		}
		return valeur;
	}

	public void gagner() {
		if (this.nbCaseBateauIA == (this.cptDestroyer + this.cptPatrouille + this.cptPortAvion + this.cptSousMarin)) {
			this.jTextArea.setText("************BRAVO !!! VOUS AVEZ GAGNÉ!!!**************");
		}

	}
	public void perdu() {
		if (this.nbCaseBateauJoueur == (this.cptDestroyerIA + this.cptPatrouilleIA + this.cptPortAvionIA + this.cptSousMarinIA)) {
			this.jTextArea.setText("************HAAAA !!! PAS DE CHANCE VOUS AVEZ PERDU!!! **************");
		}

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.cptLigne > 15) {
			this.jTextArea.setText("Info :");
			this.cptLigne = 0;
		}
		JButton btn = (JButton) e.getSource();

		String action = btn.getName();
		String attack = btn.getName();
		if (action == "reset") {
			this.reset();
		} else if (action == "quitter") {
			System.exit(0);
		} else if (action == "setting") {
			this.menuSetting();

		} else if (Integer.valueOf(attack) == -1 || Integer.valueOf(attack) == -2 || Integer.valueOf(attack) == -3
				|| Integer.valueOf(attack) == -4) {
			btn.setBackground(Color.RED);
			if (Integer.valueOf(attack) == -1) {
				this.destroyer = "Destroyer";
				String InfoEnnemi = "YEAH!!!!!Vous avez toucher le " + this.destroyer + " de l'ennemi";
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptDestroyer++;
			} else if (Integer.valueOf(attack) == -2) {
				this.sousMarin = "Sous-Marin";
				String InfoEnnemi = "YEAH!!!!!Vous avez toucher le " + this.sousMarin + " de l'ennemi";
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptSousMarin++;
			} else if (Integer.valueOf(attack) == -3) {
				this.patrouille = "Patrouille";
				String InfoEnnemi = "YEAH!!!!!Vous avez toucher la " + this.patrouille + " de l'ennemi";
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptPatrouille++;
			} else if (Integer.valueOf(attack) == -4) {
				this.portAvion = "Port-Avion";
				String InfoEnnemi = "YEAH!!!!!Vous avez toucher le " + this.portAvion + " de l'ennemi";
				this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
				this.cptLigne++;
				this.cptPortAvion++;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.gagner();
			this.IAAttack();

		} else if (Integer.valueOf(attack) != -1 || Integer.valueOf(attack) != -2 || Integer.valueOf(attack) != -3
				|| Integer.valueOf(attack) != -4) {
			this.jbTab2[Integer.valueOf(attack)].setBackground(Color.blue);

			String InfoEnnemi = "Booo!! Pas de chance recommence !! ;) ";
			this.jTextArea.setText(this.jTextArea.getText() + "\n" + InfoEnnemi);
			this.cptLigne++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.IAAttack();
		}

	}

}
