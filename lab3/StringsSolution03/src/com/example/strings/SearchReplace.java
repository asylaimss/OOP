package com.example.strings;

//Этот код выполняет поиск и замену HTML-тегов и их атрибутов в файле gettys.html.
//BufferedReader — читает файл построчно.
//FileReader — открывает файл для чтения.
//FileNotFoundException — если файл не найден.
//IOException — если возникла ошибка при чтении файла.
//Pattern и Matcher — используются для работы с регулярными выражениями.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {

    private String fileName = "gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";       // Какой тег ищем
            String replaceTag = "span";   // На какой заменяем
            String attribute = "class";   // Какой атрибут добавляем/изменяем
            String value = "sentence";    // Новое значение атрибута

            String line = "";
            int c = 1;

            //Программа меняет все теги <p> на <span>, добавляя class="sentence".
            //Этот шаблон ищет строки вида:
            //<p>Some text</p>
            //и разбивает их на три группы:
            //m.group(1) → Открывающий тег <p>
            //m.group(2) → Содержимое между тегами "Some text"
            //m.group(3) → Закрывающий тег </p>
            Pattern pattern1 = Pattern.compile("(<" + targetTag + ".*?>)(.*?)(</" + targetTag + ".*?>)");

            //Программа читает каждую строку и ищет в ней <p>...</p>.
            while ((line = reader.readLine()) != null) {
                Matcher m = pattern1.matcher(line);
                if (m.find()) {
                    //Меняет <p> на <span> и </p> на </span>.
                    String newStart = replaceTag(m.group(1), targetTag, replaceTag);
                    newStart = replaceAttribute(newStart, attribute, value);//📌 Если тег уже имеет атрибут class, он перезаписывается.
                    String newEnd = replaceTag(m.group(3), targetTag, replaceTag);

                    //Выводит новую строку с заменёнными тегами.
                    String newLine = newStart + m.group(2) + newEnd;
                    System.out.printf("%3d %s\n", c, newLine);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //📌 Находит и заменяет <p> на <span>.
    public String replaceTag(String tag, String targetTag, String replaceTag) {
        Pattern p = Pattern.compile(targetTag);  // targetTag is regex
        Matcher m = p.matcher(tag);  // tag is text to replace
        if (m.find()) {
            return m.replaceFirst(replaceTag); // swap target with replace
        }
        return targetTag;
    }

    //Если у тега уже есть class="...", меняет его на class="sentence".
    //📌 Если нет class, ничего не делает.
    public String replaceAttribute(String tag, String attribute, String value) {
        Pattern p = Pattern.compile(attribute + "=" + "\".*?\"");  // targetTag is regex
        Matcher m = p.matcher(tag);  // tag is text to replace
        if (m.find()) {
            return m.replaceFirst(attribute + "=" + "\"" + value + "\"");
        }
        return tag;
    }
}
