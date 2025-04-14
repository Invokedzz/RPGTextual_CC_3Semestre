package rpg.Jogo;

// Importa as classes dos personagens principais
import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;

// Importações do Swing e AWT (bibliotecas gráficas)
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 * Classe principal responsável por exibir a interface gráfica do jogo
 * em um terminal customizado estilo "terminal de resistência".
 */
public class JogoGui extends JFrame {

    // Área de texto onde as mensagens do jogo são exibidas
    private JTextPane areaTexto;

    /**
     * Construtor da interface gráfica do jogo.
     * Inicializa os componentes da tela e inicia o jogo.
     */
    public JogoGui() {
        // Define o título da janela
        setTitle("TERMINAL DA RESISTÊNCIA");

        // Define que o programa será encerrado ao fechar a janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Remove as bordas e barra de título da janela (estilo terminal)
        setUndecorated(true);

        // Faz a janela ocupar toda a tela (full screen)
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Define layout principal da janela
        setLayout(new BorderLayout());

        // Cria e configura a área de texto
        areaTexto = new JTextPane();
        areaTexto.setEditable(false); // Usuário não pode editar
        areaTexto.setBackground(Color.BLACK); // Fundo preto estilo terminal
        areaTexto.setForeground(Color.GREEN);  // Cor do texto inicial
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 18)); // Fonte tipo terminal

        // Coloca a área de texto dentro de um scroll (permite rolar se o texto for longo)
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER); // Adiciona ao centro da janela

        // Painel superior para conter o botão de encerrar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.BLACK); // Fundo preto como o terminal

        // Botão de encerrar o jogo
        JButton botaoFechar = new JButton("Encerrar");
        botaoFechar.setBackground(Color.RED);
        botaoFechar.setForeground(Color.WHITE);
        botaoFechar.setFocusPainted(false);
        botaoFechar.setFont(new Font("Arial", Font.BOLD, 14));

        // Define a ação do botão: fechar o programa
        botaoFechar.addActionListener(e -> System.exit(0));

        // Adiciona o botão ao painel e o painel à janela
        topPanel.add(botaoFechar);
        add(topPanel, BorderLayout.NORTH);

        // Torna a janela visível
        setVisible(true);

        // Inicia o jogo
        startGame();
    }

    /**
     * Início da história do jogo. Exibe introdução e inicia a escolha do personagem.
     */
    private void startGame() {
        // Cria as opções de personagem
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        // Texto introdutório em verde
        String textoVerde = "[ACESSANDO TERMINAL DA RESISTÊNCIA VERDE...]\n\n" +
                ">> Conexão segura estabelecida.\n\n" +
                ">> Identidade confirmada. Acesso de campo liberado.\n\n" +
                ">> Carregando perfil dos agentes disponíveis para a missão final: OPERAÇÃO RAIZ...\n\n" +
                ">> Apenas dois membros ativos estão aptos para a infiltração nos Núcleos Verdes.\n\n";

        // Imprime o texto devagar com som (estilo digitação de terminal)
        printSlowlyWithSoundGui(textoVerde, 30, Color.GREEN, () -> escolherPersonagem(escolha1, escolha2));
    }

    /**
     * Exibe informações dos personagens e permite o jogador escolher um.
     */
    private void escolherPersonagem(DrMorato escolha1, Liz escolha2) {

        // Mostra os personagens disponíveis
        String personagens = "\nPersonagens que podem ser escolhidos:\n" +
                "--------------------------------------------------\n" +
                escolha1.escolha() +
                "\n--------------------------------------------------\n" +
                escolha2.escolha() +
                "\n--------------------------------------------------\n";

        // Exibe o texto com efeito de digitação lenta
        printSlowlyGui(personagens, 15, Color.WHITE, () -> {
            // Opções do popup de escolha
            String[] options = {"Dr. Morato", "Liz"};

            // Abre caixa de diálogo para escolher personagem
            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Escolha o personagem:",
                    "Seleção de Personagem",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]
            );

            // Se o usuário fechar a caixa de seleção
            if (choice == JOptionPane.CLOSED_OPTION) {
                appendText("\nNenhum personagem selecionado.\n", Color.RED);
                return;
            }

            // Define o personagem escolhido
            Personagem chosen = (choice == 0) ? new DrMorato() : new Liz();

            // Mostra o personagem escolhido
            appendText("\n" + chosen + "\n", Color.WHITE);
        });
    }

    /**
     * Imprime texto com efeito de digitação lenta na cor desejada.
     */
    private void printSlowlyGui(String text, long delayMillis, Color corTexto, Runnable onComplete) {
        new Thread(() -> {
            for (char c : text.toCharArray()) {
                SwingUtilities.invokeLater(() -> appendText(Character.toString(c), corTexto));
                try {
                    Thread.sleep(delayMillis); // Aguarda tempo entre cada caractere
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // Após terminar de imprimir, executa a próxima ação
            SwingUtilities.invokeLater(onComplete);
        }).start();
    }

    /**
     * Imprime texto com efeito de digitação e som (beep) a cada espaço.
     */
    private void printSlowlyWithSoundGui(String text, long delayMillis, Color corTexto, Runnable onComplete) {
        new Thread(() -> {
            for (char c : text.toCharArray()) {
                SwingUtilities.invokeLater(() -> appendText(Character.toString(c), corTexto));

                if (c == ' ') {
                    SomInterface.playBeep();  // Toca beep ao imprimir espaços
                }

                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Fecha o som após o texto terminar e executa ação final
            SwingUtilities.invokeLater(() -> {
                SomInterface.fecharBeep();
                if (onComplete != null) {
                    onComplete.run();
                }
            });
        }).start();
    }

    /**
     * Adiciona texto na área de texto com a cor especificada.
     */
    private void appendText(String text, Color color) {
        // Pega o documento de texto da área de exibição
        StyledDocument doc = areaTexto.getStyledDocument();

        // Cria e configura o estilo de cor
        Style style = areaTexto.addStyle("CustomStyle", null);
        StyleConstants.setForeground(style, color);

        // Insere o texto com o estilo no final do documento
        try {
            doc.insertString(doc.getLength(), text, style);
        } catch (BadLocationException e) {
            e.printStackTrace(); // Em caso de erro ao inserir texto
        }
    }
}
