package sber.java.caesars_cipher;

/*
 * Написать шифр Цезаря со следующими пререквизитами:
 * Сформировать английский и русский алфавит в виде строковых значений;
 * Диапазон для русского алфавита 0x0410 <= i <= 0x044F;
 * Диапазон для английского алфавита 0x0041 <= i <= 0x007A;
 * Учесть, что в английском алфавите должны отсутствовать ненужные символы (использовать только буквы);
 * Метод для шифра Цезаря должен принимать на вход два параметра: строковое выражение шифруемого значения и сдвиг;
 * Сдвиг может быть любым (положительным, отрицательным, превышать размер любого алфавита).
 * Строка для тестирования результата: "Aa Zz Аа Яя";
 */

public class CaesarsCipher {

    public static String cipher(String alphabet, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) != ' ') {
                if (shift < 0) {
                    result.append((char) (alphabet.charAt(i) - shift));
                } else {
                    result.append((char) (alphabet.charAt(i) + shift));
                }
            } else {
                result.append(alphabet.charAt(i));
            }
        }
        return result.toString().trim();
    }


    private static String createCyrillicAlphabet() {
        StringBuilder builder = new StringBuilder();
        for (char i = 0x0410; i <= 0x044F; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    private static String createLatinAlphabet() {
        StringBuilder builder = new StringBuilder();
        for (char i = 0x0041; i <= 0x007A; i++) {
            if (i != 0x005B && i != 0x005C && i != 0x005D && i != 0x005E && i != 0x005F && i != 0x0060) {
                builder.append(i);
            }
        }
        return builder.toString().trim();
    }
}
