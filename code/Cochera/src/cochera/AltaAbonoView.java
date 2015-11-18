package cochera;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;

public class AltaAbonoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private SistemaAdministracionCochera sistema;

	public AltaAbonoView(SistemaAdministracionCochera sist) {
		setVisible(true);
		sistema = sist;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("Tama\u00F1o");
		JLabel lblNewLabel_1 = new JLabel("Precio");
		JLabel lblNewLabel_2 = new JLabel("Periodo");
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblAltaDeAbono = new JLabel("Alta de abonos");
		lblAltaDeAbono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(85)
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel)
																		.addComponent(lblNewLabel_2)
																		.addComponent(lblNewLabel_1))
												.addGap(109)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textField)
														.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
												.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(138).addComponent(lblAltaDeAbono)))
						.addContainerGap(65, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblAltaDeAbono)
						.addGap(27)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(55, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						sistema.altaAbono(comboBox.getSelectedItem().toString(), Float.parseFloat(textField.getText()),
								comboBox_1.getSelectedItem().toString());
						Abono_menu abmen = new Abono_menu(sistema);
						dispose();
					}
				});

			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Abono_menu abmen = new Abono_menu(sistema);
						dispose();
					}
				});

			}
		}

		Iterator<Cochera> coch = sistema.getCocheras().iterator();//
		Cochera aux;
		int flag;
		Vector<Cochera> Vaux = new Vector<Cochera>();
		Iterator<Cochera> itaux;
		while (coch.hasNext()) {
			flag = 0;
			aux = coch.next();
			itaux = Vaux.iterator();
			while (itaux.hasNext() && flag == 0)
				if (aux.getTamano() == itaux.next().getTamano())
					flag = 1;
			if (flag == 0)
				Vaux.addElement(aux);
		}

		itaux = Vaux.iterator();
		while (itaux.hasNext()) {
			aux = itaux.next();
			comboBox.addItem(aux.getTamano());
		}

		comboBox_1.addItem("Quincenal");
		comboBox_1.addItem("Mensual");
		comboBox_1.addItem("Semestral");
	}

}
