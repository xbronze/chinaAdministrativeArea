package com.xbronze.map;

import com.xbronze.map.domain.MapInfoVO;
import com.xbronze.map.factory.MapFactory;
import com.xbronze.map.gui.MainFrame;
import com.xbronze.map.service.MapService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * 地图api key
     */
    private static final String KEY = "";

    public static void main( String[] args ) {
        //MapFactory factory = new MapFactory();
        //MapService mapService = factory.createMapService("baidu");
        //try {
        //    List<MapInfoVO> mapInfoVOList = mapService.administrativeAreaBuilder(KEY, 2, "1", "中华人民共和国", null);
        //    for (MapInfoVO mapInfoVO : mapInfoVOList) {
        //        System.out.println(mapInfoVO.toString());
        //    }
        //} catch (Exception e) {
        //    System.out.println("Exception!!! the message is :" + e.getMessage());
        //}

        //SwingUtilities.invokeLater(new Runnable() {
        //    @Override
        //    public void run() {
        //        createAndShowGUI();
        //    }
        //});

        new MainFrame();
    }

    private static void createAndShowGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.RED));
        panel.setBounds(10, 10, 870, 200);
        panel.add(northPanelInputBuild(), BorderLayout.WEST);
        panel.add(northPanelButtonBuild(), BorderLayout.EAST);
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setBorder(new LineBorder(Color.BLUE));
        panel2.setBounds(10, 220, 870, 340);
        panel2.add(new JLabel("HELLO WORLD"));
        frame.getContentPane().add(panel2, BorderLayout.SOUTH);

        frame.pack();
        frame.setTitle("地图信息获取");
        frame.setSize(900, 600);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }

    public static JPanel northPanelInputBuild(){
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.CYAN));
        JLabel keyLabel = new JLabel("key:");
        keyLabel.setBounds(10, 20, 80, 25);
        panel.add(keyLabel);

        JTextField keyText = new JTextField(50);
        keyText.setBounds(100, 20, 200, 25);
        panel.add(keyText);

        JLabel mapLabel = new JLabel("地图类型:");
        mapLabel.setBounds(10, 50, 80, 25);
        panel.add(mapLabel);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"高德地图", "百度地图"});
        comboBox.setBounds(100, 50, 200, 25);
        panel.add(comboBox);
        return panel;
    }

    public static JPanel northPanelButtonBuild(){
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.PINK));
        JButton queryButton = new JButton("查询");
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("查询按钮被点击");
            }
        });
        panel.add(queryButton);

        JButton exportButton = new JButton("导出");
        panel.add(exportButton);
        return panel;
    }
}
