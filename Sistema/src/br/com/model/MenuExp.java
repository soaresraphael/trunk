package br.com.model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MenuExp extends JFrame {

    private static final long serialVersionUID = -4985498392168006224L;

    private final JDesktopPane desktop = new JDesktopPane();

    public MenuExp() {
        super("Tela Principal");

        final int inset = 50;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension dimension = new Dimension(screenSize.width / 3, screenSize.height / 2);
        this.setBounds(inset, inset, dimension.width - inset * 2, dimension.height - inset * 2);

        this.setContentPane(desktop);
        this.setJMenuBar(this.createMenuBar());

        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    private JMenuBar createMenuBar() {
		// TODO Auto-generated method stub
		return null;
	}

	// esse é o cara chamado ao acessarmos o menu, ou no seu caso, clicar no botão :)
    protected void createFrame() {
        final Teste frame = new Teste();
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (final PropertyVetoException e) {
            // trate a exceção conforme sua necessidade
        }
    }

	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
	}

}