package ui;

import model.Person;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;
    private PersonTableListener personTableListener;

    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JMenuItem removeItem = new JMenuItem("Remove Item");
        popup.add(removeItem);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                ListSelectionModel selectionModel = table.getSelectionModel();
                selectionModel.setSelectionInterval(row, row);

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (personTableListener != null) {
                    personTableListener.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
        });

    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }
    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void addPersonTableListener(PersonTableListener listener) {
        this.personTableListener = listener;
    }

}
