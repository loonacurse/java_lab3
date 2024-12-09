import java.util.Objects;

/**
 * Клас NPC (Non-Playable Character) представляє неігрового персонажа в грі.
 * Він містить основну інформацію про персонажа, таку як ім'я, роль, здоров'я, рівень та ворожість.
 */
public class NPC {
    // Поля класу
    private String name;          // Ім'я персонажа
    private String role;          // Роль персонажа
    private int health;           // Рівень здоров'я
    private int level;            // Рівень персонажа
    private boolean isHostile;    // Чи є персонаж ворожим

    /**
     * Конструктор для ініціалізації NPC.
     *
     * @param name      ім'я персонажа
     * @param role      роль персонажа
     * @param health    рівень здоров'я
     * @param level     рівень персонажа
     * @param isHostile чи є персонаж ворожим
     */
    public NPC(String name, String role, int health, int level, boolean isHostile) {
        this.name = name;
        this.role = role;
        this.health = health;
        this.level = level;
        this.isHostile = isHostile;
    }

    // Геттери для доступу до приватних полів

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHostile() {
        return isHostile;
    }

    /**
     * Виводить інформацію про NPC в консоль.
     */
    public void displayInfo() {
        System.out.println("NPC Info:");
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Health: " + health);
        System.out.println("Level: " + level);
        System.out.println("Hostile: " + (isHostile ? "Yes" : "No"));
    }

    /**
     * Перевизначення методу equals() для порівняння об'єктів NPC.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо всі поля збігаються; інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NPC npc = (NPC) o;
        return health == npc.health &&
               level == npc.level &&
               isHostile == npc.isHostile &&
               Objects.equals(name, npc.name) &&
               Objects.equals(role, npc.role);
    }

    /**
     * Перевизначення методу hashCode() для забезпечення коректної роботи з колекціями.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, role, health, level, isHostile);
    }
}
