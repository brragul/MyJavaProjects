package zipUtility;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipWindow {

	private JFrame frame;
	String s1="Directory:",s2="Directory:",s3="Directory:",s4="Directory:";

	/**ti
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipWindow window = new ZipWindow();
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
	public ZipWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String s1="Directory:",s2="Directory:",s3="Directory:",s4="Directory:";
		frame = new JFrame();
		frame.setBounds(100, 100, 899, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFileChooser ipfile = new JFileChooser();
		byte[] buffer = new byte[1024];
		byte[] buffer1 = new byte[1024];
		byte[] buffer2 = new byte[1024];
		byte[] buffer3 = new byte[1024];
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(31, 39, 356, 326);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(446, 39, 356, 326);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose the Source file to ZIP");
		lblNewLabel.setBounds(44, 45, 226, 20);
		panel.add(lblNewLabel);
		
		JLabel dlabel1 = new JLabel("Directory:");
		dlabel1.setBounds(42, 126, 299, 20);
		panel.add(dlabel1);
		
		JLabel dlabel2 = new JLabel("Directory:");
		dlabel2.setBounds(42, 269, 299, 20);
		panel.add(dlabel2);
		
		JLabel dlabel3 = new JLabel("Directory:");
		dlabel3.setBounds(42, 125, 299, 20);
		panel_1.add(dlabel3);
		
		JLabel dlabel4 = new JLabel("Directory:");
		dlabel4.setBounds(42, 260, 299, 20);
		panel_1.add(dlabel4);
		
		JButton btnNewButton = new JButton("Browse Source to ZIP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				try {
					FileOutputStream os = new FileOutputStream("E:/Compressed/Myfile.zip");
					ZipOutputStream zos = new ZipOutputStream(os);
					ZipEntry ze = new ZipEntry("a.txt");
					zos.putNextEntry(ze);
					FileInputStream in = new FileInputStream(file);
					String s1="Directory:E:/a.txt";
					dlabel1.setText(s1);
					int len;
		    		while ((len = in.read(buffer)) > 0) {
		    			zos.write(buffer, 0, len);
		    		}
		 
		    		in.close();
		    		zos.closeEntry();
		 
		    		zos.close();
		    		System.out.println("Done");

				} catch (FileNotFoundException e1) {
					System.out.println("File not found exception");
					e1.printStackTrace();					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(54, 81, 216, 29);
		panel.add(btnNewButton);
		
		JLabel lblChooseTheSource = new JLabel("Choose the Source file to UnZIP");
		lblChooseTheSource.setBounds(44, 172, 226, 20);
		panel.add(lblChooseTheSource);
		
		JButton btnBrowseSourceTo = new JButton("Browse Source to UNZIP");
		btnBrowseSourceTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipfile.showOpenDialog(frame);
				String outfolder ="E:\\Compressed";
				String file=ipfile.getSelectedFile().getPath();
				String s1="Directory:"+file;
				dlabel2.setText(s1);
			    	System.out.println(file);
				try {
					File folder = new File(outfolder);
			    	if(!folder.exists()){
			    		folder.mkdir();
			    	}
					ZipInputStream zis= new ZipInputStream(new FileInputStream(file));
					ZipEntry ze = zis.getNextEntry();
					while(ze!=null){
					String filename= ze.getName();
					File newFile = new File(outfolder + File.separator + filename);
					FileOutputStream fos = new FileOutputStream(newFile);
					
					int len;
		            while ((len = zis.read(buffer1)) > 0) {
		       		fos.write(buffer1, 0, len);
		            }
		 
		            fos.close();   
		            ze = zis.getNextEntry();
					}
		            zis.closeEntry();
		        	zis.close();
		     
		        	System.out.println("Done");
				} catch (FileNotFoundException e1) {
					System.out.println("File not found exception");
					e1.printStackTrace();
				} catch (IOException e1) {
					System.out.println("IO exception");
					e1.printStackTrace();
				}
			}
		});
		btnBrowseSourceTo.setBounds(54, 214, 216, 29);
		panel.add(btnBrowseSourceTo);
		
		
		
		
		
		JLabel lblChooseTheSource_1 = new JLabel("Choose the Source file to GZIP");
		lblChooseTheSource_1.setBounds(51, 44, 226, 20);
		panel_1.add(lblChooseTheSource_1);
		
		JLabel lblChooseTheSource_2 = new JLabel("Choose the Source file to GUNZIP");
		lblChooseTheSource_2.setBounds(51, 165, 255, 20);
		panel_1.add(lblChooseTheSource_2);
		
		JButton btnBrowseSourceTo_1 = new JButton("Browse Source to GZIP");
		btnBrowseSourceTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				String outgzipfile ="E:\\Compressed\\MyFile.gz";
				String s1="Directory:E:/ag.txt";
				dlabel3.setText(s1);
				try{
					 
			    	GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(outgzipfile));
			        FileInputStream in =  new FileInputStream(file);
			        int len;
			        while ((len = in.read(buffer2)) > 0) {
			        	gzos.write(buffer2, 0, len);
			        }
			 
			        in.close();
			    	gzos.finish();
			    	gzos.close();
			    	System.out.println("Done");
			 
			    }catch(IOException ex){
			       ex.printStackTrace();   
			    }
			}
		});
		btnBrowseSourceTo_1.setBounds(51, 80, 226, 29);
		panel_1.add(btnBrowseSourceTo_1);
		
		JButton btnBrowseSourceTo_2 = new JButton("Browse Source to GUNZIP");
		btnBrowseSourceTo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				String s1="Directory:"+file;
				dlabel4.setText(s1);
				String outgzipfile ="E:\\Compressed\\ag.txt";
				try{
					 
			    	 GZIPInputStream gzis = 
			    		new GZIPInputStream(new FileInputStream(file));
			 
			    	 FileOutputStream out = 
			            new FileOutputStream(outgzipfile);
			 
			        int len;
			        while ((len = gzis.read(buffer3)) > 0) {
			        	out.write(buffer3, 0, len);
			        }
			 
			        gzis.close();
			    	out.close();
			 
			    	System.out.println("Done");
			 
			    }catch(IOException ex){
			       ex.printStackTrace();   
			    }
			}
		});
		btnBrowseSourceTo_2.setBounds(51, 206, 226, 29);
		panel_1.add(btnBrowseSourceTo_2);
		
		
	}
}
