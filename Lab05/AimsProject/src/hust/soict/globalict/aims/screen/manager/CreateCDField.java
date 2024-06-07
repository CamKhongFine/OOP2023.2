package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCDField {
    private JTextField[] textFields;
    private Store store;

    public CreateCDField(Store store) {
        this.store = store;
    }

    JPanel newForm(int number) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        textFields = new JTextField[number];
        String[] labels = {"Id: ", "Title: ", "Category: ", "Cost: ", "Artist: "};

        for (int i = 0; i < number; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            textFields[i] = new JTextField(20);
            formPanel.add(textFields[i], gbc);
        }

        panel.add(formPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new saveInfo());
        panel.add(submitButton, BorderLayout.SOUTH);

        return panel;
    }

    private class inputListener implements ActionListener {
        private JDialog inform;

        @Override
        public void actionPerformed(ActionEvent e) {
            showDialog("Input Recognized!");
        }
    }

    private class errorListener implements ActionListener {
        private JDialog inform;

        @Override
        public void actionPerformed(ActionEvent e) {
            showDialog("Error, enter again!");
        }
    }

    private void showDialog(String message) {
        JDialog inform = new JDialog();
        inform.setLayout(new GridBagLayout());

        JLabel informLabel = new JLabel(message);
        informLabel.setFont(new Font(informLabel.getFont().getName(), Font.PLAIN, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        inform.add(informLabel, gbc);

        inform.setSize(200, 150);
        inform.setLocationRelativeTo(null);
        inform.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Create CD Form");
        Store store = new Store();
        CreateCDField createCDField = new CreateCDField(store);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.add(createCDField.newForm(5));
        frame.setVisible(true);
    }

    private class saveInfo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(textFields[0].getText());
                String title = textFields[1].getText();
                String category = textFields[2].getText();
                float cost = Float.parseFloat(textFields[3].getText());
                String artist = textFields[4].getText();

                CompactDisc CD = new CompactDisc(id, title, category, cost, "", artist);

                if (store != null) {
                    store.addMedia(CD);
                    new inputListener().actionPerformed(e);
                } else {
                    throw new NullPointerException("Store is not initialized.");
                }
            } catch (NumberFormatException ex) {
                new errorListener().actionPerformed(e);
            } catch (NullPointerException ex) {
                new errorListener().actionPerformed(e);
                System.err.println(ex.getMessage());
            }
        }
    }
}
