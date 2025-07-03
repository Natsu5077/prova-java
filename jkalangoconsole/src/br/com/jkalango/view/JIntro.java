package br.com.jkalango.view;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIntro extends JFrame {

    public JIntro() {

        //  Configurações do JFrame (Formulário) 
        setTitle("JKalango: A Missão Começa");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    
        ImageIcon backgroundImage = new ImageIcon("background.png");
        JLabel lblImg = new JLabel(backgroundImage);
        getLayeredPane().add(lblImg, JLayeredPane.DEFAULT_LAYER);

        getContentPane().setBackground(Color.BLACK);

        //  Mensagem do JKalango 
        JLabel mensagemLabel = new JLabel();
        mensagemLabel.setText("<html><body style='text-align: center; color: white; font-family: \"Press Start 2P\", cursive; font-size: 10px; text-shadow: 1px 1px 2px black;'>"
                                + "Nas entranhas pútridas do **Cerrado Mágico**, outrora um Éden da **Orientação a Objetos**, agora jaz um domínio de pesadelo e **corrupção digital**. "
                                + "Você é **JKalango**, um resquício mutante de uma classe esquecida, com o último lampejo de pureza em seu ser. "
                                + "As outrora vibrantes **JFormigas** e **JAbelhinhas** foram diluídas em **monstros polimórficos e abstratos**, aberrações de código que rastejam por este plano distorcido. "
                                + "Cada **interface** se manifesta como um portão para o abismo, sussurrando promessas de loucura, enquanto **métodos destruídos** ecoam os lamentos de suas funções perdidas. "
                                + "Sua missão, se ousar aceitá-la, é navegar por este purgatório digital, confrontando os horrores da **aniquilação de dados** e do **esquecimento de instâncias**. "
                                + "Desvende os **mistérios corrompidos** antes que o próprio tecido da programação se desfaça, e o Cerrado Mágico se torne apenas mais um **loop infinito de terror**."
                                + "</body></html>");

        mensagemLabel.setHorizontalAlignment(JLabel.CENTER);
        mensagemLabel.setForeground(Color.WHITE);
        mensagemLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        //  Criar e Adicionar o JButton 
        JButton iniciarMissaoButton = new JButton("Iniciar Primeira Missão");

        iniciarMissaoButton.setForeground(Color.WHITE);
        iniciarMissaoButton.setBackground(new Color(50, 50, 50));
        iniciarMissaoButton.setFocusPainted(false);

        //  Adicionar ação ao botão 
        iniciarMissaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui estava o provável erro.
                // Alterado de new JCadastroJogador() para new JCadastroJogadorGabarito().
                new JCadastroJogadorGabarito(); // Instancia a tela de cadastro correta
                dispose(); // libera recursos da JIntro.
            }
        });

        setLayout(new BorderLayout());

        add(mensagemLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK); // Muda para BLACK para combinar com o fundo
        buttonPanel.add(iniciarMissaoButton);

        add(buttonPanel, BorderLayout.SOUTH);

        //  Tornar o JFrame visível (sempre por último) 
        setVisible(true);
    }
}