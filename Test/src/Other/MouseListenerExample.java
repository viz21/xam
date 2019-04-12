package Other;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class MouseListenerExample extends Frame implements MouseListener{
	
	JLabel l;
	public MouseListenerExample() {
		addMouseListener(this);
		this.l = new JLabel();
		l.setBounds(20, 50, 100, 20);
		add(l);
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
