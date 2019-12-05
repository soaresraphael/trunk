package br.com.model;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
 
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.awt.*;
 
 
@SuppressWarnings({ "unused", "serial" })
public class Principal extends JFrame implements ActionListener
{
    // Declara componetes
    JDesktopPane painel;
 
    public Principal() 
    {
        // herda classe
        super("Java - Formularios - MDI - JFrame / JDesktopPane / JInternalFrame");
         
        // Define tamanho da janela principal
        int bordas = 50;
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(bordas, bordas, tela.width  - bordas *2 , tela.height - bordas *2);
         
        // Cria painel principal
        painel = new JDesktopPane(); 
        painel.setBackground(Color.LIGHT_GRAY);
                 
        setContentPane(painel);
        setJMenuBar(createMenuBar());        
    }
     
    protected JMenuBar createMenuBar()
    {
        // Cria barra de menu
        JMenuBar barra = new JMenuBar();
         
        // Cria menu
        JMenu menu = new JMenu("Formularios");        
        barra.add(menu);
 
        // Cria itens dos menus
        JMenuItem item = new JMenuItem("Novo");
        item.setActionCommand("novo");
        item.addActionListener(this);
        menu.add(item);
        
        // Cria itens dos menus
        item = new JMenuItem("Teste");
        item.setActionCommand("teste");
        item.addActionListener(this);
        menu.add(item);
 
        //Cria segundo item
        item = new JMenuItem("Sair");
        item.setActionCommand("sair");
        item.addActionListener(this);
        menu.add(item);
 
        return barra;
    }
 
     
    public void actionPerformed(ActionEvent e) 
    {
        // Cria eventos do menu
    	
    	switch (e.getActionCommand()) {
		case "novo":
			criaFormulario();
			break;
		case "teste":
			try {
				criaTeste();
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "sair":
			sair();
			break;
			
		default:
			break;
		}
//        if (e.getActionCommand() == "novo")
//        { 
//            criaFormulario();
//        } 
//        else
//        {
//            sair();
//        }
    }
 
    protected void sair() 
    {
        // Fecha sistema
        System.exit(0);
    }
     
    protected void criaFormulario()
    {
        // Cria formulario filho
        FormularioFilho frame = new FormularioFilho();
        frame.setVisible(true); 
         
        // Adiciona janela filho na janela pai
        painel.add(frame);
        try
        {
            // Seta foco
            frame.setSelected(true);
        }
        catch (java.beans.PropertyVetoException e)        
        {
             
        }
    }
    
    protected void criaTeste() throws java.beans.PropertyVetoException
    {
        // Cria formulario filho
        MenuExp fr = new MenuExp();
        fr.setVisible(true); 
         
        // Adiciona janela filho na janela pai
        painel.add(fr);
        // Seta foco
		fr.setSelected(true);
    }
    
        
     
    private static void criaGUI() 
    {     
        // Decora barra da janela
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        // Cria formulario filho     
        Principal formulario = new Principal();
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        // Exibe formulario
        formulario.setVisible(true);
    }
 
    
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run() 
            {
                // Chama GUI
                criaGUI();
            }
        });
    }
}
