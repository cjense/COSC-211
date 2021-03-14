import java.util.Random;

public class AmhListTester {
    private static AmhArrayList<String> names;
    private static AmhArrayList<Integer> numbers;

    public static void main(String[] args) {

        names = new AmhArrayList<>();
        numbers = new AmhArrayList<>();

        //testing methods,
        //switch with individual methods of specific use cases you want to test
        // testAddMethod();
        // testRemoveMethod();
        // testSetMethod();

        /*
        Switch this, and also switch them in the reset lists method when you want to test
        AmhArrayList

        names = new AmhArrayList<>();
        numbers = new AmhArrayList<>();
        */
    }

    private static void testAddMethod() {

        resetLists();//basically clear everything before testing
        testAddToNegativeIndex();

        resetLists();//basically clear everything before testing
        testAddFirstValueToArrayList();

        resetLists();//basically clear everything before testing
        testAddMultipleValuesToArrayList();

        resetLists();//basically clear everything before testing
        testAddingItemsToAlreadyFilledPositionZero();

        resetLists();//basically clear everything before testing
        testAddingItemsToRandomizedPositionsInList();
    }

    private static void testRemoveMethod() {
        resetLists();//basically clear everything before testing
        testRemoveFirstValueFromEmptyList();

        resetLists();//basically clear everything before testing
        testRemoveLastValueFromEmptyList();

        resetLists();//basically clear everything before testing
        testRemoveLastValueFromList();

        resetLists();//basically clear everything before testing
        testRemoveFirstValueFromList();

        resetLists();//basically clear everything before testing
        testRemoveLastValueFromList();

        resetLists();//basically clear everything before testing
        testRemovingEverythingFromList();
    }

    private static void testSetMethod() {
        resetLists();//basically clear everything before testing
        testSettingOnEmptyList();

        resetLists();//basically clear everything before testing
        testSettingOnNormalList();

        resetLists();//basically clear everything before testing
        testSettingAnItemOnRandomPosInList();

        resetLists();//basically clear everything before testing
        testSettingRandomThingsOnRandomPosInList();

        resetLists();//basically clear everything before testing
        testSettingOutOfBoundInEmptyList();

        resetLists();//basically clear everything before testing
        testSettingOutOfBoundInFilledList();

    }

    public static void testAddToNegativeIndex() {
        System.out.println("Testing adding to a negative index");
        //testing adding list to -1 index
        System.out.println("Testing adding items to -1 index");
        try {
            names.add(-1, "Huncho");
            numbers.add(-1, 21);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getLocalizedMessage());
        }
        System.out.println();

    }

    private static void testAddFirstValueToArrayList() {
        String firstName = "Ngacho";
        int firstNumber = 19;

        System.out.println("Testing adding the first value to the names list...");
        names.add(0, firstName);
        System.out.println(firstName + " is added to names");
        System.out.println("Names list now has : " + names);
        System.out.println("First name is " + names.get(0));
        System.out.println("Size of names is " + names.size());

        System.out.println("Testing adding the last value to the numbers list...");
        numbers.add(0, 19);
        System.out.println(firstNumber + " is added to numbers");
        System.out.println("Numbers list now has : " + numbers.toString());
        System.out.println("First number is " + numbers.get(0));
        System.out.println("Size of numbers is " + names.size());

        System.out.println();
    }

    private static void testAddMultipleValuesToArrayList() {
        String[] newNames = {"Grace", "Dasha", "Aniella", "Ian", "Mufaro"};
        int[] newNumbers = {7, 5, 9, 10, 12, 11, 24, 65};

        System.out.println("Testing adding multiple names to the list...");
        //adding names to names linked list
        for (int i = 0; i < newNames.length; i++) {
            names.add(i, newNames[i]);
            System.out.println(newNames[i] + " added to names");
            System.out.println("Names list now has : " + names.toString());
            System.out.println("Names list now has a size of " + names.size());

        }

        System.out.println("Testing adding multiple numbers to a list");
        //adding numbers to linked list
        for (int i = 0; i < newNumbers.length; i++) {
            //add to nex pos since one is already in. test what happens otherwise
            numbers.add(i, newNumbers[i]);
            System.out.println(newNumbers[i] + " added to numbers");
            System.out.println("Numbers list now has : " + numbers.toString());
            System.out.println("Numbers list now has a size of " + numbers.size());
        }

        System.out.println();
    }

    private static void testAddingItemsToAlreadyFilledPositionZero() {
        System.out.println("Testing adding items to positions already in list. Position 0 only");
        addItemsToLists();
        String[] _names = {"Billie", "Aryen", "Arjun"};
        int[] _numbers = {99, 98, 97};

        System.out.println("Testing adding to position 0");
        System.out.println("Names list had " + names.toString());
        for (int i = 0; i < _names.length; i++) {
            names.add(0, _names[i]);
        }
        System.out.println("Names list now has " + names.toString());
        System.out.println();

        System.out.println("Numbers list had " + numbers.toString());
        for (int i = 0; i < _numbers.length; i++) {
            numbers.add(0, _numbers[i]);
        }
        System.out.println("Numbers list now has " + numbers.toString());
        System.out.println();

    }

    private static void testAddingItemsToRandomizedPositionsInList() {
        addItemsToLists();
        System.out.println("Testing adding to rand pos");
        Random random = new Random();
        String[] _randomizedNames = {"Khaligraph", "Nyashinski", "Willy", "Bahati"};
        for (int i = 0; i < _randomizedNames.length; i++) {
            int randomNamePos = random.nextInt(names.size());
            System.out.println("Names list had " + names.toString() + " pre-adding");
            System.out.println("Adding " + _randomizedNames[i] + " to pos " + randomNamePos);
            names.add(randomNamePos, _randomizedNames[i]);
            System.out.println("Names list has " + names.toString() + " post-adding");
            System.out.println();
        }


        int[] _randomizedInts = {413, 404, 409, 405};
        for (int i = 0; i < _randomizedInts.length; i++) {
            int randomIntPos = random.nextInt(numbers.size());
            System.out.println("Name list had " + numbers.toString() + " pre-adding");
            System.out.println("Adding " + _randomizedInts[i] + " to pos " + randomIntPos);
            numbers.add(randomIntPos, _randomizedInts[i]);
            System.out.println("Name list has " + numbers.toString() + " post-adding");
            System.out.println();
        }
        System.out.println("Numbers list now has " + numbers.toString());
        System.out.println();

    }

    private static void testRemoveFirstValueFromEmptyList() {
        System.out.println("Testing Remove First Value in an empty list...");
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
    }

    private static void testRemoveLastValueFromEmptyList() {
        System.out.println("Testing Remove the Last Value in an empty list...");
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
    }

    private static void testRemoveFirstValueFromList() {
        System.out.println("Testing Removing First Value from a filled list...");
        addItemsToLists();

        int firstValue = 0;

        System.out.println("Names had " + names.toString());
        System.out.println("Size of names was " + names.size());
        String name = names.remove(firstValue);
        System.out.println("Remove " + name + " from pos " + firstValue + " in names.");
        System.out.println("Names now has " + names.toString());
        System.out.println("Size of names is " + names.size());
        System.out.println();


        System.out.println("Numbers had " + numbers.toString());
        System.out.println("Size of numbers was  " + numbers.size());
        int number = numbers.remove(firstValue);
        System.out.println("Remove " + number + " from pos " + firstValue + " in numbers.");
        System.out.println("Numbers now has " + numbers.toString());
        System.out.println("Size of numbers is now " + numbers.size());

    }

    private static void testRemoveLastValueFromList() {
        System.out.println("Testing removing last value from a filled list...");
        addItemsToLists();
        int lastValueNames = names.size() - 1;
        int lastValueNums = numbers.size() - 1;

        System.out.println("Names had " + names.toString());
        System.out.println("Size of names was " + names.size());
        String name = names.remove(lastValueNames);
        System.out.println("Remove " + name + " from pos " + lastValueNames + " in names.");
        System.out.println("Names now has " + names.toString());
        System.out.println("Size of names is " + names.size());
        System.out.println();


        System.out.println("Numbers had " + numbers.toString());
        System.out.println("Size of numbers was  " + numbers.size());
        int number = numbers.remove(lastValueNums);
        System.out.println("Remove " + number + " from pos " + lastValueNums + " in numbers.");
        System.out.println("Numbers now has " + numbers.toString());
        System.out.println("Size of numbers is now " + numbers.size());
    }

    private static void testRemovingEverythingFromList() {
        System.out.println("Testing removing everything from a list...");
        addItemsToLists();
        if (names.size() == 0) {
            if (numbers.size() == 0) {
                return;
            }
        }
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println("Names had " + names.toString());
            String name = names.remove(i);
            System.out.println("Remove " + name + " from pos " + i + " in names.");
            System.out.println("Names now has " + names.toString());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.println("Numbers had " + numbers.toString());
            int number = numbers.remove(i);
            System.out.println("Remove " + number + " from pos " + i + " in numbers.");
            System.out.println("Numbers now has " + numbers.toString());

        }
    }

    private static void testRemoveRandomItemsFromList() {
        //test removing random things from the list
        Random random = new Random();
        //add stuff in list
        addItemsToLists();
        System.out.println("Testing Removing random Items from the lists...");
        for (int i = 0; i < 4; i++) {

            System.out.println("List has " + names.toString() + " pre-removal");
            if (names.size() > 0) {
                int randomNamePos = random.nextInt(names.size());
                System.out.println("Removing " + names.remove(randomNamePos) + " from pos " + randomNamePos + " in  Names...");
            }
            System.out.println("Names list now has " + names.toString());


            if (numbers.size() > 0) {
                System.out.println("List has " + numbers.toString() + " pre-removal");
                int randomIntPos = random.nextInt(numbers.size());
                System.out.println("Removing " + numbers.remove(randomIntPos) + " from " + randomIntPos + " numbers...");
            }
            System.out.println("Numbers list now has " + numbers.toString());

        }

    }


    private static void testSettingOnEmptyList() {
        //setting on an empty list
        System.out.println("Testing setting on an empty list...");
        try {
            names.set(0, "Fifa");
            System.out.println("Names list has " + names.toString());
            numbers.set(0, 999);
            System.out.println("Numbers list has " + numbers.toString());
            System.out.println();

        } catch (Exception ex) {
            System.out.println("Exception Caught! " + ex.getLocalizedMessage());
        }

    }

    private static void testSettingOnNormalList() {
        //testing on a normal list
        System.out.println("Testing on a normal list...");
        addItemsToLists();
        System.out.println("Names List had " + names.toString());
        String name = "Derek";
        int namePos = 2;
        System.out.println("Set " + name + " at pos " + namePos);
        names.set(namePos, name);
        System.out.println("Names List now has " + names.toString());

        System.out.println("Numbers list had " + numbers.toString());
        int number = 999;
        int numPos = 4;
        System.out.println("Set " + number + " at pos " + numPos);
        numbers.set(numPos, number);
        System.out.println("Numbers list now has " + numbers.toString());

    }

    private static void testSettingAnItemOnRandomPosInList() {
        //test set on random pos in the list
        System.out.println("Testing adding random things on a normal list....");
        Random random = new Random();
        addItemsToLists();
        System.out.println("Names List had " + names.toString());
        String name = "Neto";
        int namePos = random.nextInt(names.size());
        System.out.println("Set " + name + " at pos " + namePos);
        names.set(namePos, name);
        System.out.println("Names List now has " + names.toString());

        System.out.println("Numbers list had " + numbers.toString());
        int number = 243;
        int numPos = random.nextInt(numbers.size());
        System.out.println("Set " + number + " at pos " + numPos);
        numbers.set(numPos, number);
        System.out.println("Numbers list now has " + numbers.toString());

    }

    private static void testSettingRandomThingsOnRandomPosInList() {
        Random random = new Random();
        addItemsToLists();
        int numOfRandomThings = random.nextInt(20);
        for (int i = 0; i < numOfRandomThings; i++) {
            System.out.println("Names List had " + names.toString());
            String name = "Neto";
            if (names.size() > 0) {
                int namePos = random.nextInt(names.size());
                System.out.println("Set " + name + " at pos " + namePos);
                names.set(namePos, name);
                System.out.println("Names List now has " + names.toString());
            }

            if (numbers.size() > 0) {
                System.out.println("Numbers list had " + numbers.toString());
                int number = 243;
                int numPos = random.nextInt(numbers.size());
                System.out.println("Set " + number + " at pos " + numPos);
                numbers.set(numPos, number);
                System.out.println("Numbers list now has " + numbers.toString());
            }

        }
    }

    private static void testSettingOutOfBoundInEmptyList() {
        //testing on setting an out of bounds list
        System.out.println("Testing adding out of bounds in a list...");
        try {
            System.out.println("Names List had " + names.toString());
            names.set(names.size(), "Cancelo");
            System.out.println("Names List now has " + names.toString());

            System.out.println("Numbers list had " + numbers.toString());
            numbers.set(names.size(), 1024);
            System.out.println("Numbers list now has " + numbers.toString());

        } catch (Exception e) {
            System.out.println("Exception Caught! " + e.getLocalizedMessage());
        }

    }

    private static void testSettingOutOfBoundInFilledList() {
        //testing on setting an out of bounds list
        System.out.println("Testing adding out of bounds in a list...");
        addItemsToLists();
        try {
            System.out.println("Names List had " + names.toString());
            names.set(names.size(), "Cancelo");
            System.out.println("Names List now has " + names.toString());

            System.out.println("Numbers list had " + numbers.toString());
            numbers.set(names.size(), 1024);
            System.out.println("Numbers list now has " + numbers.toString());

        } catch (Exception e) {
            System.out.println("Exception Caught! " + e.getLocalizedMessage());
        }

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

    private static void resetLists(){
        numbers = new AmhArrayList<>();
        names = new AmhArrayList<>();

        /*
        Uncomment this part if testing array list
        names = new AmhArrayList<>();
        numbers = new AmhArrayList<>();*/
    }
}