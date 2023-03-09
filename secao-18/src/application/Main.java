package application;
import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int numeroContrato = scan.nextInt();
        scan.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dataContrato = LocalDate.parse(scan.next(), dateTimeFormatter);
        System.out.print("Valor: ");
        double totalContrato = scan.nextDouble();

        Contract contract = new Contract(numeroContrato, dataContrato, totalContrato);

        System.out.print("Número de parcelas: ");
        int totalParcelas = scan.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract,totalParcelas);

        System.out.println("Parcelas: ");

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        scan.close();
    }

}