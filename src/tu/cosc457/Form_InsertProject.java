package tu.cosc457;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_InsertProject {
    private JPanel rootPanel;
    private JTextField pfwrField;
    private JComboBox statusComboBox;
    private JComboBox departmentComboBox;
    private JComboBox entryTypeComboBox;
    private JTextField budgetCodeField;
    private JTextField buildingField;
    private JTextField roomField;
    private JComboBox stComboBox;
    private JTextField stPropField;
    private JTextField tfEndField;
    private JTextField tfStartField;
    private JTextField initialWstField;
    private JTextField finalWstField;
    private JLabel subtype_l;
    private JLabel stProp_l;
    private JLabel other_l;
    private JLabel tf_l;
    private JLabel wst_l;
    private JLabel tfStart_l;
    private JLabel tfEnd_l;
    private JLabel wstInitial_l;
    private JLabel wstFinal_l;
    private JLabel entryType_l;
    private JLabel room_l;
    private JLabel building_l;
    private JLabel budgetCode_l;
    private JLabel department_l;
    private JLabel status_l;
    private JLabel pfwr_l;

    private String building, room, budgetCode, pfwr;
    private EntryType et;
    private String[]
            taskSubTypes = {"", "Service", "Design", "Estimate", "Other"},
            projectSubTypes = {"", "Installation", "Modification", "ConvertSpace", "NewConstruction", "Repair", "Other"};

    void changeEntryType(EntryType et){
        this.et=et;
        if(et == EntryType.Project){
            subtype_l.setText("Project Type");
            stComboBox.setModel((new JComboBox(projectSubTypes)).getModel());
            stProp_l.setText("Project Manager");

            subtype_l.setVisible(true);
            stComboBox.setVisible(true);
            stProp_l.setVisible(true);
            stPropField.setVisible(true);
            other_l.setVisible(true);
            tf_l.setVisible(true);
            tfEnd_l.setVisible(true);
            tfEndField.setVisible(true);
            tfStart_l.setVisible(true);
            tfStartField.setVisible(true);
        }
        else if(et == EntryType.Task){
            subtype_l.setText("Task Type");
            stComboBox.setModel((new JComboBox(taskSubTypes)).getModel());
            stProp_l.setText("Parent Project PFWR");

            subtype_l.setVisible(true);
            stComboBox.setVisible(true);
            stProp_l.setVisible(true);
            stPropField.setVisible(true);
            other_l.setVisible(true);
            tf_l.setVisible(true);
            tfEnd_l.setVisible(true);
            tfEndField.setVisible(true);
            tfStart_l.setVisible(true);
            tfStartField.setVisible(true);
        }
        else{
            resetEntryTypeFields();
        }
    }
    void resetEntryTypeFields(){
        subtype_l.setVisible(false);
        stComboBox.setVisible(false);
        stProp_l.setVisible(false);
        stPropField.setVisible(false);
        other_l.setVisible(false);
        tf_l.setVisible(false);
        tfEnd_l.setVisible(false);
        tfEndField.setVisible(false);
        tfStart_l.setVisible(false);
        tfStartField.setVisible(false);
        wst_l.setVisible(false);
        wstInitial_l.setVisible(false);
        initialWstField.setVisible(false);
        wstFinal_l.setVisible(false);
        finalWstField.setVisible(false);
    }

    private void createUIComponents() {
        et = EntryType.UNSELECTED;
        subtype_l.setVisible(false);
        stComboBox.setVisible(false);
        stProp_l.setVisible(false);
        stPropField.setVisible(false);
        other_l.setVisible(false);
        tf_l.setVisible(false);
        tfEnd_l.setVisible(false);
        tfEndField.setVisible(false);
        tfStart_l.setVisible(false);
        tfStartField.setVisible(false);
        wst_l.setVisible(false);
        wstInitial_l.setVisible(false);
        initialWstField.setVisible(false);
        wstFinal_l.setVisible(false);
        finalWstField.setVisible(false);
        entryTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox c = (JComboBox) e.getSource();
                changeEntryType(EntryType.fromString((String)c.getSelectedItem()));
            }
        });

        // TODO: place custom component creation code here
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Form_InsertProject");
        Form_InsertProject f = new Form_InsertProject();
        f.createUIComponents();
        frame.setContentPane(f.rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

enum CompletionStatus{
    UNSELECTED,
    COMPLETE,
    INCOMPLETE
}
enum Department{
    UNSELECTED,
    AISD,
    AMDD,
    AMDS,
    AOD,
    AOS,
    BCFD,
    BCSD,
    BSD,
    CL,
    CLO,
    COMM,
    FMD,
    FPD,
    FPS,
    GED,
    HRSD,
    ITSD,
    MERC,
    NSAD,
    NSTD,
    PESD,
    REDD,
    RSD,
    SD,
    SDO,
    SECD,
    SES,
    SS,
    TSD,
    TSX
}

enum EntryType {
    UNSELECTED("UNSELECTED"),
    Project("Project"),
    Task("Task");
    private final String type;
    private EntryType(final String type){
        this.type = type;
    }
    public static EntryType fromString(String s){
        for(EntryType t: EntryType.values()){
            if(t.type.equalsIgnoreCase(s)){
                return t;
            }
        }
        return UNSELECTED;
    }

}
enum TaskSubType{
    UNSELECTED,
    Service,
    Design,
    Estimate,
    Other
}
enum ProjectSubType{
    UNSELECTED,
    Installation,
    Modification,
    ConvertSpace,
    NewConstruction,
    Repair,
    Other
}
