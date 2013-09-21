import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClasseTeste extends JFrame{

  //bloco 1 - objeto da janela
  private JButton objeto0;
  
  public ClasseTeste(){
    //bloco 2 definicao dos dados da janela
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(0,153,204));
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(new java.awt.Dimension(336,230));
    this.setLocation((screenSize.width - 336) / 2, (screenSize.height - 230) /2 );
    this.setTitle("Aprendendo Swing");
    this.setResizable(false);
    
    //bloco 3 - Criaçao dos objetos na janela
    objeto0 = new JButton("Button");
    objeto0.setBounds(new Rectangle(79,47,100,30));
    this.getContentPane().add(objeto0,null);
    
    objeto0.addMouseListener (new MouseAdapter(){
      public void mouseClicked(MouseEvent e ){
	JOptionPane.showMessageDialog(rootPane, "Teste");
      }
    });
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	aoFechar();
      }
    });
    this.setVisible(true);
    
  }
  
  private void aoFechar(){
    System.exit(0);
  }
  
  //Insira aqui os metodos para os eventos
  public static void main(String args[]){
    new ClasseTeste();
  
  }
}