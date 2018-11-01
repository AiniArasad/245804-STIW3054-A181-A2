import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadToExcel {

    private static final String FILE = "C:\\New folder\\chessResultsList.xlsx";

    ArrayList<participant> participantlist = new ArrayList<participant>();
    ArrayList<Header> firstHeader = new ArrayList<Header>();

    public List<Header> readHeader() {

        try {
            System.out.println("\n");
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(FILE));
            XSSFSheet sheet = wb.getSheetAt(0);//Sheet Index


            for (int c = 0; c <= 3; c++) {

                XSSFRow word = sheet.getRow(c);
                System.out.println(word.getCell(0).getStringCellValue());
                firstHeader.add(new Header(word.getCell(0).getStringCellValue()));

            }
            return firstHeader;

        } catch (Exception e) {
            return null;
        }
    }

    /*public List<Header> readHeader() {

        try {

            String l1, l2, l3, l4;

            System.out.println("\n");
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(FILE));
            HSSFSheet sheet = wb.getSheetAt(0);

            HSSFRow line1 = sheet.getRow(0);
            HSSFRow line2 = sheet.getRow(1);
            HSSFRow line3 = sheet.getRow(2);
            HSSFRow line4 = sheet.getRow(3);

            l1 = line1.getCell(0).getStringCellValue();
            l2 = line2.getCell(0).getStringCellValue();
            l3 = line3.getCell(0).getStringCellValue();
            l4 = line4.getCell(0).getStringCellValue();

            System.out.println("" + firstHeader.get(0).getLine1());
            System.out.println("" + firstHeader.get(0).getLine2());
            System.out.println("" + firstHeader.get(0).getLine3());
            System.out.println("" + firstHeader.get(0).getLine4());
            firstHeader.add(new Header(l1, l2, l3, l4));

            return firstHeader;
        } catch (Exception e) {
            return null;
        }
    }*/



        public List<participant> readParticipant () {
            try {

                System.out.println("\n");
                XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FILE));
                XSSFSheet sheet = workbook.getSheetAt(0);


                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.println("|  ID                           NAME                FIDEID    FED      RTG             CLUB OR CITY |");
                System.out.println("----------------------------------------------------------------------------------------------------");


                for (int a = 5; a <= 154; a++) {
                    int c = a - 4;
                    XSSFRow r = sheet.getRow(a);
                    System.out.printf("| %3d", c);
                    //Name
                    System.out.printf("  %42s", r.getCell(2).getStringCellValue());
                    //FideID
                    System.out.printf("  %5s", r.getCell(3).getStringCellValue());
                    //FED
                    System.out.printf("  %7s", r.getCell(4).getStringCellValue());
                    //RTG
                    System.out.printf("  %7s", r.getCell(5).getNumericCellValue());
                    //Club or City
                    System.out.printf("  %23s | %n", r.getCell(6).getStringCellValue());


                    int index = c;
                    String name = r.getCell(2).getStringCellValue();
                    String fieldID = r.getCell(3).getStringCellValue();
                    String fed = r.getCell(4).getStringCellValue();
                    double rtg = r.getCell(5).getNumericCellValue();
                    String clubC = r.getCell(6).getStringCellValue();


                    participantlist.add(new participant(c, name, fieldID, fed, rtg, clubC));
                    System.out.println("----------------------------------------------------------------------------------------------------");
                }


                return participantlist;

            } catch (Exception e) {
                return null;

            }
        }
    }
