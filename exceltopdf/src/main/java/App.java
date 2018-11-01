public class App
{
    public static void main( String[] args ){
        ReadToExcel read = new ReadToExcel();
        printToPDF print = new printToPDF();

        try {
            print.printPdf();

        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.println("\n\n");
        System.out.println("Print to PDF Successful!");
    }
}