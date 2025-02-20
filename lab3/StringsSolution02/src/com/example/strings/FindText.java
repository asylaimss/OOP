//Этот код выполняет поиск строк в файле gettys.html, которые соответствуют определённому регулярному выражению (Pattern).
//Если найдено совпадение, программа выводит номер строки и её содержимое.
package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//BufferedReader — читает файл построчно.
//FileReader — открывает файл для чтения.
//FileNotFoundException — если файл не найден.
//IOException — если возникла ошибка при чтении файла.
//Pattern и Matcher — используются для работы с регулярными выражениями.

public class FindText {

    private String fileName = "gettys.html"; //имя файла, в котором ищем текст
    private Pattern pattern;
    private Matcher m;

    public static void main(String[] args) {
        FindText find = new FindText();
        find.execute();
    }

    public void execute() {
        pattern = Pattern.compile("^</.*?>$");
//Этот шаблон ищет строки, содержащие только закрывающие HTML-теги.
//Разбор выражения:
//^ — начало строки.
//</ — обязательное начало закрывающего тега.
//.*? — любое содержимое внутри тега.
//>$ — обязательное окончание тега.

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //new FileReader(fileName) — открывает файл gettys.html для чтения.
            //new BufferedReader(...) — оборачивает FileReader, чтобы читать файл построчно (ускоряет работу).
            //try-with-resources автоматически закроет файл, когда код завершится.

            String line = "";  // Переменная для строки из файла
            int c = 1;         // Счётчик строк (начинается с 1)

            //reader.readLine() читает одну строку из файла.
            //Если строка не пустая (!= null), программа продолжает работу.
            //Чтение выполняется в цикле, пока все строки файла не будут обработаны.
            while ((line = reader.readLine()) != null) {
                //pattern.matcher(line) — ищет соответствие регулярному выражению в текущей строке.
                //if (m.find()) — если найдено совпадение, выводим строку.
                //" " + c + " " + line — выводит номер строки и сам текст.
                m = pattern.matcher(line);  // Проверяем строку с регулярным выражением
                if (m.find()) {  // Если есть совпадение
                    System.out.println(" " + c + "  " + line);  // Выводим номер строки и её содержимое
                }
                c++; //Переходим к следующей строке (увеличиваем номер)

            }
//Обработка ошибок
            //Если что-то пойдёт не так:
            //FileNotFoundException — если файла gettys.html нет в папке проекта.
            //IOException — если возникла ошибка при чтении файла.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
