import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FrameOfStock extends javax.swing.JFrame {

    public FrameOfStock() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        comboBoxCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProduct = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textFieldNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxTypeOfMovement = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCurrentStock = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLog = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock");
        setResizable(false);

        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboBoxProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel1.setText("Категория товаров");
        jLabel2.setText("Товар");
        jLabel3.setText("Количество");

        comboBoxTypeOfMovement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Приход", "Уход"}));

        jLabel4.setText("Тип перемещения");

        buttonAdd.setText("Добавить");

        jLabel5.setText("Текущий остаток");

        tableCurrentStock.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Категория товара", "Товар", "Текущий остаток"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCurrentStock.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableCurrentStock);

        jLabel6.setText("Журнал перемещения товаров");

        tableLog.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Категория товара", "Товар", "Тип перемещения", "Количество", "Дата"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLog.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableLog);
        modelOfTableLog=(DefaultTableModel) tableLog.getModel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(110, 110, 110))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel3)
                                                                                        .addComponent(jLabel4))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(comboBoxProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(comboBoxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(comboBoxTypeOfMovement, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(buttonAdd))
                                                                                .addGap(96, 96, 96)))
                                                                .addGap(159, 159, 159))))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBoxTypeOfMovement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonAdd)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        dateFormated = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        addProductsToComboBoxes(comboBoxCategory);
        comboBoxCategory.addActionListener(e -> changeComboBoxOfProducts(comboBoxCategory.getSelectedItem().toString()));
        buttonAdd.addActionListener(e -> {
            try{
                checkNumber();
                addMovementToTable();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(jScrollPane2,ex.getMessage());
            }
        });
        setVisible(true);
        pack();
    }

    private void addMovementToTable()throws Exception {
        DefaultTableModel model=(DefaultTableModel) this.tableCurrentStock.getModel();
        checkIfCorrectMovement(model);
        if(comboBoxTypeOfMovement.getSelectedItem().toString()=="Уход"){
            takeProduct(model);
        }
        if(comboBoxTypeOfMovement.getSelectedItem().toString()=="Приход"){
            if(model.getRowCount()==0){
                addNewProductToStock(model);
            }else {
                for (int i=0;i<model.getRowCount();i++){
                    if(model.getValueAt(i,1).toString()==comboBoxProduct.getSelectedItem().toString()){
                        addProduct(model);
                        return;
                    }
                }
                addNewProductToStock(model);
            }
        }
    }

    private void addProduct(DefaultTableModel model) {
        for (int i=0;i<model.getRowCount();i++){
            if(model.getValueAt(i,1).toString()==this.comboBoxProduct.getSelectedItem().toString()){
                model.setValueAt(Integer.parseInt(model.getValueAt(i,2).toString())+
                        Integer.parseInt(textFieldNumber.getText()),i,2);
                addLog();
                return;
            }
        }
    }

    private void takeProduct(DefaultTableModel model) throws Exception {
        for (int i=0;i<model.getRowCount();i++){
            if(model.getValueAt(i,1).toString()==this.comboBoxProduct.getSelectedItem().toString()){
                if(Integer.parseInt(textFieldNumber.getText())>Integer.parseInt(model.getValueAt(i,2).toString())){
                    throw new Exception("Такого количества нет на складе!");
                }
                model.setValueAt(Integer.parseInt(model.getValueAt(i,2).toString())-
                        Integer.parseInt(textFieldNumber.getText()),i,2);
                addLog();
                return;
            }
        }
    }

    private void addNewProductToStock(DefaultTableModel model) {
        model.addRow(new Object[]{comboBoxCategory.getSelectedItem().toString(),comboBoxProduct.getSelectedItem().toString(),textFieldNumber.getText()});
        addLog();
    }

    private void addLog() {
        modelOfTableLog.addRow(new Object[]{comboBoxCategory.getSelectedItem().toString(),comboBoxProduct.getSelectedItem().toString(),
                comboBoxTypeOfMovement.getSelectedItem().toString(),textFieldNumber.getText(),dateFormated.format(new Date())});
    }

    private void checkIfCorrectMovement(DefaultTableModel model)throws Exception {
        if(comboBoxTypeOfMovement.getSelectedItem().toString()=="Уход"){
            for (int i=0;i<model.getRowCount();i++){
                if(model.getRowCount()==0){
                    throw new Exception("Товара не было на складе!");
                }
                if(model.getValueAt(i,1).toString()==comboBoxProduct.getSelectedItem().toString()){
                    return;
                }
            }
            throw new Exception("Товара не было на складе!");
        }
    }

    private void checkNumber() throws Exception{
        if(this.textFieldNumber.getText().equals("")){
            throw new Exception("Пустое значение \"Количество\"");
        }
        if (!this.textFieldNumber.getText().matches("[0-9]+")){
            this.textFieldNumber.setText("");
            throw new Exception("Неверное значение \"Количество\"");
        }
    }

    private void setProductsToMap(){
        this.products.put("Продукты",new String[]{"Хлеб","Сахар","Мясо"});
        this.products.put("Детское питание",new String[]{"Молоко","Каша"});
    }

    private void addProductsToComboBoxes(JComboBox comboBoxType){
        setProductsToMap();
        for(String key: this.products.keySet()){
            comboBoxType.addItem(key);
        }
        changeComboBoxOfProducts(comboBoxType.getSelectedItem().toString());
    }

    private void changeComboBoxOfProducts(String category) {
        this.comboBoxProduct.setModel(new DefaultComboBoxModel<>(new String[]{}));
        for(String value: this.products.get(category)){
            this.comboBoxProduct.addItem(value);
        }
    }

    private javax.swing.JButton buttonAdd;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JComboBox<String> comboBoxProduct;
    private javax.swing.JComboBox<String> comboBoxTypeOfMovement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableCurrentStock;
    private javax.swing.JTable tableLog;
    DefaultTableModel modelOfTableLog;
    private javax.swing.JTextField textFieldNumber;
    private HashMap<String,String[]> products=new HashMap<>();
    private SimpleDateFormat dateFormated;

}