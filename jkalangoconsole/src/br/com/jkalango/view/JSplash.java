package br.com.jkalango.view;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JSplash extends JFrame {
    public JSplash() {
        // 1) O formulário (JFrame) 
        setTitle("JKalango Splash Screen"); 
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout()); 

        // 2) Adicionar o JButton com o título Start
        JButton startButton = new JButton("Start");
        add(startButton); 

        // 3) Adicionar um evento ao botão que ao clicar mostre "JKalango"
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JIntro();
            }
        });
        // 4) Mostrar o formulário - This should be the last step in the constructor
        setVisible(true); 
    }
}
