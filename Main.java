import java.util.Arrays;
import java.util.Comparator;
//var 20
/**
 * Клас Main демонструє роботу з об'єктами класу NPC:
 * створення масиву, сортування за рівнем та здоров'ям, а також пошук об'єкта.
 */
public class Main {
    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка (не використовується)
     */
    public static void main(String[] args) {
        // Створення масиву NPC
        NPC[] npcs = {
            new NPC("Gandalf", "Wizard", 100, 50, false),
            new NPC("Legolas", "Archer", 90, 30, false),
            new NPC("Aragorn", "Warrior", 110, 40, false),
            new NPC("Orc", "Fighter", 80, 20, true),
            new NPC("Sauron", "Dark Lord", 150, 100, true),
            new NPC("Goblin", "Thief", 50, 40, true)
        };

        // Виведення початкового масиву
        System.out.println("Original NPCs:");
        for (NPC npc : npcs) {
            npc.displayInfo();
            System.out.println();
        }

        // Сортування за рівнем (спадання), а в разі рівності за здоров'ям (зростання)
        NPC[] sortedByLevelAndHealth = Arrays.copyOf(npcs, npcs.length);
        Arrays.sort(sortedByLevelAndHealth, Comparator
            .comparingInt(NPC::getLevel).reversed() // Сортуємо за рівнем (спадання)
            .thenComparingInt(NPC::getHealth));    // Сортуємо за здоров'ям (зростання)
        System.out.println("NPCs sorted by level (descending) and health (ascending):");
        for (NPC npc : sortedByLevelAndHealth) {
            npc.displayInfo();
            System.out.println();
        }

        // Заданий об'єкт для пошуку
        NPC targetNPC = new NPC("Legolas", "Archer", 90, 30, false);

        // Пошук об'єкта в масиві
        boolean found = false; // Флаг для перевірки знайденого об'єкта
        for (NPC npc : npcs) {
            if (npc.equals(targetNPC)) {
                System.out.println("Target NPC found:");
                npc.displayInfo();
                found = true;
                break;
            }
        }

        // Якщо об'єкт не знайдено
        if (!found) {
            System.out.println("Target NPC not found in the array.");
        }
    }
}
