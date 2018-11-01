public class participant {
    private int num;
    private double Rtg;
    private String name, fieldID, fed, clubC;

    public participant(int num, String name, String fieldID, String fed, double rtg, String clubC) {
        this.num = num;
        this.name = name;
        this.fieldID = fieldID;
        this.fed = fed;
        this.Rtg = rtg;
        this.clubC = clubC;
    }
    public participant(){
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldId() {
        return fieldID;
    }

    public void setFieldId(String fieldId) {
        this.fieldID = fieldID;
    }

    public String getFed() {
        return fed;
    }

    public void setFed(String fed) {
        this.fed = fed;
    }

    public double getRtg() {
        return Rtg;
    }

    public void setRtg(double rtg) {
        this.Rtg = rtg;
    }

    public String getClubC() {
        return clubC;
    }

    public void setClubC(String clubC) {
        this.clubC = clubC;
    }
}