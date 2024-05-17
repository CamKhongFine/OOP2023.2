package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new playListener()); // Add action listener to the play button
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class playListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (media instanceof Playable) {

                JDialog dialog = new JDialog();
                dialog.setTitle("Playing Media");
                dialog.setSize(400, 300);
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JLabel titleLabel = new JLabel(media.getTitle());
                titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                dialog.add(titleLabel, BorderLayout.NORTH);

                JLabel infoLabel = new JLabel(media.getTitle() + " are playing");
                infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                dialog.add(infoLabel, BorderLayout.CENTER);

                dialog.setVisible(true);

                ((Playable) media).play();
            }
        }
    }
}
