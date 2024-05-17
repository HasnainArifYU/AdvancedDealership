package pluralsight;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String name, String email, Vehicle vehicleSold, double price, double monthlyPayment, double salesTax, double recordingFee, double processingFee, boolean finance) {
        super(date, name, email, vehicleSold, price, monthlyPayment);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        double price = (((this.vehicleSold.getPrice())/100)*105)+100;
        if (this.vehicleSold.getPrice()>=10000.0){
            price += 495.0;
        }
        else {
            price += 295;
        }
        return price;
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinance()) {
            if ((getTotalPrice()>=10000.0)){
                this.monthlyPayment = ((getTotalPrice()/100)*104.25)/48;
            }
            else{
                this.monthlyPayment = ((getTotalPrice()/100)*105.25)/24;
            }
        }
        else {
            this.monthlyPayment = 0;
        }
        return monthlyPayment;
    }
}
