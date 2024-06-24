package org.example.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.example.controller.VeiculoController;
import org.example.model.Entity.Modelo;
import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.ModeloRepository;
import org.example.model.Repositories.VeiculoRepository;

public class frame extends JFrame {

	
    private static final long serialVersionUID = 1L;
    
    
    private VeiculoController veiculoController = new VeiculoController();
    private VeiculoRepository veiculoRepository;
    private ModeloRepository modeloRepository = new ModeloRepository();
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JTextField textPlaca;
    private JTextField txtCor;
    private JTextField textTipo;
    private JTextField textAno;
    private JTextField textModelo;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame frame = new frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public frame() {
    	
    	veiculoController = new VeiculoController();  
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1043, 640);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Gestão de veículos");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("criar");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("criarVeiculos");
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("gestão");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("gestaoVeiculos");
            }
        });
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenu mnNewMenu_1 = new JMenu("Gestão de funcionários");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("criar");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("criarFuncionario");
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("gestão");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("gestaoFuncionarios");
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_7);

        JMenu mnNewMenu_2 = new JMenu("Gestão de marcas");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("criar");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("criarMarcas");
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_10);

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("gestão ");
        mntmNewMenuItem_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("gestaoMarcas");
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_11);

        JMenu mnNewMenu_3 = new JMenu("Gestão de modelos");
        menuBar.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_12 = new JMenuItem("criar");
        mntmNewMenuItem_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("criarModelo");
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_12);

        JMenuItem mntmNewMenuItem_15 = new JMenuItem("gestão");
        mntmNewMenuItem_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("gestaoModelo");
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_15);

        JMenu mnNewMenu_4 = new JMenu("Gestão de movimentos");
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_16 = new JMenuItem("Buscar movimento pelo ID");
        mntmNewMenuItem_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("buscarMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_16);

        JMenuItem mntmNewMenuItem_17 = new JMenuItem("Editar movimento");
        mntmNewMenuItem_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("editarMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_17);

        JMenuItem mntmNewMenuItem_18 = new JMenuItem("Novo movimento");
        mntmNewMenuItem_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("novoMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_18);

        JMenuItem mntmNewMenuItem_19 = new JMenuItem("Excluir movimento");
        mntmNewMenuItem_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("excluirMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_19);

        JMenu mnNewMenu_5 = new JMenu("Sair");
        menuBar.add(mnNewMenu_5);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);

        menuPrincipal();
        criarVeiculos();
        gestaoVeiculos();
        criarFuncionario();
        gestaoFuncionarios();
        criarMarcas();
        gestaoMarcas();
        criarModelo();
        gestaoModelo();
        buscarMovimento();
        editarMovimento();
        novoMovimento();
        excluirMovimento();

        cardLayout.show(contentPane, "menuPrincipal");
    }

    private void mostrarPainel(String panelName) {
        cardLayout.show(contentPane, panelName);
    }

    private void menuPrincipal() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Criar Veículos");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);
        contentPane.add(panel, "menuPrincipal");
    }

    private void criarVeiculos() {
      
    	  JPanel panel = new JPanel();
          panel.setBackground(new Color(128, 128, 192));
          panel.setLayout(null);

          JLabel lblCor = new JLabel("Cor");
          lblCor.setBackground(new Color(0, 255, 255));
          lblCor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblCor.setBounds(317, 121, 80, 14);
          panel.add(lblCor);

          JLabel lblTipo = new JLabel("Tipo");
          lblTipo.setBackground(new Color(0, 255, 255));
          lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblTipo.setBounds(317, 164, 80, 14);
          panel.add(lblTipo);

      
          
          JLabel lblNewLabel = new JLabel("Criar veiculo");
          lblNewLabel.setBackground(new Color(0, 255, 255));
          lblNewLabel.setForeground(new Color(0, 0, 0));
          lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblNewLabel.setBounds(361, 25, 163, 38);
          panel.add(lblNewLabel);
          
          JLabel lblPlaca = new JLabel("Placa");
          lblPlaca.setBackground(new Color(0, 255, 255));
          lblPlaca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblPlaca.setBounds(309, 73, 136, 38);
          panel.add(lblPlaca);
          
          JLabel lblAno = new JLabel("Ano");
          lblAno.setBackground(new Color(0, 255, 255));
          lblAno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblAno.setBounds(320, 214, 45, 13);
          panel.add(lblAno);
          
          JLabel lblModelo = new JLabel("modelo_id ");
          lblModelo.setBackground(new Color(0, 255, 255));
          lblModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
          lblModelo.setBounds(311, 237, 119, 47);
          panel.add(lblModelo);
          
          textPlaca = new JTextField();
          textPlaca.setBounds(384, 85, 96, 19);
          panel.add(textPlaca);
          textPlaca.setColumns(10);
          
          txtCor = new JTextField();
          txtCor.setColumns(10);
          txtCor.setBounds(384, 121, 96, 19);
          panel.add(txtCor);
          
          textTipo = new JTextField();
          textTipo.setColumns(10);
          textTipo.setBounds(384, 164, 96, 19);
          panel.add(textTipo);
          
          textAno = new JTextField();
          textAno.setColumns(10);
          textAno.setBounds(384, 213, 96, 19);
          panel.add(textAno);
          
          textModelo = new JTextField();
          textModelo.setColumns(10);
          textModelo.setBounds(396, 253, 96, 19);
          panel.add(textModelo);
          
          JButton btnSalvar = new JButton("Salvar");
          btnSalvar.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  String placa = textPlaca.getText();
                  String cor = txtCor.getText();
                  String tipo = textTipo.getText();
                  int ano = Integer.parseInt(textAno.getText());
                  Modelo modeloInBd = new Modelo();
                  modeloInBd.setId(Long.parseLong(textModelo.getText()));
                  Modelo modelo = (Modelo) modeloRepository.findById(modeloInBd);
                  System.out.println(modelo.getId());
                  
                  

                  Veiculo novoVeiculo = new Veiculo();
                  novoVeiculo.setPlaca(placa);
                  novoVeiculo.setCor(cor);
                  novoVeiculo.setTipo(tipo);
                  novoVeiculo.setAno(ano);
                  novoVeiculo.setModeloId(modelo);
                  veiculoController.createVeiculo(novoVeiculo);
                  
//                  try {
//                	  if(!em.getTransaction().isActive()) {
//                		  veiculoController.createVeiculo(novoVeiculo);
//                		  JOptionPane.showMessageDialog(null, "Salvo !!");
//                	  }
//                	  
//                  }catch (Exception ex) {
//                	  
//                	  ex.printStackTrace(); 
//                	  
//                      if (em.getTransaction().isActive()) {
//                          em.getTransaction().rollback();
//                      }
//                      
//                      JOptionPane.showMessageDialog(null, "Error !!");
//				}
                  
                  
                 
              }
          });
          btnSalvar.setBounds(361, 375, 85, 21);
          panel.add(btnSalvar);
          
          JButton btnLimpar = new JButton("Limpar ");
          btnLimpar.setBounds(252, 375, 85, 21);
          panel.add(btnLimpar);
        

        contentPane.add(panel, "criarVeiculos");
    }

    private void gestaoVeiculos() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestão de Veículos");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "gestaoVeiculos");
    }

    private void criarFuncionario() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Criar Funcionário");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "criarFuncionario");
    }

    private void gestaoFuncionarios() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestão de Funcionários");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "gestaoFuncionarios");
    }

    
    private void criarMarcas() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Criar Marcas");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "criarMarcas");
    }

    private void gestaoMarcas() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestão de Marcas");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "gestaoMarcas");
    }

    private void criarModelo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Criar Modelos");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "criarModelo");
    }

    private void gestaoModelo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestão de Modelos");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "gestaoModelo");
    }

    private void buscarMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Buscar Movimento");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "buscarMovimento");
    }

    private void editarMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Editar Movimento");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);
        
        

        contentPane.add(panel, "editarMovimento");
    }

    private void novoMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Novo Movimento");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "novoMovimento");
    }

    private void excluirMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Movimento");
        lblTitulo.setBounds(280, 150, 150, 14);
        panel.add(lblTitulo);

        contentPane.add(panel, "excluirMovimento");
    }
}
