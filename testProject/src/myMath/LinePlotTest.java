package myMath;



import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
    public LinePlotTest() {
    	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        
        Polynom p = new Polynom();
        p.add(new Monom(0.2,4));
        p.add(new Monom(-1.5,3));
        p.add(new Monom(3,2));
        p.add(new Monom(-1,1));
        p.add(new Monom(-5,0));
        
        DataTable data = new DataTable(Double.class, Double.class);  
        for (double x = -2.0; x < 6.0; x+=0.01) {
            double y = p.f(x);
            data.add(x,y);
        }
        DataTable data2 = new DataTable(Double.class, Double.class);
        XYPlot plot = new XYPlot(data,data2);
        getContentPane().add(new InteractivePanel(plot));
        
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color); 
        
        
        for (double x = -2.0; x < 6.0; x+=0.25) {
        	if(p.f(x)<p.f(x+0.25) && p.f(x)<p.f(x-0.25)){
				data2.add(x,p.f(x));
			}
			else if(p.f(x)>p.f(x+0.25) && p.f(x)>p.f(x-0.25)){
				data2.add(x,p.f(x));
			}
        }
        Color color2 = new Color(1.0f, 0.5f, 0.5f);
        plot.getPointRenderers(data2).get(0).setColor(color2);
        
        System.out.println("Up : " + p.area(-2, 6, 0.01));
        System.out.println("Under : " + p.areaUnder(-2, 6, 0.01));
    }

    public static void main(String[] args) {
        LinePlotTest frame = new LinePlotTest();
        frame.setVisible(true);
    }
}