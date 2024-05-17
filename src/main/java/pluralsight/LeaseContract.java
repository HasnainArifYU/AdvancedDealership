package pluralsight;

public class LeaseContract extends Contract
{
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold, double price, double monthlyPayment, double endingValue, double leaseFee) {
        super(date, name, email, vehicleSold, price, monthlyPayment);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = (this.vehicleSold.getPrice()*.5)+((this.vehicleSold.getPrice()/100)*7);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        return ((getTotalPrice()/100)*104)/36;
    }
}
