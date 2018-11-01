import com.itextpdf.text.*;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class printToPDF {

    public void printPdf() {

        ReadToExcel read = new ReadToExcel();

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\New folder\\ListChess.pdf"));

            document.open();

           /* document.add(new Paragraph("" + new ReadToExcel().firstHeader.get(0).getLine1();
            document.add(new Paragraph("" + new ReadToExcel().firstHeader.get(0).getLine2();
            document.add(new Paragraph("" + new ReadToExcel().firstHeader.get(0).getLine3();
            document.add(new Paragraph("" + new ReadToExcel().firstHeader.get(0).getLine4();
            document.add(new Paragraph("    "));*/


            int a = 0;
            for (Header header1: read.readHeader()) {
                FontSelector selector = new FontSelector();
                Font f1 = FontFactory.getFont(FontFactory.COURIER_BOLD, 12);
                f1.setColor(BaseColor.BLACK);
                String text = read.firstHeader.get(a).getFirstWord();
                /*String text = read.firstHeader.get(a).getLine1();
                String text1 = read.firstHeader.get(a).getLine2();
                String text2 = read.firstHeader.get(a).getLine3();
                String text3 = read.firstHeader.get(a).getLine4();*/
                selector.addFont(f1);
                Phrase phrase = selector.process(text);
                document.add(new Paragraph(phrase));
                a++;
            }


            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingAfter(10f);
            table.setSpacingBefore(10f);

            //float[] columnWidth = {2f, 15f, 4f, 4f, 5f, 12f};
            float[] columnWidth = {3f, 18f, 3f, 3f, 2f, 10f};

            table.setWidths(columnWidth);
            PdfPCell c1 = new PdfPCell(new Paragraph("No."));
            PdfPCell c2 = new PdfPCell(new Paragraph("Name"));
            PdfPCell c3 = new PdfPCell(new Paragraph("FideID"));
            PdfPCell c4 = new PdfPCell(new Paragraph("FED"));
            PdfPCell c5 = new PdfPCell(new Paragraph("RTG"));
            PdfPCell c6 = new PdfPCell(new Paragraph("Club/City"));

            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
            table.addCell(c6);

            int b = 0;
            for (participant student1 : read.readParticipant()) {
                PdfPCell data1 = new PdfPCell(new Paragraph(String.valueOf(read.participantlist.get(b).getNum())));
                PdfPCell data2 = new PdfPCell(new Paragraph(read.participantlist.get(b).getName()));
                PdfPCell data3 = new PdfPCell(new Paragraph(String.valueOf(read.participantlist.get(b).getFieldId())));
                PdfPCell data4 = new PdfPCell(new Paragraph(String.valueOf(read.participantlist.get(b).getFed())));
                PdfPCell data5 = new PdfPCell(new Paragraph(String.valueOf(read.participantlist.get(b).getRtg())));
                PdfPCell data6 = new PdfPCell(new Paragraph(String.valueOf(read.participantlist.get(b).getClubC())));

                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);
                table.addCell(data5);
                table.addCell(data6);

                b++;
            }

            document.add(table);
            document.close();
            writer.close();

        } catch (DocumentException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}