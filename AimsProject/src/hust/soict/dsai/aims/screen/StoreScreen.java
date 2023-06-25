package hust.soict.dsai.aims.screen;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart = new Cart();
	
	JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new menuListener());
        smUpdateStore.add(addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new menuListener());
        smUpdateStore.add(addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new menuListener());
        smUpdateStore.add(addDVD);


        menu.add(smUpdateStore);
        JMenuItem viewStoreOpt = new JMenuItem("View Store");
        viewStoreOpt.addActionListener(new menuListener());
        menu.add(viewStoreOpt);
        JMenuItem viewCartOpt = new JMenuItem("View Cart");
        viewCartOpt.addActionListener(new menuListener());
        menu.add(viewCartOpt);


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
        title.setForeground(Color.GREEN);

        JButton cart = new JButton("View Cart");
        cart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Frame frame : Frame.getFrames()) {
                            frame.setVisible(frame.getTitle().equals("Cart"));
                        }
                    }
                }
        );
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    public class menuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            if (menu.equals("View Cart")) {
                for (Frame frame : Frame.getFrames()) {
                    frame.setVisible(frame.getTitle().equals("Cart"));
                }
            } else if (menu.equals("Add Book")) {
                for (Frame frame : Frame.getFrames()) {
                    frame.setVisible(frame.getTitle().equals("Add Book To Store"));
                }
            } else if (menu.equals("Add CD")) {
                for (Frame frame : Frame.getFrames()) {
                    frame.setVisible(frame.getTitle().equals("Add CD To Store"));
                }
            } else if (menu.equals("Add DVD")) {
                for (Frame frame : Frame.getFrames()) {
                    frame.setVisible(frame.getTitle().equals("Add DVD To Store"));
                }
            }
        }
    }
    
    JPanel createCenter()
    {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++)
        {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart)
    {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        store.getItemsInStore().addListener(
//                new ListChangeListener<Media>() {
//                    @Override
//                    public void onChanged(Change<? extends Media> change) {
//                        BorderLayout layout = (BorderLayout)cp.getLayout();
//                        cp.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//                        cp.add(createCenter(),BorderLayout.CENTER);
//                        cp.repaint();
//                        cp.revalidate();
//                    }
//                }
//        );
        
        
    }
    
    public static void main(String[] args) {
    	Store store = new Store();
        Cart cart = new Cart();
        
        List<Track> tracks = new ArrayList<Track>();
        Track track1 = new Track("Track 1", 24);
        Track track2 = new Track("Track 2", 16);
        tracks.add(track1);
        tracks.add(track2);

        Media cd = new CompactDisc("hello world", "hard movie", "NDT", 32, 29.3f, tracks);

        List<String> authors = new ArrayList<>();
        authors.add("John Wohleben");
        authors.add("Osho");
        Media book1 = new Book("The hidden life of trees", "Science", 15.6f, authors);
        Book book2 = new Book("The midnight library", "Literature", 9.13f);

        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.45f);
        Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        store.addMedia(cd);                                            
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);

        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        new StoreScreen(store, cart);
	}
}
