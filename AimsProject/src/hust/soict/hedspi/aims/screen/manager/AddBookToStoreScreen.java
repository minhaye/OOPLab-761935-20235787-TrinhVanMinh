package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.exception.AimsException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5, 2, 10, 10));

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextField();

        form.add(new JLabel("Id"));
        form.add(tfId);

        form.add(new JLabel("Title"));
        form.add(tfTitle);

        form.add(new JLabel("Category"));
        form.add(tfCategory);

        form.add(new JLabel("Cost"));
        form.add(tfCost);

        form.add(new JLabel("Authors"));
        form.add(tfAuthors);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText());
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());

                Book book = new Book(id, title, category, cost);

                String[] authors = tfAuthors.getText().split(",");
                for (String author : authors) {
                    if (!author.trim().isEmpty()) {
                        book.addAuthor(author.trim());
                    }
                }

                store.addMedia(book);

                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Id and cost must be valid numbers.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            } catch (AimsException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(form);
        center.add(btnAdd);

        return center;
    }
}
