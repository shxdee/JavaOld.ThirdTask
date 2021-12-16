package main;

/*Интерфейс «Фильтр» с единственным методом apply. Метод получает на вход строку
        и возвращает логическое значение (строка удовлетворяет условию фильтра или нет).*/

public interface IFilter {
    Boolean apply(String sentence);
}
