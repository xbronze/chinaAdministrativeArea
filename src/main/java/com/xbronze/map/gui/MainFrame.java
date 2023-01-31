package com.xbronze.map.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private final JFrame frame = new JFrame("地图");
    private final Container container = frame.getContentPane();
    private final JButton queryButton = new JButton("查询");
    private final JButton exportButton = new JButton("导出");

    private final JLabel keyLabel = new JLabel("key:");
    private final JTextField keyText = new JTextField(50);
    private final JLabel mapLabel = new JLabel("地图类型:");
    private final JComboBox<String> comboBox = new JComboBox<>(new String[]{"高德地图", "百度地图"});


    public MainFrame(){
        frame.setSize(900, 600);
        container.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        frame.setVisible(true);
    }

    public void init(){
        // 输入
        JPanel inputPanel = new JPanel();

        keyLabel.setBounds(10, 20, 80, 25);
        mapLabel.setBounds(10, 50, 80, 25);
        inputPanel.add(keyLabel);
        inputPanel.add(mapLabel);
        keyText.setBounds(100, 20, 200, 25);
        comboBox.setBounds(100, 50, 200, 25);
        inputPanel.add(keyText);
        inputPanel.add(comboBox);

        container.add(inputPanel, BorderLayout.NORTH);

        // 按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        queryButton.setActionCommand("query");
        buttonPanel.add(addButtonListener(queryButton));
        exportButton.setActionCommand("export");
        buttonPanel.add(addButtonListener(exportButton));
        container.add(buttonPanel, BorderLayout.CENTER);

        // 输出
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("HELLO WORLD"));
        container.add(outputPanel, BorderLayout.SOUTH);
    }

    public JButton addButtonListener(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "query" :
                        System.out.println("queryButton check, key value :" + keyText.getText());
                        break;
                    case "export" :
                        System.out.println("exportButton check, key value :" + keyText.getText());
                        break;
                    default:
                        break;
                }

            }
        });
        return button;
    }
}