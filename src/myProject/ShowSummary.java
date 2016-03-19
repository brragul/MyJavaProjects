package myProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ShowSummary {
	BigInteger acc;
	JTable table;
	FileWriter os;
	public ShowSummary() {
			String con="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
			try {
				Connection c3=DriverManager.getConnection(con);
				Statement s3 = c3.createStatement();
				ResultSet rs=s3.executeQuery("select accountno from userdetails where username='"+UserLogin.getUser()+"'");
				while(rs.next()){
					acc=BigInteger.valueOf(rs.getInt(1));
					System.out.println(acc);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try {
				Connection c3=DriverManager.getConnection(con);
				Statement s3 = c3.createStatement();
				ResultSet rs=s3.executeQuery("select * from trandetail where from_acc="+acc+" or to_acc="+acc+" order by date_time");
				table = new JTable(buildTableModel(rs));
				if(!OptionPage.dwnbool){
			    JOptionPane.showMessageDialog(null, new JScrollPane(table));}
				else{
					try {
						os = new FileWriter(new File("E:\\tran1.txt"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TableModel model = table.getModel();
					 for(int i = 0; i < model.getColumnCount(); i++){
				            os.write(model.getColumnName(i) + "\t");
				        }
					for( int i = 0; i < model.getRowCount(); i++ )
					{
					   for( int j = 0; j < model.getColumnCount(); j++ )
					   {
						   System.out.println(model.getValueAt(i, j));
						   try {
						  
						  os.write(model.getValueAt(i, j).toString()+"\t");
						} catch (IOException e) {
							e.printStackTrace();
						}
					   }

						  os.write("\n");

					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }
	    System.out.println(columnNames);

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    System.out.println(data);
	    return new DefaultTableModel(data, columnNames);

	}
}
