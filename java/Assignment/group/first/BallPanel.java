package group.first;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;


public class BallPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("宋体", Font.BOLD, 18);
	private Ball ball = null;
	private ControlBall cBall = null;
	public BallPanel()
	{
		//建立  控制球的 对象
		cBall = new ControlBall();

	}

	public ControlBall getcBall()
	{
		return cBall;
	}

	@Override
	public void paint(Graphics canvas)
	{
		super.paint(canvas);
		canvas.setFont(font);
		canvas.setColor(Color.LIGHT_GRAY);
		
		// 设置 画布
		Graphics2D g2d=(Graphics2D) canvas;

		//绘制渐变背景
		/*Shape p = new Rectangle(0,0,800,600); 
		Color color =  new Color(250, 250, 210);
		RoundRectangle2D body = new RoundRectangle2D.Float(0, 0, 50, 50, 50, 50); 
		GradientPaint gp = new GradientPaint(0, 0, color.darker(), 0, 100, color.brighter().brighter());
		g2d.setPaint(gp);
		//g2d.setComposite(AlphaComposite.DstIn);
		g2d.fillRect(0,0,300,300); 
		g2d.fill(body);*/
		
		int centerX,centerY;
		/**
		 * 初始化所有的球
		 * 圆心坐标 centerX, centerY
		 * 号码坐标 centerX-7, centerY+7
		 */
		for (int i = 1; i <= 33; i++)
		{
			ball = cBall.getRedBall(i);
			centerX = ball.getX();
			centerY = ball.getY();
			//System.out.println(i + " , " + centerX + " , " + centerY);
			drawHighLight(g2d, ball.getColor(), centerX, centerY, ball.getRadius());
			canvas.drawString(ball.getNumber(),  centerX-7, centerY+7);
		}
		for (int i = 1; i <= 16; i++)
		{
			ball = cBall.getBlueBall(i); 
			centerX = ball.getX();
			centerY = ball.getY();
			drawHighLight(g2d, ball.getColor(), centerX, centerY, ball.getRadius());
			canvas.drawString(ball.getNumber(),  centerX-7, centerY+7);
		}
		for (int i = 1; i <= 7; i++)
		{
			ball = cBall.getSelectedBall(i);
			centerX = ball.getX();
			centerY = ball.getY();
			drawHighLight(g2d, ball.getColor(), centerX, centerY, ball.getRadius());
			canvas.drawString(ball.getNumber(),  centerX-7, centerY+7);
		}
	}

	/**
	 * 鼠标事件只监听单击事件
	 * 传入 鼠标坐标参数
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// e.getButton就会返回点鼠标的那个键，左键还是右健，1-左键，3-右键
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			int x = e.getX(); // 得到鼠标x坐标
			int y = e.getY(); // 得到鼠标y坐标
			//String banner =  x + " , " + y +"\n ";
			//判断是否选择有球, 坐标参数对应：Jframe(9,30) <--> Jpanel(0,0)
			if (cBall.judgeSelectBall(x-9, y-30))
			{
				updateUI(); //重绘面板
				//revalidate();
			}
		}
	}

	/**
	 * 画高亮区域
	 * @param g2d
	 * @param color
	 * @param centerX
	 * @param centerY
	 * @param radius
	 */
	private void drawHighLight(Graphics2D g2d, Color color, int centerX, int centerY, int radius )
	{
		Ellipse2D.Double circle = new Ellipse2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2);

		// draw body
		g2d.setColor(color);
		GradientPaint paint = new GradientPaint(centerX, centerY, color.darker(), centerX, centerY + radius * 2,
				color.brighter().brighter());
		g2d.setPaint(paint);
		g2d.fill(circle);

		// draw highlight.
		Shape highlightArea = createHighlightShape(centerX, centerY, radius);
		g2d.setColor(new Color(255, 255, 255, 150));
		g2d.fill(highlightArea);
	}

	// 对高亮区域的计算，可以用一个圆心在左上方的大圆形和矩形进行剪切：
	private static Shape createHighlightShape(int centerX, int centerY, int radius)
	{
		double myRadius = radius * 0.77;
		double x = centerX - myRadius;
		double y1 = centerY - myRadius - myRadius / 5;
		double y2 = centerY - myRadius - myRadius / 5 * 2;

		Ellipse2D.Double circle1 = new Ellipse2D.Double(x, y1, myRadius * 1.8, myRadius * 1.8);
		Ellipse2D.Double circle2 = new Ellipse2D.Double(x, y2, myRadius * 1.5, myRadius * 1.5);

		Area area = new Area(circle1);
		area.intersect(new Area(circle2));
		return area;
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}