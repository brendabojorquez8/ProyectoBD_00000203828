/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import datos.BarcosDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import negocios.Control;
import objetosNegocio.Barco;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Salida;

public class FrmSalidas extends javax.swing.JFrame {

    private Control control;
    private BarcosDAO barcosDAO;

    /**
     * Creates new form FrmSalidas
     */
    public FrmSalidas() {
        initComponents();
        this.control = new Control();
        txtFechaHora.setToolTipText("Formato YYYY-MM-DD HH:MM:SS");

        this.cargarSalidas();
        this.cargarCmb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAzul = new javax.swing.JPanel();
        panelBlanco = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        panSalidas = new javax.swing.JScrollPane();
        tblSalidas = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbDestino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        lbFEchaHora = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JTextField();
        lbBarco = new javax.swing.JLabel();
        cmbBarcos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo Salidas");

        panelAzul.setBackground(new java.awt.Color(187, 209, 234));

        panelBlanco.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTitulo.setText("Salidas");

        panSalidas.setBackground(new java.awt.Color(255, 255, 255));

        tblSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha_Hora", "Destino", "ID_Barco", "Nombre_Barco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panSalidas.setViewportView(tblSalidas);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lbId.setText("ID");

        txtId.setText("0");

        lbDestino.setText("Destino");

        lbFEchaHora.setText("Fecha Hora");

        lbBarco.setText("Barco");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnMenu.setText("Menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/icons8-barco-regresa-al-puerto-40.png"))); // NOI18N

        javax.swing.GroupLayout panelBlancoLayout = new javax.swing.GroupLayout(panelBlanco);
        panelBlanco.setLayout(panelBlancoLayout);
        panelBlancoLayout.setHorizontalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDestino)
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFEchaHora)
                            .addComponent(lbBarco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(panSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBlancoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(40, 40, 40))
            .addGroup(panelBlancoLayout.createSequentialGroup()
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMenu))
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(lbIcon)
                        .addGap(18, 18, 18)
                        .addComponent(lbTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBlancoLayout.setVerticalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon)
                    .addComponent(lbTitulo))
                .addGap(30, 30, 30)
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBlancoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDestino)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFEchaHora)
                            .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBarco)
                            .addComponent(cmbBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))))
                .addGap(18, 18, 18)
                .addGroup(panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAzulLayout = new javax.swing.GroupLayout(panelAzul);
        panelAzul.setLayout(panelAzulLayout);
        panelAzulLayout.setHorizontalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAzulLayout.setVerticalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.txtId.getText().equals("0")) {
            if (!txtDestino.getText().isEmpty()&&
                    !txtFechaHora.getText().isEmpty()&&
                    cmbBarcos.getSelectedIndex()!=0) {
                this.guardarSalida();
                this.limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this, "Deben llenarse todos los datos", "Alerta", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            this.actualizarSalida();
            this.limpiarFormulario();
        }

        
        this.cargarSalidas();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.cargarSalida();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.cargarSalidas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarSalida();
        this.cargarSalidas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    private void limpiarFormulario() {
        txtId.setText("0");
        txtDestino.setText("");
        txtFechaHora.setText("");
        cmbBarcos.setSelectedIndex(0);
    }

    private void cargarCmb() {
        Barco seleccione = new Barco();
        seleccione.setNombre("Seleccione");
        cmbBarcos.addItem(seleccione);
        List<Barco> barcos = this.control.obtenerBarcos(txtBusqueda.getText());
        if (barcos != null) {
            for (Barco barco : barcos) {
                cmbBarcos.addItem(barco);
            }
        }
    }

    private void cargarSalidas() {
        List<Salida> salidas = this.control.obtenerSalidas(txtBusqueda.getText());
        if (salidas != null) {
            DefaultTableModel modelo = (DefaultTableModel) tblSalidas.getModel();
            //borra los registros
            modelo.setRowCount(0);
            for (Salida salida : salidas) {
                modelo.addRow(salida.toArray());
            }
        }

    }

    private void guardarSalida() {

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //averiguar qué formato acepta ese
        //try catch
        Salida salida = new Salida();
        try {
            salida.setFechaHora(new java.sql.Date(formater.parse(txtFechaHora.getText()).getTime()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha incorrecta", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        salida.setDestino(txtDestino.getText());
        salida.setBarco((Barco) cmbBarcos.getSelectedItem());
        this.control.guardarSalida(salida);
    }

    private void actualizarSalida() {
        //usar el simpleDate con el parse y pues el try catch
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Salida salida = new Salida();
        salida.setId(Integer.parseInt(txtId.getText()));
        salida.setDestino(txtDestino.getText());
        salida.setBarco((Barco) cmbBarcos.getSelectedItem());
        try {
            salida.setFechaHora(new java.sql.Date(formater.parse(txtFechaHora.getText()).getTime()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha incorrecta", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        this.control.actualizarSalida(salida);
    }

    private void cargarSalida() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int fila = this.tblSalidas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una salida", "información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) this.tblSalidas.getModel();
            Integer idSalida = (Integer) modelo.getValueAt(fila, 0);
            Salida salida = this.control.consultarSalidaPorId(idSalida);
            if (salida != null) {
                txtId.setText(salida.getId().toString());
                txtDestino.setText(salida.getDestino());
                txtFechaHora.setText(formater.format(salida.getFechaHora()));
                cmbBarcos.setSelectedItem(salida.getBarco());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la salida", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void eliminarSalida() {
        int fila = this.tblSalidas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una salida", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) this.tblSalidas.getModel();
            Integer idSalida = (Integer) modelo.getValueAt(fila, 0);
            boolean eliminacionExitosa = this.control.eliminarSalida(idSalida);
            if (eliminacionExitosa) {
                JOptionPane.showMessageDialog(this, "Salida eliminada correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la salida", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<Barco> cmbBarcos;
    private javax.swing.JLabel lbBarco;
    private javax.swing.JLabel lbDestino;
    private javax.swing.JLabel lbFEchaHora;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JScrollPane panSalidas;
    private javax.swing.JPanel panelAzul;
    private javax.swing.JPanel panelBlanco;
    private javax.swing.JTable tblSalidas;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
