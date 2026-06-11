package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.exception.AimsException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(7, 2, 10, 10));

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();
        tfArtist = new JTextField();

        form.add(new JLabel("Id"));
        form.add(tfId);

        form.add(new JLabel("Title"));
        form.add(tfTitle);

        form.add(new JLabel("Category"));
        form.add(tfCategory);

        form.add(new JLabel("Director"));
        form.add(tfDirector);

        form.add(new JLabel("Length"));
        form.add(tfLength);

        form.add(new JLabel("Cost"));
        form.add(tfCost);

        form.add(new JLabel("Artist"));
        form.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
                String artist = tfArtist.getText();

                CompactDisc cd = new CompactDisc(id, title, category, cost, length, director, artist);

                store.addMedia(cd);

                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Id, length and cost must be valid numbers.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            } catch (AimsException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(form);
        center.add(btnAdd);

        return center;
    }
}
