/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.Timer;

/**
 *
 * @author ruivsan21
 */
public class MainScreen extends javax.swing.JPanel
{

    /**
     * Creates new form MainScreen
     */
    public MainScreen()
    {
        initComponents();
        fillCombo();
        timer.start();
    }
    
    public MainScreen(String us)
    {
        initComponents();
        usernameLabel.setText(us);
        fillCombo();
        timer.start();
    }
    
    public JLabel getUsernameLabel()
    {
        return usernameLabel;
    }

    Timer timer = new Timer(500, new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Date date = new Date();
            usernameLabel.setText(MainFrame.username);
            dateLabel.setText("Today is " + date);
            Connection con = null;
            con = app.MainFrame.setConnection(con);
            if (!dishesComboBox.getSelectedItem().equals("-"))
            {
                String a = "-";
                String b = "-";
                try
                {
                    Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stm.executeQuery("SELECT * FROM DISHES WHERE DISH_NAME = '" + dishesComboBox.getSelectedItem() + "'");
                    rs.next();
                    a = "" + rs.getObject("CALORIES");
                    b = "" + rs.getObject("DAYS");
                    stm.close();
                    rs.close();
                    con.close();
                } catch (SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
                caloriesLabel.setText("Calories: " + a);
                daysSinceLabel.setText("Days since last eaten: " + b);
            }
            else
            {
                caloriesLabel.setText("Calories: -");
                daysSinceLabel.setText("Days since last eaten: -");
            }
        }
    });
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dishesComboBox = new javax.swing.JComboBox();
        daysSinceLabel = new javax.swing.JLabel();
        addNewDishLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dishesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lunchButton = new javax.swing.JButton();
        dinnerButton = new javax.swing.JButton();
        confirmMealPlanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clearTableLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        usernameLabel.setForeground(new java.awt.Color(100, 100, 100));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        usernameLabel.setText(" ");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText(" ");

        dishesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        dishesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dishesComboBoxActionPerformed(evt);
            }
        });

        daysSinceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        daysSinceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daysSinceLabel.setText("Days since last eaten: -");

        addNewDishLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addNewDishLabel.setForeground(new java.awt.Color(50, 50, 50));
        addNewDishLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addNewDishLabel.setText("Create New Dish");
        addNewDishLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                addNewDishLabelMouseMoved(evt);
            }
        });
        addNewDishLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewDishLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addNewDishLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addNewDishLabelMouseExited(evt);
            }
        });

        caloriesLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        caloriesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caloriesLabel.setText("Calories: -");

        dishesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lunch", null, null, null},
                {"Dinner", null, null, null}
            },
            new String [] {
                " ", "Dish", "Last Eaten", "Calories"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dishesTable);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Today's Plan");

        lunchButton.setText("Add to Lunch");
        lunchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lunchButtonMouseClicked(evt);
            }
        });

        dinnerButton.setText("Add to Dinner");
        dinnerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dinnerButtonMouseClicked(evt);
            }
        });

        confirmMealPlanButton.setText("Confirm Meal Plan");
        confirmMealPlanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMealPlanButtonMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Dish:");

        clearTableLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        clearTableLabel.setForeground(new java.awt.Color(100, 100, 100));
        clearTableLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearTableLabel.setText("Clear Table");
        clearTableLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearTableLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearTableLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearTableLabelMouseExited(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lunchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(caloriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(dinnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addComponent(daysSinceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dishesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addNewDishLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(confirmMealPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(clearTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dishesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caloriesLabel)
                    .addComponent(daysSinceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lunchButton)
                    .addComponent(dinnerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(addNewDishLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmMealPlanButton)
                    .addComponent(clearTableLabel))
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseMoved
    {//GEN-HEADEREND:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void dishesComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dishesComboBoxActionPerformed
    {//GEN-HEADEREND:event_dishesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dishesComboBoxActionPerformed

    private void addNewDishLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addNewDishLabelMouseClicked
    {//GEN-HEADEREND:event_addNewDishLabelMouseClicked
        MainFrame.setPanelVisible(3);
    }//GEN-LAST:event_addNewDishLabelMouseClicked

    private void addNewDishLabelMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addNewDishLabelMouseMoved
    {//GEN-HEADEREND:event_addNewDishLabelMouseMoved
        
    }//GEN-LAST:event_addNewDishLabelMouseMoved

    private void addNewDishLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addNewDishLabelMouseEntered
    {//GEN-HEADEREND:event_addNewDishLabelMouseEntered
        addNewDishLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        addNewDishLabel.setHorizontalAlignment(CENTER);
    }//GEN-LAST:event_addNewDishLabelMouseEntered

    private void addNewDishLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addNewDishLabelMouseExited
    {//GEN-HEADEREND:event_addNewDishLabelMouseExited
        addNewDishLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
    }//GEN-LAST:event_addNewDishLabelMouseExited

    private void lunchButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lunchButtonMouseClicked
    {//GEN-HEADEREND:event_lunchButtonMouseClicked
        dishesTable.setValueAt(dishesComboBox.getSelectedItem(), 0, 1);
        Connection con = null;
        con = MainFrame.setConnection(con);
        if (!dishesComboBox.getSelectedItem().equals("-"))
        {
            String a = "-";
            String b = "-";
            try
            {
                Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stm.executeQuery("SELECT * FROM DISHES WHERE DISH_NAME = '" + dishesComboBox.getSelectedItem() + "'");
                rs.next();
                a = "" + rs.getObject("CALORIES");
                b = "" + rs.getObject("DAYS");
                MainFrame.lunch = (String) dishesComboBox.getSelectedItem();
                MainFrame.lunchCal = (int) rs.getObject("CALORIES");
                stm.close();
                rs.close();
                con.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            dishesTable.setValueAt(b + " days ago", 0, 2);
            dishesTable.setValueAt(a, 0, 3);   
        }
        else
        {
            dishesTable.setValueAt("-", 0, 2);
            dishesTable.setValueAt("-", 0, 3);
        }
    }//GEN-LAST:event_lunchButtonMouseClicked

    private void dinnerButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_dinnerButtonMouseClicked
    {//GEN-HEADEREND:event_dinnerButtonMouseClicked
        dishesTable.setValueAt(dishesComboBox.getSelectedItem(), 1, 1);
        Connection con = null;
        con = MainFrame.setConnection(con);
        if (!dishesComboBox.getSelectedItem().equals("-"))
        {
            String a = "-";
            String b = "-";
            try
            {
                Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stm.executeQuery("SELECT * FROM DISHES WHERE DISH_NAME = '" + dishesComboBox.getSelectedItem() + "'");
                rs.next();
                a = "" + rs.getObject("CALORIES");
                b = "" + rs.getObject("DAYS");
                MainFrame.dinner = (String) dishesComboBox.getSelectedItem();
                MainFrame.dinnerCal = (int) rs.getObject("CALORIES");
                stm.close();
                rs.close();
                con.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            dishesTable.setValueAt(b + " days ago", 1, 2);
            dishesTable.setValueAt(a, 1, 3);
        }
        else 
        {
            dishesTable.setValueAt("-", 1, 2);
            dishesTable.setValueAt("-", 1, 3);
        }
    }//GEN-LAST:event_dinnerButtonMouseClicked

    private void clearTableLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearTableLabelMouseEntered
    {//GEN-HEADEREND:event_clearTableLabelMouseEntered
        clearTableLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        clearTableLabel.setHorizontalAlignment(CENTER);
    }//GEN-LAST:event_clearTableLabelMouseEntered

    private void clearTableLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearTableLabelMouseExited
    {//GEN-HEADEREND:event_clearTableLabelMouseExited
        clearTableLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
    }//GEN-LAST:event_clearTableLabelMouseExited

    private void clearTableLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_clearTableLabelMouseClicked
    {//GEN-HEADEREND:event_clearTableLabelMouseClicked
        for (int i = 1; i < 4; i++)
        {
            for (int a = 0; a < 2; a++)
            {
                dishesTable.setValueAt("", a, i);
            }
        }
    }//GEN-LAST:event_clearTableLabelMouseClicked

    private void confirmMealPlanButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_confirmMealPlanButtonMouseClicked
    {//GEN-HEADEREND:event_confirmMealPlanButtonMouseClicked
        if (dishesTable.getValueAt(1, 2).equals(null) || dishesTable.getValueAt(1, 2).equals("-") || dishesTable.getValueAt(0, 2).equals("") || dishesTable.getValueAt(0, 2).equals("-"))
        {
            errorLabel.setText("*Please add missing Lunch and/or Dinner");
        }
        else
        {
            Connection con = null;
            try
            {
                Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stm.executeQuery("SELECT * FROM MEAL_PLAN");
                rs.updateBoolean("DONE", true);
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            MainFrame.setPanelVisible(4);
            MainFrame.mealPlanDone = true;
        }
    }//GEN-LAST:event_confirmMealPlanButtonMouseClicked

    public void fillCombo()
    {
        Connection con = null;
        con = MainFrame.setConnection(con);
        try
        {
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery("SELECT * FROM DISHES");
            while (rs.next())
            {
                dishesComboBox.addItem(rs.getString("DISH_NAME"));
            }
            con.close();
            stm.close();
            rs.close();
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addCombo(String a)
    {
        dishesComboBox.addItem(a);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addNewDishLabel;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JLabel clearTableLabel;
    private javax.swing.JButton confirmMealPlanButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel daysSinceLabel;
    private javax.swing.JButton dinnerButton;
    private javax.swing.JComboBox dishesComboBox;
    private javax.swing.JTable dishesTable;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lunchButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
