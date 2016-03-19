package zipUtility;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZipUtility {

	public static void main(String[] args){
		JFrame frame = new JFrame("Zip");
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4,1));
		JPanel zippanel = new JPanel();
		JPanel unzippanel = new JPanel();
		JPanel gzippanel = new JPanel();
		JPanel gunzippanel = new JPanel();

		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		JFileChooser ipfile = new JFileChooser();
		
		JButton button1 = new JButton("Browse Source to ZIP");
		JButton button2 = new JButton("Browse Source to UNZIP");
		JButton button3 = new JButton("Browse Source to GZIP");
		JButton button4 = new JButton("Browse Source to GUNZIP");
		
		zippanel.setLayout(new FlowLayout());
		unzippanel.setLayout(new FlowLayout());
		gzippanel.setLayout(new FlowLayout());
		gunzippanel.setLayout(new FlowLayout());
		
		label1.setText("Choose the Source file to ZIP");
		label2.setText("Choose the Source file to UnZIP");
		label3.setText("Choose the Source file to GZIP");
		label4.setText("Choose the Source file to GUnZIP");
		
		zippanel.add(label1);
		zippanel.add(button1);
		unzippanel.add(label2);
		unzippanel.add(button2);
		gzippanel.add(label3);
		zippanel.add(button3);
		gunzippanel.add(label4);
		gunzippanel.add(button4);
		
		frame.add(zippanel);
		frame.add(unzippanel);
		frame.add(gzippanel);
		frame.add(gunzippanel);
		
		
		byte[] buffer = new byte[1024];
		byte[] buffer1 = new byte[1024];
		byte[] buffer2 = new byte[1024];
		byte[] buffer3 = new byte[1024];
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				try {
					FileOutputStream os = new FileOutputStream("E:/Compressed/Myfile.zip");
					ZipOutputStream zos = new ZipOutputStream(os);
					ZipEntry ze = new ZipEntry("a.txt");
					zos.putNextEntry(ze);
					FileInputStream in = new FileInputStream(file);
					
					
					int len;
		    		while ((len = in.read(buffer)) > 0) {
		    			zos.write(buffer, 0, len);
		    		}
		 
		    		in.close();
		    		zos.closeEntry();
		 
		    		zos.close();
		    		System.out.println("Done");

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ipfile.showOpenDialog(frame);
				String outfolder ="E:\\Compressed";
				String file=ipfile.getSelectedFile().getPath();
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
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				String outgzipfile ="E:\\Compressed\\MyFile.gz";
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
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ipfile.showOpenDialog(frame);
				String file=ipfile.getSelectedFile().getPath();
				String outgzipfile ="E:\\Compressed\\a.txt";
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
		
		
	}
}
