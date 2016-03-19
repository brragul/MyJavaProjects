package drawingPad;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CreateMenuBar {
protected static JMenuBar addMenu(){
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu Edit = new JMenu("Edit");
	JMenuItem newmenuitem = new JMenuItem("New");
	JMenuItem savemenuitem= new JMenuItem("Save");
	file.add(newmenuitem);
	file.add(savemenuitem);
	mb.add(file);
	mb.add(Edit);
	return mb;
}
}
