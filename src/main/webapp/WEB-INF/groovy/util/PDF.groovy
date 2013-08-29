package util

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

class PDF {
	PdfReader pdf;
	PdfStamper pdfStamper;

	def name = "xFxILE.PDF"

	def open(pdfPath) {
		pdf = new PdfReader(pdfPath)
	}

	def listFormFields() {
		def list = []
		def fields = pdf.getAcroFields().getFields().keySet();
		fields.each { field ->
			list << field
		}
		list
	}

	def preparePdfStamper(pdfStamperOutputStream) {
		try {
			this.pdfStamper = new PdfStamper(pdf, pdfStamperOutputStream)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	def changeFieldValue(field, newValue) {
    AcroFields form = pdfStamper.getAcroFields()
    try {
			form.setField(field, newValue)
		} catch (Exception e) {
			e.printStackTrace()
		}        
	}

	def closePdf() {
    pdf.close();			
	}
	
	def closePdfStamper() {
		pdfStamper.close()
	}
		
	def closeAll() {
		pdfStamper.close()
    pdf.close();			
	}
}
