package encryption;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class EncryptionGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnGenerate;
	private JLabel lblYouKeyIndex;
	private JTextArea txtText;
	private JTextArea txtEncrypted;
	private JButton btnNewButton;

	public static List<Character> lista;
	public static List<Character> randomLista;
	public static List<List<Character>> indeksi;
	public static char karakter;
	public List<Character> message;
	public static List<Character> pomocna;
	public static List<Character> pomocna1;

	public char[] slova;
	private JTextField txtIndex;
	private JButton btnBack;

	public EncryptionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnGenerate());
		contentPane.add(getLblYouKeyIndex());
		contentPane.add(getTxtText());
		contentPane.add(getTxtEncrypted());
		contentPane.add(getBtnNewButton());
		contentPane.add(getTxtIndex());
		contentPane.add(getBtnBack());

		lista = new ArrayList<Character>();
		randomLista = new ArrayList<Character>();

		indeksi = new ArrayList<List<Character>>(); // pomocna struktura koja nam sluzi da pamtimo random listu i tako
													// omogucava dektripciju iako se generise nova random lista
		karakter = ' ';

		message = new ArrayList<Character>();
		pomocna = new ArrayList<Character>();
		pomocna1 = new ArrayList<Character>();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Generate a new key");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(135, 34, 184, 61);
		}
		return lblNewLabel;
	}

	private JButton getBtnGenerate() {
		if (btnGenerate == null) {
			btnGenerate = new JButton("Generate a key");
			btnGenerate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lista.clear();
					randomLista.clear();
					karakter = ' ';
					txtText.setText(null);
					txtEncrypted.setText(null);

					for (int i = 32; i < 127; i++) { // 32 je space u ascii
						lista.add(Character.valueOf(karakter));
						karakter++;
					}

					pomocna1 = new ArrayList<Character>(lista);

					randomLista = new ArrayList<Character>(lista);
					Collections.shuffle(randomLista);
					pomocna = new ArrayList<Character>(randomLista);
					indeksi.add(pomocna);
					txtIndex.setText(indeksi.indexOf(randomLista) + "");

					/*
					 * System.out.println(); for (Character r : lista) System.out.print(r);
					 * System.out.println(); for (Character r : randomLista) System.out.print(r);
					 * System.out.println(); for (int i = 0; i<indeksi.size(); i++) { for (char x :
					 * indeksi.get(i) ) { System.out.print(x); } System.out.println(); }
					 * System.out.println();
					 */

				}
			});
			btnGenerate.setBounds(145, 86, 147, 42);
		}
		return btnGenerate;
	}

	private JLabel getLblYouKeyIndex() {
		if (lblYouKeyIndex == null) {
			lblYouKeyIndex = new JLabel("You key index is: ");
			lblYouKeyIndex.setForeground(Color.RED);
			lblYouKeyIndex.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			lblYouKeyIndex.setBounds(572, 34, 156, 61);
		}
		return lblYouKeyIndex;
	}

	private JTextArea getTxtText() {
		if (txtText == null) {
			txtText = new JTextArea();
			txtText.setBounds(30, 157, 348, 239);
		}
		return txtText;
	}

	private JTextArea getTxtEncrypted() {
		if (txtEncrypted == null) {
			txtEncrypted = new JTextArea();
			txtEncrypted.setBounds(608, 150, 362, 246);
		}
		return txtEncrypted;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Encrypt");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String indexString = txtIndex.getText();

					String poruka = txtText.getText();

					if (indexString == null)
						JOptionPane.showConfirmDialog(null, "Generate the key first");
					slova = poruka.toCharArray();
					StringBuilder builder = new StringBuilder();

					for (int i = 0; i < slova.length; i++) {
						for (int j = 0; j < lista.size(); j++) {
							if (slova[i] == lista.get(j)) {
								builder.append(randomLista.get(j));

							}

						}
						txtEncrypted.setText(builder.toString());

					}

				}
			});
			btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
			btnNewButton.setForeground(Color.RED);
			btnNewButton.setBounds(408, 238, 164, 61);
		}
		return btnNewButton;
	}

	private JTextField getTxtIndex() {
		if (txtIndex == null) {
			txtIndex = new JTextField();
			txtIndex.setEnabled(false);
			txtIndex.setBounds(731, 53, 55, 26);
			txtIndex.setColumns(10);
		}
		return txtIndex;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EncryptionProgramGUI back = new EncryptionProgramGUI();
					back.setVisible(true);
					dispose();

				}
			});
			btnBack.setBounds(437, 300, 117, 29);
		}
		return btnBack;
	}
}
