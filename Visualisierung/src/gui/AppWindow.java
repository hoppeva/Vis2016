package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class AppWindow extends JFrame {

	String[] kategories = {"Housing", "Income", "Jobs", "Community", "Education", "Environment", "Civic Engagement", "Health", "Life Satisfaction", "Safety", "Work-Life Balance"};
	String[][] underkategory = {
		{"Dwellings without basic facilities", "Housing expenditure", "Rooms per person"}, 
		{"Household net adjusted disposable income", "Household net financial wealth"},
		{"Employment rate", "Job security", "Long-term unemployment rate", "Personal earnings"},
		{"Quality of support network"},
		{"Educational attainment", "Student skills", "Years in education"},
		{"Air pollution", "Water quality"},
		{"Consultation on rule-making", "Voter turnout"},
		{"Life expectancy", "Self-reported health"},
		{"Life satisfaction"},
		{"Assault rate", "Homicide rate"},
		{"Employees working very long hours", "Time devoted to leisure and personal care"}};
	
	JTextField 	textfield_dm;
	JTextField 	textfield_euro;

	JButton[]	button = new JButton[38];
	
	ArrayList<JWindow> popup1 = new ArrayList<JWindow>();
	ArrayList<JWindow> popup2 = new ArrayList<JWindow>();
	
	HashMap <String, int[]> landKoordinaten = new HashMap<String, int[]>();
	
	HashMap <String, Double> land_HO_Base_TOT = new HashMap<String, Double>();
	HashMap <String, Integer> land_HO_Hish_TOT = new HashMap<String, Integer>();
	HashMap <String, Double> land_HO_Numr_TOT = new HashMap<String, Double>();
	
	HashMap <String, Integer> land_IW_Hadi_TOT = new HashMap<String, Integer>();
	HashMap <String, Integer> land_IW_Hnfw_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Integer> land_JE_Empl_TOT = new HashMap<String, Integer>();
	HashMap <String, Double> land_JE_Jt_TOT = new HashMap<String, Double>();
	HashMap <String, Double> land_JE_Ltur_TOT = new HashMap<String, Double>();
	HashMap <String, Integer> land_JE_Pearn_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Integer> land_SC_Sntws_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Integer> land_ES_Edua_TOT = new HashMap<String, Integer>();
	HashMap <String, Integer> land_ES_Stcs_TOT = new HashMap<String, Integer>();
	HashMap <String, Double> land_ES_Eduex_TOT = new HashMap<String, Double>();
	
	HashMap <String, Integer> land_EQ_Airp_TOT = new HashMap<String, Integer>();
	HashMap <String, Integer> land_EQ_Water_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Double> land_CG_Trasq_TOT = new HashMap<String, Double>();
	HashMap <String, Integer> land_CG_Voto_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Double> land_HS_Leb_TOT = new HashMap<String, Double>();
	HashMap <String, Integer> land_HS_Sfrh_TOT = new HashMap<String, Integer>();
	
	HashMap <String, Double> land_SW_Lifs_TOT = new HashMap<String, Double>();
	
	HashMap <String, Double> land_PS_Sfrv_TOT = new HashMap<String, Double>();
	HashMap <String, Double> land_PS_Reph_TOT = new HashMap<String, Double>();
	
	HashMap <String, Double> land_WL_Ewlh_TOT = new HashMap<String, Double>();
	HashMap <String, Double> land_WL_Tnow_TOT = new HashMap<String, Double>();
	
	String filelocation = "dataset_betterlifeindex2015.csv"; 


	public AppWindow() {
		this.getContentPane().setLayout(null);
		
		int[] aus = {1100, 460};
		landKoordinaten.put("Australia", aus);
		int[] aut = {610, 143};
		landKoordinaten.put("Austria", aut);
		int[] bel = {570, 125};
		landKoordinaten.put("Belgium", bel);
		int[] can = {170, 100};
		landKoordinaten.put("Canada", can);
		int[] cze = {610, 132};
		landKoordinaten.put("Czech Republic", cze);
		int[] dnk = {590, 110};
		landKoordinaten.put("Denmark", dnk);
		int[] fin = {645, 70};
		landKoordinaten.put("Finland", fin);
		int[] fra = {565, 145};
		landKoordinaten.put("France", fra);
		int[] deu = {590, 130};
		landKoordinaten.put("Germany", deu);
		int[] grc = {640, 185};
		landKoordinaten.put("Greece", grc);
		int[] hun = {622, 145};
		landKoordinaten.put("Hungary", hun);
		int[] isl = {500, 72};
		landKoordinaten.put("Iceland", isl);
		int[] irl = {530, 115};
		landKoordinaten.put("Ireland", irl);
		int[] ita = {600, 165};
		landKoordinaten.put("Italy", ita);
		int[] jpn = {1095, 185};
		landKoordinaten.put("Japan", jpn);
		int[] kor = {1050, 190};
		landKoordinaten.put("Korea", kor);
		int[] lux = {575, 133};
		landKoordinaten.put("Luxembourg", lux);
		int[] mex = {130, 250};
		landKoordinaten.put("Mexico", mex);
		int[] nld = {580, 120};
		landKoordinaten.put("Netherlands", nld);
		int[] nzl = {1210, 550};
		landKoordinaten.put("New Zealand", nzl);
		int[] nor = {585, 80};
		landKoordinaten.put("Norway", nor);
		int[] pol = {625, 120};
		landKoordinaten.put("Poland", pol);
		int[] prt = {520, 175};
		landKoordinaten.put("Portugal", prt);
		int[] svk = {622, 133};
		landKoordinaten.put("Slovak Republic", svk);
		int[] esp = {540, 175};
		landKoordinaten.put("Spain", esp);
		int[] swe = {610, 80};
		landKoordinaten.put("Sweden", swe);
		int[] che = {585, 145};
		landKoordinaten.put("Switzerland", che);
		int[] tur = {680, 180};
		landKoordinaten.put("Turkey", tur);
		int[] gbr = {553, 115};
		landKoordinaten.put("United Kingdom", gbr);
		int[] usa = {170, 165};
		landKoordinaten.put("United States", usa);
		int[] bra = {330, 390};
		landKoordinaten.put("Brazil", bra);
		int[] chl = {265, 490};
		landKoordinaten.put("Chile", chl);
		int[] est = {645, 90};
		landKoordinaten.put("Estonia", est);
		int[] isr = {692, 215};
		landKoordinaten.put("Israel", isr);
		int[] rus = {900, 80};
		landKoordinaten.put("Russia", rus);
		int[] svn = {610, 155};
		landKoordinaten.put("Slovenia", svn);
		
		this.initWindow();
		
		readCSVFile();

		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {


			}

			public void windowActivated(WindowEvent e) {


			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent e) {


			}

			public void windowDeiconified(WindowEvent e) {


			}

			public void windowIconified(WindowEvent e) {


			}

			public void windowOpened(WindowEvent e) {


			}



		});

	}

	protected void initWindow() 
	{
		
		ImagePanel panel = new ImagePanel(new ImageIcon("weltkarte_troglosironidae.png").getImage());
		
		panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
               closeAllPopups();
            }

        });
		
		setzeLandpunkte(panel);
			
	
		this.getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void closeAllPopups(){
		 for(int i = 0; i< popup1.size(); i++){
         	popup1.get(i).dispose();
         }
         for(int i = 0; i< popup2.size(); i++){
         	popup2.get(i).dispose();
         }
	}
	public void setzeLandpunkte(ImagePanel panel){
			Collection<int[]> collectionValues = landKoordinaten.values();
			int i = 0;
			for(int[] s: collectionValues){
				button[i] = new JButton();
				button[i].setForeground(Color.RED);
				button[i].setBackground(Color.RED);
				button[i].setBorder(BorderFactory.createEmptyBorder());
				
				for(Object o : landKoordinaten.keySet()){
					if(landKoordinaten.get(o).equals(s)){
						String name = o.toString();
						//System.out.println(o.toString());
						button[i].setBounds(s[0], s[1], 10, 10);
						button[i].setToolTipText("<html>" + name + "</html>");
						JWindow popup = zeigePopup(name);
					
						int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-(this.getWidth()/2) -100;
						int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-(this.getHeight()/2 + 75);
						popup.setLocation(x-210, y-100);
						
						button[i].addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								closeAllPopups();
								popup.pack();
								popup.setVisible(true);
							}
						});
						
						popup1.add(popup);
						panel.add(button[i]);
						break;
					}
				}
				i++;
			}
	}
	
	public JWindow zeigePopup(String titel){
		//Create the popup menu.
		//final JFrame frame = new JFrame();
        final JWindow popup = new JWindow();
        popup.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Bar Chart");
		BarChartGui chart = new BarChartGui();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JLabel labelTitel = new JLabel(titel);
		labelTitel.setFont(new Font(labelTitel.getFont().getName(), Font.BOLD, 16));
		labelTitel.setForeground(Color.blue);
		
		for(int i = 0; i < kategories.length; i++){
			panel1.add(new JButton(new AbstractAction(kategories[i]) {
	            public void actionPerformed(ActionEvent e) {        	
	            	JButton btn1 = (JButton)e.getSource();
	            	String tex = btn1.getText();
	            	for(int k = 0; k< kategories.length; k++){
	            		if(kategories[k].equals(tex)){
	            			JWindow popup3 = showDetailPopup(k, tex);
	            			popup3.setLocationRelativeTo(popup);
	    	            	popup3.setLocation(popup3.getX()+225, popup3.getY()-50);
	    	            	    	            	
	    	            	for(int j = 0; j< popup2.size(); j++){
	    	                 	popup2.get(j).dispose();
	    	                 }
	    	            	popup3.setVisible(true);
	    	            	popup3.pack();
	    	            	
	    	            	
	    	            	popup2.add(popup3);
	    	            	break;
	            		}
	            	}
				}
	        }));
		}
		
		chart.addBar(Color.red, 100);
		chart.addBar(Color.green, 50);
		chart.addBar(Color.blue, 70);
		chart.addBar(Color.cyan, 30);
		chart.addBar(Color.darkGray, 70);
		chart.addBar(Color.magenta, 20);
		chart.addBar(Color.orange, 70);
		chart.addBar(Color.yellow, 10);
		chart.addBar(Color.gray, 70);
		chart.addBar(Color.pink, 90);
		chart.addBar(Color.lightGray, 80);
		
		//frame.getContentPane().add(chart);
		popup.add(labelTitel, BorderLayout.NORTH);
		popup.add(chart, BorderLayout.CENTER);
		popup.add(panel1, BorderLayout.WEST);
		

		return popup;
		
	}
	
	public JWindow showDetailPopup(int kategory, String titel){
		final JWindow popup = new JWindow();
        popup.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Bar Chart");
		BarChartGui chart = new BarChartGui();
		JPanel panel1 = new JPanel();
		JPanel panel4 = new JPanel();
		//panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JLabel labelTitel = new JLabel(titel);
		labelTitel.setFont(new Font(labelTitel.getFont().getName(), Font.BOLD, 16));
		labelTitel.setForeground(Color.blue);
	
		Color[] color = {Color.green, Color.blue, Color.red, Color.yellow};
		for(int i = 0; i< underkategory[kategory].length; i++){
			JLabel lab = new JLabel(underkategory[kategory][i]);
			panel1.add(lab);	
			JSeparator sep = new JSeparator();
			sep.setMaximumSize(new Dimension(600, 15));
			panel1.add(sep);
			chart.addBar(color[i], 70);
		}
		
		panel4.add(chart);
	
		
		//frame.getContentPane().add(chart);
		popup.add(labelTitel, BorderLayout.NORTH);
		popup.add(panel4, BorderLayout.CENTER);
		popup.add(panel1, BorderLayout.WEST);
				
		return popup;
	}
	
	
	public void readCSVFile(){
		try {
			FileReader fr = new FileReader(filelocation);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			int i = 0;
			
			while (line != null) {
				// System.out.println(line);
				line = reader.readLine();
				
				try {
					String[] split = line.split(",");
					
					if(split[2].contains("HO_BASE") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_HO_Base_TOT.put(split[1], d);
					}else if(split[2].contains("HO_HISH") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_HO_Hish_TOT.put(split[1], integ);
					}else if(split[2].contains("HO_NUMR") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_HO_Numr_TOT.put(split[1], d);
					}else if(split[2].contains("IW_HADI") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_IW_Hadi_TOT.put(split[1], integ);
					}else if(split[2].contains("IW_HNFW") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_IW_Hnfw_TOT.put(split[1], integ);
					}else if(split[2].contains("JE_EMPL") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_JE_Empl_TOT.put(split[1], integ);
					}else if(split[2].contains("JE_JT") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_JE_Jt_TOT.put(split[1], d);
					}else if(split[2].contains("JE_LTUR") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_JE_Ltur_TOT.put(split[1], d);
					}else if(split[2].contains("JE_PEARN") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_JE_Pearn_TOT.put(split[1], integ);
					}else if(split[2].contains("SC_SNTWS") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_SC_Sntws_TOT.put(split[1], integ);
					}else if(split[2].contains("ES_EDUA") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_ES_Edua_TOT.put(split[1], integ);
					}else if(split[2].contains("ES_STCS") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_ES_Stcs_TOT.put(split[1], integ);
					}else if(split[2].contains("ES_EDUEX") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_ES_Eduex_TOT.put(split[1], d);
					}else if(split[2].contains("EQ_AIRP") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_EQ_Airp_TOT.put(split[1], integ);
					}else if(split[2].contains("EQ_WATER") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_EQ_Water_TOT.put(split[1], integ);
					}else if(split[2].contains("CG_TRASG") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_CG_Trasq_TOT.put(split[1], d);
					}else if(split[2].contains("CG_VOTO") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_CG_Voto_TOT.put(split[1], integ);
					}else if(split[2].contains("HS_LEB") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_HS_Leb_TOT.put(split[1], d);
					}else if(split[2].contains("HS_SFRH") && split[7].contains("Total")){
						Integer integ = Integer.parseInt(split[14]);
						land_HS_Sfrh_TOT.put(split[1], integ);
					}else if(split[2].contains("SW_LIFS") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_SW_Lifs_TOT.put(split[1], d);
					}else if(split[2].contains("PS_SFRV") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_PS_Sfrv_TOT.put(split[1], d);
					}else if(split[2].contains("PS_REPH") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_PS_Reph_TOT.put(split[1], d);
					}else if(split[2].contains("WL_EWLH") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_WL_Ewlh_TOT.put(split[1], d);
					}else if(split[2].contains("WL_TNOW") && split[7].contains("Total")){
						Double d = Double.parseDouble(split[14]);
						land_WL_Tnow_TOT.put(split[1], d);
					}
					
				//	System.out.println(split[1]);
				} catch (NullPointerException e1) {
					System.out.println("Ende");
				}
				i++;

			}
			System.out.println(land_HO_Base_TOT);
			System.out.println(land_HO_Hish_TOT);
			System.out.println(land_HO_Numr_TOT);
			System.out.println(land_IW_Hadi_TOT);
			System.out.println(land_IW_Hnfw_TOT);
			System.out.println(land_JE_Empl_TOT);
			System.out.println(land_JE_Jt_TOT);
			System.out.println(land_JE_Ltur_TOT);
			System.out.println(land_JE_Pearn_TOT);
			System.out.println(land_SC_Sntws_TOT);
			System.out.println(land_ES_Edua_TOT);
			System.out.println(land_ES_Stcs_TOT);
			System.out.println(land_ES_Eduex_TOT);
			System.out.println(land_EQ_Airp_TOT);
			System.out.println(land_EQ_Water_TOT);
			System.out.println(land_CG_Trasq_TOT);
			System.out.println(land_CG_Voto_TOT);
			System.out.println(land_HS_Leb_TOT);
			System.out.println(land_HS_Sfrh_TOT);
			System.out.println(land_SW_Lifs_TOT);
			System.out.println(land_PS_Sfrv_TOT);
			System.out.println(land_PS_Reph_TOT);
			System.out.println(land_WL_Ewlh_TOT);
			System.out.println(land_WL_Tnow_TOT);



			
		} catch (IOException e2) {
			System.out.println("Fehler beim Dateieinlesen");

		}
	}
}

class ImagePanel extends JPanel {
	 
	  private Image img;
	 
	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	 
	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension((img.getWidth(null)), (img.getHeight(null)));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    
	  }
	 
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
	 
	}

