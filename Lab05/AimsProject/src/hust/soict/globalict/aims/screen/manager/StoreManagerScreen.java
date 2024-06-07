package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen{
    private Store store;
    private JFrame newFrame;

    public StoreManagerScreen(Store store) {
        this.store = store;
        newFrame = new JFrame();
        Container cp = newFrame.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        newFrame.setTitle("Store");
        newFrame.setSize(1024, 768);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(new viewListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem firstOption = new JMenuItem("Add Book");
        firstOption.addActionListener(new updateListener());
        JMenuItem secondOption = new JMenuItem("Add CD");
        secondOption.addActionListener(new updateListener());
        JMenuItem thirdOption = new JMenuItem("Add DVD");
        thirdOption.addActionListener(new updateListener());

        smUpdateStore.add(viewStore);
        smUpdateStore.add(firstOption);
        smUpdateStore.add(secondOption);
        smUpdateStore.add(thirdOption);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int size = mediaInStore.size();
        for(int i = 0; i < 9; i++) {
            if(i < size) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else break;
        }

        return center;
    }

    public static void main(String[] args) {
        //
    }

    private class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(newFrame != null) {
                newFrame.dispose();
            }

            newFrame = new JFrame();
            Container cp = newFrame.getContentPane();
            cp.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(createMenuBar(), BorderLayout.NORTH);
            panel.add(newHeader(), BorderLayout.CENTER);
            cp.add(panel, BorderLayout.NORTH);

            String command = e.getActionCommand();
            int number = switch (command) {
                case "Add Book":
                    yield 5;
                case "Add CD" :
                    yield 8;
                case "Add DVD":
                    yield 6;
                default:
                    yield 0;
            };

            cp.add(newForm(number), BorderLayout.CENTER);

            newFrame.setTitle("Update");
            newFrame.setSize(1024, 768);
            newFrame.setLocationRelativeTo(null);
            newFrame.setVisible(true);
        }
        JPanel newHeader() {
            JPanel header = new JPanel();
            header.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel title = new JLabel("INPUT MEDIA");
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
            title.setForeground(Color.orange);
            header.add(title);
            return header;
        }

        JPanel newForm(int number) {
            switch (number) {
                case 5:
                    CreateBookField book = new CreateBookField(store);
                    return book.newForm(number);
                case 8:
                    CreateCDField cd = new CreateCDField(store);
                    return cd.newForm(5);
                case 6:
                    CreateDVDField dvd = new CreateDVDField(store);
                    return dvd.newForm(number);
                default:
                    return null;
            }
        }
    }

    private class viewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(newFrame != null) {
                newFrame.dispose();
            }
            newFrame = new JFrame();
            Container cp = newFrame.getContentPane();
            cp.setLayout(new BorderLayout());
            cp.add(createNorth(), BorderLayout.NORTH);
            cp.add(createCenter(), BorderLayout.CENTER);

            newFrame.setTitle("Store");
            newFrame.setSize(1024, 768);
            newFrame.setLocationRelativeTo(null);
            newFrame.setVisible(true);
        }
    }
}
