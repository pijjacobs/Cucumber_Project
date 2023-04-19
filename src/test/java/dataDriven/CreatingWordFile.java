package dataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreatingWordFile {

	public static void main(String[] args) {
		createWordDocument("D:\\Jegan\\Created files coderun\\Doc files\\WordDocx.doc\\");
	}

	public static void createWordDocument(final String outputFileName) {
		// create a document
		XWPFDocument doc = new XWPFDocument();

		// create a paragraph with justify alignment
		XWPFParagraph p1 = doc.createParagraph();

		// first line indentation in the paragraph
		p1.setFirstLineIndent(400);

		// justify alignment
		p1.setAlignment(ParagraphAlignment.DISTRIBUTE);

		// wrap words
		p1.setWordWrapped(true);

		// insert page break after this paragraph
		// p1.setPageBreak(true);
		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r1 = p1.createRun();
		String t1 = "Used to make professional-quality documents, letters, reports, etc., MS Word is a word processor developed by Microsoft. It has advanced features which allow you to format and edit your files and documents in the best possible way. "
				+ " MS Word enables users to do write-ups, create documents, resumes, contracts, etc. This is one of the most commonly used programs under the Office suite.";
		r1.setText(t1);

		// create a paragraph with left alignment
		XWPFParagraph p2 = doc.createParagraph();

		// first line indentation in the paragraph
		p2.setFirstLineIndent(400);

		// left alignment
		p2.setAlignment(ParagraphAlignment.LEFT);

		// wrap words
		p2.setWordWrapped(true);

		// insert page break after this paragraph
		// p2.setPageBreak(true);
		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r2 = p2.createRun();
		String t2 = "To create an MS Word doc, follow the steps mentioned above to open Microsoft Word. Then once the program is open, click on “File” followed by “New”. This opens a new doc where something new can be created."
				+ " Since it is used by people of all age groups, in schools, in colleges and for official purposes, having proper knowledge of Microsoft Word is a must. The preview of the MS Doc file once it is opened is given below";
		r2.setText(t2);

		// create a paragraph with ITALIC text
		XWPFParagraph p3 = doc.createParagraph();

		// left alignment
		p3.setAlignment(ParagraphAlignment.LEFT);

		// wrap words
		p3.setWordWrapped(true);

		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r3 = p3.createRun();
		String t3 = "For a better understanding of how MS Word works and the features that are included in it, you can refer to the video given below and analyse its functioning easily.";
		r3.setText(t3);

		// make text italic
		r3.setItalic(true);

		// create a paragraph with BOLD text
		XWPFParagraph p4 = doc.createParagraph();

		// left alignment
		p4.setAlignment(ParagraphAlignment.LEFT);

		// wrap words
		p4.setWordWrapped(true);

		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r4 = p4.createRun();
		String t4 = "This has options like font colour, font size, font style, alignment, bullets, line spacing, etc. All the basic elements which one may need to edit their document is available under the Home option.";
		r4.setText(t4);

		// make text bold
		r4.setBold(true);

		// create a paragraph with Strike-Through text
		XWPFParagraph p5 = doc.createParagraph();

		// left alignment
		p5.setAlignment(ParagraphAlignment.LEFT);

		// wrap words
		p5.setWordWrapped(true);

		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r5 = p5.createRun();
		String t5 = "Tables, shapes, images, charts, graphs, header, footer, page number, etc. can all be entered in the document. They are included in the “Insert” category.";
		r5.setText(t5);

		// make StrikeThrough
		r5.setStrikeThrough(true);

		// create a paragraph with Underlined text
		XWPFParagraph p6 = doc.createParagraph();

		// left alignment
		p6.setAlignment(ParagraphAlignment.LEFT);

		// wrap words
		p6.setWordWrapped(true);

		// XWPFRun object defines a region of text with a common set of
		// properties
		XWPFRun r6 = p6.createRun();
		String t6 = "The template or the design in which you want your document to be created can be selected under the Design tab. Choosing an appropriate tab will enhance the appearance of your document.";
		r6.setText(t6);

		// make Underlined
		r6.setUnderline(UnderlinePatterns.SINGLE);

		// write to a docx file
		FileOutputStream fo = null;
		try {
			// create .docx file
			fo = new FileOutputStream(outputFileName);

			// write to the .docx file
			doc.write(fo);
		} catch (IOException e) {
		} finally {
			if (fo != null) {
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (doc != null) {
				try {
					doc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}