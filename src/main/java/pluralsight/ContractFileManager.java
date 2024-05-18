package pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public ArrayList<Contract> getContract() {

        ArrayList<Contract> contracts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("contracts.csv"))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                if (fields[0].trim().equalsIgnoreCase("SALE")) {
                    Vehicle saleInContract = new Vehicle(Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), fields[6], fields[7], fields[8], fields[9], Integer.parseInt(fields[10]), Double.parseDouble(fields[11]));
                    contracts.add(new SalesContract(fields[1], fields[2], fields[3], saleInContract, Double.parseDouble(fields[11]), Double.parseDouble(fields[17]), Double.parseDouble(fields[12]), Double.parseDouble(fields[13]), Double.parseDouble(fields[14]), fields[10]));
                }
                if (fields[0].trim().equalsIgnoreCase("LEASE")) {
                    Vehicle leaseInContract = new Vehicle(Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), fields[6], fields[7], fields[8], fields[9], Integer.parseInt(fields[10]), Double.parseDouble(fields[11]));
                    contracts.add(new LeaseContract(fields[1], fields[2], fields[3], leaseInContract, Double.parseDouble(fields[11]), Double.parseDouble(fields[17]), Double.parseDouble(fields[12]), Double.parseDouble(fields[13])));
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return contracts;
    }

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            if (contract instanceof SalesContract) {
                Vehicle vehicle = contract.vehicleSold;
                bw.write("SALE|" + contract.getDate() + "|" + contract.getName() + "|" + contract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.totalPrice + "|" + ((SalesContract) contract).isFinance() + "|" + contract.monthlyPayment);
                bw.newLine();
                
            }

            System.out.println("Contract saved successfully to contracts.csv.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


