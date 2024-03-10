import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook note1 = new Notebook(10.6, "Asus E42", "Черный", "Intel Atom c220", 4, 500, "Intel HD", "Windows 7");
        Notebook note2 = new Notebook(14.2, "Acer K72", "Серый", "Ryzen 5 7520U", 8, 1000, "AMD Radeon 610M", "Windows 10");
        Notebook note3 = new Notebook(15.6, "Dexp Q20", "Белый", "Intel I5 5530K", 32, 500, "Intel Iris Xe Graphics", "Windows 8");
        Notebook note4 = new Notebook(17.0, "HP 3420", "Красный", "Intel Core I7 7260U", 16, 1000, "Intel UHD Graphics 600", "Windows 11");
        Notebook note5 = new Notebook(14.2, "Asus A30", "Белый", "Intel I3 5230", 8, 500, "Intel Iris Xe Graphics", "Windows 10");
        
        Scanner scan = new Scanner(System.in,"cp866");
        String inputData = "";
        Set<Notebook> books = new HashSet<>(Arrays.asList(note1, note2, note3, note4, note5));
        Map<Integer, String> mapFilter = new HashMap<>();
        printFilterNotes(mapFilter, books);
        boolean runProg = true;
        while (runProg) {
            System.out.println(
                "Введите номер критерия фильтрации:\n"+
                "1. Диоганаль\n"+
                "2. Цвет\n"+
                "3. Объём ОЗУ\n"+
                "4. Объём жесткого диска\n"+
                "5. Операционная система\n"+
                "6. Сбросить фильтр\n"+
                "7. Выход из программы");
            switch (scan.nextLine()) {
                case "1": {
                    System.out.println("Введите минимальный размер диагонали: ");
                    inputData = scan.nextLine();
                    mapFilter.put(1, inputData);
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "2": {
                    System.out.println("Введите цвет ноутбука: ");
                    inputData = scan.nextLine();
                    mapFilter.put(2, inputData);
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "3": {
                    System.out.println("Введите минимальный размер ОЗУ: ");
                    inputData = scan.nextLine();
                    mapFilter.put(3, inputData);
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "4": {
                    System.out.println("Введите минимальный размер HDD: ");
                    inputData = scan.nextLine();
                    mapFilter.put(4, inputData);
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "5": {
                    System.out.println("Введите операционную систему: ");
                    inputData = scan.nextLine();
                    mapFilter.put(5, inputData);
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "6": {
                    mapFilter.clear();
                    printFilterNotes(mapFilter, books);
                    break;
                }
                case "7": {
                    runProg = false;
                    scan.close();
                    break;
                }
            }            
        }
    }

    public static void printFilterNotes(Map<Integer, String> filterList, Set<Notebook> books) {
        for (Notebook book : books) {
            if (!filterList.isEmpty()) {
                boolean filterCheck = true;
                for (Integer filter : filterList.keySet()) {
                    switch (filter) {
                        case 1:
                        if (book.getSize()<Double.parseDouble(filterList.get(filter)))
                            filterCheck = false;
                            break;
                        case 2:
                        if (!book.getColor().equals(filterList.get(filter)))
                            filterCheck = false;                            
                            break;    
                        case 3:
                        if (book.getRam()<Integer.parseInt(filterList.get(filter)))
                            filterCheck = false;                            
                            break;  
                        case 4:
                        if (book.getHdd()<Integer.parseInt(filterList.get(filter)))
                            filterCheck = false;                            
                            break; 
                        case 5:
                        if (!book.getOs().equals(filterList.get(filter)))
                            filterCheck = false;                            
                            break;                                                    
                        default:
                            break;
                    }
                }
                if (filterCheck) {
                    System.out.println(book);
                }
            } else {
                System.out.println(book);
            }
        }
    }

}