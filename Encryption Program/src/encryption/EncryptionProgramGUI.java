package encryption;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EncryptionProgramGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblDecryptionProgram;
	private JButton btnQuit;
	private JButton btnDecryption;
	private JButton btnEncryption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionProgramGUI frame = new EncryptionProgramGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EncryptionProgramGUI() {
		setBackground(new Color(102, 204, 204));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblDecryptionProgram());
		contentPane.add(getBtnQuit());
		contentPane.add(getBtnDecryption());
		contentPane.add(getBtnEncryption());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Fast and easy encryption and ");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(259, 44, 570, 119);
		}
		return lblNewLabel;
	}
	private JLabel getLblDecryptionProgram() {
		if (lblDecryptionProgram == null) {
			lblDecryptionProgram = new JLabel("decryption program");
			lblDecryptionProgram.setForeground(Color.RED);
			lblDecryptionProgram.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblDecryptionProgram.setBounds(301, 127, 528, 58);
		}
		return lblDecryptionProgram;
	}
	
	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton("Quit");
			btnQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnQuit.setForeground(Color.RED);
			btnQuit.setFont(new Font("Times New Roman", Font.BOLD, 17));
			btnQuit.setBounds(609, 275, 197, 67);
		}
		return btnQuit;
	}
	private JButton getBtnDecryption() {
		if (btnDecryption == null) {
			btnDecryption = new JButton("Decryption");
			btnDecryption.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecryptionGUI dec = new DecryptionGUI();
					dec.setVisible(true);
					dispose();
				}
			});
			btnDecryption.setFont(new Font("Times New Roman", Font.BOLD, 17));
			btnDecryption.setForeground(Color.RED);
			btnDecryption.setBounds(353, 276, 197, 67);
		}
		return btnDecryption;
	}
	private JButton getBtnEncryption() {
		if (btnEncryption == null) {
			btnEncryption = new JButton("Encryption");
			btnEncryption.setBackground(Color.WHITE);
			btnEncryption.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EncryptionGUI en = new EncryptionGUI();
					en.setVisible(true);
					dispose();
					
				}
			});
			btnEncryption.setForeground(Color.RED);
			btnEncryption.setFont(new Font("Times New Roman", Font.BOLD, 17));
			btnEncryption.setBounds(110, 275, 186, 67);
		}
		return btnEncryption;
	}
}
