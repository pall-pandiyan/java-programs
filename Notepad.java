import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Stack;

import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;

class Notepad {
	public static void main(String args[]) {
		new Window();
	}
}

class Window extends JFrame implements ActionListener {
	JTextArea pane;
	JMenuBar menu;
	JMenu file;
	JMenuItem mNew;
	JMenuItem open;
	JMenuItem save;
	JMenuItem saveAs;
	JSeparator sep1;
	JMenuItem exit;
	JMenu edit;
	JMenuItem undo;
	JMenuItem cut;
	JMenuItem copy;
	JMenuItem paste;
	JMenuItem delete;
	JMenuItem find;
	JMenuItem findNext;
	JMenuItem replace;
	JMenuItem mGoto;
	JMenuItem selectAll;
	JMenuItem time;
	JMenu help;
	JMenuItem about;
	JScrollPane scrollPane;
	File f;
	Stack undoBuffer;
	Boolean b = false; //for UndoBuffer
	FindOption fo;
	UndoManager undoManager;
	AbstractDocument doc;
	Window() {
		super("Notepad");
		undoBuffer = new Stack();
		undoManager = new UndoManager();
		pane = new JTextArea();
		f = new File(pane);
		menu = new JMenuBar();
		scrollPane = new JScrollPane(pane);
		file = new JMenu("File"); mNew = new JMenuItem("New"); open = new JMenuItem("Open..."); save = new JMenuItem("Save"); saveAs = new JMenuItem("Save As..."); sep1 = new JSeparator(); exit = new JMenuItem("Exit");
		file.add(mNew); file.add(open);	file.add(save); file.add(saveAs); file.add(sep1); file.add(exit);
		edit = new JMenu("Edit"); undo = new JMenuItem("Undo"); 
		cut= new JMenuItem("Cut");
		copy= new JMenuItem("Copy");
		paste= new JMenuItem("Paste");
		delete= new JMenuItem("Delete");
		find= new JMenuItem("Find");
		findNext= new JMenuItem("Find Next");
		replace= new JMenuItem("Replace");
		mGoto= new JMenuItem("Goto");
		selectAll= new JMenuItem("Select All");
		time= new JMenuItem("Time");
		help = new JMenu("Help");
		about = new JMenuItem("About");
		help.add(about);
		edit.add(undo);	edit.add(new JSeparator());
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.add(new JSeparator());
		edit.add(find);
		edit.add(findNext);
		edit.add(replace);
		edit.add(mGoto);
		edit.add(selectAll);
		edit.add(new JSeparator());
		edit.add(time);
		menu.add(file);
		menu.add(edit);
		menu.add(help);
		setJMenuBar(menu);
		add(scrollPane);

		mNew.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		exit.addActionListener(this);	
		undo.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		findNext.addActionListener(this);
		replace.addActionListener(this);
		mGoto.addActionListener(this);
		selectAll.addActionListener(this);
		time.addActionListener(this);
		about.addActionListener(this);
		pane.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (b==false)
				undoBuffer.push(pane.getText());
			}
		});
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					dispose();
				}
		});
		pack();
		setSize(1261,681);
		pane.getDocument().addUndoableEditListener(new UndoableEditListener() {
				public void undoableEditHappened(UndoableEditEvent e) {
					undoManager.addEdit(e.getEdit());
				}
		});
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==mNew) {
			pane.setText("");
		}
		if (e.getSource()==open) {
			FileDialog fd = new FileDialog(this, "Open...");
			fd.setFile("*.txt");
			fd.setVisible(true);
			if (!fd.getFile().equals(null))
			f = new File(fd.getFile(), fd.getDirectory(), pane);
		}
		if (e.getSource()==save) {
			if (f.isFileEmpty()) {
				FileDialog fd = new FileDialog(this, "Save...", FileDialog.SAVE);
				fd.setFile("*.txt");
				fd.setVisible(true);
				if (!fd.getFile().equals(null))
				f.setFilePath(fd.getDirectory() + fd.getFile());
			}
			f.saveToFile();
		}
		if (e.getSource()==saveAs) {
			FileDialog fd = new FileDialog(this, "Save As...", FileDialog.SAVE); 
			fd.setFile("*.txt");
			fd.setVisible(true);
			if (!fd.getFile().equals(null))
			f.setFilePath(fd.getDirectory()+fd.getFile());
			f.saveToFile();
		}
		if (e.getSource()==undo) {
					undoManager.undo();
		}
		if (e.getSource()==copy) {
			pane.copy();
		}
		if (e.getSource()==cut) {
			pane.cut();
		}
		if (e.getSource()==paste) {
			pane.paste();
		}
		if (e.getSource()==delete) {
			pane.setText(pane.getText().replace(pane.getSelectedText(), ""));
		}
		if (e.getSource()==find) {
				FindWindow f = new FindWindow(this);
				String findText = f.getFindText();
				if (findText!="") { try {
				fo = new FindOption(findText, pane);
				}
				catch (NotFoundException ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
				}
			}

			if (e.getSource()==findNext) {
				fo.findNext();
			}
			if (e.getSource()==replace) {
					new ReplaceDialog(this, pane);
			} 
			if (e.getSource()==selectAll) {
				pane.selectAll();
			}
			if (e.getSource()==time) {
				//Under-construction
			}
			if (e.getSource()==about) {
					new AboutDialog(this);
			}
			if (e.getSource()==exit) {
				dispose();
			}
	}
}

class AboutDialog extends Dialog implements ActionListener {
	JLabel l1,l2;
	JButton b1;
	AboutDialog(Frame f) {
		super(f,"About...", true);
		l1 = new JLabel("Notepad v1.1");
		l1.setFont(new Font("Arial", Font.BOLD,30));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2 = new JLabel("Coded by: Masroor Aijaz");
		l2.setHorizontalAlignment(JLabel.CENTER);
		b1 = new JButton("Okay!");
		add(l1); add(l2); add(b1);
		setLayout(new GridLayout(3,1));
		setSize(341,166);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					dispose();
				}
		});
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			dispose();
		}
	}
}

class ReplaceDialog extends Dialog implements ActionListener {
	JLabel l1, l2;
	JTextField t1,t2;
	JButton b1,b2,b3,b4;
	FindOption fo;
	JTextArea p;
	ReplaceDialog(Frame f, JTextArea p)  {
			super(f,"Replace...", false);
			l1 = new JLabel("Find: ");
			l2 = new JLabel("Replace with: ");
			b1 = new JButton("Find Next");
			b2 = new JButton("Replace");
			b3 = new JButton("Replace All");
			b4 = new JButton("Cancel");
			t1 = new JTextField("",20);
			t2 = new JTextField("",20);
			setLayout(new FlowLayout());
			b1.addActionListener(this);
			b4.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			add(l1); add(t1); add(l2); add(t2); add(b1); add(b2); add(b3); add(b4);
			setSize(347,185);
			this.p = p;
			fo = new FindOption(p);
			addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dispose();
					}
			});
			setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b4) {
			dispose();
		}
		if (e.getSource()==b1) {
				try { 
					fo.setFindText(t1.getText()); 
					fo.findNext();
				}
				catch (NotFoundException ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
				
		}
		if (e.getSource()==b2) {
			String text = p.getText();
			String newText="";
			for (int i=0,j=0;i<p.getText().length();i++) {
				if (i==p.getSelectionStart()) {
						newText+=t2.getText();
						i=p.getSelectionEnd()-1;
				}
				else
					newText+=text.charAt(i);
			}
			p.setText(newText);
			if (fo.getTotal()!=fo.getCountNext())
				fo.findNext();
			else 
				try {
				fo = new FindOption(t1.getText(), p);
			}
			catch (NotFoundException ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		}
		if (e.getSource()==b3) {
			p.setText(p.getText().replace(t1.getText(),t2.getText()));
		}
	}
}

class NotFoundException extends Exception {
	String msg;
	NotFoundException() {
		msg = "Cannot find the word.";
	}
	public String toString() {
		return msg;
	}
}

class FindOption {
	private String fText;
	private JTextArea p;
	private int first=0;
	private int last=0;
	private int total=0;
	private int countNext=0;
	//private int i=0;
	FindOption(String text, JTextArea p) throws NotFoundException{
		this.p = p;
		fText = text;
		total = p.getText().split(fText,-1).length - 1;
		if (total==0) {
			throw new NotFoundException();
		}
		findNext();
	}
	FindOption(JTextArea p) {
		this.p = p;	
		
	}
	void findNext() {
		System.out.println(countNext + "&" + total);
		if (countNext==total) {
			last=0;
			first=0;
			countNext=0; }
			String text = p.getText().substring(last);
			select(text);

	}
	void select(String text) {
		countNext++;
		first = last + text.indexOf(fText);
		last = first + fText.length();
		p.select(first, last);
	}
	public void setFindText(String text) throws NotFoundException {
		fText = text;
		total = p.getText().split(fText,-1).length - 1;
		if (total==0) {
			throw new NotFoundException();
		}
	}
	public int getTotal() {
		return total;
	}
	public int getCountNext() {
		return countNext;
	}
}


class File {
	String filePath;
	JTextArea l;
	File(String fileName, String directory, JTextArea l) {
				filePath = directory + fileName;
				this.l = l;
				loadFile();
	}
	File (JTextArea tp) {
		filePath = "";
		l = tp;
	}

	public void saveToFile() {
		char buffer[] = new char[l.getText().length()];
			buffer = l.getText().toCharArray();
		try  (FileWriter f = new FileWriter(filePath) )
			{ f.write(buffer);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error while saving the file...");

		}
	}
	public void loadFile() {
			String fileText ="";
			try {
			FileReader fr = new FileReader(filePath); 
				int c;
				while ((c=fr.read())!=-1) 
					fileText = fileText + String.valueOf((char) c);
				l.setText(fileText);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				filePath = null;
			}
	}
	public boolean isFileEmpty() {
		if (filePath==null || filePath=="") 
			return true;
		else
		return false;
	}
	public void setFilePath(String p) {
		filePath = p;
	}
	public String getFilePath() {
		return filePath;
	}
}

class FindWindow extends Dialog {
	String findText;
	JTextField text;
	JButton bfind;
	JButton bexit;
	FindWindow(Frame f) {
			super(f,"Find", true);
				  text = new JTextField("",20);
				  bfind = new JButton("Find");
				 bexit = new JButton("Exit");
				this.add(text);
				this.add(bfind);
				this.add(bexit);
				this.setLayout(new FlowLayout());
				this.setSize(370,83);
			
				bfind.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ee) {
								findText = text.getText();
								dispose();
					}	
				});
				bexit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ee) {
							findText ="";
							dispose();
						}
				});
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dispose();
					}
				});
					this.setVisible(true);
	}
	String getFindText() {
		return findText;
	}
}