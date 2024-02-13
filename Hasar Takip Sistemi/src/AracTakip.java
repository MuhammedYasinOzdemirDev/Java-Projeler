import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.security.Guard;

public class AracTakip extends JPanel implements ActionListener, KeyListener,MouseListener {
    private static DefaultTableModel model;
    private Araclar araclar;
    public AracTakip() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        plaka_alan = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        marka_alan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        model_alan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yil_alan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        motor_no_alan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sasi_alan = new javax.swing.JTextField();
        aractip_alan = new javax.swing.JTextField();
        ruhsat_alan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        kasa_tip_alan = new javax.swing.JTextField();
        sanziman_alan = new javax.swing.JTextField();
        renk_alan = new javax.swing.JTextField();
        motor_gucualan = new javax.swing.JTextField();
        motor_hacmi_alan = new javax.swing.JTextField();
        yakit_alan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        yeni_arac_button = new javax.swing.JButton();
        arac_duzenle_button = new javax.swing.JButton();
        arac_sil_button = new javax.swing.JButton();
        yenile_button = new javax.swing.JButton();
        kapat_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        plaka_sorgula_alan = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        ruhtsat_sorgula_alan = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        marka_sorgula_alan = new javax.swing.JComboBox<>();
        model_sorgula_alan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        arac_tip_sorgula_alan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        kasa_tip_sorgu_alan = new javax.swing.JComboBox<>();
        arac_table = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 900));

        jPanel1.setBackground(new java.awt.Color(128, 109, 190));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Plaka");

        plaka_alan.setEditable(false);
        plaka_alan.setPreferredSize(new java.awt.Dimension(180, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Marka");

        marka_alan.setEditable(false);
        marka_alan.setMinimumSize(new java.awt.Dimension(64, 25));
        marka_alan.setPreferredSize(new java.awt.Dimension(64, 25));


        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Model");

        model_alan.setEditable(false);
        model_alan.setMinimumSize(new java.awt.Dimension(64, 25));
        model_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Model Yılı");

        yil_alan.setEditable(false);
        yil_alan.setMinimumSize(new java.awt.Dimension(64, 25));
        yil_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Motor No");

        motor_no_alan.setEditable(false);
        motor_no_alan.setMinimumSize(new java.awt.Dimension(64, 25));
        motor_no_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Şaşi No");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Ruhsat Sahibi");

        sasi_alan.setEditable(false);
        sasi_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        aractip_alan.setEditable(false);
        aractip_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        ruhsat_alan.setEditable(false);
        ruhsat_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Araç Bilgileri");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Araç Tipi");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Kasa Tipi");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Şansızman");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Renk");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Yakıt Cinsi");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Motor Gücü");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Motor Hacmi");

        kasa_tip_alan.setEditable(false);
        kasa_tip_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        sanziman_alan.setEditable(false);
        sanziman_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        renk_alan.setEditable(false);
        renk_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        motor_gucualan.setEditable(false);
        motor_gucualan.setPreferredSize(new java.awt.Dimension(64, 25));

        motor_hacmi_alan.setEditable(false);
        motor_hacmi_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        yakit_alan.setPreferredSize(new java.awt.Dimension(64, 25));
        yakit_alan.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(marka_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(model_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(yil_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(motor_no_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(plaka_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel12)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(sasi_alan, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                                                .addComponent(ruhsat_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(aractip_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(kasa_tip_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(sanziman_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(renk_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(motor_gucualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(motor_hacmi_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(yakit_alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(plaka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(marka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(model_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(yil_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(motor_no_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sasi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(ruhsat_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(aractip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel33)
                                        .addComponent(kasa_tip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel34)
                                        .addComponent(sanziman_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel35)
                                        .addComponent(renk_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel37)
                                        .addComponent(motor_gucualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel38)
                                        .addComponent(motor_hacmi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(yakit_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(128, 109, 190));
        jPanel2.setPreferredSize(new java.awt.Dimension(958, 50));

        yeni_arac_button.setText("Yeni Araç");
        yeni_arac_button.setPreferredSize(new java.awt.Dimension(120, 48));

        arac_duzenle_button.setText("Araç Düzenle");
        arac_duzenle_button.setPreferredSize(new java.awt.Dimension(120, 48));

        arac_sil_button.setText("Araç Sil");
        arac_sil_button.setPreferredSize(new java.awt.Dimension(120, 48));

        yenile_button.setText("Yenile");
        yenile_button.setPreferredSize(new java.awt.Dimension(120, 48));

        kapat_button.setText("Kapat");
        kapat_button.setPreferredSize(new java.awt.Dimension(120, 48));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(yeni_arac_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(arac_duzenle_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(arac_sil_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(yenile_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(kapat_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kapat_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yenile_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(arac_sil_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(arac_duzenle_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yeni_arac_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(128, 109, 190));

        plaka_sorgula_alan.setBackground(new java.awt.Color(102, 255, 102));
        plaka_sorgula_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel39.setText("Ruhsat Sahibi");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel40.setText("Plaka No");

        ruhtsat_sorgula_alan.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel41.setText("Marka");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setText("Model");

        marka_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.MarkaCek()));

        model_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.ModelCek()));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Araç Tipi");

        arac_tip_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.AracTipCek()));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Kasa Tipi");

        kasa_tip_sorgu_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.kasaTipCek()));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ruhtsat_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(plaka_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(marka_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(model_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(arac_tip_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kasa_tip_sorgu_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel40)
                                                                        .addComponent(plaka_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel41)))
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(marka_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(arac_tip_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel39)
                                                .addComponent(ruhtsat_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel42)
                                                .addComponent(model_sorgula_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(kasa_tip_sorgu_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        null
                },
                new String [] {
                        "Araç No", "Plaka No", "Marka", "Model", "Yıl","Motor No", "Şaşi", "Ruhsat Sahibi", "Araç Tipi", "Kasa Tipi", "Şanzıman", "Renk", "Motor Gücü", "Motor Hacmi", "Yakıt Cinsi"
                }
        ));

        arac_table.setViewportView(jTable1);

        model= (DefaultTableModel) jTable1.getModel();
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(72);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(14).setPreferredWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(arac_table, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(arac_table))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        araclar=new Araclar();
        yeni_arac_button.addActionListener(this);
        arac_duzenle_button.addActionListener(this);
        arac_sil_button.addActionListener(this);
        yenile_button.addActionListener(this);
        plaka_sorgula_alan.addKeyListener(this);
        plaka_sorgula_alan.addMouseListener(this);
        ruhtsat_sorgula_alan.addKeyListener(this);
        ruhtsat_sorgula_alan.addMouseListener(this);
        marka_sorgula_alan.addActionListener(this);
        marka_sorgula_alan.addMouseListener(this);
        model_sorgula_alan.addActionListener(this);
        kapat_button.addActionListener(this);
        arac_tip_sorgula_alan.addActionListener(this);
        arac_tip_sorgula_alan.addMouseListener(this);
        kasa_tip_sorgu_alan.addActionListener(this);
        kasa_tip_sorgu_alan.addMouseListener(this);
        jTable1.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==yeni_arac_button){
            araclar.Ekle();

        } else if (arac_duzenle_button==e.getSource()) {
            araclar.Duzenle();

        } else if (arac_sil_button==e.getSource()) {
            araclar.Sil();
        } else if (yenile_button==e.getSource()) {
            araclar.Yenile();
        } else if (kapat_button==e.getSource()) {
            araclar.Kapat();
        }
        if(marka_sorgula_alan==e.getSource()){
            String select=marka_sorgula_alan.getSelectedItem().toString();
            marka_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.MarkaCek()));
            marka_sorgula_alan.setSelectedItem(select);
            String ara=marka_sorgula_alan.getSelectedItem().toString();
            if(!(ara.equals("Tümü"))){
                araclar.Arama(ara,2);
            }
            else{
                araclar.Arama("",2);
            }
        }
        if(model_sorgula_alan==e.getSource()){
            String ara=model_sorgula_alan.getSelectedItem().toString();

            if(!(ara.equals("Tümü"))){
                araclar.Arama(ara,3);
            }
            else{
                araclar.Arama("",3);
            }
        }
        if(arac_tip_sorgula_alan==e.getSource()){

            String ara=arac_tip_sorgula_alan.getSelectedItem().toString();
            if(!(ara.equals("Tümü"))){
                araclar.Arama(ara,8);
            }
            else{
                araclar.Arama("",8);
            }
        }
        if(kasa_tip_sorgu_alan==e.getSource()){

            String ara=kasa_tip_sorgu_alan.getSelectedItem().toString();
            if(!(ara.equals("Tümü"))){
                araclar.Arama(ara,9);
            }
            else{
                araclar.Arama("",9);
            }
        }
        araclar.Yenile();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==plaka_sorgula_alan){
            Border border=new LineBorder(Color.red,1);
            plaka_sorgula_alan.setBorder(border);
        }
        if(e.getSource()==ruhtsat_sorgula_alan){
            Border border=new LineBorder(Color.red,1);
            ruhtsat_sorgula_alan.setBorder(border);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==plaka_sorgula_alan){
            String deger=plaka_sorgula_alan.getText();
            plaka_sorgula_alan.setBorder(null);
            araclar.Arama(deger,1);
        } else if (e.getSource()==ruhtsat_sorgula_alan) {
            String deger=ruhtsat_sorgula_alan.getText();
            ruhtsat_sorgula_alan.setBorder(null);
            araclar.Arama(deger,7);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        araclar.Yenile();
        if(e.getSource()==model_sorgula_alan){
            String select=model_sorgula_alan.getSelectedItem().toString();
            model_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.ModelCek()));
            model_sorgula_alan.setSelectedItem(select);
        }
        if(e.getSource()==arac_tip_sorgula_alan){
            String select=arac_tip_sorgula_alan.getSelectedItem().toString();
            arac_tip_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.AracTipCek()));
            arac_tip_sorgula_alan.setSelectedItem(select);
        }
        if(e.getSource()==kasa_tip_sorgu_alan){
            String select=kasa_tip_sorgu_alan.getSelectedItem().toString();
            kasa_tip_sorgu_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.kasaTipCek()));
            kasa_tip_sorgu_alan.setSelectedItem(select);
        }
        if(e.getSource()==plaka_sorgula_alan){
            Border border=new LineBorder(Color.red,1);
            plaka_sorgula_alan.setBorder(border);
        }
        if(e.getSource()==ruhtsat_sorgula_alan){
            Border border=new LineBorder(Color.red,1);
            ruhtsat_sorgula_alan.setBorder(border);
        }
        araclar.Yenile();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jTable1){
            araclar.Goruntule();
        }
        if(e.getSource()==marka_sorgula_alan){
            String select=marka_sorgula_alan.getSelectedItem().toString();
            marka_sorgula_alan.setModel(new javax.swing.DefaultComboBoxModel<>(Araclar.MarkaCek()));
            marka_sorgula_alan.setSelectedItem(select);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static DefaultTableModel getModel() {
        return model;
    }

    private javax.swing.JButton arac_duzenle_button;
    private javax.swing.JButton arac_sil_button;
    private javax.swing.JScrollPane arac_table;
    private static javax.swing.JComboBox<String> arac_tip_sorgula_alan;
    private javax.swing.JButton kapat_button;
    private static javax.swing.JTextField aractip_alan;
    private static javax.swing.JComboBox<String> kasa_tip_sorgu_alan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTextField kasa_tip_alan;
    private static javax.swing.JTextField marka_alan;
    private static javax.swing.JComboBox<String> marka_sorgula_alan;
    private static javax.swing.JTextField model_alan;
    private static javax.swing.JComboBox<String> model_sorgula_alan;
    private static javax.swing.JTextField motor_gucualan;
    private static javax.swing.JTextField motor_hacmi_alan;
    private static javax.swing.JTextField motor_no_alan;
    private static javax.swing.JFormattedTextField plaka_alan;
    private static javax.swing.JTextField plaka_sorgula_alan;
    private static javax.swing.JTextField renk_alan;
    private static javax.swing.JTextField ruhsat_alan;
    private static javax.swing.JTextField ruhtsat_sorgula_alan;
    private static javax.swing.JTextField sanziman_alan;
    private static javax.swing.JTextField sasi_alan;
    private static javax.swing.JTextField yakit_alan;
    private static javax.swing.JButton yeni_arac_button;
    private static javax.swing.JButton yenile_button;
    private static javax.swing.JTextField yil_alan;


    public JButton getArac_duzenle_button() {
        return arac_duzenle_button;
    }

    public JButton getArac_sil_button() {
        return arac_sil_button;
    }

    public JScrollPane getArac_table() {
        return arac_table;
    }

    public static JComboBox<String> getArac_tip_sorgula_alan() {
        return arac_tip_sorgula_alan;
    }

    

    public static JTable getjTable1() {
        return jTable1;
    }

    public static JTextField getKasa_tip_alan() {
        return kasa_tip_alan;
    }

    public static JTextField getMarka_alan() {
        return marka_alan;
    }

    public static JComboBox<String> getMarka_sorgula_alan() {
        return marka_sorgula_alan;
    }

    public static JTextField getModel_alan() {
        return model_alan;
    }

    public static JComboBox<String> getModel_sorgula_alan() {
        return model_sorgula_alan;
    }

    public static JTextField getMotor_gucualan() {
        return motor_gucualan;
    }

    public static JTextField getMotor_hacmi_alan() {
        return motor_hacmi_alan;
    }

    public static JTextField getMotor_no_alan() {
        return motor_no_alan;
    }

    public static JFormattedTextField getPlaka_alan() {
        return plaka_alan;
    }

    public static JTextField getPlaka_sorgula_alan() {
        return plaka_sorgula_alan;
    }

    public static JTextField getRenk_alan() {
        return renk_alan;
    }

    public static JTextField getRuhsat_alan() {
        return ruhsat_alan;
    }

    public static JTextField getRuhtsat_sorgula_alan() {
        return ruhtsat_sorgula_alan;
    }

    public static JTextField getSanziman_alan() {
        return sanziman_alan;
    }

    public static JTextField getSasi_alan() {
        return sasi_alan;
    }

    public static JTextField getYakit_alan() {
        return yakit_alan;
    }

    public static JButton getYeni_arac_button() {
        return yeni_arac_button;
    }

    public static JButton getYenile_button() {
        return yenile_button;
    }

    public static JTextField getYil_alan() {
        return yil_alan;
    }

    public static JTextField getAractip_alan() {
        return aractip_alan;
    }

    public static JComboBox<String> getKasa_tip_sorgu_alan() {
        return kasa_tip_sorgu_alan;
    }

}
