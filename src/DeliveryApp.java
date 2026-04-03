import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp{

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTracing = new ArrayList<>();
    private static ParcelBox<StandardParcel> boxSt = new ParcelBox<>();
    private static ParcelBox<FragileParcel> boxFr = new ParcelBox<>();
    private static ParcelBox<PerishableParcel> boxPer = new ParcelBox<>();



    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackingParcel();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }


    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Трекинг посылок");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Какой тип посылки?");
        System.out.println("1 - стандартная. 2 - хрупкий груз. 3 - скоропортищаяся");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите Название");
        String name = scanner.nextLine();
        System.out.println("Укажите день отправки");
        int data = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите адресс доставки");
        String address = scanner.nextLine();
        System.out.println("Укажите вес");
        int weight = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(name , data, address, weight);
                allParcels.add(standardParcel);
                boxSt.addParcel(standardParcel);



                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(name , data, address, weight);
                allParcels.add(fragileParcel);
                allTracing.add(fragileParcel);
                boxFr.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок годности посылки");
                int perishable = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(name , data, address, weight, perishable);
                allParcels.add(perishableParcel);
                boxPer.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверный выбор.");
        }

    }

    private static void sendParcels() {
        for(Parcel parcel : allParcels){
             parcel.packageItem();
             parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        for(Parcel parcel : allParcels){
             sum += parcel.calculateDeliveryCost();
        }
        System.out.println("общая стоимость всех доставок: " + sum);

    }
    private static void trackingParcel(){
        if (allTracing.isEmpty()) {
            System.out.println("Нет посылок для отслеживания");
            return;
        }
        for(Trackable trackable : allTracing){
            System.out.println("Введите адрес где сейчас посылка - " + trackable);
            String address = scanner.nextLine();
            trackable.reportStatus(address);
        }
    }
    private static void showBox(){
        System.out.println("Какую коробку открываем?");
        System.out.println("1 - стандартную. 2 -с хрупким грузом. 3 - скоропортящиеся");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                boxSt.getAllParcels();
                break;
            case 2:
                boxFr.getAllParcels();
                break;
            case 3:
                boxPer.getAllParcels();
                break;
            case 0:
                break;
            default:
                System.out.println("Неверный выбор.");
        }

    }

}
