package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter {

    private JFrame frame;
    private JLabel inputLabel, outputLabel;
    private JTextField input;
    private JTextField output;
    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;
    private JButton convertButton;

    protected void initComponents(){
        frame=new JFrame("Unit Converter");
        frame.setSize(400,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        inputLabel=new JLabel("Input: ");
        input=new JTextField(10);
        outputLabel=new JLabel("Output: ");
        output=new JTextField(10);
        output.setEditable(false);
        fromUnit=new JComboBox<String>(new String[]{"Meters","Feet","Inches","Centimeters"});
        toUnit=new JComboBox<String>(new String[]{"Meters","Feet","Inches","Centimeters"});
        convertButton=new JButton("Convert");

        inputLabel.setBounds(20,20,100,20);
        input.setBounds(150,20,100,20);
        fromUnit.setBounds(270,20,100,20);
        outputLabel.setBounds(20,50,100,20);
        output.setBounds(150,50,100,20);
        toUnit.setBounds(270,50,100,20);
        convertButton.setBounds(150,80,100,20);

        convertButton.addActionListener(new ConvertButtonListener());

        frame.add(inputLabel);
        frame.add(input);
        frame.add(fromUnit);
        frame.add(outputLabel);
        frame.add(output);
        frame.add(toUnit);
        frame.add(convertButton);

        frame.setVisible(true);
    }

    public UnitConverter(){
        initComponents();
    }

    public static void main(String[] args){
        new UnitConverter();
    }


    private class ConvertButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String fromUnitType=fromUnit.getSelectedItem().toString();
            String toUnitType=toUnit.getSelectedItem().toString();
            double inputValue;
            double outputValue=0.0;
            try {
                inputValue = Double.parseDouble(input.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid number!");
                return;
            }
            if(fromUnitType.equals("Meters")){
                if(toUnitType.equals("Feet")){
                    outputValue = UnitConverter.meterstoFeet(inputValue);
                }
            }


            if(fromUnitType.equals("Meters")){
                if(toUnitType.equals("Meters")){
                    outputValue= UnitConverter.meterstoMeters(inputValue);
                } else if (toUnitType.equals("Feet")) {
                    outputValue= UnitConverter.meterstoFeet(inputValue);
                } else if (toUnitType.equals("Inches")) {
                    outputValue= UnitConverter.meterstoInches(inputValue);
                } else if (toUnitType.equals("Centimeters")) {
                    outputValue= UnitConverter.meterstoCentimeters(inputValue);
                }

            } else if (fromUnitType.equals("Feet")) {
                if(toUnitType.equals("Meters")){
                    outputValue= UnitConverter.FeettoMeters(inputValue);
                } else if (toUnitType.equals("Feet")) {
                    outputValue= UnitConverter.FeettoFeet(inputValue);
                } else if (toUnitType.equals("Inches")) {
                    outputValue= UnitConverter.FeettoInches(inputValue);
                } else if (toUnitType.equals("Centimeters")) {
                    outputValue= UnitConverter.FeettoCentimeters(inputValue);
                }

            } else if (fromUnitType.equals("Inches")){
                if(toUnitType.equals("Meters")){
                    outputValue= UnitConverter.InchestoMeters(inputValue);
                } else if (toUnitType.equals("Feet")) {
                    outputValue= UnitConverter.InchestoFeet(inputValue);
                } else if (toUnitType.equals("Inches")) {
                    outputValue= UnitConverter.InchestoInches(inputValue);
                } else if (toUnitType.equals("Centimeters")) {
                    outputValue= UnitConverter.InchestoCentimeters(inputValue);
                }

            } else if (fromUnitType.equals("Centimeters")) {
                if(toUnitType.equals("Meters")){
                    outputValue= UnitConverter.CentimeterstoMeters(inputValue);
                } else if (toUnitType.equals("Feet")) {
                    outputValue= UnitConverter.CentimeterstoFeet(inputValue);
                } else if (toUnitType.equals("Inches")) {
                    outputValue= UnitConverter.CentimeterstoInches(inputValue);
                } else if (toUnitType.equals("Centimeters")) {
                    outputValue= UnitConverter.CentimeterstoCentimeters(inputValue);
                }
            }
            output.setText(String.format("%.2f", outputValue));
        }
    }

    //Meters to *
    public static double meterstoMeters(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double meterstoCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue*100;
        return outputValue;
    }
    public static double meterstoFeet(double inputValue){
        double outputValue;
        outputValue=inputValue*3.28084;
        return outputValue;
    }
    public static double meterstoInches(double inputValue){
        double outputValue;
        outputValue=inputValue*3.28084*12;
        return outputValue;
    }

    //Feet to *
    public static double FeettoMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/3.28084;
        return outputValue;
    }
    public static double FeettoCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue/3.28084*100;
        return outputValue;
    }
    public static double FeettoFeet(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double FeettoInches(double inputValue){
        double outputValue;
        outputValue=inputValue*12;
        return outputValue;
    }

    //Inches to *
    public static double InchestoMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/12/3.28084;
        return outputValue;
    }
    public static double InchestoCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue/12/3.28084*100;
        return outputValue;
    }
    public static double InchestoFeet(double inputValue){
        double outputValue;
        outputValue=inputValue/12;
        return outputValue;
    }
    public static double InchestoInches(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }

    // Centimeters to *
    public static double CentimeterstoMeters(double inputValue){
        double outputValue;
        outputValue=inputValue/100;
        return outputValue;
    }
    public static double CentimeterstoCentimeters(double inputValue){
        double outputValue;
        outputValue=inputValue;
        return outputValue;
    }
    public static double CentimeterstoFeet(double inputValue){
        double outputValue;
        outputValue=inputValue/100*3.28084;
        return outputValue;
    }
    public static double CentimeterstoInches(double inputValue){
        double outputValue;
        outputValue=inputValue/100*3.28084*12;
        return outputValue;
    }
}

