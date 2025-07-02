package br.com.jkalango.view; // Esta linha deve ser EXATA

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.jkalango.service.RegistroService; // ESTE IMPORT É CRUCIAL e deve apontar para o pacote correto

public class JCadastroJogadorGabarito extends JFrame {

    private JTextField txtNome;
    private JTextField txtNickName;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JTextField txtTelefone;

    public JCadastroJogadorGabarito() {
        setTitle("Cadastro de Jogador - JKalango");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(new JLabel("Nome:"));
        txtNome = new JTextField(25);
        add(txtNome);

        add(new JLabel("Nickname:"));
        txtNickName = new JTextField(25);
        add(txtNickName);

        add(new JLabel("Email:"));
        txtEmail = new JTextField(25);
        add(txtEmail);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField(25);
        add(txtSenha);

        add(new JLabel("Telefone:"));
        txtTelefone = new JTextField(25);
        add(txtTelefone);

        JButton btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

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
        new JCadastroJogadorGabarito();
    }
}