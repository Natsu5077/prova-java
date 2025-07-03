package br.com.jkalango.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.jkalango.service.RegistroService;

public class JCadastroJogadorGabarito extends JFrame {

    private JTextField txtNome;
    private JTextField txtNickName;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JTextField txtTelefone;

    public JCadastroJogadorGabarito() {
        setTitle("Cadastro de Jogador - JKalango");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //  Configurações para a coluna dos Rótulos (coluna 0) 
  
        // Isso empurrará os rótulos para a direita, aproximando-os dos campos de texto.
        gbc.weightx = 0.1; // Um pequeno peso para a coluna dos rótulos
        gbc.fill = GridBagConstraints.NONE; // Rótulos não devem preencher o espaço horizontal

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Alinha o rótulo à direita dentro de sua célula
        add(new JLabel("Nome:"), gbc);

        // Nickname
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nickname:"), gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Email:"), gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Senha:"), gbc);

        // Telefone
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Telefone:"), gbc);

        // Configurações para a coluna dos Campos de Texto (coluna 1) 
        gbc.weightx = 1.0; // Esta coluna deve levar a maior parte do espaço extra
        gbc.fill = GridBagConstraints.HORIZONTAL; // Campos de texto preenchem horizontalmente

        // Nome Campo
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinha o campo à esquerda dentro de sua célula
        txtNome = new JTextField(20);
        add(txtNome, gbc);

        // Nickname Campo
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtNickName = new JTextField(20);
        add(txtNickName, gbc);

        // Email Campo
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        // Senha Campo
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        txtSenha = new JPasswordField(20);
        add(txtSenha, gbc);

        // Telefone Campo
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        txtTelefone = new JTextField(20);
        add(txtTelefone, gbc);

        // Botão Cadastrar
        // Resetamos o weightx e fill para o botão
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Ocupa duas colunas para centralizar
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        JButton btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String nickName = txtNickName.getText().trim();
                String email = txtEmail.getText().trim();
                String senha = new String(txtSenha.getPassword());
                String telefone = txtTelefone.getText().trim();

                if (nome.isEmpty() || nickName.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this, "Por favor, preencha todos os campos.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    RegistroService registroService = new RegistroService();
                    
                    String erroMensagem = registroService.cadastrarJogador(nome, nickName, email, senha, telefone);

                    if (erroMensagem == null) {
                        JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this, "Jogador cadastrado com sucesso!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
                        txtNome.setText("");
                        txtNickName.setText("");
                        txtEmail.setText("");
                        txtSenha.setText("");
                        txtTelefone.setText("");
                    } else {
                        JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this, erroMensagem, "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this, "Ocorreu um erro inesperado ao processar o cadastro: " + ex.getMessage(), "Erro Grave", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JCadastroJogadorGabarito();
            }
        });
    }
}