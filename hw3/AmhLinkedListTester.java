import java.util.Random;

public class AmhLinkedListTester {

    private static AmhLinkedList<String> names;
    private static AmhLinkedList<Integer> numbers;

    public static void main(String[] args) {
        names = new AmhLinkedList<>();
        numbers = new AmhLinkedList<>();

        //testAddMethod();
        //testRemoveMethod();
        testSetMethods();
    }


    private static void testAddMethod() {
        System.out.println("Testing Add Method...");

        //testing adding list to -1 index
        System.out.println("Testing adding items to -1 index");
        try {
            names.add(-1, "Huncho");
            numbers.add(-1, 21);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getLocalizedMessage());
        }
        //testing adding first value to linked list
        String firstName = "Ngacho";
        int firstNumber = 19;

        System.out.println("Testing adding the first value to the names list...");
        names.add(0, firstName);
        System.out.println(firstName + " is added to names");
        System.out.println("Names list now has : " + names.toString());
        System.out.println("First name is " + names.get(0));

        System.out.println("Testing adding the last value to the numbers list...");
        numbers.add(0, 19);
        System.out.println(firstNumber + " is added to numbers");
        System.out.println("Numbers list now has : " + numbers.toString());
        System.out.println("First number is " + numbers.get(0));

        //testing multiple numbers added to the linked list
        String[] newNames = {"Grace", "Dasha", "Aniella", "Ian", "Mufaro"};
        int[] newNumbers = {7, 5, 9, 10, 12, 11, 24, 65};

        System.out.println("Testing adding multiple names to the list...");
        //adding names to names linked list
        for (int i = 0; i < newNames.length; i++) {
            names.add(i + 1, newNames[i]);
            System.out.println(newNames[i] + " added to names");
            System.out.println("Names list now has : " + names.toString());
        }

        System.out.println("Testing adding multiple numbers to a list");
        //adding numbers to linked list
        for (int i = 0; i < newNumbers.length; i++) {
            //add to nex pos since one is already in. test what happens otherwise
            numbers.add(i + 1, newNumbers[i]);
            System.out.println(newNumbers[i] + " added to numbers");
            System.out.println("Numbers list now has : " + numbers.toString());
        }


        System.out.println("Testing adding items to positions already in list");
        String[] _names = {"Billie", "Aryen", "Arjun"};
        int[] _numbers = {99, 98, 97};
        System.out.println("Testing adding to position 0");
        for (int i = 0; i < _names.length; i++){
            names.add(0, _names[i]);
        }
        System.out.println("Names list now has " + names.toString());

        for (int i = 0; i < _numbers.length; i++){
            numbers.add(0, _numbers[i]);
        }
        System.out.println("Numbers list now has " + numbers.toString());

        //testing to random pos
        System.out.println();
        System.out.println("Testing adding to rand pos");
        Random random = new Random();
        String[] _randomizedNames = {"Khaligraph", "Nyashinski", "Willy", "Bahati"};
        for (int i = 0; i < _randomizedNames.length; i++){
            int randomNamePos = random.nextInt(names.size());
            System.out.println("Names list had " + names.toString() + " pre-adding");
            System.out.println("Adding " + _randomizedNames[i] + " to pos " + randomNamePos);
            names.add(randomNamePos, _randomizedNames[i]);
            System.out.println("Names list has " + names.toString() + " post-adding");
            System.out.println();
        }
        System.out.println("Names list now has " + names.toString());

        int[] _randomizedInts = {413, 404, 409, 405};
        for (int i = 0; i < _randomizedInts.length; i++){
            int randomIntPos = random.nextInt(numbers.size());
            System.out.println("Name list had " + numbers.toString() + " pre-adding");
            System.out.println("Adding " + _randomizedInts[i] + " to pos " + randomIntPos);
            numbers.add(randomIntPos, _randomizedInts[i]);
            System.out.println("Name list has " + numbers.toString() + " post-adding");
            System.out.println();
        }
        System.out.println("Numbers list now has " + numbers.toString());


    }

    public static void addItemsToLists() {
        //testing multiple numbers added to the linked list
        String[] newNames = {"Ngacho", "Grace", "Dasha", "Aniella", "Ian", "Mufaro"};
        int[] newNumbers = {21, 7, 5, 9, 10, 12, 11, 24, 65};
        //adding names to names linked list
        for (int i = 0; i < newNames.length; i++) {
            names.add(i, newNames[i]);
        }
        //adding numbers to linked list
        for (int i = 0; i < newNumbers.length; i++) {
            //add to nex pos since one is already in. test what happens otherwise
            numbers.add(i, newNumbers[i]);
        }
    }

    public static void removeAllItemsFromLists() {
        if (names.size() == 0) {
            if (numbers.size() == 0) {
                return;
            }
        }
        for (int i = names.size() - 1; i >= 0; i--) {
            names.remove(i);
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            numbers.remove(i);
        }
    }


    private static void testRemoveMethod() {
        System.out.println("Testing Remove method...");
        removeAllItemsFromLists();
        System.out.println("Names List has " + names.toString() + " while numbers list has " + numbers.toString());
        try {
            //Removing one item from the list
            System.out.println("Testing removing items from an empty list...");
            String firstName = names.remove(0);
            System.out.println("First name is : " + firstName);
            System.out.println("Names list now has " + names.toString());
            int firstInt = numbers.remove(0);
            System.out.println("First number is : " + firstInt);
            System.out.println("Numbers list now has " + numbers.toString());

        } catch (Exception exception) {
            System.out.println("Exception caught! " + exception.getLocalizedMessage());
        }
        //adding items to lists
        addItemsToLists();

        try {
            System.out.println("Attempting to remove the last item...");
            String lastName = names.remove(names.size() - 1);
            System.out.println("Last name is " + lastName);
            System.out.println("Names list now has " + names.toString());
            int lastInt = numbers.remove(numbers.size() - 1);
            System.out.println("Last number is " + lastInt);
            System.out.println("Numbers list now has " + numbers.toString());

        } catch (Exception exception) {
            System.out.println("Exception caught!" + exception.getLocalizedMessage());
        }

        //removing everything from list
        System.out.println("Testing removing all items from names list...");
        removeAllItemsFromLists();
        System.out.println("Names list now has " + names.toString());
        System.out.println("Numbers list now has " + numbers.toString());

        //test removing random things from the list
        Random random = new Random();

        //add stuff in list
        addItemsToLists();
        System.out.println("Testing Removing random Items from the lists...");
        for (int i = 0; i < 12; i++) {

            System.out.println("List has " + names.toString() + " pre-removal");
            if (names.size() > 0) {
                int randomNamePos = random.nextInt(names.size());
                System.out.println("Removing " + names.remove(randomNamePos) + " from Names...");
            }
            System.out.println("Names list now has " + names.toString());


            if (numbers.size() > 0) {
                System.out.println("List has " + numbers.toString() + " pre-removal");
                int randomIntPos = random.nextInt(numbers.size());
                System.out.println("Removing " + numbers.remove(randomIntPos) + " from numbers...");
            }
            System.out.println("Numbers list now has " + numbers.toString());

        }


    }

    private static void testSetMethods(){
        removeAllItemsFromLists();
        //setting on an empty list
        System.out.println("Testing setting on an empty list...");
        try {
            names.set(0, "Fifa");
            System.out.println("Names list has " + names.toString());
            numbers.set(0, 999);
            System.out.println("Numbers list has " + numbers.toString());
            System.out.println();

        }catch (Exception ex){
            System.out.println("Exception Caught! " + ex.getLocalizedMessage());
        }

        System.out.println("Testing on a normal list");
        addItemsToLists();
        System.out.println("Names List had " + names.toString());
        names.set(2, "Derek");
        System.out.println("Names List now has " + names.toString());

        System.out.println("Numbers list had " + numbers.toString());
        numbers.set(4, 999);
        System.out.println("Numbers list now has " + numbers.toString());


        //testing on setting an out of bounds list
        System.out.println("Testing adding out of bounds in a list...");
        try{
            System.out.println("Names List had " + names.toString());
            names.set(names.size(), "Cancelo");
            System.out.println("Names List now has " + names.toString());

            System.out.println("Numbers list had " + numbers.toString());
            numbers.set(names.size(), 1024);
            System.out.println("Numbers list now has " + numbers.toString());

        }catch (Exception e){
            System.out.println("Exception Caught! " + e.getLocalizedMessage());
        }



    }
}