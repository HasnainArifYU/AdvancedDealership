package pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            if (contract instanceof SalesContract) {
                Vehicle vehicle = contract.vehicleSold;
                bw.write("SALE|" + contract.getDate() + "|" + contract.getName() + "|" + contract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((SalesContract) contract).getSalesTax() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinance() + "|" + contract.getMonthlyPayment());
                bw.newLine();
            }
            if (contract instanceof LeaseContract) {
                Vehicle vehicle = contract.vehicleSold;
                bw.write("LEASE|" + contract.getDate() + "|" + contract.getName() + "|" + contract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((LeaseContract) contract).getEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
                bw.newLine();
            }
            System.out.println("Contract saved successfully to contracts.csv.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


