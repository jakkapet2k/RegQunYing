package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Insets;



public class Home extends JPanel implements ActionListener{
	public static final String View_STR = "View Goods";
	DefaultTableModel tableModel;
    JLabel label;
	Main main;
	Menu menu;
	
	public Home(Main main)   {
		setBackground(Color.WHITE);
		this.setBounds(0,0,500,300);
		this.setLayout(null);
		setPreferredSize(new Dimension(684,486));

        ImageIcon icon = new ImageIcon("C:/Users/Jakkapet2K/Desktop/web tem/img/navbar_logo.png");
        Image img = icon.getImage().getScaledInstance(2448/6, 957/6, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(img);

        label = new JLabel();
        label.setIcon(scaledIcon);
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;

      add(label, c);
      
      JLabel lblGoodsInfo = new JLabel("Registration system QunYing");
      lblGoodsInfo.setFont(new Font("Quark", Font.BOLD, 23));
      lblGoodsInfo.setBounds(272, 42, 106,33);
      GridBagConstraints gbc_lblGoodsInfo = new GridBagConstraints();
      gbc_lblGoodsInfo.gridx = 0;
      gbc_lblGoodsInfo.gridy = 1;
      this.add(lblGoodsInfo, gbc_lblGoodsInfo);
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();

			
			

		}

	
}
