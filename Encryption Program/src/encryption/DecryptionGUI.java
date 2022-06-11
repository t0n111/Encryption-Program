package encryption;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DecryptionGUI extends JFrame {
	
	JFrame contentPane;
	private JTextArea txtText;
	private JTextArea txtEncrypted;
	private JLabel lblNewLabel;
	private JTextField txtIndex;
	private JButton btnDecrypted;
	private JButton btnNewButton;
	
	public char[] slova;

	

	/**
	 * Create the frame.
	 */
	public DecryptionGUI() {
		getContentPane().setBackground(new Color(204, 204, 255));
		getContentPane().setLayout(null);
		getContentPane().add(getTxtText());
		getContentPane().add(getTxtEncrypted());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTxtIndex());
		getContentPane().add(getBtnDecrypted());
		getContentPane().add(getBtnNewButton());
		contentPane = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 480);
		contentPane.setBackground(new Color(204, 204, 255));
		
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Enter the key index: ");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(340, 86, 180, 25);
		}
		return lblNewLabel;
	}
	private JTextField getTxtIndex() {
		if (txtIndex == null) {
			txtIndex = new JTextField();
			txtIndex.setBounds(521, 86, 36, 26);
			txtIndex.setColumns(10);
		}
		return txtIndex;
	}
	private JButton getBtnDecrypted() {
		if (btnDecrypted == null) {
			btnDecrypted = new JButton("Decrypted");
			btnDecrypted.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int index = Integer.parseInt(txtIndex.getText());
					if (EncryptionGUI.indeksi == null || index > EncryptionGUI.indeksi.size()) {
						JOptionPane.showConfirmDialog(null, "Wrong index");
						throw new RuntimeException("Wrong index");
						
					}
					String poruka = txtText.getText();
					slova = poruka.toCharArray();
					StringBuilder builder = new StringBuilder(); 
					
					

					for (int i = 0; i < slova.length; i++) {
						for (int j = 0; j < EncryptionGUI.indeksi.get(index).size(); j++) {
							if (slova[i] == EncryptionGUI.indeksi.get(index).get(j)) {
								builder.append(EncryptionGUI.pomocna1.get(j));
								
								
							}

						}
						txtEncrypted.setText(builder.toString());
						
						  
				}
			} });
			btnDecrypted.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
			btnDecrypted.setForeground(Color.RED);
			btnDecrypted.setBounds(407, 215, 164, 49);
		}
		return btnDecrypted;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EncryptionProgramGUI encryptionProgramGUI = new EncryptionProgramGUI();
					encryptionProgramGUI.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setBounds(433, 266, 117, 29);
		}
		return btnNewButton;
	}
}
