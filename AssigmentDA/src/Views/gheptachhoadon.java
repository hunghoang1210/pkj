/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Ban;
import Models.HDCT;
import Models.HoaDon;
import Models.Mon;
import Service.BanService;
import Service.BanServiceImpl;
import Service.HDCTService;
import Service.HDCTServiceImpl;
import Service.HoaDonService;
import Service.HoaDonServiceImpl;
import Service.MonService;
import Service.MonServiceImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fuoc
 */
public class gheptachhoadon extends javax.swing.JFrame {

    /**
     * Creates new form Chuyenban
     */
    public gheptachhoadon() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    help al;
    HDCTService hDCTService = new HDCTServiceImpl();
    MonService monService = new MonServiceImpl();
    BanService banService = new BanServiceImpl();
    BanHangView aThis;
    HoaDonService hoaDonService = new HoaDonServiceImpl();
    String tenmon;
    int soluong;

    gheptachhoadon(BanHangView aThis, String tenban, String mahd, String maban) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtbanchon.setText(tenban);
        txtmabanchon.setText(maban);
        txtmahd.setText(mahd);
        loadbancbo();
        this.aThis = aThis;
        txtbanchon.setEnabled(false);
        txtmabanchon.setEnabled(false);
        txtmahd.setEnabled(false);
        txtmahdbanchuyen.setEnabled(false);
        if (txtmahd.getText().equals(txtmahdbanchuyen.getText())) {
            btn2.setEnabled(false);
        }
    }

    void loadbancbo() {
        List<HoaDon> li = hoaDonService.getAll();
        List<Ban> list = banService.getAll();
        cbban.removeAllItems();
        for (HoaDon hd : li) {
            Ban abc = banService.getone(hd.getMaban());
            cbban.addItem(abc.getTenBan() + "           /" + abc.getMaBan());
        }
        loadHDCT();
        cbban.removeItem(txtbanchon.getText() + "           /" + txtmabanchon.getText());
    }

    void loadHDCT() {
        String key = (String) cbban.getSelectedItem();
        if (key == null) {
        } else {
            String[] keys = key.split("/");
            List<HoaDon> hd = hoaDonService.getmaban(keys[1]);
            for (HoaDon nv : hd) {
                System.out.println("mã hd: " + nv.getMahd());
                txtmahdbanchuyen.setText(nv.getMahd());
            }
            if (hd.size() == 0) {
                txtmahdbanchuyen.setText("TRỐNG");
            }
            try {
                DefaultTableModel model = (DefaultTableModel) tbchitietban1.getModel();
                model.setRowCount(0);
                List<HDCT> list = hDCTService.getAll1(txtmahdbanchuyen.getText());
                for (HDCT nv : list) {
                    List<Mon> tenmon = monService.getIdMon(nv.getMaMon_FK());
                    String tenthucpham = null;
                    for (Mon mon : tenmon) {
                        tenthucpham = mon.getTenMon();
                    }
                    Object[] row = {
                        nv.getMaCTHD(),
                        nv.getMaMon_FK(),
                        tenthucpham,
                        nv.getDonGia(),
                        nv.getSoLuong(), (nv.getDonGia() * nv.getSoLuong())
                    };
                    model.addRow(row);
                }

            } catch (Exception e) {
                alert("Lỗi");
            }
        }
        DefaultTableModel model = (DefaultTableModel) tbchitietban.getModel();
        model.setRowCount(0);
        float Tongtien = 0;

        try {
            List<HDCT> list = hDCTService.getAll1(txtmahd.getText());
            for (HDCT nv : list) {
                List<Mon> tenmon = monService.getIdMon(nv.getMaMon_FK());
                String tenthucpham = null;
                for (Mon mon : tenmon) {
                    tenthucpham = mon.getTenMon();
                }
                Object[] row = {
                    nv.getMaCTHD(),
                    nv.getMaMon_FK(),
                    tenthucpham,
                    nv.getDonGia(),
                    nv.getSoLuong(), (nv.getDonGia() * nv.getSoLuong())
                };
                model.addRow(row);
            }
            String tt = String.valueOf(Tongtien);
            String tt2 = tt.replace(".0", "");
        } catch (Exception e) {
            alert("Lỗi !");
        }
    }
    int dong = 0;
    List<HDCT> bang2 = new ArrayList<HDCT>();
    List<HDCT> bang1 = new ArrayList<HDCT>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbanchon = new javax.swing.JTextField();
        txtmabanchon = new javax.swing.JTextField();
        txtmahd = new javax.swing.JTextField();
        cbban = new javax.swing.JComboBox<>();
        txtmahdbanchuyen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbchitietban = new javax.swing.JTable();
        btn2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbchitietban1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txttk3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tách/ghép đơn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setText("Bàn đang chọn");

        jLabel3.setText("Mã bàn");

        jLabel4.setText("Mã hóa đơn");

        jLabel5.setText("Bàn ");

        jLabel6.setText("Mã hóa đơn bàn chuyển");

        cbban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbban.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbanItemStateChanged(evt);
            }
        });

        tbchitietban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HDCT", "Mã món", "Tên món", "Giá", "Số lượng"
            }
        ));
        tbchitietban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbchitietbanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbchitietban);

        btn2.setText("Ghép");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        tbchitietban1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HDCT", "Mã món", "Tên món", "Giá", "Số lượng"
            }
        ));
        jScrollPane2.setViewportView(tbchitietban1);

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn1.setText("Tách");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Món");

        jLabel8.setText("Số lượng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbanchon)
                            .addComponent(txtmabanchon)
                            .addComponent(txtmahd, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmahdbanchuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbban, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btn2)
                        .addGap(81, 81, 81)
                        .addComponent(btn1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txttk3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtbanchon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtmabanchon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmahdbanchuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn2)
                            .addComponent(btn1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbchitietban.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tbchitietban1.getModel();
        int row = model.getRowCount();
        int row2 = model2.getRowCount();
        bang1.removeAll(bang1);
        for (int i = 0; i < row; i++) {
            HDCT dong1 = new HDCT();
            dong1.setMaCTHD((String) model.getValueAt(i, 0));
            dong1.setMaMon_FK((String) model.getValueAt(i, 1));
            dong1.setMaHD_FK(txtmahd.getText());
            dong1.setDonGia((float) model.getValueAt(i, 3));
            dong1.setSoLuong((int) model.getValueAt(i, 4));
            bang1.add(dong1);
            System.out.println("Size" + bang1.size());
        }
        for (int i = 0; i < bang1.size(); i++) {
            List<HDCT> list = hDCTService.check(txtmahdbanchuyen.getText(), bang1.get(i).getMaMon_FK());
            if (list.size() == 0) {
                HDCT newup = new HDCT();
                newup.setDonGia(bang1.get(i).getDonGia());
                newup.setMaCTHD(bang1.get(i).getMaCTHD());
                newup.setMaHD_FK(txtmahdbanchuyen.getText());
                newup.setSoLuong(bang1.get(i).getSoLuong());
                newup.setMaMon_FK(bang1.get(i).getMaMon_FK());
                hDCTService.update(newup);
                this.loadHDCT();
            } else {
                System.out.println("sptrung" + bang1.get(i).getMaMon_FK());
                for (HDCT hdct : list) {
                    System.out.println("list" + hdct.getMaMon_FK());
                    HDCT newup = new HDCT();
                    newup.setDonGia(hdct.getDonGia());
                    newup.setMaCTHD(hdct.getMaCTHD());
                    newup.setMaHD_FK(txtmahdbanchuyen.getText());
                    newup.setSoLuong(bang1.get(i).getSoLuong() + hdct.getSoLuong());
                    newup.setMaMon_FK(hdct.getMaMon_FK());
                    hDCTService.update(newup);
                    hDCTService.delete(bang1.get(i).getMaCTHD());
                    this.loadHDCT();
                }
            }
            hoaDonService.updateoffhd(txtmabanchon.getText(), txtmahd.getText());
            aThis.loadlaiban();
            aThis.loadHDCT();
            aThis.closemenuorder(true);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void tbchitietbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbchitietbanMouseClicked
        tenmon = "";
        soluong = 0;
        dong = 0;
        dong = tbchitietban.rowAtPoint(evt.getPoint());
        int keyma = tbchitietban.rowAtPoint(evt.getPoint());
        tenmon = (String) tbchitietban.getValueAt(keyma, 2);
        soluong = (int) tbchitietban.getValueAt(keyma, 4);
        txtsoluong.setValue(soluong);
        txttk3.setText(tenmon);
    }//GEN-LAST:event_tbchitietbanMouseClicked

    private void cbbanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbanItemStateChanged
        loadHDCT();
    }//GEN-LAST:event_cbbanItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        int soluongchuyen = (int) txtsoluong.getValue();
        if (soluongchuyen == 0) {
            alert("Vui lòng chọn sản phẩm cần tách!");
        } else {
            bang2.removeAll(bang2);
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            int hour = now.getHour();
            int minute = now.getMinute();
            int second = now.getSecond();
            DefaultTableModel model = (DefaultTableModel) tbchitietban1.getModel();
            DefaultTableModel model2 = (DefaultTableModel) tbchitietban.getModel();
            if (soluongchuyen < 0) {
                alert("Bạn không thể tách bằng cách trừ sản phẩm");
            } else {
                int soluongbang = (int) model2.getValueAt(dong, 4);
                List<HDCT> list = hDCTService.check(txtmahdbanchuyen.getText(), (String) model2.getValueAt(dong, 1));
                if (list.size() == 0) {
                    if (soluongbang > soluongchuyen) {
                        HDCT newup = new HDCT();
                        newup.setMaCTHD((String) model2.getValueAt(dong, 0));
                        newup.setMaHD_FK(txtmahd.getText());
                        newup.setMaMon_FK((String) model2.getValueAt(dong, 1));
                        newup.setSoLuong(soluongbang - soluongchuyen);
                        newup.setDonGia((float) model2.getValueAt(dong, 3));
                        hDCTService.update(newup);
                        HDCT newup2 = new HDCT();
                        newup2.setMaCTHD("" + day + month + year + hour + minute + second);
                        newup2.setMaHD_FK(txtmahdbanchuyen.getText());
                        newup2.setMaMon_FK((String) model2.getValueAt(dong, 1));
                        newup2.setSoLuong(soluongchuyen);
                        newup2.setDonGia((float) model2.getValueAt(dong, 3));
                        hDCTService.insert(newup2);
                    } else if (soluongchuyen > soluongbang) {
                        alert("Số lượng tách không chính xác!");
                    } else if (soluongbang == soluongchuyen) {
                        HDCT newup = new HDCT();
                        newup.setMaCTHD((String) model2.getValueAt(dong, 0));
                        newup.setMaHD_FK(txtmahdbanchuyen.getText());
                        newup.setMaMon_FK((String) model2.getValueAt(dong, 1));
                        newup.setSoLuong(soluongchuyen);
                        newup.setDonGia((float) model2.getValueAt(dong, 3));
                        hDCTService.update(newup);

                    }
                } else {
                    if (soluongbang > soluongchuyen) {
                        HDCT newup = new HDCT();
                        newup.setMaCTHD((String) model2.getValueAt(dong, 0));
                        newup.setMaHD_FK(txtmahd.getText());
                        newup.setMaMon_FK((String) model2.getValueAt(dong, 1));
                        newup.setSoLuong(soluongbang - soluongchuyen);
                        newup.setDonGia((float) model2.getValueAt(dong, 3));
                        hDCTService.update(newup);
                        for (HDCT hd : list) {
                            HDCT newup2 = new HDCT();
                            newup2.setMaCTHD(hd.getMaCTHD());
                            newup2.setMaHD_FK(hd.getMaHD_FK());
                            newup2.setMaMon_FK(hd.getMaMon_FK());
                            newup2.setSoLuong(hd.getSoLuong() + soluongchuyen);
                            newup2.setDonGia(hd.getDonGia());
                            hDCTService.update(newup2);
                        }
                    } else if (soluongbang == soluongchuyen) {
                        for (HDCT hd : list) {
                            HDCT newup2 = new HDCT();
                            newup2.setMaCTHD(hd.getMaCTHD());
                            newup2.setMaHD_FK(hd.getMaHD_FK());
                            newup2.setMaMon_FK(hd.getMaMon_FK());
                            newup2.setSoLuong(hd.getSoLuong() + soluongchuyen);
                            newup2.setDonGia(hd.getDonGia());
                            hDCTService.update(newup2);
                        }
                        hDCTService.delete((String) model2.getValueAt(dong, 0));
                    } else if (soluongbang < soluongchuyen) {
                        alert("Số lượng tách không chính xác!");
                    }
                }
            }
            this.loadHDCT();
        }
        aThis.loadlaiban();
        aThis.loadHDCT();
    }//GEN-LAST:event_btn1ActionPerformed

    private void alert(String loi) {
        if (al != null) {
            al.dispose();
            al = new help(loi);
        } else {
            al = new help(loi);
        }
        al.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gheptachhoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gheptachhoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gheptachhoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gheptachhoadon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gheptachhoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JComboBox<String> cbban;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbchitietban;
    private javax.swing.JTable tbchitietban1;
    private javax.swing.JTextField txtbanchon;
    private javax.swing.JTextField txtmabanchon;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtmahdbanchuyen;
    private javax.swing.JSpinner txtsoluong;
    private javax.swing.JTextField txttk3;
    // End of variables declaration//GEN-END:variables

}
