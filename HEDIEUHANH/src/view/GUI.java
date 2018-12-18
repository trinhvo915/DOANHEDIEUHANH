package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import handel.ShowFlieData;
import mode.Data;
import mode.DataBean;
import banker.ActionBanker;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	ArrayList<DataBean> arrayListMax = null;
	ArrayList<DataBean> arrayListAllo = null;
	ArrayList<DataBean> arrayListNeed = null;
	ArrayList<DataBean> arrayListAvali = null;
	ArrayList<DataBean> arrayListListAvali = null;

	private DefaultTableModel defaultTableModelMax;
	private DefaultTableModel defaultTableModelAllo;
	private DefaultTableModel defaultTableModelNeed;
	private DefaultTableModel defaultTableModelAvali;
	private DefaultTableModel defaultTableModelListAvali;

	private JPanel contentPane;
	private JTable tblMax;
	private JTable tblAllo;
	private JTable tblNeed;
	private JTextField txtQ;
	private JTextField txtP;
	private JTable tblListAvailable;
	private JTable tableAvailable;
	JLabel lblResult;
	/**
	 * 
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setAlwaysOnTop(true);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ĐỒ ÁN HỆ ĐIỀU HÀNH");
		setBackground(new Color(189, 183, 107));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Xây Dựng Chương Trình Mô Phỏng Giải Thuật Nhà Băng Của Dijsktra Để Tránh Deadlock");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLUE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("BẢNG DỮ LIỆU MAX");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("BẢNG DỮ LIỆU ALLOCATION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.BLUE);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_3 = new JLabel("BẢNG DỮ LIỆU NEED");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_4 = new JLabel("SỐ TIẾN TRÌNH  P :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.BLUE);
		
		txtQ = new JTextField();
		txtQ.setForeground(Color.RED);
		txtQ.setEnabled(false);
		txtQ.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SỐ TÀI NGUYÊN  R :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.BLUE);
		
		txtP = new JTextField();
		txtP.setForeground(Color.RED);
		txtP.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtP.setEnabled(false);
		txtP.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblNewLabel_6 = new JLabel("KHỞI CHẠY & KIỂM TRA");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(Color.BLUE);
		
		JButton btnCreData = new JButton("RUN");
		btnCreData.addActionListener(new ActionListener() {
			// **********************************************//
			// xữ lý load dữ liệu
			public void actionPerformed(ActionEvent arg0) {
				ActionBanker actionBanker = new ActionBanker();
				actionBanker.CreateData();
				actionBanker.PrintData();
				actionBanker.RunProcessor();
				//Data data = new Data();
				int q = Data.getQ();
				int p = Data.getP();
				txtQ.setText(q+"");
				txtP.setText(""+p);

				ShowFlieData showFlieData = new ShowFlieData();
				defaultTableModelMax = (DefaultTableModel) tblMax.getModel();
				arrayListMax = showFlieData.showTable("TableMaxData.txt");
				for (DataBean dataBean : arrayListMax) {
					System.out.println(dataBean.toString());
				}
				for (DataBean dataBean : arrayListMax) {
					defaultTableModelMax.addRow(new Object[] {
							dataBean.getRow1(),dataBean.getRow2(),dataBean.getRow3(),dataBean.getRow4(),dataBean.getRow5(),dataBean.getRow6(),dataBean.getRow7(),dataBean.getRow8(),dataBean.getRow9(),dataBean.getRow10(),dataBean.getRow11()
					});
				}
				////   ALLOTATION ///
				defaultTableModelAllo = (DefaultTableModel) tblAllo.getModel();
				arrayListAllo = showFlieData.showTable("TableAllocationData.txt");
				for (DataBean dataBean : arrayListAllo) {
					System.out.println(dataBean.toString());
				}
				for (DataBean dataBean : arrayListAllo) {
					defaultTableModelAllo.addRow(new Object[] {
							dataBean.getRow1(),dataBean.getRow2(),dataBean.getRow3(),dataBean.getRow4(),dataBean.getRow5(),dataBean.getRow6(),dataBean.getRow7(),dataBean.getRow8(),dataBean.getRow9(),dataBean.getRow10(),dataBean.getRow11()
					});
				}
				//// Need ///
				defaultTableModelNeed = (DefaultTableModel) tblNeed.getModel();
				arrayListNeed = showFlieData.showTable("TableNeedData.txt");
				for (DataBean dataBean : arrayListNeed) {
					System.out.println(dataBean.toString());
				}
				for (DataBean dataBean : arrayListNeed) {
					defaultTableModelNeed.addRow(new Object[] {
							dataBean.getRow1(),dataBean.getRow2(),dataBean.getRow3(),dataBean.getRow4(),dataBean.getRow5(),dataBean.getRow6(),dataBean.getRow7(),dataBean.getRow8(),dataBean.getRow9(),dataBean.getRow10(),dataBean.getRow11()
					});
				}
				////////// Available  ///
				defaultTableModelAvali = (DefaultTableModel) tableAvailable.getModel();
				arrayListAvali = showFlieData.showTable("TableAvailableData.txt");
				for (DataBean dataBean : arrayListAvali) {
					System.out.println(dataBean.toString());
				}
				for (DataBean dataBean : arrayListAvali) {
					defaultTableModelAvali.addRow(new Object[] {
							dataBean.getRow1(),dataBean.getRow2(),dataBean.getRow3(),dataBean.getRow4(),dataBean.getRow5(),dataBean.getRow6(),dataBean.getRow7(),dataBean.getRow8(),dataBean.getRow9(),dataBean.getRow10(),dataBean.getRow11()
					});
				}
				//  listAvailable//
				defaultTableModelListAvali = (DefaultTableModel) tblListAvailable.getModel();
				File file = new File("TableListAvailableData.txt");
				if(file.exists()){
					arrayListListAvali = showFlieData.showTable("TableListAvailableData.txt");

					for (DataBean dataBean : arrayListListAvali) {
						System.out.println(dataBean.toString());
					}
					for (DataBean dataBean : arrayListListAvali) {
						defaultTableModelListAvali.addRow(new Object[] {
								dataBean.getRow1(),dataBean.getRow2(),dataBean.getRow3(),dataBean.getRow4(),dataBean.getRow5(),dataBean.getRow6(),dataBean.getRow7(),dataBean.getRow8(),dataBean.getRow9(),dataBean.getRow10(),dataBean.getRow11()
						});
					}
				}

				///         ///////////////////
				String result = showFlieData.showResult("TableResult.txt");
				lblResult.setText(result);
				try {
					if(file.exists()){
						boolean checkDeleteFile = new ShowFlieData().deleteFile("TableListAvailableData.txt");
						System.out.println("Check File : "+checkDeleteFile);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		btnCreData.setBackground(new Color(255, 215, 0));
		btnCreData.setForeground(new Color(0, 0, 128));
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					// ============  Xoa Du Lieu ===============///
					try {
						for (int i = 0; i < arrayListMax.size(); i++) {
							defaultTableModelMax.removeRow(0);
						}
						for (int i = 0; i < arrayListAllo.size(); i++) {
							defaultTableModelAllo.removeRow(0);
						}
						for (int i = 0; i < arrayListNeed.size(); i++) {
							defaultTableModelNeed.removeRow(0);
						}
						for (int i = 0; i < arrayListAvali.size(); i++) {
							defaultTableModelAvali.removeRow(0);
						}
						for (int i = 0; i < arrayListListAvali.size(); i++) {
							defaultTableModelListAvali.removeRow(0);
						}
						lblResult.setText("");
						File file = new File("TableListAvailableData.txt");
						if(file.exists()){
							boolean checkDeleteFile = new ShowFlieData().deleteFile("TableListAvailableData.txt");
							System.out.println("Check File : "+checkDeleteFile);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}


			}
		});
		btnRestart.setForeground(new Color(25, 25, 112));
		btnRestart.setBackground(new Color(255, 215, 0));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean checkDeleteFile = new ShowFlieData().deleteFile("TableListAvailableData.txt");
					System.out.println("Check File : "+checkDeleteFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(255, 215, 0));
		btnExit.setForeground(new Color(25, 25, 112));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JLabel lblBngDLiu = new JLabel("BẢNG DỮ LIỆU AVAILABLE");
		lblBngDLiu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBngDLiu.setForeground(new Color(0, 0, 255));
		
		lblResult = new JLabel("");
		lblResult.setForeground(new Color(0, 255, 0));
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(176)
					.addComponent(lblNewLabel_1)
					.addGap(315)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addGap(180))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(275))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(384)
					.addComponent(lblBngDLiu)
					.addContainerGap(829, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(383)
					.addComponent(lblNewLabel_6)
					.addContainerGap(841, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
						.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCreData)
									.addGap(36)
									.addComponent(btnRestart)
									.addGap(35)
									.addComponent(btnExit))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(lblBngDLiu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(290)
							.addComponent(lblResult)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCreData)
								.addComponent(btnExit)
								.addComponent(btnRestart))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableAvailable = new JTable();
		tableAvailable.setEnabled(false);
		tableAvailable.setModel(new DefaultTableModel(
			new Object[][] {
//				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
					"", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]"
			}
		));
		scrollPane_4.setViewportView(tableAvailable);
		
		tblListAvailable = new JTable();
		tblListAvailable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]"
			}
		));
		tblListAvailable.setEnabled(false);
		scrollPane_3.setViewportView(tblListAvailable);

		tblNeed = new JTable();
		tblNeed.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
					"", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]"
			}
		));
		tblNeed.setEnabled(false);
		scrollPane_2.setViewportView(tblNeed);
		
		tblAllo = new JTable();
		tblAllo.setEnabled(false);
		tblAllo.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
					"", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]"
			}
		));
		scrollPane_1.setViewportView(tblAllo);
		
		tblMax = new JTable();
		tblMax.setEnabled(false);
		tblMax.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
					"", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]"
				}
			));
		scrollPane.setViewportView(tblMax);
		contentPane.setLayout(gl_contentPane);
	}
}
