package C4.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class JavaGame extends JFrame {

	private JPanel contentPane;
	
	boolean jugando1 = true;
	
	int contadorX=0;
	int contadorO=0;
	
	Player1 player1 = new Player1();
	Player1 player2 = new Player1();
	
	boolean winner = false;
	
	Random rand = new Random();
	
	static JButton BS1 = new JButton ();
	static JButton BS2 = new JButton ();
	static JButton BS3 = new JButton ();
	static JButton BS4 = new JButton ();
	static JButton BS5 = new JButton ();
	static JButton BS6 = new JButton ();
	static JButton BS7 = new JButton ();
	static JButton BS8 = new JButton ();
	static JButton BS9 = new JButton ();
	
	public JavaGame() {

		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		setTitle("Java Game");
		
		setBounds(400,20,597,371);
	
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JButton nueva_partida = new JButton ("Nueva Partida");
		nueva_partida.setBounds(371, 11, 139, 32);
		contentPane.add(nueva_partida);
		
		JLabel estado = new JLabel ();
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setBounds(296, 54, 214, 35);
		contentPane.add(estado);
		
		JLabel J1 = new JLabel ("Jugador 1");
		J1.setHorizontalAlignment(SwingConstants.CENTER);
		J1.setBounds(296, 100, 129, 35);
		contentPane.add(J1);
		
		JLabel J2 = new JLabel ("Jugador 2");
		J2.setHorizontalAlignment(SwingConstants.CENTER);
		J2.setBounds(296, 175, 129, 35);
		contentPane.add(J2);
		
		JLabel N1 = new JLabel ("Nombre:");
		N1.setHorizontalAlignment(SwingConstants.CENTER);
		N1.setBounds(333, 129, 92, 35);
		contentPane.add(N1);
		
		JLabel N2 = new JLabel ("Nombre:");
		N2.setHorizontalAlignment(SwingConstants.CENTER);
		N2.setBounds(333, 221, 92, 35);
		contentPane.add(N2);
		
		JTextField TF1 = new JTextField();
		TF1.setBounds(439, 132, 132, 29);
		contentPane.add(TF1);
		
		JTextField TF2 = new JTextField();
		TF2.setBounds(439, 224, 132, 29);
		contentPane.add(TF2);
		
		JLabel tipo2 = new JLabel ("Tipo:");
		tipo2.setHorizontalAlignment(SwingConstants.CENTER);
		tipo2.setBounds(333, 286, 73, 35);
		contentPane.add(tipo2);
		
		JRadioButton H2 = new JRadioButton("Humano",false);
		H2.setBounds(427, 286, 73, 35);
		contentPane.add(H2);
		
		JRadioButton C2 = new JRadioButton("CPU",true);
		C2.setBounds(498, 285, 73, 40);
		contentPane.add(C2);
		
		ButtonGroup BG2 = new ButtonGroup();
		BG2.add(H2);
		BG2.add(C2);
		
		BS1.setBounds(0, 11, 72, 71);
		BS1.setEnabled(false);
		contentPane.add(BS1);
		
		BS2.setBounds(80, 11, 72, 71);
		BS2.setEnabled(false);
		contentPane.add(BS2);
		
		BS3.setBounds(162, 11, 72, 71);
		BS3.setEnabled(false);
		contentPane.add(BS3);
		
		BS4.setBounds(0, 93, 72, 71);
		BS4.setEnabled(false);
		contentPane.add(BS4);
		
		BS5.setBounds(80, 93, 72, 71);
		BS5.setEnabled(false);
		contentPane.add(BS5);
	
		BS6.setBounds(162, 93, 72, 71);
		BS6.setEnabled(false);
		contentPane.add(BS6);
	
		BS7.setBounds(0, 175, 72, 71);
		BS7.setEnabled(false);
		contentPane.add(BS7);
		
		BS8.setBounds(80, 175, 72, 71);
		BS8.setEnabled(false);
		contentPane.add(BS8);
		
		BS9.setBounds(162, 175, 72, 71);
		BS9.setEnabled(false);
		contentPane.add(BS9);
		
		ActionListener partida_nueva = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre1 = TF1.getText();
				String nombre2 = TF2.getText();
				boolean isCPU1 = false;
				boolean isCPU2 = false;
				winner = false;	
				
					if(H2.isSelected()) {
						isCPU2 = false;
					}else if(C2.isSelected()){
						isCPU2 = true;
					}
		
				if(nombre1.length()==0) {
					JOptionPane.showMessageDialog(null,"Introduce el nombre del jugador 1");
				}else if(nombre2.length()==0) {
					JOptionPane.showMessageDialog(null,"Introduce el nombre del jugador 2");
				}else if(!H2.isSelected()&&!C2.isSelected()){
					JOptionPane.showMessageDialog(null,"Selecciona que es el jugador 2");
				}else {	
				
					player1 = new Player1(nombre1,isCPU1);
					player2 = new Player1(nombre2,isCPU2);
					
					//System.out.println(player2.toString());
					
					estado.setText("");
					
					BS1.setEnabled(true);
					BS2.setEnabled(true);
					BS3.setEnabled(true);
					BS4.setEnabled(true);
					BS5.setEnabled(true);
					BS6.setEnabled(true);
					BS7.setEnabled(true);
					BS8.setEnabled(true);
					BS9.setEnabled(true);
					
					BS1.setText("");
					BS2.setText("");
					BS3.setText("");
					BS4.setText("");
					BS5.setText("");
					BS6.setText("");
					BS7.setText("");
					BS8.setText("");
					BS9.setText("");
					
					jugando1 = true;
					contadorX=0;
					contadorO=0;
					
					/*while(!winner&& !jugando1 && player2.isCPU) {
						clicarCPU();
					}*/
					
				}
				
			}
		};
		
		ActionListener pulsarBoton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton source = (JButton)e.getSource();//Coge el nombre del boton que se ha pulsado
				
				//Booleanos para controlar condiciones
				boolean en_blanco = false;
				boolean X = false;
				boolean O = false;
				
				if(source.getText()=="") {//If para saber si el boton pulsado esta en blanco
					en_blanco=true;
				}
				
				if(source.getText()=="X") {//If para saber el valor del boton
					X=true;
				}else if(source.getText()=="O") {
					O=true;
				}
				
				if(contadorX<3 || contadorO<3) {//Si se cumple la condicion entrara en este primer if que pone valor a un boton vacio dependiendo del jugador que este jugando
					if(BS1 == source && jugando1 && en_blanco) {//Boton 1
						BS1.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS1 == source && !jugando1 && en_blanco) {
							BS1.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS2 == source && jugando1 && en_blanco) {//Boton 2
						BS2.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS2 == source && !jugando1 && en_blanco) {
							BS2.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS3 == source && jugando1 && en_blanco) {//Boton 3
						BS3.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS3 == source && !jugando1 && en_blanco) {
							BS3.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS4 == source && jugando1 && en_blanco) {//Boton 4
						BS4.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS4 == source && !jugando1 && en_blanco) {
							BS4.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS5 == source && jugando1 && en_blanco) {//Boton 5
						BS5.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS5 == source && !jugando1 && en_blanco) {
							BS5.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS6 == source && jugando1 && en_blanco) {//Boton 6
						BS6.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS6 == source && !jugando1 && en_blanco) {
							BS6.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS7 == source && jugando1 && en_blanco) {//Boton 7
						BS7.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS7 == source && !jugando1 && en_blanco) {
							BS7.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS8 == source && jugando1 && en_blanco) {//Boton 8
						BS8.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS8 == source && !jugando1 && en_blanco) {
							BS8.setText("O");
							jugando1=true;
							contadorO++;
					}else if(BS9 == source && jugando1 && en_blanco) {//Boton 9
						BS9.setText("X");
						jugando1=false;
						contadorX++;
						clicarCPU();
					}else if(BS9 == source && !jugando1 && en_blanco) {
							BS9.setText("O");
							jugando1=true;
							contadorO++;
					}
				}else {//Si ya hay tres X o tres O entraria en este else y pondria un boton en blanco
					if(BS1 == source && jugando1 && X) {//Boton 1
						BS1.setText("");
						contadorX--;
					}else if(BS1 == source && !jugando1 && O) {
						BS1.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS2 == source && jugando1 && X) {//Boton 2
						BS2.setText("");
						contadorX--;
					}else if(BS2 == source && !jugando1 && O) {
						BS2.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS3 == source && jugando1 && X) {//Boton 3
						BS3.setText("");
						contadorX--;
					}else if(BS3 == source && !jugando1 && O) {
						BS3.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS4 == source && jugando1 && X) {//Boton 4
						BS4.setText("");
						contadorX--;
					}else if(BS4 == source && !jugando1 && O) {
						BS4.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS5 == source && jugando1 && X) {//Boton 6
						BS5.setText("");
						contadorX--;
					}else if(BS5 == source && !jugando1 && O) {
						BS5.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS6 == source && jugando1 && X) {//Boton 6
						BS6.setText("");
						contadorX--;
					}else if(BS6 == source && !jugando1 && O) {
						BS6.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS7 == source && jugando1 && X) {//Boton 7
						BS7.setText("");
						contadorX--;
					}else if(BS7 == source && !jugando1 && O) {
						BS7.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS8 == source && jugando1 && X) {//Boton 8
						BS8.setText("");
						contadorX--;
					}else if(BS8 == source && !jugando1 && O) {
						BS8.setText("");
						contadorO--;
						clicarCPU();
					}else if(BS9 == source && jugando1 && X) {//Boton 9
						BS9.setText("");
						contadorX--;
					}else if(BS9 == source && !jugando1 && O) {
						BS9.setText("");
						contadorO--;
						clicarCPU();
					}
				}
				
				//Check si hay una combinacion ganadora en el tablero despues del ultimo movimiento
				if (!winner) {
					 if ((BS1.getText().equals("X") || BS1.getText().equals("O")) &&BS1.getText().equals(BS2.getText()) && BS2.getText().equals(BS3.getText())) winner=true;
					    if ((BS4.getText().equals("X") || BS4.getText().equals("O")) &&BS4.getText().equals(BS5.getText()) && BS5.getText().equals(BS6.getText())) winner=true;
					    if ((BS7.getText().equals("X") || BS7.getText().equals("O")) &&BS7.getText().equals(BS8.getText()) && BS8.getText().equals(BS9.getText())) winner=true;
					    //check columns
					    if ((BS1.getText().equals("X") || BS1.getText().equals("O")) &&BS1.getText().equals(BS4.getText()) && BS4.getText().equals(BS7.getText())) winner=true;
					    if ((BS2.getText().equals("X") || BS2.getText().equals("O")) &&BS2.getText().equals(BS5.getText()) && BS5.getText().equals(BS8.getText())) winner=true;
					    if ((BS3.getText().equals("X") || BS3.getText().equals("O")) &&BS3.getText().equals(BS6.getText()) && BS6.getText().equals(BS9.getText())) winner=true;
					    //check diagonal
					    if ((BS1.getText().equals("X") || BS1.getText().equals("O")) &&BS1.getText().equals(BS5.getText()) && BS5.getText().equals(BS9.getText())) winner=true;
					    if ((BS3.getText().equals("X") || BS3.getText().equals("O")) &&BS3.getText().equals(BS5.getText()) && BS5.getText().equals(BS7.getText())) winner=true;
				}
				if (source.getText().equals("X") && winner) {
					estado.setText(player1.nombre+" gana");
				} else if (source.getText().equals("O") && winner) {
					estado.setText(player2.nombre+" gana");
				}
				if (winner) {
					BS1.setEnabled(false);
					BS2.setEnabled(false);
					BS3.setEnabled(false);
					BS4.setEnabled(false);
					BS5.setEnabled(false);
					BS6.setEnabled(false);
					BS7.setEnabled(false);
					BS8.setEnabled(false);
					BS9.setEnabled(false);
				}
				
			}
		};
		
		nueva_partida.addActionListener(partida_nueva);
		BS1.addActionListener(pulsarBoton);
		BS2.addActionListener(pulsarBoton);
		BS3.addActionListener(pulsarBoton);
		BS4.addActionListener(pulsarBoton);
		BS5.addActionListener(pulsarBoton);
		BS6.addActionListener(pulsarBoton);
		BS7.addActionListener(pulsarBoton);
		BS8.addActionListener(pulsarBoton);
		BS9.addActionListener(pulsarBoton);
		

		
	}

	public void clicarCPU() {
		if(player2.isCPU) {
			int r = rand.nextInt((9 - 1) + 1) + 1;
				
			System.out.println("Tirada CPU "+r);
			
				switch(r) {
					case 1:
						if(contadorO<3 && BS1.getText()==""||contadorO==3 && BS1.getText()=="O") {
							BS1.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 2:
						if(contadorO<3 && BS2.getText()==""||contadorO==3 && BS2.getText()=="O") {
							BS2.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 3:
						if(contadorO<3 && BS3.getText()==""||contadorO==3 && BS3.getText()=="O") {
							BS3.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 4:
						if(contadorO<3 && BS4.getText()==""||contadorO==3 && BS4.getText()=="O") {
							BS4.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 5:
						if(contadorO<3 && BS5.getText()==""||contadorO==3 && BS5.getText()=="O") {
							BS5.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 6:
						if(contadorO<3 && BS6.getText()==""||contadorO==3 && BS6.getText()=="O") {
							BS6.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 7:
						if(contadorO<3 && BS7.getText()==""||contadorO==3 && BS7.getText()=="O") {
							BS7.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 8:
						if(contadorO<3 && BS8.getText()==""||contadorO==3 && BS8.getText()=="O") {
							BS8.doClick();
						}else {
							clicarCPU();
						}
					break;
					case 9:
						if(contadorO<3 && BS9.getText()==""||contadorO==3 && BS9.getText()=="O") {
							BS9.doClick();
						}else {
							clicarCPU();
						}
					break;
				}
	
		}
	}
}
