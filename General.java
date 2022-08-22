import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class General {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<TV> tvs = new ArrayList<>();

    public static void main(String[] args) {
        tvs.add(new TV("LI6464",2020,500,39,TV_brands.LG));
        tvs.add(new TV("S13565",2021,460,32,TV_brands.SAMSUNG));
        tvs.add(new TV("P25215",2019,400,37,TV_brands.PHILLIPS));
        showMenu();

    }
    public static void showMenu() {
        while (true) {
            System.out.println("\nВведите действие, которое хотите реализовать: " +
                    "\n1 Показать все телевизоры." +
                    "\n2 Показать все телевизоры с заданной диагональю." +
                    "\n3 Показать все телевизоры одного производителя." +
                    "\n4 Показать все телевизоры текущего года." +
                    "\n5 Показать все телевизоры дороже заданной цены." +
                    "\n6 Показать все телевизоры, отсортированные по цене по возрастанию." +
                    "\n7 Показать все телевизоры, отсортированные по цене по убыванию." +
                    "\n8 Выход из программы");
            Integer operation = null;
            try {
                operation = Integer.parseInt(reader.readLine());
            } catch (Exception e1) {
                System.out.println("Номера действия с таким номером не существует!!!");
            }
            try {
                switch (operation) {
                    case 1:
                        printListTVs();
                        break;
                    case 2:
                        printByDiagonal();
                        break;
                    case 3:
                        printByOneBrand();
                        break;
                    case 4:
                        printByOneYear();
                        break;
                    case 5:
                        printMoreExpensive();
                        break;
                    case 6:
                        sortedAscending();
                        break;
                    case 7:
                        sortedDescending();
                        break;
                    case 8:
                        System.exit(1);
                    default:
                        System.out.println("Неверный ввод номера действия!!!");
                }
                break;

            } catch (Exception e) {
                System.out.println("Неверный ввод !!!");
                continue;
            }
        }
    }
    public static void printListTVs() {
        tvs.stream().forEach(t -> System.out.println(t + "; "));
    }
    public static void printByDiagonal() throws IOException {
        System.out.println("Введите длину диагонали телевизора (в дюймах)");
        double diagonal = Double.parseDouble(reader.readLine());

        tvs.stream()
                .filter(x -> x.getDiagonal() == diagonal)
                .forEach(t -> System.out.println(t));

        boolean isDiagonal = tvs.stream().noneMatch(x ->  x.getDiagonal() == diagonal);
        if (isDiagonal == true) {
            System.out.println("Нет совпадения по длине диагонали, равной " + diagonal);
        }

    }
    public static void printByOneBrand() throws IOException {
        System.out.println("Введите наименование бренда телевизоров, которые хотите вывести на консоль");
        String brand = reader.readLine();

        tvs.stream()
                .filter(x -> x.getTvBrand().equals(TV_brands.LG) && brand.equalsIgnoreCase("LG") ||
                        x.getTvBrand().equals(TV_brands.SAMSUNG) && brand.equalsIgnoreCase("Samsung") ||
                        x.getTvBrand().equals(TV_brands.PHILLIPS) && brand.equalsIgnoreCase("Phillips"))
                .forEach(t -> System.out.print(t + " "));

        boolean isBrand = tvs.stream().noneMatch(x -> x.getTvBrand().equals(TV_brands.LG) && brand.equalsIgnoreCase("LG") ||
                x.getTvBrand().equals(TV_brands.SAMSUNG) && brand.equalsIgnoreCase("Samsung") ||
                x.getTvBrand().equals(TV_brands.PHILLIPS) && brand.equalsIgnoreCase("Phillips"));
        if (isBrand == true) {
            System.out.println("Нет совпадения по бренду " + brand);
        }
    }
    public static void printByOneYear() throws IOException {
        System.out.println("Введите год, чтобы вывести на консоль телевизоры данного года выпуска");
        int year = Integer.parseInt(reader.readLine());

        tvs.stream()
                .filter(x -> x.getYearOfProduction() == year)
                .forEach(t -> System.out.println(t));

        boolean isYear = tvs.stream().noneMatch(x -> x.getYearOfProduction() == year);
        if (isYear == true) {
            System.out.println("В базе отсутствует телевизоры " + year + " года выпуска");
        }
    }
    public static void printMoreExpensive() throws IOException {
        System.out.println("Введите цену, чтобы вывести на консоль телевизоры дороже заданной цены");
        long price = Long.parseLong(reader.readLine());
        tvs.stream()
                .filter(t -> t.getPrice() > price)
                .forEach(t -> System.out.println(t));
        boolean isMorePrice = tvs.stream().noneMatch(t -> t.getPrice() > price);
        if (isMorePrice == true) {
            System.out.println("В базе отсутствует телевизоры дороже цены " + price);
        }
    }
    public static void sortedAscending() throws IOException{
        TvCompotator tvCompotator = new TvCompotator();
        tvs.stream().sorted(tvCompotator)
                .forEach(t -> System.out.println(t));
    }
    public static void sortedDescending() throws IOException{
        TvCompotator tvCompotator = new TvCompotator();
        tvs.stream().sorted(tvCompotator.reversed())
                .forEach(t -> System.out.println(t));
    }

}
