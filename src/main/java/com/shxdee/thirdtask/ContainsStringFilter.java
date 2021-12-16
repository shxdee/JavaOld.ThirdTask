package main;

/*При создании объекта класса конструктор получает на вход и сохраняет строку pattern.
Метод apply(str) проверяет, что строка str содержит подстроку pattern.*/

public class ContainsStringFilter implements IFilter {
    private final String pattern;

    public ContainsStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public Boolean apply(String sentence) {
        return sentence.contains(pattern);
    }
}
