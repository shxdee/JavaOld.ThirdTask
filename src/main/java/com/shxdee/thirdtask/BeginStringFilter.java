package main;

/*2.2. Класс BeginStringFilter, реализующий этот интерфейс, со следующим поведением.
        При создании объекта класса конструктор получает на вход и сохраняет строку
        pattern. Метод apply(str) проверяет, что строка str начинается с подстроки pattern.
        Т.е. должен работать следующий фрагмент кода:
        String str = “Мама мыла раму”;
        BeginStringFilter filter1 = new BeginStringFilter(“Мама”);
        BeginStringFilter filter2 = new BeginStringFilter(“мыла”);
        boolean res1 = filter1.apply(str); // результат — true
        boolean res2 = filter2.apply(str); // результат — false*/


public class BeginStringFilter implements IFilter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public Boolean apply(String sentence) {
        return sentence.startsWith(pattern);
    }
}
