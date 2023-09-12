import java.util.ArrayList;
import java.util.List;

class Vector {  //координаты нашего перса
    float x;
    float y;
    float z;
    //float предпочитают тк лучше с с данными работатет

    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}




class Character {
    private String name;
    private int age;

    private Vector position;
    //private Vector rotation; -вращение
    //private Vector scale;  - маштаб

    private int health;
    //private int damage;
    private int damageFactor;

    public Character(Vector position, String name, int age, int health, int damageFactor) {
        this.position = position;
        this.name = name;
        this.age = age;
        this.health = health;
        this.damageFactor = damageFactor;
    }


    //гетеры сеторы можно выбрать правая кнопка мыши и


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamageFactor() {
        return damageFactor;
    }

    public void setDamageFactor(int damageFactor) {
        this.damageFactor = damageFactor;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void move (float x, float y, float z){
        position.x += x;
        position.y += y;
        position.z += z;
    }

    public int hit(Character otherCharacter){
        otherCharacter.setHealth(otherCharacter.getHealth()-10);
        System.out.println(name + " attacks " + otherCharacter.getName() + ", new health " + otherCharacter.getName() + " " + otherCharacter.getHealth());

        return otherCharacter.health;
    }
    public String toString() {
        return "Character{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", damageFactor=" + damageFactor +
                '}';
    }
}


class World{
    private List<Character> characterlist = new ArrayList<>();

    public void addCharacter(Character character){
        characterlist.add(character);
    }
    public Character findCharacterByName(String name){
        for (Character character: characterlist){
            if (character.getName()== name){
                return character;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "World{" +
                "characterList=" + characterlist +
                '}';
    }

}


public class Main {
    public static void main(String[] args) {  // класс - целое обьединение
        // у методов статических нет полей и понятие обьекта в нем
        // а обьект что-то одно
        System.out.println("Hello world!");



        World world = new World();

        Character geralt = new Character(new Vector(), "Geralt", 100, 500, 10);
        Character ghoul = new Character(new Vector(), "Ogr", 500, 1000, 100);
        world.addCharacter(geralt);
        world.addCharacter(ghoul);
        System.out.println(world);
        world.findCharacterByName("Geralt").hit(world.findCharacterByName("Ogr"));

    }
}