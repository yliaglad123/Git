public class Main {

    public static void main(String[] args) {
        Boolean a = true;
        StringCollection strings =  new StringCollection(5);
        while(a) {
            System.out.println();
            System.out.println("1. Добавить элемент в коллекцию");
            System.out.println("2. Удалить элемент из коллекции");
            System.out.println("3. Реверс всех строк, входящих в коллекцию");
            System.out.println("4. Статистика по всем символам");
            System.out.println("5. Поиск подстроки в строках коллекции");
            System.out.println("6. Подсчет длины элементов коллекции");
            System.out.println("7. Поиск одинаковых элементов");
            System.out.println("8. Сравнить два элемента");
            System.out.println("9. Считать элементы из файла");
            System.out.println("10. Выход");
            System.out.println();

            int choice = Check.inputInt();

            switch(choice) {
                case 1:
                    System.out.println("Введите элемент");
                    strings.addElement(Check.inputString());
                    strings.print();
                    break;
                case 2:
                    System.out.println("Введите элемент для удаления");
                    strings.deleteElement(Check.inputString());
                    strings.print();
                    break;
                case 3:
                    strings.reverseElements();
                    strings.print();
                    break;
                case 4:
                    strings.letterCount();
                    break;
                case 5:
                    System.out.println("Введите подстроку");
                    strings.findSubstring(Check.input());
                    break;
                case 6:
                    strings.countElementsLength();
                    break;
                case 7:
                    strings.findDuplicateElements();
                    break;
                case 8:
                    System.out.println("Введите индексы элементов для сравнения");
                    System.out.println(strings.compareInnerObjects(Check.inputInt(), Check.inputInt())==0?"Элементы равны":"Элементы не равны");
                    break;
                case 9:
                    strings.initializeFromFile();
                    strings.print();
                    break;
                case 10:
                    a=false;
                    break;
            }
            strings.createXML();
        }
    }
}
