package mx.hackaton02.pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContactTableApp extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nameField;
    private JLabel statusLabel;

    // AHORA ESTE VALOR ES DINÁMICO
    private int maxContacts;

    // El constructor ahora recibe el tamaño "limit"
    public ContactTableApp() {

        setTitle("Tu Agenda");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- CONFIGURACIÓN DE TABLA ---
        String[] columnNames = {"Nombre de contacto", "Modificar", "Borrar"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column > 0;
            }
        };

        table = new JTable(tableModel);
        table.setRowHeight(35);
        table.getTableHeader().setReorderingAllowed(false);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // --- PANEL SUPERIOR ---
        JPanel inputPanel = new JPanel(new FlowLayout());
        // inputPanel.add(new JLabel("Nuevo nombre de contacto:"));
        nameField = new JTextField(20);
        JButton btnAdd = new JButton("Agregar Contacto");

        // inputPanel.add(nameField);
        inputPanel.add(btnAdd);
        add(inputPanel, BorderLayout.NORTH);

        // --- BARRA DE ESTADO ---
        statusLabel = new JLabel("Welcome");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statusLabel, BorderLayout.SOUTH);

        // --- LÓGICA AGREGAR ---
        btnAdd.addActionListener(e -> {
            new ContactForm().setVisible(true);
        });

        updateStatus();
    }

    private void updateStatus() {

    }

}