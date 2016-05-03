package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BarChartGui extends JPanel{
	private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();
	
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color, int value)
	{
		bars.put(color, value);
		
		repaint();
		
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		
		// determine longest bar
		
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}
		
		// paint bars
		
		int width = (getWidth() / bars.size()) -2;
		int x = 1;
		for (Color color : bars.keySet())
		{
			int value = bars.get(color);
			int height = (int) 
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(0, x, height, width);
			g.setColor(Color.black);
			g.drawRect(0, x, height, width);
			x += width+2;
		}
	}

	@Override
	public Dimension getPreferredSize() {
		this.setMinimumSize(new Dimension(300,100));
		return new Dimension(bars.size() * 26, 100);
	}
}