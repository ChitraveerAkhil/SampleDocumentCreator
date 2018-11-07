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
		XWPFRun nameVal = paragraph.createRun();
		nameVal.setBold(true);
		nameVal.setText("Name: ");
		nameVal.setBold(false);
		nameVal.setText(name);

		XWPFRun mobileVal = paragraph.createRun();
		mobileVal.setBold(true);
		mobileVal.setText("\nMobile Number: ");
		mobileVal.setBold(false);
		mobileVal.setText(mobileNumber);

		XWPFRun emailVal = paragraph.createRun();
		emailVal.setBold(true);
		emailVal.setText("\nEmail Id: ");
		emailVal.setBold(false);
		emailVal.setText(emailId);

		document.write(out);

		out.close();
		System.out.println("createdWord" + "_" + name + ".docx" + " written successfully");
	}

}
