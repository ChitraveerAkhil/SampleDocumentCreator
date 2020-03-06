package com.chitraveerakhil.DocumentCreator.processing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DocumentGenerator {

	private XWPFDocument document;

	public void createWordFile(String name, String mobileNumber, String emailId) throws IOException {
		document = new XWPFDocument();
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(name + ".docx"));

		XWPFParagraph paragraph = document.createParagraph();
		createXwpfRun(paragraph,"Name: ", name);
		createXwpfRun(paragraph,"\nMobile Number: ", mobileNumber);
		createXwpfRun(paragraph,"\nEmail Id: ", emailId);

		document.write(out);
		out.close();
	}
	
	void createXwpfRun(XWPFParagraph paragraph, String key, String value){
		XWPFRun xwpfRun = paragraph.createRun();
		xwpfRun.setBold(true);
		xwpfRun.setText(key);
		xwpfRun.setBold(false);
		xwpfRun.setText(value);
	}

}
