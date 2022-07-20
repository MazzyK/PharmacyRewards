import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Application extends JFrame {

    private static final long serialVersionUID = 6064645374769883647L;

    private JTextField idTextField;
    private JTextField titleTextField;
    private JTextField fnameTextField;
    private JTextField snameTextField;
    private JTextField emailTextField;
    private JTextField mobileTextField;
    private JTextField pointsTextField;
    private JTextField creditTextField;
    private JTextField skuTextField;
    private JTextField pnameTextField;
    private JTextField priceTextField;
    private JTextField companyTextField;

    private DefaultListModel<Contact> contactsListModel;
    private DefaultListModel<Product> productsListModel;
    private JList<Contact> contactsList;
    private JList<Product> productsList;

    // private AbstractAction refreshAction;
    private Action refreshAction;
    private Action newAction;
    private Action saveAction;
    private Action deleteAction;
    private Action displaylogoAction;
    private Action saleAction;

    private Contact selected;
    private Product pselected;

    public Application() {
        initActions();
        initComponents();
        refreshData();

    }

    private JComponent createEditor() {

        final JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        // Customer information title
        constraints.gridy = 1;
        panel.add(new JLabel("Selected customer"), constraints);

        // id

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.gridy = 2;
        panel.add(new JLabel("Id"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        idTextField = new JTextField();
        idTextField.setEditable(false);
        panel.add(idTextField, constraints);

        // Title

        constraints = new GridBagConstraints();
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Title"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        titleTextField = new JTextField();
        panel.add(titleTextField, constraints);

        // First name

        constraints = new GridBagConstraints();
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("FirstName"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        fnameTextField = new JTextField();
        panel.add(fnameTextField, constraints);

        // Surname
        constraints = new GridBagConstraints();
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Surname"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        snameTextField = new JTextField();
        panel.add(snameTextField, constraints);

        // Email

        constraints = new GridBagConstraints();
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Email"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        emailTextField = new JTextField();
        panel.add(emailTextField, constraints);

        // Mobile

        constraints = new GridBagConstraints();
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Mobile"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        mobileTextField = new JTextField();
        panel.add(mobileTextField, constraints);

        // Points

        constraints = new GridBagConstraints();
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Points"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        pointsTextField = new JTextField();
        panel.add(pointsTextField, constraints);

        // Credits

        constraints = new GridBagConstraints();
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Credit €"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        creditTextField = new JTextField();
        panel.add(creditTextField, constraints);

        // Product information title

        constraints = new GridBagConstraints();
        constraints.gridy = 10;
        panel.add(new JLabel("Selected product"), constraints);

        // SKU

        constraints = new GridBagConstraints();
        constraints.gridy = 11;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Product ID"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 11;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        skuTextField = new JTextField();
        skuTextField.setEditable(false);
        panel.add(skuTextField, constraints);

        // Product Name

        constraints = new GridBagConstraints();
        constraints.gridy = 12;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Product"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 12;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        pnameTextField = new JTextField();
        pnameTextField.setEditable(false);
        panel.add(pnameTextField, constraints);

        // Price

        constraints = new GridBagConstraints();
        constraints.gridy = 13;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Price €"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 13;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        priceTextField = new JTextField();
        priceTextField.setEditable(false);
        panel.add(priceTextField, constraints);

        // Company

        constraints = new GridBagConstraints();
        constraints.gridy = 14;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        panel.add(new JLabel("Company"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 14;
        constraints.weightx = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        companyTextField = new JTextField();
        companyTextField.setEditable(false);
        panel.add(companyTextField, constraints);

        return panel;
    }

    private JComponent createListPane() {

        contactsListModel = new DefaultListModel<>();
        contactsList = new JList<>(contactsListModel);
        contactsList.setPreferredSize(new Dimension(150, 400));
        contactsList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    // Contact selected = contactsList.getSelectedValue();
                    setSelectedContact(contactsList.getSelectedValue());
                }
            }

        });
        return new JScrollPane(contactsList);
    }

    private JComponent createSaleListPane() {

        productsListModel = new DefaultListModel<>();
        productsList = new JList<>(productsListModel);
        productsList.setPreferredSize(new Dimension(150, 400));
        productsList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    // Product pselected = productsList.getSelectedValue();
                    setSelectedProduct(productsList.getSelectedValue());
                }
            }

        });
        return new JScrollPane(productsList);
    }

    private void createNew() {

        final Contact contact = new Contact();
        contact.setTitle("New title");
        contact.setFname("New name");
        contact.setSname("New surname");
        contact.setEmail("New email");
        contact.setMobile("New mobile");
        contact.setPoints(20);
        contact.setCredit(0);
        setSelectedContact(contact);

    }

    private JToolBar createToolBar() {
        final JToolBar toolBar = new JToolBar();
        toolBar.add(displaylogoAction);
        toolBar.add(refreshAction);
        toolBar.add(newAction);
        toolBar.add(saveAction);
        toolBar.add(deleteAction);
        toolBar.add(saleAction);

        return toolBar;

    }

    private void delete() {
        if (selected != null) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Delete?", "Delete",
                    JOptionPane.YES_NO_OPTION)) {
                try {
                    selected.delete();
                } catch (final SQLException e) {
                    JOptionPane.showMessageDialog(this, "Failed to delete the selected contact", "Delete",
                            JOptionPane.WARNING_MESSAGE);
                } finally {
                    setSelectedContact(null);
                    refreshData();
                }
            }
        }
    }

    public float calculateCost(String sku) {
        final String sql = ("SELECT Price FROM product where SKU ='" + sku + "'");
        ResultSet rs;
        float cost = 0;
        try {
            Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                cost = rs.getFloat(1);
                System.out.println("Calculating cost");
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }

        return cost;
    }

    public int calculatePoints(int cid) {
        final String sql = ("SELECT points FROM customer where CustomerID =" + cid);
        ResultSet rs;
        int points = 0;

        try {
            Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                points = rs.getInt(1);
                System.out.println("Calculating points ...");
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }

        return points;
    }

    public void updatePoints(int newpoints, int cid) {
        final String sql = ("UPDATE customer set points =" + newpoints + " WHERE CustomerID=" + cid);

        try {
            Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            System.out.println("Updating points...");
        } catch (SQLException e) {
            System.out.println("Error:" + sql);
        }

    }

    public double getCredit(int cid) {
        final String sql = ("SELECT Credit FROM customer where CustomerID =" + cid);
        ResultSet rs;
        double credit = 0;

        try {
            Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                credit = rs.getDouble(1);
                System.out.println("Fetching credit ...");
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }

        return credit;
    }

    public void updateCredit(double credit, int cid) {
        final String sql = ("UPDATE customer set credit =" + credit + " WHERE CustomerID=" + cid);

        try {
            Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            System.out.println("Updating credit ...");
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }

    }

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public double dround(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public void checkNewpoints (int newpoints, double credit, float sum){

        if( newpoints>=500){
            int creditamount = newpoints/500;
            credit = 5*creditamount;
            newpoints = newpoints%500;
            updatePoints(newpoints,selected.getCid());
            updateCredit(credit,selected.getCid());
        }else{

            updatePoints(newpoints,selected.getCid());
            updateCredit(credit,selected.getCid());

        }
        refreshData();
        JOptionPane.showMessageDialog (this, "The final cost is €"+round(sum,2)+ "\n your points are now "+newpoints+ " and your credit is now €"+credit, "Title", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sale()  {

        JFrame frame = new JFrame();
        boolean loop = true;
        int newpoints;
        double credit=0;
        float sum = 0;
        //idTextField.setText(String.valueOf(selected.getCid()));



        while (loop){
            //ask for product
            Object productid = JOptionPane.showInputDialog(frame, "Enter productID:");
            String pid = productid.toString();

            //ask for quantity
            Object quantity = JOptionPane.showInputDialog(frame, "Enter quantity:");
            int qty = Integer.valueOf(quantity.toString());

            //ask for another product

            Object addproduct = JOptionPane.showInputDialog(frame, "Do you want to add another product?");
            String answer=addproduct.toString().toLowerCase();
            sum = sum + (calculateCost(pid)*qty);


            newpoints = Math.round(sum) +calculatePoints(selected.getCid());

            if (answer.contains("n")){
                loop= false;
                credit = getCredit(selected.getCid());
                //yes - credit

                if (credit>0){
                    Object useCredit = JOptionPane.showInputDialog(frame, "The cost is €"+round(sum,2) +"\n You have €"+credit+" credit. Do you want to use it?");
                    answer=useCredit.toString().toLowerCase();

                    //use credit - yes

                    if (answer.contains("y")){
                        //credit >cost
                        if (credit>sum){
                            credit = dround(credit-sum,2);
                            updateCredit(credit,selected.getCid());
                            updatePoints(newpoints,selected.getCid());
                            refreshData();
                            JOptionPane.showMessageDialog (this, "The final cost is €0.00"+ "\n your points now are "+newpoints+ " and your credit is now €"+credit, "Title", JOptionPane.INFORMATION_MESSAGE);
                        }else{

                            sum = round(sum,2)- (float)credit;
                            credit = 0;

                            checkNewpoints(newpoints, credit, sum);
                        }

                    }else{ // use credit - no

                        System.out.println("The newpoints are: " + newpoints);
                        System.out.println("the credit is: "+credit);
                        System.out.println("The sum/cost is: "+sum);

                        checkNewpoints(newpoints, credit, sum);
                    }
                }else{
                    checkNewpoints(newpoints,credit, sum);
                }
            }
        }
        //end while
    }

    private void initActions() {
        refreshAction = new AbstractAction("Refresh", load("Refresh")) {

            private static final long serialVersionUID = 55365373393992164L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                refreshData();
            }
        };

        newAction = new AbstractAction("New", load("New")) {

            private static final long serialVersionUID = 3096670017410948892L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                createNew();
            }
        };

        saveAction = new AbstractAction("Save", load("Save")) {

            private static final long serialVersionUID = 5605414927172629018L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                save();
            }
        };

        deleteAction = new AbstractAction("Delete", load("Delete")) {

            private static final long serialVersionUID = -7100743667301418082L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                delete();
            }
        };

        displaylogoAction = new AbstractAction("Logo", load("Logo")) {

            private static final long serialVersionUID = 2590463373537802446L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                displaylogo();
            }
        };

        saleAction = new AbstractAction("sale", load("sale")) {

            private static final long serialVersionUID = -762939146300481974L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                sale();
            }
        };
    }

    private void initComponents() {
        add(createToolBar(), BorderLayout.PAGE_END);
        add(createListPane(), BorderLayout.WEST);
        add(createEditor(), BorderLayout.CENTER);
        add(createSaleListPane(), BorderLayout.EAST);

    }

    private ImageIcon load(final String name) {
        return new ImageIcon(getClass().getResource("/icons/" + name + ".png"));
    }

    private void displaylogo() {

    }

    private void refreshData() {

        final Contact selected = contactsList.getSelectedValue();
        final Product pselected = productsList.getSelectedValue();
        contactsListModel.clear();
        productsListModel.clear();

        final SwingWorker<Void, Contact> worker = new SwingWorker<Void, Contact>() {
            @Override
            protected Void doInBackground() throws Exception {

                final List<Contact> contacts = ContactsHelper.getInstance().getContacts();
                for (final Contact contact : contacts) {
                    publish(contact);
                }
                return null;
            }

            @Override
            protected void done() {
                if (selected != null) {
                    contactsList.setSelectedValue(selected, true);
                }
            }

            @Override
            protected void process(final List<Contact> chunks) {
                for (final Contact contact : chunks) {
                    contactsListModel.addElement(contact);
                }
            }
        };

        worker.execute();

        //

        final SwingWorker<Void, Product> pworker = new SwingWorker<Void, Product>() {
            @Override
            protected Void doInBackground() throws Exception {

                final List<Product> products = ProductsHelper.getInstance().getProducts();
                for (final Product product : products) {
                    publish(product);
                }
                return null;
            }

            @Override
            protected void done() {
                if (pselected != null) {
                    productsList.setSelectedValue(pselected, true);
                }
            }

            @Override
            protected void process(final List<Product> chunks) {
                for (final Product product : chunks) {
                    productsListModel.addElement(product);
                }
            }
        };

        pworker.execute();
    }

    private void save() {

        if (selected != null) {
            try {
                selected.setTitle(titleTextField.getText());
                selected.setFname(fnameTextField.getText());
                selected.setSname(snameTextField.getText());
                selected.setEmail(emailTextField.getText());
                selected.setMobile(mobileTextField.getText());
                selected.setPoints(Integer.parseInt(pointsTextField.getText()));
                selected.setCredit(Double.parseDouble(creditTextField.getText()));
                selected.save();
            } catch (final SQLException e) {
                JOptionPane.showMessageDialog(this, "Failed to save the selected contact", "Save",
                        JOptionPane.WARNING_MESSAGE);
            } finally {
                refreshData();
            }
        }

    }

    private void setSelectedContact(final Contact selected) {
        this.selected = selected;
        if (this.selected == null) {

            idTextField.setText("");
            titleTextField.setText("");
            fnameTextField.setText("");
            snameTextField.setText("");
            emailTextField.setText("");
            mobileTextField.setText("");
            pointsTextField.setText("");
            creditTextField.setText("");
        } else {
            idTextField.setText(String.valueOf(selected.getCid()));
            titleTextField.setText(selected.getTitle());
            fnameTextField.setText(selected.getFname());
            snameTextField.setText(selected.getSname());
            emailTextField.setText(selected.getEmail());
            mobileTextField.setText(selected.getMobile());
            pointsTextField.setText(String.valueOf(selected.getPoints()));
            creditTextField.setText(String.valueOf(selected.getCredit()));

        }
    }

    private void setSelectedProduct(final Product pselected) {
        this.pselected = pselected;

        if (this.pselected == null) {
            skuTextField.setText("");
            pnameTextField.setText("");
            priceTextField.setText("");
            companyTextField.setText("");

        } else {
            skuTextField.setText(pselected.getSKU());
            pnameTextField.setText(pselected.getPname());
            priceTextField.setText(String.valueOf(pselected.getPrice()));
            companyTextField.setText(pselected.getCompany());

        }
    }
}
