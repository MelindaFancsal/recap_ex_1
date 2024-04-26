public class Main01 {
    /*
    Creati o clasa parinte care sa aiba un constructor fara argumente. In interiorul constructorului afisati mesajul
    "constructor parinte
    creati o clasa copil care sa aiba 2 constructori:
    - un constructor fara argumente
    - un constructr cu un argument de tip int

    In interiorul fiecarui constructor afisati mesajul "constructor copil cu sau fara argument" , in functie de constructorul in care va aflati.
    Din constroctorul cu un argument apelati consttorucul fara argumente

     */

    public static void main(String[] args) {
        Copil copil = new Copil(1);
        System.out.println(copil.getAge());
    }
}
