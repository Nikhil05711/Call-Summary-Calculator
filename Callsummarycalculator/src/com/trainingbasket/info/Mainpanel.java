package com.trainingbasket.info;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.trainingbasket.service.CallSummaryService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Mainpanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpanel window = new Mainpanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainpanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnCallSummaryCalculator = new JMenu("Call summary calculator");
		mnFile.add(mnCallSummaryCalculator);

		JMenu mnSyntel = new JMenu(" Syntel Text To Summary");
		mnSyntel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCallSummaryCalculator.add(mnSyntel);

		JMenuItem mntmTextToCsv = new JMenuItem("text to csv");
		mntmTextToCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int status = chooser.showOpenDialog(menuBar);
				System.out.println(status);
				if (status == 0) {
					CallSummaryService callSummaryService = new CallSummaryService(chooser.getSelectedFile().getPath(),
							"f:\\output.csv");
					callSummaryService.readFile();
					callSummaryService.writeInFile();
				}
				JOptionPane.showMessageDialog(menuBar, "c\\data\\aaa\\csv");
			}
		});
		mnSyntel.add(mntmTextToCsv);
	}
}
