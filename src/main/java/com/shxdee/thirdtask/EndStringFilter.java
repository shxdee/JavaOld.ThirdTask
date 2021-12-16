package main;

/*При создании объекта класса конструктор получает на вход и сохраняет строку pattern.
Метод apply(str) проверяет, что строка str заканчивается на подстроку pattern.*/

public class EndStringFilter implements IFilter {
    private final String pattern;

    public EndStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public Boolean apply(String sentence) {
        return sentence.endsWith(pattern);
    }
}
