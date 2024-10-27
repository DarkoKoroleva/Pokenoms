## Задание

Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса Flat, описание которого приведено ниже.

### Разработанная программа должна удовлетворять следующим требованиям:

1. Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
2. Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
3. Для хранения необходимо использовать коллекцию типа java.util.ArrayDequeue
4. При запуске приложения коллекция должна автоматически заполняться значениями из файла.
5. Имя файла должно передаваться программе с помощью: аргумент командной строки.
6. Данные должны храниться в файле в формате json
7. Чтение данных из файла необходимо реализовать с помощью класса java.util.Scanner
8. Запись данных в файл необходимо реализовать с помощью класса java.io.BufferedWriter
9. Все классы в программе должны быть задокументированы в формате javadoc.
10. Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
11. В интерактивном режиме программа должна поддерживать выполнение следующих команд:
    - help : вывести справку по доступным командам  
    - info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)  
    - show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении  
    - add {element} : добавить новый элемент в коллекцию  
    - update id {element} : обновить значение элемента коллекции, id которого равен заданному  
    - remove_by_id id : удалить элемент из коллекции по его id  
    - clear : очистить коллекцию  
    - save : сохранить коллекцию в файл  
    - execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.  
    - exit : завершить программу (без сохранения в файл)  
    - add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции  
    - remove_greater {element} : удалить из коллекции все элементы, превышающие заданный  
    - remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный  
    - count_greater_than_house house : вывести количество элементов, значение поля house которых больше заданного  
    - filter_by_furniture furniture : вывести элементы, значение поля furniture которых равно заданному  
    - print_ascending : вывести элементы коллекции в порядке возрастания  

### Формат ввода команд:

1. Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
2. Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
3. При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
4. Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
5. При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
6. Для ввода значений null использовать пустую строку.
7. Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.

### Описание хранимых в коллекции классов:
```java
public class Flat {  
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически  
    private String name; //Поле не может быть null, Строка не может быть пустой  
    private Coordinates coordinates; //Поле не может быть null  
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически  
    private Double area; //Максимальное значение поля: 858, Значение поля должно быть больше 0  
    private Long numberOfRooms; //Значение поля должно быть больше 0  
    private Long price; //Значение поля должно быть больше 0  
    private Boolean furniture; //Поле может быть null  
    private View view; //Поле не может быть null  
    private House house; //Поле может быть null  
}  
public class Coordinates {  
    private Float x; //Максимальное значение поля: 640, Поле не может быть null  
    private float y; //Значение поля должно быть больше -114  
}    
public class House {  
    private String name; //Поле не может быть null  
    private Long year; //Значение поля должно быть больше 0  
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0  
}  
public enum View {  
    YARD,  
    PARK,  
    BAD,  
    NORMAL;  
}
```