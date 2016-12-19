package com.maple.spider.vnc.SwingDemo;


import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonSubmit extends JButton {

	public JButtonSubmit() {
		setText("Submit");
		addActionListener(new ActionListenerSubmit());
	}
}
