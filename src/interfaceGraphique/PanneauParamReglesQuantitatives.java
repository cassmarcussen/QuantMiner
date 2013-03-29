/*                                             
 *Copyright 2007, 2011 CCLS Columbia University (USA), LIFO University of Orl��ans (France), BRGM (France)
 *
 *Authors: Cyril Nortet, Xiangrong Kong, Ansaf Salleb-Aouissi, Christel Vrain, Daniel Cassard
 *
 *This file is part of QuantMiner.
 *
 *QuantMiner is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 *
 *QuantMiner is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License along with QuantMiner.  If not, see <http://www.gnu.org/licenses/>.
 */
package src.interfaceGraphique;

import javax.swing.*;

import src.apriori.*;
import src.solver.*;
import src.utilitaires.*;



public class PanneauParamReglesQuantitatives extends PanneauParamBase {//step 3 rule parameters for generic algorithm
    
    /** Creates new form PanneauParamRegles */
    public PanneauParamReglesQuantitatives(ContexteResolution contexteResolution) {
        super(contexteResolution);

        ImageIcon iconeRetourDefaut = null;
        
        initComponents();
        
        if (m_contexteResolution == null)
            return;
        
        // Ic�nes sur les boutons :
        iconeRetourDefaut = new ImageIcon( ENV.REPERTOIRE_RESSOURCES + "retour_defaut.jpg" );
        jButtonDefautSupport.setIcon(iconeRetourDefaut);
        jButtonDefautConfiance.setIcon(iconeRetourDefaut);
        jButtonDefautSupportDisjonctions.setIcon(iconeRetourDefaut);
        
        
        // Initialisation du contenu des champs :
        jTextFieldSupport.setText( ContexteResolution.EcrirePourcentage(m_contexteResolution.m_parametresReglesQuantitatives.m_fMinSupp, 3, false) );
        jTextFieldConfiance.setText( ContexteResolution.EcrirePourcentage(m_contexteResolution.m_parametresReglesQuantitatives.m_fMinConf, 3, false) );
        
        jTextMiniQuants.setText( String.valueOf( m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreMinAttributsQuant ) );
        jTextMaxiQuants.setText( String.valueOf( m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreMaxAttributsQuant ) );

        if (  (m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsGauche>0)
            &&(m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsGauche<=10) )
            jComboDisjonctionsGauche.setSelectedIndex(m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsGauche - 1);
        else
            jComboDisjonctionsGauche.setSelectedIndex(0);
            
        if (  (m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsDroite>0)
            &&(m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsDroite<=10) )
            jComboDisjonctionsDroite.setSelectedIndex(m_contexteResolution.m_parametresReglesQuantitatives.m_iNombreDisjonctionsDroite - 1);
        else
            jComboDisjonctionsDroite.setSelectedIndex(0);
        
        jTextSupportSupplementaire.setText( ContexteResolution.EcrirePourcentage(m_contexteResolution.m_parametresReglesQuantitatives.m_fMinSuppDisjonctions, 3, false) );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTextFieldSupport = new javax.swing.JTextField();
        jLabelSupport = new javax.swing.JLabel();
        jLabelConfiance = new javax.swing.JLabel();
        jTextFieldConfiance = new javax.swing.JTextField();
        jLabelDisjonctionsGauche = new javax.swing.JLabel();
        jLabelDisjonctionsDroite = new javax.swing.JLabel();
        jComboDisjonctionsGauche = new javax.swing.JComboBox();
        jComboDisjonctionsDroite = new javax.swing.JComboBox();
        jLabelMiniQuants = new javax.swing.JLabel();
        jTextMiniQuants = new javax.swing.JTextField();
        jLabelMaxiQuants = new javax.swing.JLabel();
        jTextMaxiQuants = new javax.swing.JTextField();
        jLabelSupportSupplementaire = new javax.swing.JLabel();
        jTextSupportSupplementaire = new javax.swing.JTextField();
        jSeparatorDisjonctions = new javax.swing.JSeparator();
        jButtonDefautSupport = new javax.swing.JButton();
        jButtonDefautConfiance = new javax.swing.JButton();
        jButtonDefautSupportDisjonctions = new javax.swing.JButton();

        setLayout(null);

        setPreferredSize(new java.awt.Dimension(570, 237));
        jTextFieldSupport.setInputVerifier(new UtilitairesInterface.VerifieurTextFieldIntervalleFloat(0.0f, 100.0f));
        add(jTextFieldSupport);
        jTextFieldSupport.setBounds(190, 20, 100, 19);

        jLabelSupport.setText("Support threshold (%):");
        add(jLabelSupport);
        jLabelSupport.setBounds(20, 20, 220, 14); //160-->220

        jLabelConfiance.setText("Confidence threshold  (%): ");
        add(jLabelConfiance);
        jLabelConfiance.setBounds(20, 50, 220, 14); //160-->220

        jTextFieldConfiance.setInputVerifier(new UtilitairesInterface.VerifieurTextFieldIntervalleFloat(0.0f, 100.0f));
        add(jTextFieldConfiance);
        jTextFieldConfiance.setBounds(190, 50, 100, 19);

        jLabelDisjonctionsGauche.setText("Number of allowed disjunctions (\"OR\") in the rule left-hand side:");
        add(jLabelDisjonctionsGauche);
        jLabelDisjonctionsGauche.setBounds(20, 140, 380, 14);

        jLabelDisjonctionsDroite.setText("Number of allowed disjunctions (\"OR\") in the rule right-hand side:");
        add(jLabelDisjonctionsDroite);
        jLabelDisjonctionsDroite.setBounds(20, 170, 380, 14);

        jComboDisjonctionsGauche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 (only one interval)", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        add(jComboDisjonctionsGauche);
        jComboDisjonctionsGauche.setBounds(400, 140, 150, 20);

        jComboDisjonctionsDroite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 (only one  interval)", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        add(jComboDisjonctionsDroite);
        jComboDisjonctionsDroite.setBounds(400, 170, 150, 20);

        jLabelMiniQuants.setText("Number of quantitative attributes in a rule, minimum: ");
        add(jLabelMiniQuants);
        jLabelMiniQuants.setBounds(20, 90, 370, 14); //310--> 370

        add(jTextMiniQuants);
        jTextMiniQuants.setBounds(400, 90, 60, 19); //340-->400

        jLabelMaxiQuants.setText("maximum:");
        add(jLabelMaxiQuants);
        jLabelMaxiQuants.setBounds(470, 90, 70, 14); //410 --> 470

        add(jTextMaxiQuants);
        jTextMaxiQuants.setBounds(550, 90, 60, 19); //490-->550

        jLabelSupportSupplementaire.setText("Support threshold for additional intervals (%):");
        add(jLabelSupportSupplementaire);
        jLabelSupportSupplementaire.setBounds(20, 200, 340, 14);

        jTextSupportSupplementaire.setInputVerifier(new UtilitairesInterface.VerifieurTextFieldIntervalleFloat(0.0f, 100.0f));
        add(jTextSupportSupplementaire);
        jTextSupportSupplementaire.setBounds(400, 200, 100, 19);

        add(jSeparatorDisjonctions);
        jSeparatorDisjonctions.setBounds(20, 125, 530, 10);

        jButtonDefautSupport.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDefautSupport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefautSupportActionPerformed(evt);
            }
        });

        add(jButtonDefautSupport);
        jButtonDefautSupport.setBounds(300, 20, 20, 20);

        jButtonDefautConfiance.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDefautConfiance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefautConfianceActionPerformed(evt);
            }
        });

        add(jButtonDefautConfiance);
        jButtonDefautConfiance.setBounds(300, 50, 20, 20);

        jButtonDefautSupportDisjonctions.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDefautSupportDisjonctions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefautSupportDisjonctionsActionPerformed(evt);
            }
        });

        add(jButtonDefautSupportDisjonctions);
        jButtonDefautSupportDisjonctions.setBounds(510, 200, 20, 20);

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDefautSupportDisjonctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefautSupportDisjonctionsActionPerformed
        jTextSupportSupplementaire.setText( ContexteResolution.EcrirePourcentage(ParametresStandardsQuantitatifs.DEFAUT_MINSUPP_DISJONCTIONS, 3, false) );
    }//GEN-LAST:event_jButtonDefautSupportDisjonctionsActionPerformed

    private void jButtonDefautSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefautSupportActionPerformed
        jTextFieldSupport.setText( ContexteResolution.EcrirePourcentage(ParametresStandardsQuantitatifs.DEFAUT_MINSUPP, 3, false) );
    }//GEN-LAST:event_jButtonDefautSupportActionPerformed

    private void jButtonDefautConfianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefautConfianceActionPerformed
        jTextFieldConfiance.setText( ContexteResolution.EcrirePourcentage(ParametresStandardsQuantitatifs.DEFAUT_MINCONF, 3, false) );
    }//GEN-LAST:event_jButtonDefautConfianceActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDefautConfiance;
    private javax.swing.JButton jButtonDefautSupport;
    private javax.swing.JButton jButtonDefautSupportDisjonctions;
    private javax.swing.JComboBox jComboDisjonctionsDroite;
    private javax.swing.JComboBox jComboDisjonctionsGauche;
    private javax.swing.JLabel jLabelConfiance;
    private javax.swing.JLabel jLabelDisjonctionsDroite;
    private javax.swing.JLabel jLabelDisjonctionsGauche;
    private javax.swing.JLabel jLabelMaxiQuants;
    private javax.swing.JLabel jLabelMiniQuants;
    private javax.swing.JLabel jLabelSupport;
    private javax.swing.JLabel jLabelSupportSupplementaire;
    private javax.swing.JSeparator jSeparatorDisjonctions;
    private javax.swing.JTextField jTextFieldConfiance;
    private javax.swing.JTextField jTextFieldSupport;
    private javax.swing.JTextField jTextMaxiQuants;
    private javax.swing.JTextField jTextMiniQuants;
    private javax.swing.JTextField jTextSupportSupplementaire;
    // End of variables declaration//GEN-END:variables
    
    
      
    
    public boolean EnregistrerParametres() {
        
        ParametresStandardsQuantitatifs parametresReglesQuantitatives = null;
        float fMinSupp = 0.0f;
        float fMinConf = 0.0f;
        int iNombreMaxAttributsQuant = 0;
        int iNombreMinAttributsQuant = 0;
        int iNombreDisjonctionsGauche = 0;
        int iNombreDisjonctionsDroite = 0;
        float fMinSuppDisjonctions = 0.0f;
        
        
        parametresReglesQuantitatives = m_contexteResolution.m_parametresReglesQuantitatives;
        if (parametresReglesQuantitatives == null)
            return true;
    
        // M�morisation des param�tres :
        
        try {
            fMinSupp = (float) ( Double.parseDouble( jTextFieldSupport.getText() ) / 100.0 );
            parametresReglesQuantitatives.m_fMinSupp = fMinSupp;
        }
        catch (NumberFormatException e) {
            return false;
        }
 
        try {
            fMinConf = (float) ( Double.parseDouble( jTextFieldConfiance.getText() ) / 100.0 );
            parametresReglesQuantitatives.m_fMinConf = fMinConf;
        }
        catch (NumberFormatException e) {
            return false;
        }

        try {
            iNombreMinAttributsQuant = Integer.parseInt( jTextMiniQuants.getText() );
            parametresReglesQuantitatives.m_iNombreMinAttributsQuant = iNombreMinAttributsQuant;
        }
        catch (NumberFormatException e) {
            return false;
        }
        
        try {
            iNombreMaxAttributsQuant = Integer.parseInt( jTextMaxiQuants.getText() );
            parametresReglesQuantitatives.m_iNombreMaxAttributsQuant = iNombreMaxAttributsQuant;
        }
        catch (NumberFormatException e) {
            return false;
        }
        
        iNombreDisjonctionsGauche = jComboDisjonctionsGauche.getSelectedIndex();
        if ( (iNombreDisjonctionsGauche<0) || (iNombreDisjonctionsGauche>=10) )
            iNombreDisjonctionsGauche = 0;
        parametresReglesQuantitatives.m_iNombreDisjonctionsGauche = iNombreDisjonctionsGauche + 1;
        
        iNombreDisjonctionsDroite = jComboDisjonctionsDroite.getSelectedIndex();
        if ( (iNombreDisjonctionsDroite<0) || (iNombreDisjonctionsDroite>=10) )
            iNombreDisjonctionsDroite = 0;
        parametresReglesQuantitatives.m_iNombreDisjonctionsDroite = iNombreDisjonctionsDroite + 1;
        
        try {
            fMinSuppDisjonctions = (float) ( Double.parseDouble( jTextSupportSupplementaire.getText() ) / 100.0 );
            parametresReglesQuantitatives.m_fMinSuppDisjonctions = fMinSuppDisjonctions;
        }
        catch (NumberFormatException e) {
            return false;
        }

        
        return true;    
    }
    
    
}