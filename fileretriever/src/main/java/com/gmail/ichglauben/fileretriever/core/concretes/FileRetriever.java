package com.gmail.ichglauben.fileretriever.core.concretes;

import javax.swing.JFileChooser;

import com.gmail.ichglauben.fileretriever.core.utils.abstracts.CustomClass;

public class FileRetriever extends CustomClass {
	private static String path = null;
	private static java.io.File file;
	private final static javax.swing.ImageIcon img = createImageIcon("/medium.gif");

	/** Handles the cancellation of the file browser. */
	private static void handleCancellation() {
		Object[] options = { "Yes, please exit", "Nope, cancel that!" };
		int n = javax.swing.JOptionPane.showOptionDialog(null, "Are you sure you want to cancel?", "A Silly Question",
				javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, img, options,
				options[0]); // default button title
		if (n == javax.swing.JOptionPane.OK_OPTION) {
			return;
		} else
			retrieveFile();
	}

	/** Opens a file browser. */
	public static String retrieveFile() {
		detectPlatform();
		javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();

		int selectionMode = JFileChooser.FILES_ONLY;
		chooser.setFileSelectionMode(selectionMode);

		// open file chooser dialog
		int dialog = chooser.showOpenDialog(null);

		// if user selects a directory...
		if (dialog == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			path = file.getAbsolutePath().trim();
		}
		// else the user cancelled the dialog
		else {
			path = null;
			handleCancellation();
		}
		return path;
	}

	public static String retrieveFile(String desc, String[] exts) {
		detectPlatform();
		javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();

		// TODO - set a file extension filter
		// TODO - test filter
		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileNameExtensionFilter(desc, exts);

		chooser.setFileFilter(filter);

		int selectionMode = JFileChooser.FILES_ONLY;
		chooser.setFileSelectionMode(selectionMode);
		chooser.setAcceptAllFileFilterUsed(false);

		// open file chooser dialog
		int dialog = chooser.showOpenDialog(null);

		// if user selects a directory...
		if (dialog == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			path = file.getAbsolutePath().trim();
		}
		// else the user cancelled the dialog
		else {
			path = null;
			handleCancellation();
		}
		return path;
	}

	/** Returns ImageIcon */
	private static javax.swing.ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = FileRetriever.class.getResource(path);
		if (imgURL != null) {
			return new javax.swing.ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file at: \n" + path);
			return null;
		}
	}

	public String toString() {
		return "FileRetriever";
	}
}
