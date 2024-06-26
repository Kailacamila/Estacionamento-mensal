package org.example.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.example.controller.ModeloController;
import org.example.controller.MovimentoController;
import org.example.controller.FuncionarioController;
import org.example.controller.MarcaController;
import org.example.controller.VeiculoController;
import org.example.model.Entity.Funcionario;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Modelo;
import org.example.model.Entity.Movimento;
import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.FuncionarioRepository;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.ModeloRepository;
import org.example.model.Repositories.MovimentoRepository;
import org.example.model.Repositories.VeiculoRepository;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.ImageIcon;

public class frame extends JFrame {

	
    private static final long serialVersionUID = 1L;
    
    private MarcaController marcaController = new MarcaController();
    private MarcaRepository marcaRepository;
    private FuncionarioController funcionarioController = new FuncionarioController();
    private FuncionarioRepository funcionarioRepository;
    private ModeloController modeloController = new ModeloController();
    private ModeloRepository modeloRepository;
    private VeiculoController veiculoController = new VeiculoController();
    private VeiculoRepository veiculoRepository;
    private MovimentoController movimentoController = new MovimentoController();
    private MovimentoRepository movimentoRepository;
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
    	 veiculoRepository = new VeiculoRepository();  
    	 modeloRepository = new ModeloRepository();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1043, 640);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
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
        JMenuItem mntmNewMenuItem_55 = new JMenuItem("excluir funcionario");
        mntmNewMenuItem_55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("excluirFuncionario");
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_55);


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
        JMenuItem mntmNewMenuItem_57 = new JMenuItem("excluir marca ");
        mntmNewMenuItem_57.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("excluirMarca");
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_57);

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
        
        JMenuItem mntmNewMenuItem_60 = new JMenuItem("excluir modelo");
        mntmNewMenuItem_60.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("excluirModelo");
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_60);
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
        
        JMenuItem mntmNewMenuItem_54 = new JMenuItem("excluir veiculo");
        mntmNewMenuItem_54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("excluirVeiculo");
            }
        });
        mnNewMenu.add(mntmNewMenuItem_54);

       

        JMenu mnNewMenu_4 = new JMenu("Gestão de movimentos");
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_16 = new JMenuItem("Listar");
        mntmNewMenuItem_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("buscarMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_16);
        
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

        JMenuItem mntmNewMenuItem_17 = new JMenuItem("Finalizar movimento");
        mntmNewMenuItem_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("finalizarMovimento");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_17);



        JMenuItem mntmNewMenuItem_20 = new JMenuItem("grafico finalizados");
        mntmNewMenuItem_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPainel("exibirGraficoMovimentosFinalizados");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_20);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);

        menuPrincipal();
        criarVeiculos();
        gestaoVeiculos();
        excluirVeiculo();
        criarFuncionario();
        gestaoFuncionarios();
        excluirFuncionario();
        criarMarcas();
        gestaoMarcas();
        excluirMarca();
        criarModelo();
        gestaoModelo();
        excluirModelo();
        buscarMovimento();
        finalizarMovimento();
        novoMovimento();
        excluirMovimento();
        exibirGraficoMovimentosFinalizados();

        cardLayout.show(contentPane, "menuPrincipal");
    }

    private void mostrarPainel(String panelName) {
        cardLayout.show(contentPane, panelName);
    }

    private void menuPrincipal() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);


    }

    private void criarVeiculos() {
      
    	  JPanel panel = new JPanel();
          panel.setBackground(new Color(128, 128, 192));
          panel.setLayout(null);

      
          
          JLabel lblNewLabel = new JLabel("Criar veiculo");
          lblNewLabel.setBackground(new Color(0, 255, 255));
          lblNewLabel.setForeground(new Color(0, 0, 0));
          lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
          lblNewLabel.setBounds(274, 11, 163, 38);
          panel.add(lblNewLabel);
        

        contentPane.add(panel, "criarVeiculos");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(153, 66, 423, 397);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblPlaca = new JLabel("Placa");
        lblPlaca.setBounds(37, 22, 136, 38);
        panel_1.add(lblPlaca);
        lblPlaca.setBackground(new Color(0, 255, 255));
        lblPlaca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        
                  JLabel lblCor = new JLabel("Cor");
                  lblCor.setBounds(37, 91, 80, 14);
                  panel_1.add(lblCor);
                  lblCor.setBackground(new Color(0, 255, 255));
                  lblCor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                  
                            JLabel lblTipo = new JLabel("Tipo");
                            lblTipo.setBounds(37, 142, 80, 14);
                            panel_1.add(lblTipo);
                            lblTipo.setBackground(new Color(0, 255, 255));
                            lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                            
                            JLabel lblAno = new JLabel("Ano");
                            lblAno.setBounds(37, 192, 45, 13);
                            panel_1.add(lblAno);
                            lblAno.setBackground(new Color(0, 255, 255));
                            lblAno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                            
                            textModelo = new JTextField();
                            textModelo.setBounds(122, 231, 210, 19);
                            panel_1.add(textModelo);
                            textModelo.setColumns(10);
                            
                            JLabel lblModelo = new JLabel("modelo_id ");
                            lblModelo.setBounds(37, 216, 119, 47);
                            panel_1.add(lblModelo);
                            lblModelo.setBackground(new Color(0, 255, 255));
                            lblModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                            
                            textPlaca = new JTextField();
                            textPlaca.setBounds(122, 33, 210, 19);
                            panel_1.add(textPlaca);
                            textPlaca.setColumns(10);
                            
                            txtCor = new JTextField();
                            txtCor.setBounds(122, 90, 210, 19);
                            panel_1.add(txtCor);
                            txtCor.setColumns(10);
                            
                            textTipo = new JTextField();
                            textTipo.setBounds(122, 141, 210, 19);
                            panel_1.add(textTipo);
                            textTipo.setColumns(10);
                            
                            textAno = new JTextField();
                            textAno.setBounds(122, 190, 210, 19);
                            panel_1.add(textAno);
                            textAno.setColumns(10);
                            
                            JButton btnLimpar = new JButton("Limpar ");
                            btnLimpar.setBackground(new Color(188, 124, 197));
                            btnLimpar.setBounds(80, 325, 85, 21);
                            panel_1.add(btnLimpar);
                            
                            JButton btnSalvar = new JButton("Salvar");
                            btnSalvar.setBackground(new Color(188, 124, 197));
                            btnSalvar.setBounds(229, 325, 85, 21);
                            panel_1.add(btnSalvar);
                            
                            JLabel lblNewLabel_1 = new JLabel("");
                            lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kayla\\Downloads\\Parking-bro (1).png"));
                            lblNewLabel_1.setBounds(552, 101, 465, 426);
                            panel.add(lblNewLabel_1);
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
    }

    private void gestaoVeiculos() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestão de Veículos");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        // Table model for vehicles
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        // Retrieve vehicles from the controller
        List<Veiculo> veiculos = veiculoController.findAll();

        // Setup table if vehicles exist
        if (!veiculos.isEmpty()) {
            String[] columnNames = {"ID", "Placa", "Cor", "Tipo", "Ano", "Modelo"};
            tableModel.setColumnIdentifiers(columnNames);

            for (Veiculo veiculo : veiculos) {
                Object[] rowData = {veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getTipo(),
                                    veiculo.getAno(), veiculo.getModeloId().getNome()};
                tableModel.addRow(rowData);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JLabel lblNoData = new JLabel("Nenhum veículo encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblNoData, BorderLayout.CENTER);
        }

       
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpa a tabela 
                tableModel.setRowCount(0);

                
                List<Veiculo> veiculosAtualizados = veiculoController.findAll();
                for (Veiculo veiculo : veiculosAtualizados) {
                    Object[] rowData = {veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getTipo(),
                                        veiculo.getAno(), veiculo.getModeloId().getNome()};
                    tableModel.addRow(rowData);
                }
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "gestaoVeiculos");
    }
    private void excluirVeiculo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Veículo");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID do Veículo:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(470, 60, 100, 20);
        panel.add(btnExcluir);

        
        List<Veiculo> veiculos = veiculoController.findAll();

       
        if (!veiculos.isEmpty()) {
            String[] columnNames = {"ID", "Placa", "Cor", "Tipo", "Ano", "Modelo"};
            Object[][] data = new Object[veiculos.size()][columnNames.length];

            for (int i = 0; i < veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i);
                data[i][0] = veiculo.getId();
                data[i][1] = veiculo.getPlaca();
                data[i][2] = veiculo.getCor();
                data[i][3] = veiculo.getTipo();
                data[i][4] = veiculo.getAno();
                data[i][5] = veiculo.getModeloId().getNome(); 
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhum veículo encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    veiculoController.deleteVeiculo(id);
                    JOptionPane.showMessageDialog(panel, "Veículo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                  
                    contentPane.remove(panel);
                    excluirVeiculo(); 
                    CardLayout cl = (CardLayout) contentPane.getLayout();
                    cl.show(contentPane, "excluirVeiculo");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao excluir veículo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

       
        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                contentPane.remove(panel);
                
                excluirVeiculo();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "excluirVeiculo");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "excluirVeiculo");
    }


    private void criarFuncionario() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 192));
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Criar Funcionário");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(200, 24, 260, 38);
        panel.add(lblNewLabel);

        contentPane.add(panel, "criarFuncionario");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(65, 73, 464, 225);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
                JLabel lblNome = new JLabel("Nome");
                lblNome.setBounds(99, 57, 80, 14);
                panel_1.add(lblNome);
                lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                
                        JLabel lblCpf = new JLabel("CPF");
                        lblCpf.setBounds(99, 91, 80, 14);
                        panel_1.add(lblCpf);
                        lblCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                        
                                JTextField textNome = new JTextField();
                                textNome.setBounds(189, 56, 142, 19);
                                panel_1.add(textNome);
                                textNome.setColumns(10);
                                
                                        JTextField textCpf = new JTextField();
                                        textCpf.setBounds(189, 90, 142, 19);
                                        panel_1.add(textCpf);
                                        textCpf.setColumns(10);
                                        
                                                JButton btnSalvar = new JButton("Salvar");
                                                btnSalvar.setBackground(new Color(188, 124, 197));
                                                btnSalvar.setBounds(262, 158, 85, 21);
                                                panel_1.add(btnSalvar);
                                                
                                                        JButton btnLimpar = new JButton("Limpar");
                                                        btnLimpar.setBackground(new Color(188, 124, 197));
                                                        btnLimpar.setBounds(129, 158, 85, 21);
                                                        panel_1.add(btnLimpar);
                                                        
                                                        JLabel lblNewLabel_2 = new JLabel("");
                                                        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Kayla\\Downloads\\Car rental-amico (1).png"));
                                                        lblNewLabel_2.setBounds(504, 69, 524, 500);
                                                        panel.add(lblNewLabel_2);
                                                btnSalvar.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        String nome = textNome.getText();
                                                        String cpf = textCpf.getText();

                                                        Funcionario novoFuncionario = new Funcionario();
                                                        novoFuncionario.setNome(nome);
                                                        novoFuncionario.setCpf(cpf);
                                                        funcionarioController.createFuncionario(novoFuncionario); 

                                                        JOptionPane.showMessageDialog(null, "Salvo!");
                                                    }
                                                });
    }

    private void gestaoFuncionarios() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestão de Funcionários");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

       
        List<Funcionario> funcionarios = funcionarioController.findAll();

        
        if (!funcionarios.isEmpty()) {
            String[] columnNames = {"ID", "Nome", "CPF"};
            tableModel.setColumnIdentifiers(columnNames);

            for (Funcionario funcionario : funcionarios) {
                Object[] rowData = {funcionario.getId(), funcionario.getNome(), funcionario.getCpf()};
                tableModel.addRow(rowData);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JLabel lblNoData = new JLabel("Nenhum funcionário encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblNoData, BorderLayout.CENTER);
        }

        
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                tableModel.setRowCount(0);

               
                List<Funcionario> funcionariosAtualizados = funcionarioController.findAll();
                for (Funcionario funcionario : funcionariosAtualizados) {
                    Object[] rowData = {funcionario.getId(), funcionario.getNome(), funcionario.getCpf()};
                    tableModel.addRow(rowData);
                }
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "gestaoFuncionarios");
    }

    private void excluirFuncionario() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Funcionário");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID do Funcionário:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(470, 60, 100, 20);
        panel.add(btnExcluir);

       
        List<Funcionario> funcionarios = funcionarioController.findAll();

      
        if (!funcionarios.isEmpty()) {
            String[] columnNames = {"ID", "Nome", "CPF"};
            Object[][] data = new Object[funcionarios.size()][columnNames.length];

            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                data[i][0] = funcionario.getId();
                data[i][1] = funcionario.getNome();
                data[i][2] = funcionario.getCpf();
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhum funcionário encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    funcionarioController.deleteFuncionario(id);
                    JOptionPane.showMessageDialog(panel, "Funcionário excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                 
                    contentPane.remove(panel);
                    excluirFuncionario(); 
                    CardLayout cl = (CardLayout) contentPane.getLayout();
                    cl.show(contentPane, "excluirFuncionario");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao excluir funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(panel);
                excluirFuncionario();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "excluirFuncionario");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "excluirFuncionario");
    }

    
    private void criarMarcas() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 192));
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Criar Marca");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(229, 23, 163, 38);
        panel.add(lblNewLabel);

        contentPane.add(panel, "criarMarcas");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(182, 72, 371, 188);
        panel.add(panel_1);
                panel_1.setLayout(null);
        
                JLabel lblNome = new JLabel("Nome");
                lblNome.setBounds(75, 53, 61, 17);
                panel_1.add(lblNome);
                lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                
                        JTextField textNome = new JTextField();
                        textNome.setBounds(146, 53, 146, 19);
                        panel_1.add(textNome);
                        textNome.setColumns(10);
                        
                                JButton btnLimpar = new JButton("Limpar");
                                btnLimpar.setBounds(70, 132, 85, 21);
                                panel_1.add(btnLimpar);
                                btnLimpar.setBackground(new Color(188, 124, 197));
                                
                                        JButton btnSalvar = new JButton("Salvar");
                                        btnSalvar.setBounds(179, 132, 85, 21);
                                        panel_1.add(btnSalvar);
                                        btnSalvar.setBackground(new Color(188, 124, 197));
                                        
                                        JLabel lblNewLabel_3 = new JLabel("l");
                                        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Kayla\\Downloads\\By my car-amico (1).png"));
                                        lblNewLabel_3.setBounds(501, 190, 506, 379);
                                        panel.add(lblNewLabel_3);
                                        btnSalvar.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                String nome = textNome.getText();

                                                Marca novaMarca = new Marca();
                                                novaMarca.setNome(nome);
                                                marcaController.createMarca(novaMarca); 

                                                JOptionPane.showMessageDialog(null, "Salvo!");
                                            }
                                        });
    }


    private void gestaoMarcas() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestão de Marcas");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        
        List<Marca> marcas = marcaController.findAll();

      
        if (!marcas.isEmpty()) {
            String[] columnNames = {"ID", "Nome"};
            tableModel.setColumnIdentifiers(columnNames);

            for (Marca marca : marcas) {
                Object[] rowData = {marca.getId(), marca.getNome()};
                tableModel.addRow(rowData);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JLabel lblNoData = new JLabel("Nenhuma marca encontrada.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblNoData, BorderLayout.CENTER);
        }

        
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                tableModel.setRowCount(0);

              
                List<Marca> marcasAtualizadas = marcaController.findAll();
                for (Marca marca : marcasAtualizadas) {
                    Object[] rowData = {marca.getId(), marca.getNome()};
                    tableModel.addRow(rowData);
                }
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "gestaoMarcas");
    }
    private void excluirMarca() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Marca");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID da Marca:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(470, 60, 100, 20);
        panel.add(btnExcluir);

       
        List<Marca> marcas = marcaController.findAll();

      
        if (!marcas.isEmpty()) {
            String[] columnNames = {"ID", "Nome"};
            Object[][] data = new Object[marcas.size()][columnNames.length];

            for (int i = 0; i < marcas.size(); i++) {
                Marca marca = marcas.get(i);
                data[i][0] = marca.getId();
                data[i][1] = marca.getNome();
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhuma marca encontrada.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    marcaController.deleteMarca(id);
                    JOptionPane.showMessageDialog(panel, "Marca excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    contentPane.remove(panel);
                    excluirMarca(); 
                    CardLayout cl = (CardLayout) contentPane.getLayout();
                    cl.show(contentPane, "excluirMarca");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao excluir marca: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(panel);
                excluirMarca();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "excluirMarca");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "excluirMarca");
    }


    private void criarModelo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 192));
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Criar Modelo");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(232, 30, 163, 38);
        panel.add(lblNewLabel);

        contentPane.add(panel, "criarModelo");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(168, 81, 393, 176);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
                JLabel lblNome = new JLabel("Nome");
                lblNome.setBounds(40, 36, 80, 14);
                panel_1.add(lblNome);
                lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                
                        JLabel lblMarcaId = new JLabel("Marca ID");
                        lblMarcaId.setBounds(40, 86, 80, 14);
                        panel_1.add(lblMarcaId);
                        lblMarcaId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                        
                                JTextField textNome = new JTextField();
                                textNome.setBounds(118, 35, 146, 19);
                                panel_1.add(textNome);
                                textNome.setColumns(10);
                                
                                        JTextField textMarcaId = new JTextField();
                                        textMarcaId.setBounds(118, 85, 146, 19);
                                        panel_1.add(textMarcaId);
                                        textMarcaId.setColumns(10);
                                        
                                                JButton btnLimpar = new JButton("Limpar");
                                                btnLimpar.setBackground(new Color(188, 124, 197));
                                                btnLimpar.setBounds(65, 132, 85, 21);
                                                panel_1.add(btnLimpar);
                                                
                                                        JButton btnSalvar = new JButton("Salvar");
                                                        btnSalvar.setBackground(new Color(188, 124, 197));
                                                        btnSalvar.setBounds(177, 132, 85, 21);
                                                        panel_1.add(btnSalvar);
                                                        
                                                        JLabel lblNewLabel_4 = new JLabel("");
                                                        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Kayla\\Downloads\\Electric car-bro (1).png"));
                                                        lblNewLabel_4.setBounds(500, 165, 533, 446);
                                                        panel.add(lblNewLabel_4);
                                                        btnSalvar.addActionListener(new ActionListener() {
                                                            public void actionPerformed(ActionEvent e) {
                                                                String nome = textNome.getText();
                                                                Long marcaId = Long.parseLong(textMarcaId.getText());

                                                                Marca marca = new Marca();
                                                                marca.setId(marcaId);

                                                                Modelo novoModelo = new Modelo();
                                                                novoModelo.setNome(nome);
                                                                novoModelo.setMarcaId(marca);
                                                                modeloController.createModelo(novoModelo); 

                                                                JOptionPane.showMessageDialog(null, "Salvo!");
                                                            }
                                                        });
    }


    private void gestaoModelo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestão de Modelos");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        List<Modelo> modelos = modeloController.findAll();

        // Setup table if models exist
        if (!modelos.isEmpty()) {
            String[] columnNames = {"ID", "Marca", "Modelo"};
            tableModel.setColumnIdentifiers(columnNames);

            for (Modelo modelo : modelos) {
                Object[] rowData = {modelo.getId(), modelo.getMarcaId().getNome(), modelo.getNome()};
                tableModel.addRow(rowData);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JLabel lblNoData = new JLabel("Nenhum modelo encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblNoData, BorderLayout.CENTER);
        }

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                List<Modelo> modelosAtualizados = modeloController.findAll();
                for (Modelo modelo : modelosAtualizados) {
                    Object[] rowData = {modelo.getId(), modelo.getMarcaId().getNome(), modelo.getNome()};
                    tableModel.addRow(rowData);
                }
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "gestaoModelo");
    }

    private void excluirModelo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Modelo");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID do Modelo:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(470, 60, 100, 20);
        panel.add(btnExcluir);

        List<Modelo> modelos = modeloController.findAll();

        if (!modelos.isEmpty()) {
            String[] columnNames = {"ID", "Marca", "Modelo"};
            Object[][] data = new Object[modelos.size()][columnNames.length];

            for (int i = 0; i < modelos.size(); i++) {
                Modelo modelo = modelos.get(i);
                data[i][0] = modelo.getId();
                data[i][1] = modelo.getMarcaId().getNome(); 
                data[i][2] = modelo.getNome();
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhum modelo encontrado.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    modeloController.deleteModelo(id);
                    JOptionPane.showMessageDialog(panel, "Modelo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    contentPane.remove(panel);
                    excluirModelo(); 
                    CardLayout cl = (CardLayout) contentPane.getLayout();
                    cl.show(contentPane, "excluirModelo");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao excluir modelo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(panel);
                excluirModelo();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "excluirModelo");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "excluirModelo");
    }

    private void buscarMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestão de Movimentações");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        List<Movimento> movimentacoes = movimentoController.findAll();

        if (!movimentacoes.isEmpty()) {
            String[] columnNames = {"ID", "Entrada", "Saída", "Tempo", "Veículo", "Funcionário", "Valor Total", "Finalizado"};
            tableModel.setColumnIdentifiers(columnNames);

            for (Movimento movimento : movimentacoes) {
                Object[] rowData = {movimento.getId(), movimento.getEntrada(), movimento.getSaida(),
                                    movimento.getTempo(), movimento.getVeiculo().getPlaca(),
                                    movimento.getFuncionario().getNome(),movimento.getValorHora(), movimento.getValorTotal(),
                                    movimento.isFinalizado() ? "Sim" : "Não"};
                tableModel.addRow(rowData);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        } else {
            JLabel lblNoData = new JLabel("Nenhuma movimentação encontrada.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(lblNoData, BorderLayout.CENTER);
        }

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                List<Movimento> movimentacoesAtualizadas = movimentoController.findAll();
                for (Movimento movimento : movimentacoesAtualizadas) {
                    Object[] rowData = {movimento.getId(), movimento.getEntrada(), movimento.getSaida(),
                                        movimento.getTempo(), movimento.getVeiculo().getPlaca(),
                                        movimento.getFuncionario().getNome(),movimento.getValorHora(), movimento.getValorTotal(),
                                        movimento.isFinalizado() ? "Sim" : "Não"};
                    tableModel.addRow(rowData);
                }
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "buscarMovimento");
    }


    private void finalizarMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Finalizar Movimento");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID da Movimentação:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBounds(470, 60, 100, 20);
        panel.add(btnFinalizar);

        List<Movimento> movimentacoes = movimentoController.findAll();

        if (!movimentacoes.isEmpty()) {
            String[] columnNames = {"ID", "Entrada", "Saída", "Tempo", "Veículo", "Funcionário", "Valor Total", "Finalizado"};
            Object[][] data = new Object[movimentacoes.size()][columnNames.length];

            for (int i = 0; i < movimentacoes.size(); i++) {
                Movimento movimento = movimentacoes.get(i);
                data[i][0] = movimento.getId();
                data[i][1] = movimento.getEntrada();
                data[i][2] = movimento.getSaida();
                data[i][3] = movimento.getTempo();
                data[i][4] = movimento.getVeiculo().getPlaca(); 
                data[i][5] = movimento.getFuncionario().getNome(); 
                data[i][6] = movimento.getValorHora();
                data[i][6] = movimento.getValorTotal();
                data[i][7] = movimento.isFinalizado() ? "Sim" : "Não";
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhuma movimentação encontrada.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    Movimento movimento = movimentoController.finalizarMovimento(id);
                    if (movimento != null) {
                        JOptionPane.showMessageDialog(panel, "Movimentação finalizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        contentPane.remove(panel);
                        finalizarMovimento(); 
                        CardLayout cl = (CardLayout) contentPane.getLayout();
                        cl.show(contentPane, "finalizarMovimento");
                    } else {
                        JOptionPane.showMessageDialog(panel, "Movimentação não encontrada ou já finalizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(panel);
                finalizarMovimento();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "finalizarMovimento");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "finalizarMovimento");
    }


    private void novoMovimento() {
    	 JPanel panel = new JPanel();
    	    panel.setBackground(new Color(128, 128, 192));
    	    panel.setLayout(null);

    	    JLabel lblNewLabel = new JLabel("Criar Movimento");
    	    lblNewLabel.setForeground(new Color(0, 0, 0));
    	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
    	    lblNewLabel.setBounds(225, 30, 234, 38);
    	    panel.add(lblNewLabel);

    	    contentPane.add(panel, "novoMovimento");
    	    
    	    JPanel panel_1 = new JPanel();
    	    panel_1.setBackground(new Color(255, 255, 255));
    	    panel_1.setBounds(89, 79, 419, 228);
    	    panel.add(panel_1);
    	    panel_1.setLayout(null);
    	    
    	        	    JLabel lblEntrada = new JLabel("Entrada");
    	        	    lblEntrada.setBounds(54, 24, 80, 14);
    	        	    panel_1.add(lblEntrada);
    	        	    lblEntrada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    	        	    
    	        	        	    JLabel lblVeiculoId = new JLabel("Veículo ID");
    	        	        	    lblVeiculoId.setBounds(54, 57, 80, 14);
    	        	        	    panel_1.add(lblVeiculoId);
    	        	        	    lblVeiculoId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    	        	        	    
    	        	        	        	    JLabel lblFuncionarioId = new JLabel("Funcionário ID");
    	        	        	        	    lblFuncionarioId.setBounds(50, 97, 100, 14);
    	        	        	        	    panel_1.add(lblFuncionarioId);
    	        	        	        	    lblFuncionarioId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    	        	        	        	    
    	        	        	        	    
    	        	        	        	        	    JLabel lblValorHora = new JLabel("Valor Hora");
    	        	        	        	        	    lblValorHora.setBounds(54, 133, 80, 14);
    	        	        	        	        	    panel_1.add(lblValorHora);
    	        	        	        	        	    lblValorHora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    	        	        	        	        	    
    	        	        	        	        	        	    JButton btnSalvar = new JButton("Salvar");
    	        	        	        	        	        	    btnSalvar.setBackground(new Color(188, 124, 197));
    	        	        	        	        	        	    btnSalvar.setBounds(115, 196, 85, 21);
    	        	        	        	        	        	    panel_1.add(btnSalvar);
    	        	        	        	        	        	    
    	        	        	        	        	        	        	    JButton btnLimpar = new JButton("Limpar");
    	        	        	        	        	        	        	    btnLimpar.setBackground(new Color(188, 124, 197));
    	        	        	        	        	        	        	    btnLimpar.setBounds(235, 196, 85, 21);
    	        	        	        	        	        	        	    panel_1.add(btnLimpar);
    	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	    JTextField textEntrada = new JTextField();
    	        	        	        	        	        	        	        	    textEntrada.setBounds(211, 38, 96, 19);
    	        	        	        	        	        	        	        	    panel_1.add(textEntrada);
    	        	        	        	        	        	        	        	    textEntrada.setColumns(10);
    	        	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	        	    JTextField textVeiculoId = new JTextField();
    	        	        	        	        	        	        	        	        	    textVeiculoId.setBounds(211, 68, 96, 19);
    	        	        	        	        	        	        	        	        	    panel_1.add(textVeiculoId);
    	        	        	        	        	        	        	        	        	    textVeiculoId.setColumns(10);
    	        	        	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	        	        	    JTextField textFuncionarioId = new JTextField();
    	        	        	        	        	        	        	        	        	        	    textFuncionarioId.setBounds(211, 98, 96, 19);
    	        	        	        	        	        	        	        	        	        	    panel_1.add(textFuncionarioId);
    	        	        	        	        	        	        	        	        	        	    textFuncionarioId.setColumns(10);
    	        	        	        	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	        	        	        	    JTextField textValorHora = new JTextField();
    	        	        	        	        	        	        	        	        	        	        	    textValorHora.setBounds(211, 128, 96, 19);
    	        	        	        	        	        	        	        	        	        	        	    panel_1.add(textValorHora);
    	        	        	        	        	        	        	        	        	        	        	    textValorHora.setColumns(10);
    	        	        	        	        	        	        	        	        	        	        	    
    	        	        	        	        	        	        	        	        	        	        	    JLabel lblNewLabel_5 = new JLabel("");
    	        	        	        	        	        	        	        	        	        	        	    lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Kayla\\Downloads\\Parking-amico (1) (1).png"));
    	        	        	        	        	        	        	        	        	        	        	    lblNewLabel_5.setBounds(493, 11, 548, 547);
    	        	        	        	        	        	        	        	        	        	        	    panel.add(lblNewLabel_5);
    	        	        	        	        	        	    btnSalvar.addActionListener(new ActionListener() {
    	        	        	        	        	        	        public void actionPerformed(ActionEvent e) {
    	        	        	        	        	        	            try {
    	        	        	        	        	        	                LocalTime entrada = LocalTime.parse(textEntrada.getText());
    	        	        	        	        	        	                BigDecimal valorHora = textValorHora.getText().isEmpty() ? null : new BigDecimal(textValorHora.getText());

    	        	        	        	        	        	                Long veiculoId = Long.parseLong(textVeiculoId.getText());
    	        	        	        	        	        	                Long funcionarioId = Long.parseLong(textFuncionarioId.getText());

    	        	        	        	        	        	                Veiculo veiculo = new Veiculo();
    	        	        	        	        	        	                veiculo.setId(veiculoId);

    	        	        	        	        	        	                Funcionario funcionario = new Funcionario();
    	        	        	        	        	        	                funcionario.setId(funcionarioId);

    	        	        	        	        	        	                Movimento novoMovimento = new Movimento();
    	        	        	        	        	        	                novoMovimento.setEntrada(entrada);
    	        	        	        	        	        	                novoMovimento.setVeiculo(veiculo);
    	        	        	        	        	        	                novoMovimento.setFuncionario(funcionario);
    	        	        	        	        	        	                novoMovimento.setValorHora(valorHora);

    	        	        	        	        	        	                movimentoController.createMovimento(novoMovimento);

    	        	        	        	        	        	                JOptionPane.showMessageDialog(null, "Salvo!");
    	        	        	        	        	        	            } catch (Exception ex) {
    	        	        	        	        	        	                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
    	        	        	        	        	        	            }
    	        	        	        	        	        	        }
    	        	        	        	        	        	    });
    	}
    private void excluirMovimento() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Excluir Movimento");
        lblTitulo.setBounds(280, 20, 200, 14);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo);

        JLabel lblId = new JLabel("ID da Movimentação:");
        lblId.setBounds(150, 60, 150, 20);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(300, 60, 150, 20);
        panel.add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(470, 60, 100, 20);
        panel.add(btnExcluir);

        List<Movimento> movimentacoes = movimentoController.findAll();

        if (!movimentacoes.isEmpty()) {
            String[] columnNames = {"ID", "Entrada", "Saída", "Tempo", "Veículo", "Funcionário", "Valor Total", "Finalizado"};
            Object[][] data = new Object[movimentacoes.size()][columnNames.length];

            for (int i = 0; i < movimentacoes.size(); i++) {
                Movimento movimento = movimentacoes.get(i);
                data[i][0] = movimento.getId();
                data[i][1] = movimento.getEntrada();
                data[i][2] = movimento.getSaida();
                data[i][3] = movimento.getTempo();
                data[i][4] = movimento.getVeiculo().getPlaca(); 
                data[i][5] = movimento.getFuncionario().getNome(); 
                data[i][6] = movimento.getValorTotal();
                data[i][7] = movimento.isFinalizado() ? "Sim" : "Não";
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 100, 700, 400);
            panel.add(scrollPane);
        } else {
            JLabel lblNoData = new JLabel("Nenhuma movimentação encontrada.");
            lblNoData.setHorizontalAlignment(SwingConstants.CENTER);
            lblNoData.setBounds(50, 100, 700, 400);
            panel.add(lblNoData);
        }

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(txtId.getText());
                    movimentoController.deleteMovimento(id);
                    JOptionPane.showMessageDialog(panel, "Movimentação excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    contentPane.remove(panel);
                    excluirMovimento(); 
                    CardLayout cl = (CardLayout) contentPane.getLayout();
                    cl.show(contentPane, "excluirMovimento");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao excluir movimentação: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnAtualizar = new JButton("Atualizar Tabela");
        btnAtualizar.setBounds(50, 520, 150, 20);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(panel);
                excluirMovimento();
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.show(contentPane, "excluirMovimento");
            }
        });
        panel.add(btnAtualizar);

        contentPane.add(panel, "excluirMovimento");
    }

    public void exibirGraficoMovimentosFinalizados() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gráfico de Movimentos Finalizados");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Finalizados", 0);
        dataset.setValue("Não Finalizados", 0);

        JFreeChart chart = ChartFactory.createPieChart(
                "Movimentos Finalizados",
                dataset,
                true, 
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("Tahoma", Font.PLAIN, 12));
        plot.setNoDataMessage("Sem dados disponíveis");

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        chartPanel.setMouseWheelEnabled(true);

        panel.add(chartPanel, BorderLayout.CENTER);

        JButton btnAtualizar = new JButton("Atualizar Gráfico");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movimento> movimentos = movimentoController.findAll();
                int finalizados = 0;
                int naoFinalizados = 0;

                for (Movimento movimento : movimentos) {
                    if (movimento.isFinalizado()) {
                        finalizados++;
                    } else {
                        naoFinalizados++;
                    }
                }

                dataset.setValue("Finalizados", finalizados);
                dataset.setValue("Não Finalizados", naoFinalizados);

                plot.setDataset(dataset);
                plot.setNoDataMessage("Sem dados disponíveis");
            }
        });
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        contentPane.add(panel, "exibirGraficoMovimentosFinalizados");
        CardLayout cl = (CardLayout) contentPane.getLayout();
        cl.show(contentPane, "exibirGraficoMovimentosFinalizados");
    }
}