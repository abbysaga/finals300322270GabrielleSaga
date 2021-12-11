public class CustInfo {
    public CustInfo(int year, double startAmt, double interest, double endBal) {
        this.year = year;
        this.startAmt = startAmt;
        this.interest = interest;
        this.endBal = endBal;
    }

    private int year;
    private double startAmt;
    private double interest;
    private double endBal;

    // get-set methods
    public int getYear() { return year; }
    public void setYear(int Year) { this.year = year; }

    public double getStartAmt() { return startAmt; }
    public void setStartAmt(double startAmt) { this.startAmt = startAmt; }
}
