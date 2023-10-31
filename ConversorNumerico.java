package primer_ejemplo;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Dimension;

public class ConversorNumerico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bgTipoConversion;
	private String texto;
	private JRadioButton rdbtnBIN;
	private JRadioButton rdbtnOct;
	private JRadioButton rdbtnDec;
	private JRadioButton rdbtnHex;
	private JLabel lbl0;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;
	private JLabel lblE;
	private JLabel lblF;
	private String sistemaAnterior;
	private String sistemaActual = "DEC";
	int xMouse, yMouse;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorNumerico frame = new ConversorNumerico();
					frame.setUndecorated(true);
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
	public ConversorNumerico() {
		
		bgTipoConversion = new ButtonGroup();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONVERSOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(92, 19, 268, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblConvertir = new JLabel("0");
		lblConvertir.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblConvertir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConvertir.setBounds(9, 70, 414, 40);
		contentPane.add(lblConvertir);
		
		rdbtnBIN = new JRadioButton("BIN");
		rdbtnBIN.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		rdbtnBIN.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rdbtnBIN.setBounds(10, 129, 68, 23);
		contentPane.add(rdbtnBIN);
		
		rdbtnOct = new JRadioButton("OCT");
		rdbtnOct.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		rdbtnOct.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rdbtnOct.setBounds(120, 129, 75, 23);
		contentPane.add(rdbtnOct);
		
		rdbtnDec = new JRadioButton("DEC");
		rdbtnDec.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		rdbtnDec.setSelected(true);
		rdbtnDec.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rdbtnDec.setBounds(230, 129, 75, 23);
		contentPane.add(rdbtnDec);
		
		rdbtnHex = new JRadioButton("HEX");
		rdbtnHex.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		rdbtnHex.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rdbtnHex.setBounds(348, 129, 75, 23);
		contentPane.add(rdbtnHex);
		
		bgTipoConversion.add(rdbtnBIN);
		bgTipoConversion.add(rdbtnOct);
		bgTipoConversion.add(rdbtnDec);
		bgTipoConversion.add(rdbtnHex);
		
		JLabel lblRESET = new JLabel("RESET");
		lblRESET.setForeground(new Color(255, 255, 255));
		lblRESET.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRESET.setBackground(new Color(255,255,255));
				lblRESET.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblConvertir.setText("0");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRESET.setForeground(new Color(255,255,255));
				lblRESET.setBackground(new Color(128,0,255));
			}
		});
		lblRESET.setOpaque(true);
		lblRESET.setBackground(new Color(128, 0, 255));
		lblRESET.setHorizontalAlignment(SwingConstants.CENTER);
		lblRESET.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRESET.setBounds(10, 298, 414, 40);
		contentPane.add(lblRESET);
		
		lbl0 = new JLabel("0");
		lbl0.setForeground(new Color(255, 255, 255));
		lbl0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl0.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "0";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl0.setBackground(new Color(255,255,255));
				lbl0.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl0.setForeground(new Color(255,255,255));
				lbl0.setBackground(new Color(128,0,255));
			}
		});
		lbl0.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setOpaque(true);
		lbl0.setBackground(new Color(128, 0, 255));
		lbl0.setBounds(28, 256, 106, 31);
		contentPane.add(lbl0);
		
		lbl1 = new JLabel("1");
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl1.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "1";
				else texto = "1";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setBackground(new Color(255,255,255));
				lbl1.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl1.setForeground(new Color(255,255,255));
				lbl1.setBackground(new Color(128,0,255));
			}
		});
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl1.setOpaque(true);
		lbl1.setBackground(new Color(128, 0, 255));
		lbl1.setBounds(145, 256, 101, 31);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("2");
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl2.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "2";
				else texto = "2";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl2.setBackground(new Color(255,255,255));
				lbl2.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl2.setForeground(new Color(255,255,255));
				lbl2.setBackground(new Color(128,0,255));
			}
		});
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl2.setOpaque(true);
		lbl2.setBackground(new Color(128, 0, 255));
		lbl2.setBounds(256, 256, 68, 31);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("3");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl3.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "3";
				else texto = "3";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl3.setBackground(new Color(255,255,255));
				lbl3.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl3.setForeground(new Color(255,255,255));
				lbl3.setBackground(new Color(128,0,255));
			}
		});
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl3.setOpaque(true);
		lbl3.setBackground(new Color(128, 0, 255));
		lbl3.setBounds(334, 256, 68, 31);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("4");
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl4.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "4";
				else texto = "4";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl4.setBackground(new Color(255,255,255));
				lbl4.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl4.setForeground(new Color(255,255,255));
				lbl4.setBackground(new Color(128,0,255));
			}
		});
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl4.setOpaque(true);
		lbl4.setBackground(new Color(128, 0, 255));
		lbl4.setBounds(28, 214, 54, 31);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("5");
		lbl5.setForeground(new Color(255, 255, 255));
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl5.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "5";
				else texto = "5";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl5.setBackground(new Color(255,255,255));
				lbl5.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl5.setForeground(new Color(255,255,255));
				lbl5.setBackground(new Color(128,0,255));
			}
		});
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl5.setOpaque(true);
		lbl5.setBackground(new Color(128, 0, 255));
		lbl5.setBounds(92, 214, 54, 31);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("6");
		lbl6.setForeground(new Color(255, 255, 255));
		lbl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl6.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "6";
				else texto = "6";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl6.setBackground(new Color(255,255,255));
				lbl6.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl6.setForeground(new Color(255,255,255));
				lbl6.setBackground(new Color(128,0,255));
			}
		});
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl6.setOpaque(true);
		lbl6.setBackground(new Color(128, 0, 255));
		lbl6.setBounds(156, 214, 54, 31);
		contentPane.add(lbl6);
		
		lbl7 = new JLabel("7");
		lbl7.setForeground(new Color(255, 255, 255));
		lbl7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl7.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "7";
				else texto = "7";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl7.setBackground(new Color(255,255,255));
				lbl7.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl7.setForeground(new Color(255,255,255));
				lbl7.setBackground(new Color(128,0,255));
			}
		});
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl7.setOpaque(true);
		lbl7.setBackground(new Color(128, 0, 255));
		lbl7.setBounds(220, 214, 54, 31);
		contentPane.add(lbl7);
		
		lbl8 = new JLabel("8");
		lbl8.setForeground(new Color(255, 255, 255));
		lbl8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl8.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "8";
				else texto = "8";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl8.setBackground(new Color(255,255,255));
				lbl8.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl8.setForeground(new Color(255,255,255));
				lbl8.setBackground(new Color(128,0,255));
			}
		});
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl8.setOpaque(true);
		lbl8.setBackground(new Color(128, 0, 255));
		lbl8.setBounds(284, 214, 54, 31);
		contentPane.add(lbl8);
		
		lbl9 = new JLabel("9");
		lbl9.setForeground(new Color(255, 255, 255));
		lbl9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lbl9.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0")) texto += "9";
				else texto = "9";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl9.setBackground(new Color(255,255,255));
				lbl9.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl9.setForeground(new Color(255,255,255));
				lbl9.setBackground(new Color(128,0,255));
			}
		});
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl9.setOpaque(true);
		lbl9.setBackground(new Color(128, 0, 255));
		lbl9.setBounds(348, 214, 54, 31);
		contentPane.add(lbl9);
		
		lblA = new JLabel("A");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblA.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "A";
				else if(rdbtnHex.isSelected())texto = "A";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblA.setBackground(new Color(255,255,255));
				lblA.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblA.setForeground(new Color(255,255,255));
				lblA.setBackground(new Color(128,0,255));
			}
		});
		lblA.setEnabled(false);
		lblA.setOpaque(true);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblA.setBackground(new Color(128, 0, 255));
		lblA.setBounds(28, 172, 54, 31);
		contentPane.add(lblA);
		
		lblB = new JLabel("B");
		lblB.setForeground(new Color(255, 255, 255));
		lblB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblB.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "B";
				else if(rdbtnHex.isSelected()) texto = "B";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblB.setBackground(new Color(255,255,255));
				lblB.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblB.setForeground(new Color(255,255,255));
				lblB.setBackground(new Color(128,0,255));
			}
		});
		lblB.setEnabled(false);
		lblB.setOpaque(true);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblB.setBackground(new Color(128, 0, 255));
		lblB.setBounds(92, 172, 54, 31);
		contentPane.add(lblB);
		
		lblC = new JLabel("C");
		lblC.setForeground(new Color(255, 255, 255));
		lblC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblC.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "C";
				else if(rdbtnHex.isSelected())texto = "C";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblC.setBackground(new Color(255,255,255));
				lblC.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblC.setForeground(new Color(255,255,255));
				lblC.setBackground(new Color(128,0,255));
			}
		});
		lblC.setEnabled(false);
		lblC.setOpaque(true);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblC.setBackground(new Color(128, 0, 255));
		lblC.setBounds(156, 172, 54, 31);
		contentPane.add(lblC);
		
		lblD = new JLabel("D");
		lblD.setForeground(new Color(255, 255, 255));
		lblD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblD.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "D";
				else if (rdbtnHex.isSelected())texto = "D";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblD.setBackground(new Color(255,255,255));
				lblD.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblD.setForeground(new Color(255,255,255));
				lblD.setBackground(new Color(128,0,255));
			}
		});
		lblD.setEnabled(false);
		lblD.setOpaque(true);
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblD.setBackground(new Color(128, 0, 255));
		lblD.setBounds(220, 172, 54, 31);
		contentPane.add(lblD);
		
		lblE = new JLabel("E");
		lblE.setForeground(new Color(255, 255, 255));
		lblE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblE.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "E";
				else if(rdbtnHex.isSelected()) texto = "E";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblE.setBackground(new Color(255,255,255));
				lblE.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblE.setForeground(new Color(255,255,255));
				lblE.setBackground(new Color(128,0,255));
			}
		});
		lblE.setEnabled(false);
		lblE.setOpaque(true);
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblE.setBackground(new Color(128, 0, 255));
		lblE.setBounds(284, 172, 54, 31);
		contentPane.add(lblE);
		
		lblF = new JLabel("F");
		lblF.setForeground(new Color(255, 255, 255));
		lblF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblF.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "F";
				else if(rdbtnHex.isSelected()) texto = "F";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblF.setBackground(new Color(255,255,255));
				lblF.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblF.setForeground(new Color(255,255,255));
				lblF.setBackground(new Color(128,0,255));
			}
		});
		lblF.setEnabled(false);
		lblF.setOpaque(true);
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblF.setBackground(new Color(128, 0, 255));
		lblF.setBounds(348, 172, 54, 31);
		contentPane.add(lblF);
		
		JLabel lblAutor = new JLabel("AUTOR");
		lblAutor.setForeground(new Color(255, 255, 255));
		lblAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Vladut Gabriel Alexandru");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAutor.setBackground(new Color(255,255,255));
				lblAutor.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAutor.setForeground(new Color(255,255,255));
				lblAutor.setBackground(new Color(128,0,255));
			}
		});
		lblAutor.setOpaque(true);
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAutor.setBackground(new Color(128, 0, 255));
		lblAutor.setBounds(10, 349, 202, 40);
		contentPane.add(lblAutor);
		
		JLabel lblRESET_1_1 = new JLabel("SALIR");
		lblRESET_1_1.setForeground(new Color(255, 255, 255));
		lblRESET_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRESET_1_1.setBackground(new Color(255,255,255));
				lblRESET_1_1.setForeground(new Color(128,0,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRESET_1_1.setForeground(new Color(255,255,255));
				lblRESET_1_1.setBackground(new Color(128,0,255));
			}
		});
		lblRESET_1_1.setOpaque(true);
		lblRESET_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRESET_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRESET_1_1.setBackground(new Color(128, 0, 255));
		lblRESET_1_1.setBounds(220, 349, 203, 40);
		contentPane.add(lblRESET_1_1);
		rdbtnHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistemaAnterior = sistemaActual;
				sistemaActual = "HEX";
				SistemaNumerico();
				lblConvertir.setText(calcular(lblConvertir.getText(), sistemaAnterior, sistemaActual));
				
			}
		});
		
		lblA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblA.isEnabled()){ // skip if label not enabled
                    return;
                }
				texto = lblConvertir.getText();
				if(!texto.startsWith("0") && rdbtnHex.isSelected()) texto += "A";
				else if(rdbtnHex.isSelected())texto = "A";
				lblConvertir.setText(texto);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblA.setBackground(new Color(255,255,255));
				lblA.setForeground(new Color(128,0,255));
			}
		});
		
		rdbtnDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistemaAnterior = sistemaActual;
				sistemaActual = "DEC";
				SistemaNumerico();
				lblConvertir.setText(calcular(lblConvertir.getText(), sistemaAnterior, sistemaActual));
			}
		});
		
		rdbtnBIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistemaAnterior = sistemaActual;
				sistemaActual = "BIN";
				SistemaNumerico();
				lblConvertir.setText(calcular(lblConvertir.getText(), sistemaAnterior, sistemaActual));
			
			}
		});
		
		rdbtnOct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistemaAnterior = sistemaActual;
				sistemaActual = "OCT";
				SistemaNumerico();
				lblConvertir.setText(calcular(lblConvertir.getText(), sistemaAnterior, sistemaActual));
				
			}
		});
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				contentMousePressed(e);
			}
		});
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override 
			public void mouseDragged(MouseEvent e) {
				contentMouseDragged(e);
			}
		});
	}
	public void SistemaNumerico() {
		JLabel botones[] = {lbl0, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lblA, lblB, lblC, lblD, lblE, lblF};
		if(rdbtnHex.isSelected()) {
			for(JLabel boton: botones) {
				boton.setEnabled(true);
			}
		}else if(rdbtnDec.isSelected()) {
			for(int i=0;i<16;i++) {
				if(i<10) botones[i].setEnabled(true);
				else { 
					botones[i].setEnabled(false);
				}
			}
		}else if(rdbtnOct.isSelected()) {
			for(int i=0;i<16;i++) {
				if(i<8) botones[i].setEnabled(true);
				else { 
					botones[i].setEnabled(false);
				}
			}
		}else if(rdbtnBIN.isSelected()) {
			for(int i = 0 ; i<16; i++) {
				if(i<2) botones[i].setEnabled(true);
				else { 
					botones[i].setEnabled(false);
				}
			}
		}
	}
	    public static String calcular(String numero, String estadoAnterior, String estadoActual) {
	        int valorDecimal;

	        switch (estadoAnterior) {
	            case "DEC":
	                valorDecimal = Integer.parseInt(numero);
	                break;
	            case "HEX":
	                valorDecimal = Integer.parseInt(numero, 16);
	                break;
	            case "OCT":
	                valorDecimal = Integer.parseInt(numero, 8);
	                break;
	            case "BIN":
	                valorDecimal = Integer.parseInt(numero, 2);
	                break;
	            default:
	                throw new IllegalArgumentException("Estado anterior no válido");
	        }

	        switch (estadoActual) {
	            case "DEC":
	                return String.valueOf(valorDecimal);
	            case "HEX":
	                return Integer.toHexString(valorDecimal).toUpperCase();
	            case "OCT":
	                return Integer.toOctalString(valorDecimal);
	            case "BIN":
	                return Integer.toBinaryString(valorDecimal);
	            default:
	                throw new IllegalArgumentException("Estado actual no válido");
	        }
	    }
	    private void contentMousePressed(MouseEvent e) {
			xMouse = e.getX();
			yMouse = e.getY();
		}
		
		private void contentMouseDragged(MouseEvent e) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			this.setLocation(x - xMouse, y - yMouse );
		}
	}

